package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.PilaYCola;
import org.example.models.*;

import java.sql.*;

public class FacturaDao implements CrudRepository<Factura>{
    private Connection connection;

    @Override
    public PilaYCola<Factura> findById(int id) throws SQLException {
        PilaYCola<Factura> facturas = new Cola<>();
        try(PreparedStatement stmt = connection.prepareStatement("SELECT f.precio, sc.* ct.* FROM facturas AS f INNER JOIN " +
                "servicios_culminados AS sc ON (sc.id_solicitud = f.id_servicio_culminado) INNER JOIN " +
                "centros_turisticos AS ct ON (ct.id_centro = sc.id_centro) WHERE id_factura = ?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                Factura factura = rs.next() ? crearFactura(rs) : null;
                if (factura != null) facturas.push(factura);
            }
        }
        return facturas;
    }

    @Override
    public PilaYCola<Factura> findAll() throws SQLException{
        PilaYCola<Factura> facturas = new Cola<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT f.precio, sc.* ct.* FROM facturas AS f INNER JOIN " +
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
        if (dato.getServicioCulminado().getServicioEnEjecucion().getSolicitud().getId() > 0){
            consulta = "UPDATE facturas SET precio=? WHERE id_factura = ?";
        }else {
            consulta = "INSERT INTO facturas(precio, id_servicio_culminado) VALUES (?, ?))";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setFloat(1, dato.getPrecio());
            if (dato.getIdFactura() > 0){
                stmt.setInt(2, dato.getIdFactura());
            }else{
                stmt.setInt(2, dato.getServicioCulminado().getServicioEnEjecucion().getSolicitud().getId());
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
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private Factura crearFactura(ResultSet rs) throws SQLException {
        CentroTuristico ct = new CentroTuristico(
                rs.getInt("id_centro"),
                rs.getString("nombre_centro"),
                rs.getBoolean("tiene_contrato")
        );

        return new Factura(
                new ServicioCulminado(
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
                ),
                rs.getFloat("precio"));
    }
}
