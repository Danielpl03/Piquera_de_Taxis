package org.example.services;

import org.example.estructuras.Cola;
import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.Solicitud;
import org.example.models.SolicitudEnEjecucion;
import org.example.models.Taxi;

import javax.swing.*;
import java.sql.SQLException;

public class Piquera {
    static LinkedList<Taxi> taxis;
    static LinkedList<Solicitud> solicitudes;

    public static void asignarSolicitudes() {
        taxis = TaxisService.getTaxis();
        solicitudes = SolicitudesService.getSolicitudes();
        int cont = 0;
        for (Solicitud solicitud : solicitudes) {
            for (Taxi taxi : taxis) {
                if ( taxi.getEstado().equals("libre") && taxi.getCapacidad() >= solicitud.getCantPersonas()
                        && taxi.getCombustible() *5 >= solicitud.getCantKm()){
                    taxi.setEstado("ocupado");
                    TaxisService.actualizarTaxi(taxi);
                    taxis.remove(taxi);
                    ServiciosService.registrarServicioEnEjecucion(solicitud, taxi);
                    try {
                        SolicitudesService.eliminarSolicitud(solicitud.getId());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Se asignaron ".concat(String.valueOf(cont)).concat(" solicitudes"));
        }
    }
    public static void procesarSolicitudInmediata(Solicitud solicitud) {
        for (Taxi taxi : taxis) {
            if ( taxi.getEstado().equals("disponible") && taxi.getCapacidad() >= solicitud.getCantPersonas()
                    && taxi.getCombustible() *5 >= solicitud.getCantKm()){
                taxi.setEstado("ocupado");
                TaxisService.actualizarTaxi(taxi);
                taxis.remove(taxi);
                ServiciosService.registrarServicioEnEjecucion(solicitud, taxi);
                break;
            }
        }
        // agendar solicitud inmediata
    }
}
