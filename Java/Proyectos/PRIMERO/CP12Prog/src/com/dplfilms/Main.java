package com.dplfilms;

import com.dplfilms.entidades.Empleado;
import com.dplfilms.servicios.EmpleadoServicio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpleadoServicio servicio = new EmpleadoServicio();

        try {
            // Agregar empleado
            Empleado empleado = new Empleado(0, "Paula Pérez", "Diseño Web", 3000.0, 1);
            servicio.agregarEmpleado(empleado);

            // Actualizar empleado
            empleado.setSalario(3200.0);
            servicio.actualizarEmpleado(empleado);

            // Listar empleados
            List<Empleado> empleados = servicio.listarEmpleados();
            System.out.println("Empleados:");
            for (Empleado e : empleados) {
                System.out.println(e.getId() + " - " + e.getNombre() + " - " + e.getCargo());
            }

            // Consulta compleja
            System.out.println("\nEstos son los empleados y su información de departamento:");
            List<String> info = servicio.listarEmpleadossConDepartamentos();
            for (String s : info) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

