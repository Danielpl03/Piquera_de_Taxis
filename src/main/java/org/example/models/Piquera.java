package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Piquera {
    static List<Taxi> taxis = new ArrayList<>();
    static List<Solicitud> solicitudes = new ArrayList<>();
    static List<SolicitudEnEjecucion> solicitudesEnEjecucion = new ArrayList<>();
    public static void asignarSolicitudes(){
        for (Solicitud solicitud : solicitudes) {
            for (Taxi taxi : taxis) {
                if (taxi.getCapacidad()>=solicitud.getCantPersonas()
                && taxi.getCombustible()*5>= solicitud.getCantKm()){
                    taxis.remove(taxi);
                    solicitudes.remove(solicitud);
                    solicitudesEnEjecucion.add(new SolicitudEnEjecucion(solicitud,taxi));
                    // actualizar base de datos, crear Servicio En ejecucion
                    // eliminar las solicitudes pendientes
                    // y actualizar el estado de los taxis de disponibles a ocupados
                    break;
                }
            }
        }
    }
    public static void procesarSolicitudInmediata(Solicitud solicitud){
        for (Taxi taxi : taxis) {
            if (taxi.getCapacidad()>=solicitud.getCantPersonas()
                    && taxi.getCombustible()*5>= solicitud.getCantKm()){
                taxis.remove(taxi);
                solicitudes.remove(solicitud);
                solicitudesEnEjecucion.add(new SolicitudEnEjecucion(solicitud,taxi));
                // actualizar base de datos, crear Servicio En ejecucion
                // eliminar las solicitudes pendientes
                // y actualizar el estado de los taxis de disponibles a ocupados
                break;
            }
        }
    }
}
