package org.example.models;

import java.time.LocalTime;

public class Solicitud {
    private int id;
    private CentroTuristico centro;
    private String direccion;
    private String destino;
    private LocalTime hora;
    private int cantPersonas;
    private float cantKm;

    public Solicitud(int id, CentroTuristico centro, String direccion, String destino, LocalTime hora, int cantPersonas, float cantKm) {
        this.id = id;
        this.centro = centro;
        this.direccion = direccion;
        this.destino = destino;
        this.hora = hora;
        this.cantPersonas = cantPersonas;
        this.cantKm = cantKm;
    }

    public Solicitud() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CentroTuristico getCentro() {
        return centro;
    }

    public void setCentro(CentroTuristico centro) {
        this.centro = centro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public float getCantKm() {
        return cantKm;
    }

    public void setCantKm(float cantKm) {
        this.cantKm = cantKm;
    }
}
