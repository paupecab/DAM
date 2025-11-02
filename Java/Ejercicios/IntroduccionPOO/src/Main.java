import Vehiculos.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Bicicleta bici = new Bicicleta("BH", "Oregon", "azul");
        Moto m = new Moto("Yamaha", "3000", "negro", 200);
        System.out.println(bici);
        System.out.println(m);
        bici.acelerar(15);
        m.acelerar(120);
        System.out.println(bici);
        System.out.println(m);
        bici.frenar(5);
        m.frenar(30);
        System.out.println(bici);
        System.out.println(m);
    }
}
