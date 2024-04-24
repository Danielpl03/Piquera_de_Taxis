package org.example.models.dao;

import org.example.estructuras.LinkedList;

import java.sql.Connection;
import java.sql.SQLException;

public interface CrudRepository<T> {
    T findById(int id) throws SQLException;
    T findById(String id) throws SQLException;

    LinkedList<T> findAll() throws SQLException;

    void save(T dato) throws SQLException;

    void delete(int id) throws SQLException;
    void delete(String id) throws SQLException;

    void setConnection(Connection connection) throws SQLException;
}
