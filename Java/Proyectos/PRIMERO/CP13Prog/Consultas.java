package modelo;

import com.db4o.*;
import com.db4o.query.Predicate;

import java.util.List;

public class Consultas {

    private ObjectContainer db;

    public Consultas(String nombreBD) {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nombreBD);
    }

    // Buscar libro por título
    public List<Libro> buscarPorTitulo(String titulo) {
        return db.query(new Predicate<Libro>() {
            public boolean match(Libro libro) {
                return libro.getTitulo().equalsIgnoreCase(titulo);
            }
        });
    }

    // Buscar libro por autor
    public List<Libro> buscarPorAutor(String autor) {
        return db.query(new Predicate<Libro>() {
            public boolean match(Libro libro) {
                return libro.getAutor().equalsIgnoreCase(autor);
            }
        });
    }

    // Buscar libro por género
    public List<Libro> buscarPorGenero(String genero) {
        return db.query(new Predicate<Libro>() {
            public boolean match(Libro libro) {
                return libro.getGenero().equalsIgnoreCase(genero);
            }
        });
    }

    // Eliminar libro por título
    public boolean eliminarLibro(String titulo) {
        List<Libro> libros = buscarPorTitulo(titulo);
        if (libros.isEmpty()) {
            return false;
        } else {
            for (Libro libro : libros) {
                db.delete(libro);
            }
            return true;
        }
    }

    // Actualizar libro
    public boolean actualizarLibro(String titulo, Libro nuevoLibro) {
        List<Libro> libros = buscarPorTitulo(titulo);
        if (libros.isEmpty()) {
            return false;
        } else {
            for (Libro libro : libros) {
                db.delete(libro);
            }
            db.store(nuevoLibro);
            return true;
        }
    }

    // Cerrar conexión con la base de datos
    public void cerrar() {
        db.close();
    }
}
