import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private final Map<String, Producto> productos = new HashMap<>();

    // Metodo para agregar productos al inventario
    public void agregarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    // Metodo para obtener un producto por su nombre
    public Producto obtenerProducto(String nombre) {
        return productos.get(nombre);
    }

    // Metodo para procesar un pedido
    // Lanza la excepción personalizada si el producto no está disponible
    public void procesarPedido(Pedido pedido) throws NoDisponibleException {
        Producto producto = obtenerProducto(pedido.getNombreProducto());

        // Validación de existencia y cantidad suficiente
        if (producto == null) {
            throw new NoDisponibleException("El producto '" + pedido.getNombreProducto() +
                    "' no está disponible.");
        }
        if (pedido.getCantidadSolicitada() <= 0) {
            throw new IllegalArgumentException("La cantidad solicitada debe ser mayor que cero.");
        }
        if (producto.getCantidad() < pedido.getCantidadSolicitada()) {
            throw new NoDisponibleException("No hay suficiente stock de '" + pedido.getNombreProducto() +
                    "'. El stock disponible es: " + producto.getCantidad());
        }

        // Si es correcto, se descuenta la cantidad y se registra el pedido
        producto.setCantidad(producto.getCantidad() - pedido.getCantidadSolicitada());
        System.out.println("Pedido registrado: " + pedido.getNombreProducto() + " Cantidad solicitada:" +
                pedido.getCantidadSolicitada());
    }
}