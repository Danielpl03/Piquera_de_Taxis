package org.example.services;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;
import org.example.models.dao.ServicioInmediatoDao;
import org.example.models.dao.SolicitudDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class SolicitudesService {
    private static SolicitudDao dao;
    private static ServicioInmediatoDao sInmediatoDao;
    private static LinkedList<Solicitud> solicitudes;

    public SolicitudesService() {
        dao = new SolicitudDao();
        solicitudes = new Cola<>();
        sInmediatoDao = new ServicioInmediatoDao();
    }

    public static Solicitud crearSolicitud(ResultSet rs) throws SQLException {
        CentroTuristico ct = CentrosTuristicosService.getCentrosTuristico(rs.getInt("id_centro"));
        return new Solicitud(rs.getInt("id_solicitud"), ct,
                rs.getString("direccion"),
                rs.getString("destino"),
                rs.getTime("hora_recogida").toLocalTime(),
                rs.getInt("cant_personas"),
                rs.getFloat("cant_km")
        );
    }

    public boolean asignarSolicitud(Solicitud solicitud){

        return true;
    }

    public static void registrarSolicitud(int id, int index, String direccion, String destino, LocalTime hora, int cantPersonas, float cantKm, boolean inmediata) throws SQLException {
        Solicitud solicitud = new Solicitud(id, CentrosTuristicosService.getCentrosTuristicos().getIndex(index), direccion, destino, hora, cantPersonas, cantKm);
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

    public static Cola<Solicitud> getSolicitudes() throws SQLException {
        try (Connection connection = Postgres.getConnection()){
            dao.setConnection(connection);
            return (Cola<Solicitud>) dao.findAll();
        }
    }

    public static Solicitud getSolicitud(int id) throws SQLException {
        try (Connection connection = Postgres.getConnection()){
            dao.setConnection(connection);
            return dao.findById(id);
        }
    }
}
