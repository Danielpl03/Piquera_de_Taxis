package org.example.models;

public class Factura {
    private int idFactura;
    private ServicioCulminado servicioCulminado;
    private float precio;

    public Factura(ServicioCulminado servicioCulminado, float precio) {
        this.servicioCulminado = servicioCulminado;
        this.precio = precio;
    }

    public ServicioCulminado getServicioCulminado() {
        return servicioCulminado;
    }

    public void setServicioCulminado(ServicioCulminado servicioCulminado) {
        this.servicioCulminado = servicioCulminado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
}
