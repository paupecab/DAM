package com.dplfilms.repositorio;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Clase que maneja la conexión con la base de datos

public class ConexionDB {
    private static Connection conexion;

    // Devuelve una conexión activa a la base de datos
    public static Connection getConexion() throws SQLException {
        // Si no existe o está cerrada, la crea usando los datos de configuración
        if (conexion == null || conexion.isClosed()) {
            try (InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("config.properties")) {
                Properties propiedades = new Properties();
                propiedades.load(input);
                String url = propiedades.getProperty("db.url");
                String usuario = propiedades.getProperty("db.user");
                String clave = propiedades.getProperty("db.password");
                conexion = DriverManager.getConnection(url, usuario, clave);
            } catch (Exception e) {
                throw new SQLException("Ha habido un error al cargar la configuración de la base de datos", e);
            } // Lanza una excepción si SQLException si hay algún error al conectar.
        }
        return conexion; // Devuelve el objeto Connection para la base de datos.
    }
}
