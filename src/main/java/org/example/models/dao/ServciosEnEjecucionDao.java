package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.models.*;
import org.example.services.SolicitudesService;
import org.example.services.TaxisService;

import java.sql.*;

public class ServciosEnEjecucionDao implements CrudRepository<ServicioEnEjecucion> {
    private Connection connection;

    @Override
    public ServicioEnEjecucion findById(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM servicios_en_ejecucion AS sej INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = se.id_centro) WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? crearServicioEnEjecucion(rs) : null;
            }
        }
    }

    @Override
    public ServicioEnEjecucion findById(String id) throws SQLException {
        return null;
    }

    @Override
    public LinkedList<ServicioEnEjecucion> findAll() throws SQLException{
        LinkedList<ServicioEnEjecucion> servicios = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM servicios_en_ejecucion AS sej INNER JOIN centros_turisticos AS ct ON (ct.id_centro = sej.id_centro) ")) {
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
    public void delete(String id) throws SQLException {

    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private ServicioEnEjecucion crearServicioEnEjecucion(ResultSet rs) throws SQLException {
        return new ServicioEnEjecucion(
                SolicitudesService.crearSolicitud(rs),
                TaxisService.crearTaxi(rs)
        );
    }
}
