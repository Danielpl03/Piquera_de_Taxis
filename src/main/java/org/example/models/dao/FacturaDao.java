package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.models.*;
import org.example.services.SolicitudesService;
import org.example.services.TaxisService;

import java.sql.*;

public class FacturaDao implements CrudRepository<Factura>{
    private Connection connection;

    @Override
    public Factura findById(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("SELECT f.precio FROM facturas AS f INNER JOIN " +
                "servicios_culminados AS sc ON (sc.id_solicitud = f.id_servicio_culminado) INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = sc.id_centro) WHERE id_factura = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? crearFactura(rs) : null;
            }
        }
    }

    @Override
    public Factura findById(String id) throws SQLException {
        return null;
    }

    @Override
    public LinkedList<Factura> findAll() throws SQLException{
        LinkedList<Factura> facturas = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT f.precio FROM facturas AS f INNER JOIN " +
                    "servicios_culminados AS sc ON (sc.id_solicitud = f.id_servicio_culminado) INNER JOIN " +
                    "centros_turisticos AS ct ON (ct.id_centro = sc.id_centro)")) {
            while (rs.next()){
                facturas.push(crearFactura(rs));
            }
        }
        return facturas;
    }

    @Override
    public void save(Factura dato) throws SQLException{
        String consulta;
        if (dato.getServicioCulminado().getSolicitud().getId() > 0){
            consulta = "UPDATE facturas SET precio=? WHERE id_factura = ?";
        }else {
            consulta = "INSERT INTO facturas(precio, id_servicio_culminado) VALUES (?, ?))";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setFloat(1, dato.getPrecio());
            if (dato.getIdFactura() > 0){
                stmt.setInt(2, dato.getIdFactura());
            }else{
                stmt.setInt(2, dato.getServicioCulminado().getSolicitud().getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM facturas WHERE id_factura = ?")){
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

    private Factura crearFactura(ResultSet rs) throws SQLException {
        return new Factura(
                new ServicioCulminado(
                        SolicitudesService.getSolicitud(rs.getInt("id_solicitud")),
                        TaxisService.crearTaxi(rs),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora_fin").toLocalTime()
                ),
                rs.getFloat("precio")
        );
    }
}
