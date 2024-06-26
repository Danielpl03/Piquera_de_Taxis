package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.Taxi;
import org.example.models.TaxiEstatal;
import org.example.services.Postgres;
import org.example.services.TaxisService;

import java.sql.*;

public class TaxiDao implements CrudRepository<Taxi>{
    private Connection connection;

    @Override
    public Taxi findById(String  id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM taxis WHERE id_chapa = ?")){
            stmt.setString(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? TaxisService.crearTaxi(rs) : null;
            }
        }
    }

    @Override
    public Taxi findById(int id) throws SQLException {
        return null;
    }

    @Override
    public LinkedList<Taxi> findAll() throws SQLException{
        LinkedList<Taxi> taxis = new LinkedListSimple<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM taxis")) {
            while (rs.next()){
                taxis.add(TaxisService.crearTaxi(rs));
            }
        }
        return taxis;
    }

    @Override
    public void save(Taxi dato) throws SQLException{
        String consulta, consultaXTipo;
        String tipo, campo;
        if (dato instanceof TaxiEstatal) {
            tipo = "taxi_estatal";
            campo = "nombre_estatal";
        } else{
            tipo = "taxi_particular";
            campo = "no_patente";
        }
        if (this.findById(dato.getId()) != null){
            consulta = "UPDATE taxis SET id_chapa=?, estado=?, marca=?, capacidad=?, chofer=?, combustible=?, tipo=? WHERE id_chapa = ?";
            consultaXTipo = "UPDATE ".concat(tipo.concat(" SET ".concat(campo.concat("=? WHERE id_chapa = ?"))));
        }else {
            consulta = "INSERT INTO taxis(id_chapa, estado, marca, capacidad, chofer, combustible, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            consultaXTipo = "INSERT INTO ".concat(tipo).concat("( ".concat(campo).concat(", id_chapa) VALUES (?, ?)"));
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setString(1, dato.getId());
            stmt.setString(2, dato.getEstado());
            stmt.setString(3, dato.getMarca());
            stmt.setInt(4, dato.getCapacidad());
            stmt.setString(5, dato.getChofer());
            stmt.setFloat(6, dato.getCombustible());
            stmt.setString(7, tipo);
            if (this.findById(dato.getId()) != null){
                stmt.setString(8, dato.getId());
            }
            stmt.executeUpdate();
        }
        try(PreparedStatement stmt = connection.prepareStatement(consultaXTipo)){
            stmt.setString(1, dato.getTipo());
            stmt.setString(2, dato.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public void delete(String id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM taxis WHERE id_chapa = ?")){
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    public String findTaxi(String id, String tabla) throws SQLException {
        String consulta = "SELECT * FROM ".concat(tabla).concat(" WHERE id_chapa = ?");
        connection = Postgres.getConnection();
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setString(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    if (tabla.equals("taxi_estatal")) {
                        return rs.getString("empresa");
                    }
                    return rs.getString("no_patente");
                }
            }
        }
        return null;
    }

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }
     public void actualizarTaxi(Taxi dato) throws SQLException {
        String consulta = "UPDATE taxis SET estado=?, cant_combustible=? WHERE id_chapa = ?";

         try(PreparedStatement stmt = connection.prepareStatement(consulta)) {
             stmt.setString(1, dato.getEstado());
             stmt.setFloat(2, dato.getCombustible());
             stmt.setString(3, dato.getId());
             stmt.executeUpdate();
         }
    }
}
