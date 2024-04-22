package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Piquera {
    List<Taxi> taxis = new ArrayList<>();
    List<Solicitud> solicitudes = new ArrayList<>();
    List<SolicitudEnEjecucion> solicitudesEnEjecucion = new ArrayList<>();
    public void asignarSolicitudes(){
        for (Solicitud solicitud : solicitudes) {
            for (Taxi taxi : taxis) {
                if (taxi.getCapacidad()>=solicitud.getCantPersonas()
                && taxi.getCombustible()*5>= solicitud.getCantKm()){
                    taxis.remove(taxi);
                    solicitudesEnEjecucion.add(new SolicitudEnEjecucion(solicitud,taxi));
                    break;
                }
            }
        }
    }

}
