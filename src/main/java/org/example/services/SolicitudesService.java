package org.example.services;

import org.example.estructuras.Cola;
import org.example.estructuras.PilaYCola;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;
import org.example.models.dao.ServicioInmediatoDao;
import org.example.models.dao.SolicitudDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;

public class SolicitudesService {
    private SolicitudDao dao;
    private ServicioInmediatoDao sInmediatoDao;
    private Cola<Solicitud> solicitudes;

    public SolicitudesService() {
        dao = new SolicitudDao();
        solicitudes = new Cola<>();
        sInmediatoDao = new ServicioInmediatoDao();
    }

    public boolean asignarSolicitud(Solicitud solicitud){

        return true;
    }

    public void registrarSolicitud(int id, CentroTuristico centro, String direccion, String destino, LocalTime hora, int cantPersonas, float cantKm, boolean inmediata) throws SQLException {
        Solicitud solicitud = new Solicitud(id, centro, direccion, destino, hora, cantPersonas, cantKm);
        try (Connection connection = Postgres.getConnection()) {
            if (inmediata){
                sInmediatoDao.setConnection(connection);
                sInmediatoDao.save(solicitud);
            }else {
                dao.setConnection(connection);
                dao.save(solicitud);
            }
        }
    }

    public PilaYCola<Solicitud> mostrarSolicitudes() throws SQLException {
        try (Connection connection = Postgres.getConnection()){
            dao.setConnection(connection);
            return dao.findAll();
        }
    }

    public PilaYCola<Solicitud> mostrarSolicitud(int id) throws SQLException {
        try (Connection connection = Postgres.getConnection()){
            dao.setConnection(connection);
            return dao.findById(id);
        }
    }
}
