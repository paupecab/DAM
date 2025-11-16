package monitores;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

//Monitor productos A-F
public class GestorExclusivos {
    // el map almacena clave (id producto) -> valor (estado o cliente id)
    private final Map<String, String> exclusivos;

    private static final String ESTADO_LIBRE = "LIBRE";
    private static final String ESTADO_VENDIDO = "VENDIDO";
    private static final String[] CATALOGO_EXCLUSIVOS =
            {"A", "B", "C", "D", "E", "F"};

    public GestorExclusivos() {
        this.exclusivos = new HashMap<>();
        for (String producto : CATALOGO_EXCLUSIVOS) {
            this.exclusivos.put(producto, ESTADO_LIBRE);
        }
    }

    // metodo para liberar un producto asegurado si no ha podido venderse
    private void liberar(String p, String idCliente){
        if (exclusivos.containsKey(p) && !exclusivos.get(p).equals(ESTADO_VENDIDO)){
            exclusivos.put(p,ESTADO_LIBRE);
            System.out.println(Thread.currentThread().getName()+" LIBERA Producto "+p+
                    " y notifica.");
            notifyAll();
        }
    }

    // metodo que asegura productos de forma atomica
    public synchronized boolean intentarComprar(String idCliente, String p1, String p2)
            throws InterruptedException {
        String hilo = Thread.currentThread().getName();

        if (exclusivos.get(p1).equals(ESTADO_VENDIDO)){
            System.out.println("[" + hilo + "] No queda stock de P1: "+p1+" está VENDIDO.");
            return false;
        }else{
            // --- INTENTA ASEGURAR PRODUCTO 1 -> espera bloqueante ---
            System.out.println("[" + hilo + "] Intenta asegurar P1: " + p1);

            // mientras p1 no esté libre, el hilo debe esperar a que otro lo despierte
            // cuando complete la compra
            while (!exclusivos.get(p1).equals(ESTADO_LIBRE)) {
                System.out.println("[" + hilo + "] Espera por P1: " + p1);
                wait();

                // si al despertar e intentar cogerlo está vendido, devuelve false
                if (exclusivos.get(p1).equals(ESTADO_VENDIDO)){
                    System.out.println("[" + hilo + "] No queda stock de P1: "+p1+" está VENDIDO.");
                    return false;
                }
            }

            // p1 está libre, se asegura y se marca como asegurado con el id del cliente
            exclusivos.put(p1, idCliente);
            System.out.println("[" + hilo + "] ASEGURA P1: " + p1);

            // retardo aleatorio
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5001));

            // --- INTENTAR ASEGURAR PRODUCTO 2 ---
            System.out.println("[" + hilo + "] Intenta asegurar P2: " + p2);

            if (!exclusivos.get(p2).equals(ESTADO_LIBRE)) {
                // si p2 esta ocupado esperamos con timeout para no bloquear indefinidamente
                System.out.println("[" + hilo + "] P2 ocupado. Espera con timeout " +
                        "(" + 3000 + "ms)...");
                wait(3000);

                // al despertar verificamos estado
                if (!exclusivos.get(p2).equals(ESTADO_LIBRE)) {
                    // Fallo: p2 sigue ocupado después del tiempo razonable
                    System.out.println("[" + hilo + "] Fallo en P2. Producto " + p2 + " no liberado a tiempo.");

                    // liberacion de p1
                    liberar(p1, idCliente);
                    return false;
                }
            }

            // --- P2 ASEGURADO Y CONFIRMACIÓN ---

            // si se llega aquí, p2 esta libre, lo asegura
            exclusivos.put(p2, idCliente);
            System.out.println("[" + hilo + "] ASEGURA P2: " + p2);

            // retardo aleatorio
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5001));
            System.out.println("[" + hilo + "] Pagando paquete... ");

            // se marcan ambos productos como vendidos
            exclusivos.put(p1, ESTADO_VENDIDO);
            exclusivos.put(p2, ESTADO_VENDIDO);

            System.out.println(">>> [" + hilo +
                    "] COMPRA CONFIRMADA: Paquete [" + p1 + ", " + p2 + "]");

            notifyAll();
            return true;
        }
    }
}
