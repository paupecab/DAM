package com.dplfilms.repositorio;

import com.dplfilms.entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase que gestiona las operaciones CRUD de empleados.
 
public class EmpleadoRepositorio {

    // Agregar un empleado a la base de datos
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO empleados (nombre, cargo, salario, departamento_id) VALUES (?, ?, ?, ?)";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            conexion.setAutoCommit(false);

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getCargo());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setInt(4, empleado.getDepartamentoId());

            pstmt.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    // Actualizar un empleado existente
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        String sql = "UPDATE empleados SET nombre=?, cargo=?, salario=?, departamento_id=? WHERE id=?";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getCargo());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setInt(4, empleado.getDepartamentoId());
            pstmt.setInt(5, empleado.getId());

            pstmt.executeUpdate();
        }
    }

    // Listar todos los empleados
    public List<Empleado> listarEmpleados() throws SQLException {
        String sql = "SELECT * FROM empleados";
        List<Empleado> empleados = new ArrayList<>();
        try (Connection conexion = ConexionDB.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empleado empleado = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("cargo"),
                    rs.getDouble("salario"),
                    rs.getInt("departamento_id")
                );
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    // Consulta compleja: empleados con información de departamentos y salario medio del departamento
    public List<String> listarEmpleadosConDepartamentos() throws SQLException {
        String sql = "SELECT e.nombre AS nombre_empleado, d.nombre_departamento, " +
                     "(SELECT AVG(salario) FROM empleados WHERE departamento_id = e.departamento_id) AS salario_medio " +
                     "FROM empleados e JOIN departamentos d ON e.departamento_id = d.id";
        List<String> resultado = new ArrayList<>();
        try (Connection conexion = ConexionDB.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String info = rs.getString("nombre_empleado") + " | " +
                              rs.getString("nombre_departamento") + " | " +
                              "Salario medio: " + rs.getDouble("salario_medio");
                resultado.add(info);
            }
        }
        return resultado;
    }
}
