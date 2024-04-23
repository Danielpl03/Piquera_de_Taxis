package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ServicioCulminado {
    private ServicioEnEjecucion servicioEnEjecucion;
    private LocalDate fecha;
    private LocalTime horaFin;

    public ServicioCulminado(ServicioEnEjecucion servicioEnEjecucion, LocalDate fecha, LocalTime horaFin) {
        this.servicioEnEjecucion = servicioEnEjecucion;
        this.fecha = fecha;
        this.horaFin = horaFin;
    }

    public ServicioEnEjecucion getServicioEnEjecucion() {
        return servicioEnEjecucion;
    }

    public void setServicioEnEjecucion(ServicioEnEjecucion servicioEnEjecucion) {
        this.servicioEnEjecucion = servicioEnEjecucion;
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
