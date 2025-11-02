import java.util.Arrays;
import java.util.List;

public class GestionPedidos {
    public static void main(String[] args) {
        // Crear inventario y agregar productos
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Producto("Portátil", 10));
        inventario.agregarProducto(new Producto("Ratón", 5));
        inventario.agregarProducto(new Producto("Teclado", 2));

        // Creamos una lista de pedidos para procesar
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Portátil", 2),
                new Pedido("Ratón", 6), // Excepción: no hay suficiente stock
                new Pedido("Teclado", 1),
                new Pedido("Monitor", 1), // Excepción: producto no existe
                new Pedido("Portátil", 0)  // Excepción: cantidad inválida
        );

        // Procesamiento de cada pedido con try/catch/finally
        for (Pedido pedido : pedidos) {
            try {
                inventario.procesarPedido(pedido);
            } catch (NoDisponibleException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error de validación: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                // Para cubrir cualquier otra excepción que no se haya anticipado
            } finally {
                // Este bloque se ejecuta siempre, haya o no excepción
                System.out.println("El intento de procesamiento para: " + pedido.getNombreProducto() +
                        " ha finalizado.");
            }
        }

        // Mostrar el inventario final después de procesar los pedidos
        System.out.println("El inventario final es:");
        for (String nombre : Arrays.asList("Portátil", "Ratón", "Teclado")) {
            Producto p = inventario.obtenerProducto(nombre);
            System.out.println(nombre + ": " + (p != null ? p.getCantidad() : "No existe"));
        }
    }
}
