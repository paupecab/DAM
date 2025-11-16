package hilos;

import monitores.ColaPedidos;
import modelo.*;
import monitores.GestorExclusivos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/* Cliente es productor de pedidos. Puede elegir aleatoriamente entre:

A. Hacer un pedido de productos normales el 70% de veces
B. Hacer un pedido de paquete de productos exclusivos el 30% de veces

Pedidos en general:
- Id de pedido

Pedidos de producto normal:
- Lista Carrito de producto
- Genera un número aleatorio de productos diferentes con cantidad aleatoria
- En un bucle, crea instancias de Producto y las agrega a la lista

Pedidos de productos exclusivos:
- Lista paquete
- Llama a gestorExclusivos e intenta comprar el paquete
- Si devuelve false el pedido se cancela, el hilo se interrumpe
y no añade pedido a la cola.
*/
public class Cliente extends Thread {
    private final ColaPedidos colaPendientes;
    private static int contadorId = 1;
    private final GestorExclusivos gestorExclusivos;

    // creamos una lista que simula el catalogo de productos
    private static final String[][] CATALOGO_PRODUCTOS = {
            {"L-01", "Frankenstein"},
            {"L-02", "Cumbres borrascosas"},
            {"L-03", "Crimen y castigo"},
            {"L-04", "Tokyo Blues"},
            {"L-05", "A sangre fria"},
            {"L-06", "El color purpura"},
            {"L-07", "Romancero gitano"},
            {"L-08", "El retrado de Dorian Grey"},
            {"L-09", "Jane Eyre"},
            {"L-10", "Caida de la Casa Usher"},
    };

    // productos exclusivos
    private static final String[] exclusivos = {"A", "B", "C", "D", "E", "F"};

    // creacion de instancias con un contador unico que se incrementa
    private static synchronized int siguienteId(){
        return contadorId++; //devuelve el valor actual e incrementa en 1
    }

    public Cliente(ColaPedidos colaPendientes, GestorExclusivos gestorExclusivos){
        this.colaPendientes = colaPendientes;
        this.gestorExclusivos = gestorExclusivos;
    }

    @Override
    public void run() {
        while(true){
            try{
                int idPedido = siguienteId();

                if (ThreadLocalRandom.current().nextDouble() < 0.5) {
                    // ---- COMPRA DE PRODUCTOS NORMALES ----

                    List<Producto> carrito = new ArrayList<>();

                    // generar productos aleatorios
                    int cantidadDistintos = ThreadLocalRandom.current().nextInt(1, 4);

                    for (int i = 0; i < cantidadDistintos; i++) {
                        // Seleccionar un producto aleatorio del array
                        String[] productoElegido =
                                CATALOGO_PRODUCTOS[ThreadLocalRandom.current().
                                        nextInt(CATALOGO_PRODUCTOS.length)];

                        String ID = productoElegido[0];
                        String nombre = productoElegido[1];
                        int cantidad = ThreadLocalRandom.current().nextInt(1, 6);

                        // Crear el Producto con ID, Nombre y Cantidad
                        Producto nuevoProducto = new Producto(ID, nombre, cantidad);
                        carrito.add(nuevoProducto);
                    }

                    Pedido nuevoPedido = new Pedido(idPedido, carrito, EstadoPedido.PENDIENTE);
                    colaPendientes.agregar(nuevoPedido);
                }else{
                    // ---- COMPRA DE PRODUCTOS EXCLUSIVOS ----

                    // ids de productos exclusivos
                    int idP1= ThreadLocalRandom.current().nextInt(exclusivos.length);
                    // P2 no puede ser el mismo que P1
                    int idP2;
                    do {
                        idP2 = ThreadLocalRandom.current().nextInt(exclusivos.length);
                    } while (idP1 == idP2);

                    String p1 = exclusivos[idP1];
                    String p2 = exclusivos[idP2];

                    // intentar comprar
                    boolean exito = gestorExclusivos.intentarComprar(getName(), p1, p2);
                    if(exito){
                        List<Producto> paquete = new ArrayList<>();
                        paquete.add(new Producto(p1, "Edicion especial " + p1, 1));
                        paquete.add(new Producto(p2, "Edicion especial " + p2, 1));

                        Pedido nuevoPedido = new Pedido(idPedido, paquete, EstadoPedido.PENDIENTE);
                        colaPendientes.agregar(nuevoPedido);
                    }else{
                        System.out.println("<<< [" + Thread.currentThread().getName() + "] " +
                                "No se ha podido generar el " +
                                "pedido de exclusivos: Pedido "+idPedido);
                    }
                }
                //Esperar entre un pedido y otro
                //Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5001));

            }catch (InterruptedException e){
                System.out.println("["+Thread.currentThread().getName()
                        +"][GESTOR]: Terminado por interrupcion.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
