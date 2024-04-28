package org.example.models;


public abstract class Taxi {
    private String id;
    private String estado;
    private String marca;
    private int capacidad;
    private float combustible;
    private String chofer;

    public Taxi() {
    }

    public Taxi(String id) {
        this.id = id;
    }

    public Taxi(String id, String estado, String marca, int capacidad, float combustible, String chofer) {
        this.id = id;
        this.estado = estado;
        this.marca = marca;
        this.capacidad = capacidad;
        this.combustible = combustible;
        this.chofer = chofer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getCombustible() {
        return combustible;
    }

    public void setCombustible(float combustible) {
        this.combustible = combustible;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getTipo(){
        return this instanceof TaxiEstatal ? ((TaxiEstatal)this).getEmpresa()
                                           : ((TaxiParticular)this).getNoPatente()
        ;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id='" + id + '\'' +
                ", estado='" + estado + '\'' +
                ", marca='" + marca + '\'' +
                ", capacidad=" + capacidad +
                ", combustible=" + combustible +
                ", chofer='" + chofer + '\'' +
                '}';
    }
}
