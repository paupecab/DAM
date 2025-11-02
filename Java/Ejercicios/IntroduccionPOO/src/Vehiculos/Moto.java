package Vehiculos;

public class Moto extends Bicicleta {
    private int cilindrada;

    /*Constructor de clase que pasa parámetros de superclase y llama al método super para
     heredar atributos.*/
    public Moto(String marca, String modelo, String color, int cilindrada) {
        super(marca, modelo, color);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto "+ getMarca()+", "+getModelo()+", de color "+getColor()+" y cilindrada " + cilindrada +
        ". Velocidad actual: "+getVelocidad()+" km/h";
    }
}