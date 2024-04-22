package org.example.models.dao;

import org.example.estructuras.PilaYCola;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    PilaYCola<T> findById(int id) throws SQLException;

    PilaYCola<T> findAll() throws SQLException;

    void save(T dato) throws SQLException;

    void delete(int id) throws SQLException;

    void setConnection(Connection connection) throws SQLException;
}
