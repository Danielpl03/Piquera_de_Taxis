package org.example.models;

public class CentroTuristico {
    private int id;
    private String nombre;
    private boolean tieneContrato;

    public CentroTuristico(int id, String nombre, boolean tieneContrato) {
        this.id = id;
        this.nombre = nombre;
        this.tieneContrato = tieneContrato;
    }

    public CentroTuristico(String nombreCentro, boolean tieneContrato) {
        this.tieneContrato = tieneContrato;
        this.nombre = nombreCentro;
    }

    public CentroTuristico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTieneContrato() {
        return tieneContrato;
    }

    public void setTieneContrato(boolean tieneContrato) {
        this.tieneContrato = tieneContrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
