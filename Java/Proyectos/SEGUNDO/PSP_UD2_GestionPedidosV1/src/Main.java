import hilos.*;
import modelo.EstadoPedido;
import modelo.Pedido;
import monitores.*;

public class Main {
    public static void main(String[] args){
        final int CAPACIDAD_ALMACEN = 25;
        ColaPedidos colaPendientes = new ColaPedidos(CAPACIDAD_ALMACEN);
        ColaPedidos colaProcesados = new ColaPedidos(CAPACIDAD_ALMACEN);

        Runnable transportista = ()->{
            while(true){
                try{
                    Pedido pedidoEnviado = colaProcesados.retirar();
                    if (pedidoEnviado == null) break;


                    //actualización de pedido
                    pedidoEnviado.setEstado(EstadoPedido.ENVIADO);
                    System.out.println("["+Thread.currentThread().getName()+
                            "][TRANSPORTISTA]: ENVÍO COMPLETADO para pedido "+
                            pedidoEnviado.getId());
                }catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+": Detenido por interrupción.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
    }
}
