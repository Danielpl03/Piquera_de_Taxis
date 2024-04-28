package org.example.models;

public class TaxiParticular extends Taxi{
    private String noPatente;

    public TaxiParticular() {
    }

    public TaxiParticular(String id, String estado, String marca, int capacidad, float combustible, String chofer, String noPatente) {
        super(id, estado, marca, capacidad, combustible, chofer);
        this.noPatente = noPatente;
    }

    public String getNoPatente() {
        return noPatente;
    }

    public void setNoPatente(String noPatente) {
        this.noPatente = noPatente;
    }
}
