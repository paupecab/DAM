package repositorio;
import excepciones.DiscoInvalidoExcepcion;
import excepciones.StockInsuficienteExcepcion;
import java.util.*;

public class Tienda {
    private ArrayList<Disco> discos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Metodo iniciar llama a cada método en cada opción.
    public void iniciar(){
        while(true) {
            mostrarMenu();
            try {
            String entrada = scanner.nextLine();
            int opcion = Integer.parseInt(entrada.trim());
            switch(opcion){
                case 1: agregarDisco(); break;
                case 2: venderDisco(); break;
                case 3: reponerStock(); break;
                case 4: listarDiscos(); break;
                case 5: escucharCancion(); break;
                case 6: buscarDiscoTitulo(); break;
                case 7: buscarDiscoArtista(); break;
                case 8: buscarDiscoGenero(); break;
                case 9: System.out.println("Hasta la próxima!"); System.exit(0);
                default: System.out.println("Vaya, eso no vale.");
            }
            } 
            catch (NumberFormatException e){
                System.out.println("Por favor, introduce un número válido");
            }
        }
    }

    // Metodo que imprime por pantalla las opciones
    private void mostrarMenu(){
        System.out.println("\n=====MENU DISCOS PEARL=====");
        System.out.println("1. Agregar un disco");
        System.out.println("2. Vender un disco");
        System.out.println("3. Reponer stock");
        System.out.println("4. Listar toooodos los discos");
        System.out.println("5. Escuchar una canción");
        System.out.println("6. Buscar un disco por su Título");
        System.out.println("7. Buscar un disco por su Artista");
        System.out.println("8. Buscar un disco por su Género");
        System.out.println("9. Salir en busca de otra vibra");
        System.out.println("Selecciona una opción: ");
    }

    private void agregarDisco() {
        try {
            System.out.print("\nTítulo: ");
            String titulo = scanner.nextLine();

            System.out.print("Artista: ");
            String artista = scanner.nextLine();

            System.out.print("Género: ");
            String genero = scanner.nextLine();

            System.out.print("Introduce las canciones, separadas por comas: ");
            String linea = scanner.nextLine();
            String[] arrayCanciones = linea.split(",");
            ArrayList<String> canciones = new ArrayList<>(Arrays.asList(arrayCanciones));
            // Quitar espacios al inicio y al final de cada cancion
            for (int i = 0; i < canciones.size(); i++) {
                canciones.set(i, canciones.get(i).trim());
            }

            System.out.print("Precio: ");
            float precio = Float.parseFloat(scanner.nextLine());

            System.out.println("Stock actual: ");
            int stock = Integer.parseInt(scanner.nextLine());

            Disco nuevo = new Disco(titulo, artista, genero, arrayCanciones, precio, stock);
            discos.add(nuevo);
            System.out.println("Disco agregado con éxito! Let there be rock ;)");
            
        } catch (DiscoInvalidoExcepcion | StockInsuficienteExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Disco buscarDisco(String titulo){
        for (Disco d : discos) {
            if (d.getTitulo().equalsIgnoreCase(titulo)) {
                return d;
            }
        } return null;
    }
    

    private void venderDisco(){
        System.out.println("\nTitulo del disco: ");
        String titulo = scanner.nextLine();
        Disco disco = buscarDisco(titulo);
        if (disco == null) {
            System.out.println("Disco no encontrado :(");
        }
        else{
        try {
            System.out.print("Cantidad a vender: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            disco.venderDisco(cantidad);
            System.out.println("Se han vendido "+cantidad+" discos! Stock actual: "+ disco.getStock());
        } catch (StockInsuficienteExcepcion e) {
            System.out.println("Error: " + e.getMessage()); 
        }
        }
    }

    private void reponerStock() {
        System.out.print("\nTitulo del disco: ");
        String titulo = scanner.nextLine();
        Disco disco = buscarDisco(titulo);
        if(disco == null) {
            System.out.println("Disco no encontrado");
            return;
        }
        try {
            System.out.print("Cantidad a reponer: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            disco.reponerStock(cantidad);
            System.out.println("Se han añadido "+cantidad+" discos al stock! Stock actual: "+ disco.getStock());
        } catch (StockInsuficienteExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }

    private void listarDiscos() {
        if(discos.isEmpty()) {
            System.out.println("\nNo hay discos registrados... aún.");
        }
        else{
            System.out.println("\nLISTA DE DISCOS:");
            System.out.printf("%-20s %-40s %-10s %-10s %-5s%n", 
                "Título", "Artista", "Género", "Precio", "Stock");
        
            for(Disco d : discos){
                System.out.printf("%-20s %-40s %-10s %-9.2f %-5d%n", 
                    d.getTitulo(), d.getArtista(), d.getGenero(), d.getPrecio(), d.getStock());
            }
        }
    }

    private void escucharCancion() {
        System.out.print("\nTítulo del disco: ");
        String titulo = scanner.nextLine();
        Disco disco = buscarDisco(titulo);
            if (disco == null) {
                System.out.println("Disco no encontrado :(");
                return;
            }
        System.out.print("Introduce el nombre de la canción: ");
        String cancion = scanner.nextLine();
        disco.escucharCancion(cancion);
}

    private void buscarDiscoTitulo() {
        System.out.print("\nIntroduce el título del disco: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Disco d : discos) {
            if (d.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.printf("%-20s %-40s %-10s %-10s %-5s%n", 
            "Título", "Artista", "Género", "Precio", "Stock");
                System.out.printf("%-20s %-40s %-10s %-9.2f %-5d%n",
                d.getTitulo(), d.getArtista(), d.getGenero(), d.getPrecio(), d.getStock());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se han encontrado discos con ese título :(");
        }
    }

    private void buscarDiscoArtista() {
        System.out.print("\nIntroduce el nombre del artista: ");
        String artista = scanner.nextLine();
        boolean encontrado = false;
        for (Disco d : discos) {
            if (d.getArtista().equalsIgnoreCase(artista)) {
                System.out.printf("%-20s %-40s %-10s %-10s %-5s%n", 
            "Título", "Artista", "Género", "Precio", "Stock");
                System.out.printf("%-20s %-40s %-10s €%-9.2f %-5d%n",
                d.getTitulo(), d.getArtista(), d.getGenero(), d.getPrecio(), d.getStock());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se han encontrado discos de ese artista :(");
        }
    }

    private void buscarDiscoGenero() {
        System.out.print("\nIntroduce el género del disco: ");
        String genero = scanner.nextLine();
        boolean encontrado = false;
        for (Disco d : discos) {
            if (d.getGenero().equalsIgnoreCase(genero)) {
                System.out.printf("%-20s %-40s %-10s %-10s %-5s%n", 
            "Título", "Artista", "Género", "Precio", "Stock");
                System.out.printf("%-20s %-40s %-10s %-9.2f %-5d%n",
                d.getTitulo(), d.getArtista(), d.getGenero(), d.getPrecio(), d.getStock());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se han encontrado discos de ese género :(");
        }
    }
}

