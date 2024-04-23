package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.PilaYCola;
import org.example.models.*;

import java.sql.*;

public class ServciosEnEjecucionDao implements CrudRepository<ServicioEnEjecucion> {
    private Connection connection;

    @Override
    public PilaYCola<ServicioEnEjecucion> findById(int id) throws SQLException {
        PilaYCola<ServicioEnEjecucion> servicios = new Cola<>();
        try(PreparedStatement stmt = connection.prepareStatement("SELECT sej.*, ct.nombre_centro FROM servicios_en_ejecucion AS sej INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = se.id_centro) WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                ServicioEnEjecucion servicioEnEjecucion = rs.next() ? crearServicioEnEjecucion(rs) : null;
                if (servicioEnEjecucion != null) servicios.push(servicioEnEjecucion);
            }
        }
        return servicios;
    }

    @Override
    public PilaYCola<ServicioEnEjecucion> findAll() throws SQLException{
        PilaYCola<ServicioEnEjecucion> servicios = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sej.*, ct.nombre_centro, ct.tiene_contrato" +
                    "FROM servicios_en_ejecucion AS sej INNER JOIN centros_turisticos AS ct ON (ct.id_centro = sej.id_centro) ")) {
            while (rs.next()){
                servicios.push(crearServicioEnEjecucion(rs));
            }
        }
        return servicios;
    }

    @Override
    public void save(ServicioEnEjecucion dato) throws SQLException{
        String consulta;
        if (dato.getSolicitud().getId() > 0){
            consulta = "UPDATE servicios_en_ejecucion SET id_centro=?, direccion=?, destino=?, hora_recogida=?, cant_km=?, cant_personas=?, id_taxi=? WHERE id_solicitud = ?";
        }else {
            consulta = "INSERT INTO servicios_en_ejecucion(id_centro, direccion, destino, hora_recogida, cant_km, cant_personas, id_taxi) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setInt(1, dato.getSolicitud().getCentro().getId());
            stmt.setString(2, dato.getSolicitud().getDireccion());
            stmt.setString(3, dato.getSolicitud().getDestino());
            stmt.setTime(4, Time.valueOf(dato.getSolicitud().getHora()));
            stmt.setFloat(5, dato.getSolicitud().getCantKm());
            stmt.setInt(6, dato.getSolicitud().getCantPersonas());
            stmt.setString(7, dato.getTaxi().getId());
            if (dato.getSolicitud().getId() > 0){
                stmt.setInt(8, dato.getSolicitud().getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM servicios_en_ejecucion WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private ServicioEnEjecucion crearServicioEnEjecucion(ResultSet rs) throws SQLException {
        CentroTuristico ct = new CentroTuristico(
                rs.getInt("id_centro"),
                rs.getString("nombre_centro"),
                rs.getBoolean("tiene_contrato")
        );

        return new ServicioEnEjecucion(new Solicitud(rs.getInt("id_solicitud"), ct,
                rs.getString("direccion"),
                rs.getString("destino"),
                rs.getTime("hora_recogida").toLocalTime(),
                rs.getInt("cant_personas"),
                rs.getFloat("cant_km")
        ), new Taxi(rs.getString("id_chapa")));
    }
}
