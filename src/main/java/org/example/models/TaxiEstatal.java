package org.example.models;

public class TaxiEstatal extends Taxi{
    private String empresa;

    public TaxiEstatal(String id, String estado, String marca, int capacidad, float combustible, String chofer, String empresa) {
        super(id, estado, marca, capacidad, combustible, chofer);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
