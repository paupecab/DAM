import hilos.*;
import modelo.EstadoPedido;
import modelo.Pedido;
import monitores.*;

public class Main {
    public static void main(String[] args){
        final int CAPACIDAD_ALMACEN = 25;
        final int numeroClientes = 10;
        final int numeroGestoresAlmacen = 3;
        final int numeroTransportistas = 2;

        //instanciar monitores
        ColaPedidos colaPendientes = new ColaPedidos(CAPACIDAD_ALMACEN);
        ColaPedidos colaProcesados = new ColaPedidos(CAPACIDAD_ALMACEN);
        GestorExclusivos gestorExclusivos = new GestorExclusivos();


        //hilo transportista
        Runnable tareaTransportista = ()->{
            while(true){
                try{
                    Pedido pedidoActual = colaProcesados.retirar();
                    if (pedidoActual == null) break;

                    //actualización de pedido
                    pedidoActual.setEstado(EstadoPedido.ENVIADO);
                    System.out.println(
                            "["+Thread.currentThread().getName()+"][TRANSPORTISTA] Pedido: "
                                    +pedidoActual.getId()+" "+pedidoActual.getEstado());

                }catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+": Detenido por interrupción.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };

        //lanzamiento de hilos

        //gestores
        for(int i=1; i<=numeroGestoresAlmacen; i++){
            Thread gestor = new Thread (new GestorAlmacen(colaPendientes,
                    colaProcesados), "GestorAlmacen"+i);
            gestor.start();
        }

        //transportistas
        for(int i=1; i<=numeroTransportistas; i++){
            Thread transportista = new Thread(tareaTransportista,
                    "Transportista"+i);
            transportista.start();
        }

        //clientes
        for(int i=1; i<=numeroClientes; i++){
            Thread cliente = new Thread (new Cliente(colaPendientes,
                    gestorExclusivos), "Cliente"+i);
            cliente.start();
        }
    }
}
