package org.example.services;

import org.example.estructuras.Cola;
import org.example.estructuras.PilaYCola;
import org.example.models.CentroTuristico;
import org.example.models.dao.CentroTuristicoDao;

import java.sql.Connection;
import java.sql.SQLException;

public class CentrosTuristicosService {
    private CentroTuristicoDao dao;
    private Cola<CentroTuristico> centrosTuristicos;

    public CentrosTuristicosService() {
        dao = new CentroTuristicoDao();
        centrosTuristicos = new Cola<>();
    }

    public PilaYCola<CentroTuristico> mostrarCentrosTuristicos() throws SQLException {
        if (centrosTuristicos.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                dao.setConnection(connection);
                centrosTuristicos = (Cola<CentroTuristico>) dao.findAll();
            }
        }
        return centrosTuristicos;
    }

    public PilaYCola<CentroTuristico> mostrarCentrosTuristico(int id) throws SQLException {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            return dao.findById(id);
        }
    }

    public void registrarCentroTuristico(CentroTuristico ct) throws SQLException{
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.save(ct);
            centrosTuristicos.clear();
        }
    }

    public void eliminarCentroTuristico(int id) throws SQLException{
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.delete(id);
            centrosTuristicos.clear();
        }
    }

}
