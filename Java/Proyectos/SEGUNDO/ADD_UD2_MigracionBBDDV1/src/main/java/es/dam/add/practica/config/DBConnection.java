package es.dam.add.practica.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//gestiona las conexiones a mysql
public class DBConnection {
    private static final String rutaServidor = "jdbc:mysql://localhost:3306/";
    private static final String usuario = "root";
    private static final String clave = "ranasconpijamas";

    private static DBConnection instancia;

    public static DBConnection getInstancia() {
        if (instancia == null) {
            instancia = new DBConnection();
        }
        return instancia;
    }

    // se puede conectar a prac2 o prac2migra cambiando el parámetro
    public Connection getConnection(String nombreBD) throws SQLException {
        return DriverManager.getConnection(rutaServidor + nombreBD
                + "?allowPublicKeyRetrieval=true&useSSL=false", usuario, clave);
    }
}

