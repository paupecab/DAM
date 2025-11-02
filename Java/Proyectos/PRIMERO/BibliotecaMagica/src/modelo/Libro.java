package modelo;

import java.io.Serializable;

public class Libro implements Serializable {

    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private String estado;
    private String descripcion;

    public Libro(String titulo, String autor, String genero, int anioPublicacion, String estado, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getEstado() { return estado; }
    public String getDescripcion() { return descripcion; }

    // Setters
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void mostrarInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\n📖 Título: " + titulo +
               "\n✍️ Autor: " + autor +
               "\n🔮 Género: " + genero +
               "\n📅 Año de publicación: " + anioPublicacion +
               "\n📦 Estado: " + estado +
               "\n📜 Descripción: " + descripcion +
               "\n----------------------------";
    }
}