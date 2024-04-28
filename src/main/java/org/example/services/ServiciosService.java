package org.example.services;

import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.ServicioCulminado;
import org.example.models.ServicioEnEjecucion;
import org.example.models.Solicitud;
import org.example.models.Taxi;
import org.example.models.dao.ServciosEnEjecucionDao;
import org.example.models.dao.ServicioCulminadoDao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServiciosService {
    private static ServciosEnEjecucionDao daoEjecucion = new ServciosEnEjecucionDao();
    private static ServicioCulminadoDao daoCulminado = new ServicioCulminadoDao();
    private static LinkedList<ServicioEnEjecucion> serviciosEnEjecucion = new LinkedListSimple<>();
    private static LinkedList<ServicioCulminado> serviciosCulminados = new LinkedListSimple<>();

    public static void registrarServicioEnEjecucion(Solicitud solicitud, Taxi taxi) {
        ServicioEnEjecucion servicioEnEjecucion = new ServicioEnEjecucion(solicitud, taxi);
        servicioEnEjecucion.getSolicitud().setId(0);
        try(Connection connection = Postgres.getConnection()){
            daoEjecucion.setConnection(connection);
            daoEjecucion.save(servicioEnEjecucion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        serviciosEnEjecucion.clear();
    }

    public static LinkedList<ServicioEnEjecucion> getServciosEnEjecucion() {
        if(serviciosEnEjecucion.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                daoEjecucion.setConnection(connection);
                serviciosEnEjecucion = daoEjecucion.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return serviciosEnEjecucion;
    }

    public static ServicioEnEjecucion getServcioEnEjecucion(int id) {
        try (Connection connection = Postgres.getConnection()) {
            daoEjecucion.setConnection(connection);
            return daoEjecucion.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cancelarServicioEnEjecucion(int id){
        try (Connection connection = Postgres.getConnection()) {
            daoEjecucion.setConnection(connection);
            Taxi taxi = serviciosEnEjecucion.get(id).getTaxi();
            taxi.setEstado("libre");
            TaxisService.actualizarTaxi(taxi);
            daoEjecucion.delete(serviciosEnEjecucion.get(id).getSolicitud().getId());
            serviciosEnEjecucion.clear();
            JOptionPane.showMessageDialog(null, "Se ha cancelado el servicio y el taxi "
                    .concat(taxi.getId()).concat(" se ha marcado como libre"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void marcarServicioComoTerminado(ServicioEnEjecucion servicioEnEjecucion){
        Taxi taxi = servicioEnEjecucion.getTaxi();
        taxi.setEstado("libre");
        taxi.setCombustible(taxi.getCombustible() - (servicioEnEjecucion.getSolicitud().getCantKm() / 5) );
        TaxisService.actualizarTaxi(taxi);
        try {
            registrarServicioCulminado(servicioEnEjecucion, 2f);
            daoEjecucion.delete(servicioEnEjecucion.getSolicitud().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        serviciosEnEjecucion.clear();
    }

    // SERVICIOS CULMINADOS
    public static void registrarServicioCulminado(ServicioEnEjecucion servicioEnEjecucion, float precio){
        ServicioCulminado servicioCulminado = new ServicioCulminado(
                servicioEnEjecucion.getSolicitud(),
                servicioEnEjecucion.getTaxi(),
                LocalDate.now(),
                LocalTime.now()
        );
        try(Connection connection = Postgres.getConnection()){
            daoCulminado.setConnection(connection);
            daoCulminado.save(servicioCulminado);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        serviciosCulminados.clear();
    }

    public static LinkedList<ServicioCulminado> getServiciosCulminados(){
        if (serviciosCulminados.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                daoCulminado.setConnection(connection);
                serviciosCulminados = daoCulminado.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return serviciosCulminados;
    }

    public static ServicioCulminado getServicioCulminado(int id){
        try (Connection connection = Postgres.getConnection()) {
            daoCulminado.setConnection(connection);
            return daoCulminado.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
