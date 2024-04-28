package org.example.services;

import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.*;
import org.example.models.dao.TaxiDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaxisService {
    private static TaxiDao dao = new TaxiDao();
    private static LinkedList<Taxi> taxis = new LinkedListSimple<>();

    public static Taxi crearTaxi(ResultSet rs) {
        Taxi taxi;
        try {
            String id = rs.getString("id_chapa");
            String tipo = rs.getString("tipo");
            if (rs.getString("tipo").equals("taxi_estatal")) {
                taxi = new TaxiEstatal(id,
                        rs.getString("estado"),
                        rs.getString("marca"),
                        rs.getInt("capacidad"),
                        rs.getFloat("combustible"),
                        rs.getString("chofer"),
                        dao.findTaxi(id, tipo)
                );
            } else {
                taxi = new TaxiParticular(rs.getString("id_chapa"),
                        rs.getString("estado"),
                        rs.getString("marca"),
                        rs.getInt("capacidad"),
                        rs.getFloat("combustible"),
                        rs.getString("chofer"),
                        dao.findTaxi(id, tipo)
                );
            }
            return taxi;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static LinkedList<Taxi> getTaxis() {
        try(Connection connection = Postgres.getConnection()){
            dao.setConnection(connection);
            taxis = dao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taxis;
    }

    public static void actualizarTaxi(Taxi dato) {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.actualizarTaxi(dato);
            taxis.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registrarTaxi(Taxi taxi){
        try(Connection connection = Postgres.getConnection()){
            dao.setConnection(connection);
            dao.save(taxi);
            taxis.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminartaxi(String id){
        try(Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.delete(id);
            taxis.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void editarTaxi(Taxi taxi){
        try(Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.save(taxi);
            taxis.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
