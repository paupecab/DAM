package modelo;

public class Producto {
    private final String id;
    private final String nombre;
    private final int cantidad;
    // incluir precio

    public Producto(String id, String nombre, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {return nombre;}

    public int getCantidad() {return cantidad;}

    @Override
    public String toString() {
        return nombre + " x" + cantidad;
    }
}
