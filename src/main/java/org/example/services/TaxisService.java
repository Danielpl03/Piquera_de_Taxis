package org.example.services;

import org.example.estructuras.LinkedList;
import org.example.models.*;
import org.example.models.dao.TaxiDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxisService {
    private static TaxiDao dao;
    private LinkedList<Taxi> taxis;

    public static Taxi crearTaxi(ResultSet rs) throws SQLException {
        Taxi taxi;
        String id = rs.getString("id_chapa");
        String tipo = rs.getString("tipo");
        try(ResultSet rs1 = dao.findTaxi(id,tipo)){
            if(rs.getString("tipo").equals("taxi_estatal")){
                taxi = new TaxiEstatal(id,
                        rs.getString("estado"),
                        rs.getString("marca"),
                        rs.getInt("capacidad"),
                        rs.getFloat("combustible"),
                        rs.getString("chofer"),
                        rs1.getString("nombre_empresa")
                );
            }else{
                taxi = new TaxiParticular(rs.getString("id_chapa"),
                        rs.getString("estado"),
                        rs.getString("marca"),
                        rs.getInt("capacidad"),
                        rs.getFloat("combustible"),
                        rs.getString("chofer"),
                        rs1.getString("no_patente")
                );
            }
        }
        return taxi;
    }
}
