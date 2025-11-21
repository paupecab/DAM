package es.dam.add.practica.modelo;

import java.sql.Date;

//cliente tabla original
public class Cliente {

    //atributos identicos a la tabla clientes de prac2
    private int id;
    private String nombre;
    private String dni;
    private Date fechaRegistro; // con java.sql.Date
    private double credito;
    private boolean activo;

    //constructor vacio para llenarlo con setters
    public Cliente() {
    }

    //constructor completo sin id porque es autoincrement
    public Cliente(String nombre, String dni, Date fechaRegistro,
                   double credito, boolean activo) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaRegistro = fechaRegistro;
        this.credito = credito;
        this.activo = activo;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public double getCredito() { return credito; }
    public boolean isActivo() { return activo; }

    //Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDni(String dni) { this.dni = dni; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public void setCredito(double credito) { this.credito = credito; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Cliente [id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", credito=" + credito +
                ", activo=" + activo + "]";
    }
}