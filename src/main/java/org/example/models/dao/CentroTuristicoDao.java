package org.example.models.dao;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.CentroTuristico;

import java.sql.*;

public class CentroTuristicoDao implements CrudRepository<CentroTuristico>{
    private Connection connection;

    @Override
    public CentroTuristico findById(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM centros_turisticos Where id_centro=?")){
            stmt.setInt(1, id);
            stmt.executeQuery();
            try (ResultSet rs = stmt.executeQuery()) {
               return rs.next() ? crearCentroTuristico(rs) : null;
            }
        }
    }

    @Override
    public CentroTuristico findById(String id) throws SQLException {
        return null;
    }

    @Override
    public LinkedList<CentroTuristico> findAll() throws SQLException {
        LinkedList<CentroTuristico> centros = new LinkedListSimple<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM centros_turisticos")){
            while(rs.next()){
                centros.add(crearCentroTuristico(rs));
            }
        }
        return centros;
    }

    @Override
    public void save(CentroTuristico dato) throws SQLException {
        String consulta;
        if (dato.getId() > 0){
            consulta = "UPDATE centros_turisticos nombre_centro=?, tiene_contrato=? WHERE id_centro = ?";
        }else {
            consulta = "INSERT INTO centros_turisticos(nombre_centro, tiene_contrato) VALUES (?, ?)";
        }
        try(PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setString(1, dato.getNombre());
            stmt.setBoolean(2, dato.isTieneContrato());
            if (dato.getId() > 0){
                stmt.setInt(3, dato.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement("DELETE FROM centros_turisticos WHERE id_centro = ?")){
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

    private CentroTuristico crearCentroTuristico(ResultSet rs) throws SQLException {
        return new CentroTuristico(
                rs.getInt("id_centro"),
                rs.getString("nombre_centro"),
                rs.getBoolean("tiene_contrato"));
    }
}
