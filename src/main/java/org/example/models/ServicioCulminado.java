package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioCulminado extends ServicioEnEjecucion{
    private LocalDate fecha;
    private LocalTime horaFin;

    public ServicioCulminado(Solicitud solicitud, Taxi taxi, LocalDate fecha, LocalTime horaFin) {
        super(solicitud, taxi);
        this.fecha = fecha;
        this.horaFin = horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
