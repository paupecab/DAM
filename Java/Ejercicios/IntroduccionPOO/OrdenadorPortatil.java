import java.util.Scanner;

public class OrdenadorPortatil {
    // Creacion de atributos
    String marca;
    String modelo;
    int procesador;
    int memoriaRam;
    int almacenamientoStatus;

    // Metodo constructor
    public OrdenadorPortatil(String marca, String modelo, int procesador,
    int memoriaRam, int almacenamientoStatus){
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.memoriaRam = memoriaRam;
        this.almacenamientoStatus = almacenamientoStatus;
    }

    // Metodo que muestra todos los atributos de un ordenador
    public void mostrarOrdenador(){
        System.out.println("La marca es: " + marca);
        System.out.println("El modelo es: " + modelo);
        System.out.println("El procesador es: " + procesador);
        System.out.println("La memoria RAM es de: " + memoriaRam + "GB");
        System.out.println("El almacenamiento es de: " + almacenamientoStatus + "GB");
    }

    // Metodo que lee la app a instalar y muestra si se ha instalado o no
    public void installApp(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Que app quieres instalar?");
            String app = scanner.nextLine(); // Leer el input del usuario
            boolean appInstalled = !app.isEmpty();
            /* OPTIMIZACION. Versión anterior:
            ---------------------
            boolean appInstalled = false;
            if (longitudApp < 1){
                appInstalled = false;
            } else{
                appInstalled = true;
            }
            --------------------
            */
            if (appInstalled == true){
                System.out.println("La app " + app + " se ha instalado correctamente.");
            } else {
                System.out.println("Ha habido un error. No se ha instalado la app.");
            }
            scanner.close(); // Cerrar el Scanner
        }

    public static void main(String[] args){
        OrdenadorPortatil ordenador1 = new OrdenadorPortatil("Lenovo", "IdeaPad", 
        12450, 16, 512);
        OrdenadorPortatil ordenador2 = new OrdenadorPortatil("Apple", "MacBook Air 2024",
                3, 8, 256);
        OrdenadorPortatil ordenador3 = new OrdenadorPortatil("ASUS", "Vivobook 16x",
                5800, 16, 512);
        ordenador1.mostrarOrdenador();
        ordenador2.mostrarOrdenador();
        ordenador3.mostrarOrdenador();
        ordenador1.installApp();

    }
}
