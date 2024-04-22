package org.example;

import org.example.models.CentroTuristico;
import org.example.services.Postgres;

import java.sql.*;
import java.util.Scanner;


public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Connection connection = Postgres.getConnection();
//        System.out.println(connection);
//        PilaYCola<Solicitud> solicitudes = new Cola<>();
//        try(Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Solicitudes")) {
//            while (rs.next()){
//                solicitudes.push(crearSolicitud(rs));
//            }
//        }
//        System.out.println(solicitudes);

//        PilaYCola<CentroTuristico> centros = new Cola<>();
//        try(Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Centros_Turisticos")){
//            while(rs.next()){
//                centros.push(crearCentroTuristico(rs));
//            }
//        }
//        System.out.println(centros);
//        Node<CentroTuristico> nodo = centros.top();
//        while(nodo != null){
//            System.out.println(nodo.getDate().getId() + "  " + nodo.getDate().getNombre()
//            +"  "+ nodo.getDate().getDireccion());
//
//            nodo = nodo.getNext();
//        }
    }
//    private static Solicitud crearSolicitud(ResultSet rs) throws SQLException {
//        CentroTuristico ct = new CentroTuristico(rs.getString("Nombre_centro"));
//        return new Solicitud(rs.getInt("Id_Solicitud"), ct,
//                rs.getString("Direccion"),
//                rs.getString("Destino"),
//                rs.getTime("Hora_Recogida").toLocalTime(),
//                rs.getInt("Cant_Personas"),
//                rs.getFloat("Cant_Km")
//        );
//    }

    private static CentroTuristico crearCentroTuristico(ResultSet rs) throws SQLException {
        return new CentroTuristico(
                rs.getInt("id_centro"),
                rs.getString("nombre_centro"),
                rs.getBoolean("Tiene_contrato"));
    }
}