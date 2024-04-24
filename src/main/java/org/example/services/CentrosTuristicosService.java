package org.example.services;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.models.CentroTuristico;
import org.example.models.dao.CentroTuristicoDao;

import java.sql.Connection;
import java.sql.SQLException;

public class CentrosTuristicosService {
    private static CentroTuristicoDao dao;
    private static LinkedList<CentroTuristico> centrosTuristicos;

    public CentrosTuristicosService() {
        dao = new CentroTuristicoDao();
        centrosTuristicos = new Cola<>();
    }

    public static Cola<CentroTuristico> getCentrosTuristicos() throws SQLException {
        if (centrosTuristicos.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                dao.setConnection(connection);
                centrosTuristicos = (Cola<CentroTuristico>) dao.findAll();
            }
        }
        return (Cola<CentroTuristico>) centrosTuristicos;
    }

    public static CentroTuristico getCentrosTuristico(int id) throws SQLException {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            return dao.findById(id);
        }
    }

    public static void registrarCentroTuristico(CentroTuristico ct) throws SQLException{
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.save(ct);
            centrosTuristicos.clear();
        }
    }

    public static void eliminarCentroTuristico(int id) throws SQLException{
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.delete(id);
            centrosTuristicos.clear();
        }
    }
}
