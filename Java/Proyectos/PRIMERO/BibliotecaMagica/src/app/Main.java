package modelo;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("bibliotecaMagica.db4o");

        // Instancia de Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú interactivo con símbolos místicos
            System.out.println(".·:*¨¨* ≈☆≈ *¨¨*:·. 🌙🌟 La Biblioteca Mágica Te Invita 🌟🌙 .·:*¨¨* ≈☆≈ *¨¨*:·.");
            System.out.println("1. ✨ Añadir un libro encantado a la colección 📚");
            System.out.println("2. 🔎 Invocar un libro por su título antiguo");
            System.out.println("3. ✍️ Invocar libros por el nombre de su autor");
            System.out.println("4. 📖 Invocar por el género arcano del libro");
            System.out.println("5. 💫 Ver todos los manuscritos");
            System.out.println("6. ❌ Eliminar un grimorio perdido");
            System.out.println("7. 📝 Actualizar los secretos de un libro");
            System.out.println("8. 🚪 Cerrar las puertas de la Biblioteca");
            System.out.print("🌙 Elige tu destino, ¿qué deseas hacer? ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar libro
                    System.out.print(".·:*¨¨* ≈☆≈ *¨¨*:·. Introduce el título del libro encantado 📖: ");
                    String titulo = scanner.nextLine();
                    System.out.print("✍️ Dime el nombre del autor de este manuscrito: ");
                    String autor = scanner.nextLine();
                    System.out.print("📚 ¿A qué género arcano pertenece este manuscrito?: ");
                    String genero = scanner.nextLine();
                    System.out.print("📅 ¿En qué año fue revelado este libro a los mortales?: ");
                    int anioPublicacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("🌟 ¿Este libro está disponible para los aprendices? (Sí/No): ");
                    String estado = scanner.nextLine();
                    System.out.print("✨ Descripción de este misterioso manuscrito: ");
                    String descripcion = scanner.nextLine();

                    Libro libroNuevo = new Libro(titulo, autor, genero, anioPublicacion, estado, descripcion);
                    biblioteca.agregarLibro(libroNuevo);
                    System.out.println("🌟 El manuscrito arcano ha sido añadido con éxito a la Biblioteca Mágica. Cuidado... Alguien te observa... 🌙");
                    break;

                case 2:
                    // Buscar por título
                    System.out.print(".·:*¨¨* ≈☆≈ *¨¨*:·. ¿Qué título deseas buscar en los confines de esta Biblioteca?: ");
                    String buscarTitulo = scanner.nextLine();
                    List<Libro> librosPorTitulo = biblioteca.buscarPorTitulo(buscarTitulo);
                    if (librosPorTitulo.isEmpty()) {
                        System.out.println("😢 No se ha encontrado ningún manuscrito con ese título. ¿Quizás se lo tragó la oscuridad?");
                    } else {
                        librosPorTitulo.forEach(Libro::mostrarInfo);
                    }
                    break;

                case 3:
                    // Buscar por autor
                    System.out.print("✍️ Dime el nombre del autor que creó este libro: ");
                    String buscarAutor = scanner.nextLine();
                    List<Libro> librosPorAutor = biblioteca.buscarPorAutor(buscarAutor);
                    if (librosPorAutor.isEmpty()) {
                        System.out.println("😢 No se ha encontrado nada relacionado con ese hechicero... ¿Tendrá un hechizo de ocultación?");
                    } else {
                        librosPorAutor.forEach(Libro::mostrarInfo);
                    }
                    break;

                case 4:
                    // Buscar por género
                    System.out.print("📚 ¿En qué género arcano te gustaría buscar el libro? ");
                    String buscarGenero = scanner.nextLine();
                    List<Libro> librosPorGenero = biblioteca.buscarPorGenero(buscarGenero);
                    if (librosPorGenero.isEmpty()) {
                        System.out.println("😢 No se ha encontrado ningún manuscrito de esas características.");
                    } else {
                        librosPorGenero.forEach(Libro::mostrarInfo);
                    }
                    break;

                case 5:
                    // Mostrar todos los libros
                    biblioteca.mostrarTodosLosLibros();
                    break;

                case 6:
                    // Eliminar por título
                    System.out.print("≈☆≈ ¿Qué grimorio perdido deseas eliminar de la Biblioteca? ❌: ");
                    String eliminarTitulo = scanner.nextLine();
                    if (biblioteca.eliminarLibroPorTitulo(eliminarTitulo)) {
                        System.out.println("✨ El grimorio ha sido borrado de esta dimensión con éxito! 🌙");
                    } else {
                        System.out.println("😢 No se ha encontrado el grimorio con ese título. Tal vez se encuentre en un plano astral.");
                    }
                    break;

                case 7:
                    // Actualizar libro
                    System.out.print("📚 Introduce el título del libro cuyo contenido deseas actualizar: ");
                    String tituloActualizar = scanner.nextLine();
                    System.out.print("✨ Introduce el nuevo título que deseas darle a este libro encantado: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("✍️ Dime el nuevo nombre del autor que lo ha reescrito: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("📚 ¿A qué nuevo género arcano pertenece este libro?: ");
                    String nuevoGenero = scanner.nextLine();
                    System.out.print("📅 ¿En qué año fue realmente revelado este libro a los mortales?: ");
                    int nuevoAnioPublicacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("🌟 ¿Está disponible para los aprendices? (Sí/No): ");
                    String nuevoEstado = scanner.nextLine();
                    System.out.print("✨ ¿Qué secretos nuevos se revelan en este libro?: ");
                    String nuevaDescripcion = scanner.nextLine();

                    Libro libroActualizado = new Libro(nuevoTitulo, nuevoAutor, nuevoGenero, nuevoAnioPublicacion, nuevoEstado, nuevaDescripcion);
                    if (biblioteca.actualizarLibro(tituloActualizar, libroActualizado)) {
                        System.out.println("🎉 El poder del manuscrito ha sido renovado con éxito. 🌟");
                    } else {
                        System.out.println("😢 No se ha encontrado el libro con ese título, ¿quizás en otra dimensión espacio-temporal?");
                    }
                    break;

                case 8:
                    // Salir
                    System.out.println("🌙✨ Que los vientos mágicos te acompañen, y que haya sido útil tu búsqueda... 🚪");
                    break;

                default:
                    System.out.println("❌ ¡Cuidado! Opción no válida, ¿quién te ha guiado por este camino? 😅 Aquí descansa nuestro goblin... No lo despiertes.");
                    break;
            }
        } while (opcion != 8);

        // Cerrar la base de datos
        biblioteca.cerrar();
        scanner.close();
    }
}
