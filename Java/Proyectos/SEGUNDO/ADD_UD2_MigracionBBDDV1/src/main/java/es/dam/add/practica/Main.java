package es.dam.add.practica;

import es.dam.add.practica.dao.ClienteDAO;
import es.dam.add.practica.modelo.Cliente;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//simulacro
public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIO DEL SIMULACRO ---");

        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            // comprobar conexión y limpiar tabla
            System.out.println("Comprobando conexión...");
            if (clienteDAO.buscarTodos().isEmpty()) {
                System.out.println("La tabla está vacía. Procediendo a carga inicial.");
            } else {
                System.out.println("La tabla ya tiene datos.");
            }

            //generar 50 clientes ficticios en memoria
            System.out.println("Generando 50 clientes ficticios...");
            List<Cliente> listaParaCargar = new ArrayList<>();

            for (int i = 1; i <= 50; i++) {
                Cliente c = new Cliente();
                c.setNombre("Cliente " + i);
                c.setDni(generarDni(i));
                c.setFechaRegistro(Date.valueOf(LocalDate.now())); // fecha de hoy
                c.setCredito(100.0 + (i * 10));
                c.setActivo(i % 2 == 0); // pares activos, impares inactivos

                listaParaCargar.add(c);
            }

            // insertar con batch
            System.out.println("Ejecutando carga masiva (Batch)...");
            clienteDAO.insertarClientes(listaParaCargar);

            // comprobacion
            List<Cliente> clientesEnBD = clienteDAO.buscarTodos();
            System.out.println("--- RESULTADO ACTUAL EN BD ---");
            System.out.println("Total clientes registrados: " + clientesEnBD.size());

            // mostramos los 10 primeros
            if (!clientesEnBD.isEmpty()) {
                System.out.println("Mostrando 10 primeros: ");
            for(int i=1; i<10; i++){System.out.println(clientesEnBD.get(i).toString());}
            }

        } catch (SQLException e) {
            System.err.println("ERROR CRÍTICO EN LA BD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String generarDni(int numero) {
        String numeroString = String.format("%08d", numero);
        return numeroString + "A";
    }
}
