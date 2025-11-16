package monitores;

import modelo.Pedido;
import java.util.LinkedList;
import java.util.Queue;

//Monitor --> Productor/Consumidor
public class ColaPedidos {
    private final Queue<Pedido> pedidos;
    private final int capacidadMaxima;

    public ColaPedidos(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
        this.pedidos = new LinkedList<>();
    }

    // agrega un pedido a la cola. Si esta llena, el hilo espera.
    public synchronized void agregar(Pedido pedido) throws InterruptedException{

        while (pedidos.size() == capacidadMaxima){
            System.out.println(
                    "["+Thread.currentThread().getName()+"]"+
                    "[ALMACEN]: Capacidad máxima alcanzada: "+capacidadMaxima+". En espera.");
            wait();
        }

        pedidos.add(pedido);
        System.out.println(
                "["+Thread.currentThread().getName()+"][CLIENTE]: Produce pedido "+
                pedido.getId()+". Total en cola: "+pedidos.size());
        notifyAll(); // despertar a los hilos que están esperando
    }

    // Retira un pedido de la cola y lo devuelve. Si esta vacía, el hilo espera.
    public synchronized Pedido retirar() throws InterruptedException{
        Pedido pedido;

        while (pedidos.isEmpty()){
            wait();
            System.out.println(
                    "["+Thread.currentThread().getName()+"][ALMACEN]"+
                            ": Cola vacía. Esperando pedidos.");
        }

        pedido = pedidos.poll(); //retira y devuelve el primer elemento
        System.out.println(
                "["+Thread.currentThread().getName()+"][ALMACEN]"+
                        ": Pedido retirado: "+pedido.getId()+
                        ". Total en cola: "+pedidos.size());

        notifyAll();
        return pedido;
    }
}
