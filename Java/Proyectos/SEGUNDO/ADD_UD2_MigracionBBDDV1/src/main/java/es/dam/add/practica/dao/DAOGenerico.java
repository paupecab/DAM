package es.dam.add.practica.dao;

import java.sql.SQLException;
import java.util.List;

//implementacion para insertar en tabla de destino
public interface DAOGenerico<T> {
    //operaciones CRUD
    T get(int id) throws SQLException;
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void deleteById(int id) throws SQLException;

    //listas y verificaciones
    boolean exist(int id) throws SQLException;
    List<T> buscarTodos() throws SQLException;

    //para busqueda
    List<T> buscarPorAtributo(String columna, String valor) throws SQLException;
}
