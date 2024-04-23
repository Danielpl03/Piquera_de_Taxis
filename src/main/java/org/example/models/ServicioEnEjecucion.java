package org.example.models;

public class ServicioEnEjecucion {
    private Solicitud solicitud;
    private Taxi taxi;

    public ServicioEnEjecucion(Solicitud solicitud, Taxi taxi) {
        this.solicitud = solicitud;
        this.taxi = taxi;
    }

    public ServicioEnEjecucion() {
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}
