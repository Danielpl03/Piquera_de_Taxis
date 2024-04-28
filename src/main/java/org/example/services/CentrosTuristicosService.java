package org.example.services;

import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.CentroTuristico;
import org.example.models.dao.CentroTuristicoDao;

import java.sql.Connection;
import java.sql.SQLException;

public class CentrosTuristicosService {
    private static CentroTuristicoDao dao = new CentroTuristicoDao();
    private static LinkedList<CentroTuristico> centrosTuristicos = new LinkedListSimple<>();

    public static LinkedList<CentroTuristico> getCentrosTuristicos() {
        if (centrosTuristicos.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                dao.setConnection(connection);
                centrosTuristicos = dao.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return centrosTuristicos;
    }

    public static CentroTuristico getCentrosTuristico(int id) {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registrarCentroTuristico(CentroTuristico ct) {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.save(ct);
            centrosTuristicos.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarCentroTuristico(int id) {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.delete(id);
            centrosTuristicos.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
