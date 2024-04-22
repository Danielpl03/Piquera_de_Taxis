package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.PilaYCola;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;

import java.sql.*;

public class SolicitudDao implements CrudRepository<Solicitud> {
    private Connection connection;

    public SolicitudDao(Connection connection) {
        this.connection = connection;
    }

    public SolicitudDao() {
    }

    @Override
    public PilaYCola<Solicitud> findById(int id) throws SQLException {
        PilaYCola<Solicitud> solicitudes = new Cola<>();
        try(PreparedStatement stmt = connection.prepareStatement("SELECT *, ct.nombre_centro FROM solicitudes AS s INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = s.id_centro) WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                Solicitud solicitud = rs.next()? crearSolicitud(rs) : null;
                if (solicitud != null) solicitudes.push(solicitud);
            }
        }
        return solicitudes;
    }

    @Override
    public PilaYCola<Solicitud> findAll() throws SQLException{
        PilaYCola<Solicitud> solicitudes = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.*, ct.* FROM solicitudes AS s INNER JOIN " +
                    "centros_turisticos AS ct ON (ct.id_centro = s.id_centro) ORDER BY ct.tiene_contrato desc")) {
            while (rs.next()){
                solicitudes.push(crearSolicitud(rs));
            }
        }
        return solicitudes;
    }

    @Override
    public void save(Solicitud dato) throws SQLException{
        String consulta;
        if (dato.getId() > 0){
            consulta = "UPDATE solicitudes SET id_centro=?, direccion=?, destino=?, hora_recogida=?, cant_km=?, cant_personas=? WHERE id_solicitud = ?";
        }else {
            consulta = "INSERT INTO solicitudes(id_centro, direccion, destino, hora_recogida, cant_km, cant_personas, id_solicitud) VALUES (?, ?, ?, ?, ?, ?, nextval('solicitudes2_id_solicitud_seq'::regclass))";
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
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM solicitudes WHERE id_solicitud = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private Solicitud crearSolicitud(ResultSet rs) throws SQLException {
        CentroTuristico ct = new CentroTuristico(
                rs.getInt("id_centro"),
                rs.getString("nombre_centro"),
                rs.getBoolean("tiene_contrato")
        );
        return new Solicitud(rs.getInt("id_solicitud"), ct,
                            rs.getString("direccion"),
                            rs.getString("destino"),
                            rs.getTime("hora_recogida").toLocalTime(),
                            rs.getInt("cant_personas"),
                            rs.getFloat("cant_km")
        );
    }
}
