package org.example.services;

import org.example.estructuras.Cola;
import org.example.models.CentroTuristico;
import org.example.models.Solicitud;

import java.sql.SQLException;
import java.time.LocalTime;

public class Services {
    private static Services services;
    private Views views;
    private final SolicitudesService solicitudesService;
    private final CentrosTuristicosService centrosTuristicosService;

    private Services(){
        solicitudesService = new SolicitudesService();
        centrosTuristicosService = new CentrosTuristicosService();
    }

    public static Services getInstance(){
        if (services == null)services = new Services();
        return services;
    }

    //  Solicitudes
    //  Mostrar todas
    public Cola<Solicitud> mostrarSolicitudes() throws SQLException {
        return (Cola<Solicitud>) solicitudesService.mostrarSolicitudes();
    }

    //  Mostrar solicitud x ID
    public Cola<Solicitud> mostrarSolicitud(int id) throws SQLException {
        return (Cola<Solicitud>) solicitudesService.mostrarSolicitud(id);
    }

    //  Resgistrar solicitud
    public void registrarSolicitud(int id, int index, String direccion, String destino, LocalTime hora, int cantPersonas, float cantKm, boolean inmediato) throws SQLException {
        CentroTuristico ct = mostrarCentrosTuristicos().getIndex(index);
        System.out.println(ct);
        solicitudesService.registrarSolicitud(id, ct, direccion, destino, hora, cantPersonas, cantKm, inmediato);
    }


    //  Centros turisticos
    //  Mostrar todos
    public Cola<CentroTuristico> mostrarCentrosTuristicos() throws SQLException {
        return (Cola<CentroTuristico>) centrosTuristicosService.mostrarCentrosTuristicos();
    }

    //  Mostrar Centro turistico x ID
    public Cola<CentroTuristico> mostrarCentroTuristico(int id) throws SQLException {
        return (Cola<CentroTuristico>) centrosTuristicosService.mostrarCentrosTuristico(id);
    }

    //  Registrar Centro turistico
    public void registrarCentroTuristico(CentroTuristico ct) throws SQLException{
        centrosTuristicosService.registrarCentroTuristico(ct);
    }

    //  Eliminar centro Turistico
    public void eliminarCentroTuristico(int id) throws SQLException{
        centrosTuristicosService.eliminarCentroTuristico(id);
    }
}
