package modelo;

import com.db4o.*;
import com.db4o.query.Predicate;

import java.util.List;

public class Biblioteca {

    private ObjectContainer db;

    public Biblioteca(String nombreBD) {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nombreBD);
    }

    public void cerrar() {
        db.close();
    }

    public void agregarLibro(Libro libro) {
        db.store(libro);
        System.out.println("🔮 Libro añadido a la Biblioteca Mágica: " + libro.getTitulo());
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return db.query(new Predicate<Libro>() {
            public boolean match(Libro libro) {
                return libro.getTitulo().equalsIgnoreCase(titulo);
            }
        });
    }

    public List<Libro> buscarPorAutor(String autor) {
        return db.query(new Predicate<Libro>() {
            public boolean match(Libro libro) {
                return libro.getAutor().equalsIgnoreCase(autor);
            }
        });
    }

    public List<Libro> buscarPorGenero(String genero) {
        return db.query(new Predicate<Libro>() {
            public boolean match(Libro libro) {
                return libro.getGenero().equalsIgnoreCase(genero);
            }
        });
    }

    public void mostrarTodosLosLibros() {
        List<Libro> todos = db.query(Libro.class);
        if (todos.isEmpty()) {
            System.out.println("📚 La biblioteca está vacía.");
        } else {
            System.out.println("📚 Libros encantados disponibles:");
            for (Libro libro : todos) {
                System.out.println(libro);
            }
        }
    }

    public boolean eliminarLibroPorTitulo(String titulo) {
        List<Libro> resultado = buscarPorTitulo(titulo);
        if (resultado.isEmpty()) {
            return false;
        } else {
            for (Libro libro : resultado) {
                db.delete(libro);
            }
            return true;
        }
    }

    public boolean actualizarLibro(String titulo, Libro nuevoLibro) {
        List<Libro> resultado = buscarPorTitulo(titulo);
        if (resultado.isEmpty()) {
            return false;
        } else {
            for (Libro libro : resultado) {
                db.delete(libro);
            }
            db.store(nuevoLibro);
            return true;
        }
    }
}
