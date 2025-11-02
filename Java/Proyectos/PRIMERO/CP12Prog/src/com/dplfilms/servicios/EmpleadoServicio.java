package com.dplfilms.servicios;

import com.dplfilms.repositorio.EmpleadoRepositorio;
import com.dplfilms.entidades.Empleado;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoServicio {
    private EmpleadoRepositorio empleadoRepositorio = new EmpleadoRepositorio();

    public void agregarEmpleado(Empleado empleado) throws SQLException {
        empleadoRepositorio.agregarEmpleado(empleado);
    }

    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        empleadoRepositorio.actualizarEmpleado(empleado);
    }

    public List<Empleado> listarEmpleados() throws SQLException {
        return empleadoRepositorio.listarEmpleados();
    }

    public List<String> listarEmpleadosConDepartamentos() throws SQLException {
        return empleadoRepositorio.listarEmpleadosConDepartamentos();
    }
}

