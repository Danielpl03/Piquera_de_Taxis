package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.PilaYCola;
import org.example.models.*;

import java.sql.*;

public class ServicioCulminadoDao implements CrudRepository<ServicioCulminado>{
    private Connection connection;

    @Override
    public PilaYCola<ServicioCulminado> findById(int id) throws SQLException {
        PilaYCola<ServicioCulminado> servicios = new Cola<>();
        try(PreparedStatement stmt = connection.prepareStatement("SELECT sc.*, ct.nombre_centro FROM servicios_culminados AS sc INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = sc.id_centro) WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                ServicioCulminado servicioCulminado = rs.next() ? crearServicioCulminado(rs) : null;
                if (servicioCulminado != null) servicios.push(servicioCulminado);
            }
        }
        return servicios;
    }

    @Override
    public PilaYCola<ServicioCulminado> findAll() throws SQLException{
        PilaYCola<ServicioCulminado> servicios = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sc.*, ct.nombre_centro, ct.tiene_contrato" +
                    "FROM servicios_culminados AS sc INNER JOIN centros_turisticos AS ct ON (ct.id_centro = sc.id_centro) ")) {
            while (rs.next()){
                servicios.push(crearServicioCulminado(rs));
            }
        }
        return servicios;
    }

    @Override
    public void save(ServicioCulminado dato) throws SQLException{
        String consulta;
        if (dato.getServicioEnEjecucion().getSolicitud().getId() > 0){
            consulta = "UPDATE servicios_culminado SET id_centro=?, direccion=?, destino=?, hora_recogida=?, cant_km=?, cant_personas=?, id_taxi=?, fecha=?, hora_fin=? WHERE id_solicitud = ?";
        }else {
            consulta = "INSERT INTO servicios_culminado(id_centro, direccion, destino, hora_recogida, cant_km, cant_personas, id_taxi, fecha, hora_fin) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setInt(1, dato.getServicioEnEjecucion().getSolicitud().getCentro().getId());
            stmt.setString(2, dato.getServicioEnEjecucion().getSolicitud().getDireccion());
            stmt.setString(3, dato.getServicioEnEjecucion().getSolicitud().getDestino());
            stmt.setTime(4, Time.valueOf(dato.getServicioEnEjecucion().getSolicitud().getHora()));
            stmt.setFloat(5, dato.getServicioEnEjecucion().getSolicitud().getCantKm());
            stmt.setInt(6, dato.getServicioEnEjecucion().getSolicitud().getCantPersonas());
            stmt.setString(7, dato.getServicioEnEjecucion().getTaxi().getId());
            stmt.setDate(8, Date.valueOf(dato.getFecha()));
            stmt.setTime(9, Time.valueOf(dato.getHoraFin()));
            if (dato.getServicioEnEjecucion().getSolicitud().getId() > 0){
                stmt.setInt(10, dato.getServicioEnEjecucion().getSolicitud().getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM servicios_culminados WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private ServicioCulminado crearServicioCulminado(ResultSet rs) throws SQLException {
        CentroTuristico ct = new CentroTuristico(
                rs.getInt("id_centro"),
                rs.getString("nombre_centro"),
                rs.getBoolean("tiene_contrato")
        );

        return new ServicioCulminado(
                new ServicioEnEjecucion(
                        new Solicitud(rs.getInt("id_solicitud"), ct,
                                    rs.getString("direccion"),
                                    rs.getString("destino"),
                                    rs.getTime("hora_recogida").toLocalTime(),
                                    rs.getInt("cant_personas"),
                                    rs.getFloat("cant_km")
                        ), new Taxi(rs.getString("id_chapa"))
                ),
                rs.getDate("fecha").toLocalDate(),
                rs.getTime("hora_fin").toLocalTime()
        );
    }
}
