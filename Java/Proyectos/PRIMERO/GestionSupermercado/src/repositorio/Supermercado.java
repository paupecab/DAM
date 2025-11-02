package repositorio;

import excepciones.*;
import java.util.*;

public class Supermercado {
    // ATRIBUTOS
    private ArrayList<Producto> productos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar(){
        while(true) { 
          try { 
            mostrarMenu();
            String entrada = scanner.nextLine();
            int opcion = Integer.parseInt(entrada.trim());
            switch(opcion){
                case 1: agregarProducto(); break;
                case 2: venderProducto(); break;
                case 3: reponerStock(); break;
                case 4: mostrarProductos(); break;
                case 5: System.out.println("¡Hasta la próxima!"); System.exit(0);
                default: System.out.println("Ups, esa no es una opción válida");
            }       
          } catch (NumberFormatException e){
                System.out.println("Debes introducir un numero válido.");
          }  
        }
    }

    // METODO mostrarMenu() que muestra todas las opciones al usuario. Es la interfaz gráfica.
    private void mostrarMenu() {
        System.out.println("\n··········MENÚ SUPERMERCADO·········");
        System.out.println("1. Agregar un producto al supermercado.");
        System.out.println("2. Vender un producto.");
        System.out.println("3. Reponer el stock de un producto.");
        System.out.println("4. Mostrar todos los productos del supermercado.");
        System.out.println("5. Salir.");
        System.out.println("¡Bienvenidx! ¿Qué quieres hacer? Selecciona una opción.");
    }
    
    // METODO buscarProducto para el resto de metodos
    private Producto buscarProducto(String nombre) {
        for(Producto p : productos) {
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            } 
        } return null;
    }

    private void agregarProducto() {
        try{
        System.out.println("\nIntroduce el nombre del producto: "); 
        String nombre = scanner.nextLine();

        System.out.println("\nIntroduce la categoría del producto: "); 
        String categoria = scanner.nextLine();

        System.out.println("\nIntroduce el precio del producto: ");
        float precio = Float.parseFloat(scanner.nextLine());

        System.out.println("\nIntroduce el stock actual del producto: "); 
        int stock = Integer.parseInt(scanner.nextLine());

        Producto nuevo = new Producto(nombre, categoria, precio, stock);
        productos.add(nuevo);

        System.out.println("¡Has agregado un producto con éxito!");
        } catch (ProductPrecioException | StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void venderProducto() {
        if (productos.isEmpty()) {
            System.out.println("Aún no hay productos. ¿Por qué no añades uno?");
            return;
        }

        System.out.println("\nIntroduce el nombre del producto a vender: "); 
        String nombre = scanner.nextLine();
        Producto p = buscarProducto(nombre);

        if(p==null){
            System.out.println("Ups! El producto no se ha encontrado.");
            return;
        }

        System.out.println("\nIntroduce la cantidad del producto a vender: ");
        String entrada = scanner.nextLine();
        int cantidad = Integer.parseInt(entrada.trim());

        try{
            p.venderProducto(cantidad);
            System.out.println("Enhorabuena! Se han vendido correctamente las "+cantidad+" unidades de "+p.getNombre());
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }       
    }
    

    private void reponerStock() {
        if (productos.isEmpty()) {
            System.out.println("Aún no hay productos. ¿Por qué no añades uno?");
            return;
        }

        System.out.println("\nIntroduce el nombre del producto a reponer: ");
        String nombre = scanner.nextLine();
        Producto p = buscarProducto(nombre);

        if(p==null){
            System.out.println("Ups! El producto no se ha encontrado.");
            return;
        }

        System.out.println("\nIntroduce la cantidad del producto a reponer: ");
        String entrada = scanner.nextLine();
        int cantidad = Integer.parseInt(entrada.trim());

        try{
            p.reponerStock(cantidad);
            System.out.println("¡Has repuesto el stock del producto con éxito! Ahora hay "
            +p.getStock()+" unidades de "+p.getNombre()+" disponibles.");
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Aún no hay productos que mostrar. ¿Por qué no añades uno?");
            return;
        }

        System.out.printf("%-30s %-30s %-11s %-5s%n","Nombre","Categoria",
        "Precio","Stock");
        for(Producto p : productos){
            System.out.printf("%-30s %-30s %-9.2f %-5d%n",p.getNombre(),p.getCategoria(),p.getPrecio(),p.getStock());
        }   
    }
    
}
