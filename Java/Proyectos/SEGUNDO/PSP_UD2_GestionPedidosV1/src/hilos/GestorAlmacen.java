package hilos;
import modelo.EstadoPedido;
import monitores.ColaPedidos;
import modelo.Pedido;

import java.util.concurrent.ThreadLocalRandom;

// GestorAlmacen es consumidor al extraer pedidos de la cola
// y productor al añadir pedidos a la cola
// hilo creado mediante la implementación de Runnable
public class GestorAlmacen implements Runnable {
    private final ColaPedidos colaPendientes;
    private final ColaPedidos colaProcesados;

    public GestorAlmacen(ColaPedidos colaPendientes, ColaPedidos colaProcesados){
        this.colaPendientes = colaPendientes;
        this.colaProcesados = colaProcesados;
    }
    @Override
    public void run() {
        while(true){
            try{
                //CONSUMIR pedidos pendientes
                Pedido pedidoActual = colaPendientes.retirar();
                System.out.println("["+Thread.currentThread().getName()+
                        "][GESTOR]: Pedido pendiente retirado.");

                //Tiempo de procesamiento aleatorio para cada hilo
                int tiempoProcesamiento = ThreadLocalRandom.current().nextInt(2000,5001);
                Thread.sleep(tiempoProcesamiento);
                System.out.println(
                        "["+Thread.currentThread().getName()+"][GESTOR] Procesando pedido: "
                                +pedidoActual.getId()+" | Tiempo: "+tiempoProcesamiento+"ms...");

                //cambio de estado de pedido
                pedidoActual.setEstado(EstadoPedido.PROCESANDO);

                //PRODUCIR pedidos procesados
                colaProcesados.agregar(pedidoActual);
                System.out.println("["+Thread.currentThread().getName()+
                        "][GESTOR]: Pedido procesado: "+pedidoActual.getId());

            }catch (InterruptedException e){
                System.out.println("["+Thread.currentThread().getName()
                        +"][GESTOR]: Terminado por interrupcion.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
