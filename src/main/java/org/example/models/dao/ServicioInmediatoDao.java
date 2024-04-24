package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.models.Solicitud;
import org.example.services.SolicitudesService;

import java.sql.*;

public class ServicioInmediatoDao implements CrudRepository<Solicitud>{
    private Connection connection;

    @Override
    public Solicitud findById(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM servicios_inmediatos AS si INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = si.id_centro) WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                 return rs.next()? SolicitudesService.crearSolicitud(rs) : null;
            }
        }
    }

    @Override
    public Solicitud findById(String id) throws SQLException {
        return null;
    }

    @Override
    public LinkedList<Solicitud> findAll() throws SQLException{
        LinkedList<Solicitud> solicitudes = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM servicios_inmediatos AS si INNER JOIN " +
                    "centros_turisticos AS ct ON (ct.id_centro = si.id_centro) ORDER BY ct.tiene_contrato desc")) {
            while (rs.next()){
                solicitudes.push(SolicitudesService.crearSolicitud(rs));
            }
        }
        return solicitudes;
    }

    @Override
    public void save(Solicitud dato) throws SQLException{
        String consulta;
        if (dato.getId() > 0){
            consulta = "UPDATE servicios_inmediatos SET id_centro=?, direccion=?, destino=?, hora_recogida=?, cant_km=?, cant_personas=? WHERE id_solicitud = ?";
        }else {
            consulta = "INSERT INTO servicios_inmediatos(id_centro, direccion, destino, hora_recogida, cant_km, cant_personas) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setInt(1, dato.getCentro().getId());
            stmt.setString(2, dato.getDireccion());
            stmt.setString(3, dato.getDestino());
            stmt.setTime(4, Time.valueOf(dato.getHora()));
            stmt.setFloat(5, dato.getCantKm());
            stmt.setInt(6, dato.getCantPersonas());
            if (dato.getId() > 0){
                stmt.setInt(7, dato.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM servicios_inmediatos WHERE id_solicitud = ?")){
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
}
