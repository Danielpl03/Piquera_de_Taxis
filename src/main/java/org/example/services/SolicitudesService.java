package org.example.services;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;
import org.example.models.dao.ServicioInmediatoDao;
import org.example.models.dao.SolicitudDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class SolicitudesService {
    private static SolicitudDao daoSolicitud = new SolicitudDao();
    private static ServicioInmediatoDao daoSolicitudInmediata = new ServicioInmediatoDao();
    private static LinkedList<Solicitud> solicitudes = new Cola<>();

    public static Solicitud crearSolicitud(ResultSet rs) {
        CentroTuristico ct = null;
        try {
            ct = CentrosTuristicosService.getCentrosTuristico(rs.getInt("id_centro"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            return new Solicitud(rs.getInt("id_solicitud"), ct,
                    rs.getString("direccion"),
                    rs.getString("destino"),
                    rs.getTime("hora_recogida").toLocalTime(),
                    rs.getInt("cant_personas"),
                    rs.getFloat("cant_km")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean asignarSolicitud(Solicitud solicitud){

        return true;
    }

    public static void registrarSolicitud(int id, int index, String direccion, String destino, LocalTime hora, int cantPersonas, float cantKm, boolean inmediata) {
        Solicitud solicitud = new Solicitud(id, CentrosTuristicosService.getCentrosTuristicos().get(index), direccion, destino, hora, cantPersonas, cantKm);
        try (Connection connection = Postgres.getConnection()) {
            if (inmediata){
                daoSolicitudInmediata.setConnection(connection);
                daoSolicitudInmediata.save(solicitud);
            }else {
                daoSolicitud.setConnection(connection);
                daoSolicitud.save(solicitud);
                solicitudes.clear();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Cola<Solicitud> getSolicitudes()  {
        if (solicitudes.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                daoSolicitud.setConnection(connection);
                solicitudes = daoSolicitud.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return (Cola<Solicitud>) solicitudes;
    }

    public static Solicitud getSolicitud(int id) {
        try (Connection connection = Postgres.getConnection()){
            daoSolicitud.setConnection(connection);
            return daoSolicitud.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarSolicitud(int id) {
        try (Connection connection = Postgres.getConnection()) {
            daoSolicitud.setConnection(connection);
            daoSolicitud.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
