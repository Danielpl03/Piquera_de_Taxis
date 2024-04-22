package org.example.models;

public class SolicitudEnEjecucion {
    Solicitud solicitud;
    Taxi taxi;

    public SolicitudEnEjecucion(Solicitud solicitud, Taxi taxi) {
        this.solicitud = solicitud;
        this.taxi = taxi;
    }
}
