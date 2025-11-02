package Vehiculos;

public class Bicicleta {
    private String marca;
    private String modelo;
    private String color;
    private int velocidad;

        // Método constructor de clase
    public Bicicleta(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidad = 0;
    }

    // Getters
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }  
    public String getColor() {
        return color;
    }
    public int getVelocidad() {
        return velocidad;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // Métodos de clase
    public int acelerar(int incremento) {
        this.velocidad += incremento;
        System.out.println("Se ha acelerado! La velocidad ha aumentado en "+incremento+"km/h. Ahora es de " + this.velocidad + "km/h.");
        return this.velocidad;
    }

    public int frenar(int decremento) {
        if (velocidad >= decremento){
            this.velocidad -= decremento;
            System.out.println("Se ha frenado! La velocidad ha disminuido en "+decremento+"km/h. Ahora es de " + this.velocidad + "km/h.");
            return this.velocidad;
        }
        else {
            System.out.println("La velocidad sigue siendo "+this.velocidad+"km/h porque no se ha podido frenar.");
            return this.velocidad;
        }
    }

    // Método toString que define la representación de un objeto como cadena de texto.
    // Se invoca de forma automática con System.out.println(objeto)
    @Override
    public String toString() {
        return "Bicicleta "+this.marca+", "+this.modelo+", de color "+this.color+", velocidad actual: "+this.velocidad+" km/h";
    }
}
