package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.*;
import org.example.services.SolicitudesService;
import org.example.services.TaxisService;

import java.sql.*;

public class ServicioCulminadoDao implements CrudRepository<ServicioCulminado>{
    private Connection connection;

    @Override
    public ServicioCulminado findById(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM servicios_culminados AS sc INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = sc.id_centro) WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? crearServicioCulminado(rs) : null;
            }
        }
    }

    @Override
    public ServicioCulminado findById(String id) throws SQLException {
        return null;
    }

    @Override
    public LinkedList<ServicioCulminado> findAll() throws SQLException{
        LinkedList<ServicioCulminado> servicios = new LinkedListSimple<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM servicios_culminados AS sc INNER JOIN centros_turisticos AS ct ON (ct.id_centro = sc.id_centro) " +
                    "INNER JOIN taxis AS t ON (t.id_chapa = sc.id_taxi)")) {
            while (rs.next()){
                servicios.add(crearServicioCulminado(rs));
            }
        }
        return servicios;
    }

    @Override
    public void save(ServicioCulminado dato) throws SQLException{
        String consulta;
        if (dato.getSolicitud().getId() > 0){
            consulta = "UPDATE servicios_culminado SET id_centro=?, direccion=?, destino=?, hora_recogida=?, cant_km=?, cant_personas=?, id_taxi=?, fecha=?, hora_fin=? WHERE id_solicitud = ?";
        }else {
            consulta = "INSERT INTO servicios_culminado(id_centro, direccion, destino, hora_recogida, cant_km, cant_personas, id_taxi, fecha, hora_fin) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setInt(1, dato.getSolicitud().getCentro().getId());
            stmt.setString(2, dato.getSolicitud().getDireccion());
            stmt.setString(3, dato.getSolicitud().getDestino());
            stmt.setTime(4, Time.valueOf(dato.getSolicitud().getHora()));
            stmt.setFloat(5, dato.getSolicitud().getCantKm());
            stmt.setInt(6, dato.getSolicitud().getCantPersonas());
            stmt.setString(7, dato.getTaxi().getId());
            stmt.setDate(8, Date.valueOf(dato.getFecha()));
            stmt.setTime(9, Time.valueOf(dato.getHoraFin()));
            if (dato.getSolicitud().getId() > 0){
                stmt.setInt(10, dato.getSolicitud().getId());
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
    public void delete(String id) throws SQLException {

    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private ServicioCulminado crearServicioCulminado(ResultSet rs) throws SQLException {
        return new ServicioCulminado(
                SolicitudesService.crearSolicitud(rs),
                TaxisService.crearTaxi(rs),
                rs.getDate("fecha").toLocalDate(),
                rs.getTime("hora_fin").toLocalTime()
        );
    }
}
