package org.example.services;

import org.example.estructuras.LinkedList;
import org.example.estructuras.LinkedListSimple;
import org.example.models.Factura;
import org.example.models.ServicioCulminado;
import org.example.models.dao.FacturaDao;

import java.sql.Connection;
import java.sql.SQLException;

public class FacturasService {
    private static FacturaDao dao = new FacturaDao();
    private static LinkedList<Factura> facturas = new LinkedListSimple<>();

    public static LinkedList<Factura> getFacturas() {
        if (facturas.isEmpty()) {
            try (Connection connection = Postgres.getConnection()) {
                dao.setConnection(connection);
                facturas = dao.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return facturas;
    }

    public static Factura getFactura(int id) {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generarFaturas(LinkedList<ServicioCulminado> servicios) {
        float precioXKm = 0f;
        for (ServicioCulminado servicio: servicios) {
            float precio = servicio.getSolicitud().getCantKm() * precioXKm;
            Factura factura = new Factura(servicio, precio);
            FacturasService.registrarFactura(factura);
        }
        facturas.clear();
    }

    public static void registrarFactura(Factura factura) {
        try (Connection connection = Postgres.getConnection()) {
            dao.setConnection(connection);
            dao.save(factura);
            facturas.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
