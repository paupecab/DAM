package repositorio;

import excepciones.*;

public class Producto {
    // ATRIBUTOS privados para clase Producto
    private String nombre;
    private String categoria;
    private float precio;
    private int stock;

    // CONSTRUCTOR que valida que el precio y el stock no sean negativos
    public Producto(String nombre, String categoria, float precio, int stock) 
    throws StockInsuficienteException, ProductPrecioException {
        // Condiciones que lanzan excepciones
        if(precio<=0) throw new ProductPrecioException("El precio no puede ser negativo.");
        if(stock<=0) throw new StockInsuficienteException("El stock no puede ser 0 o negativo.");

        // Inicialización de atributos de clase
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;

        /*Se pueden añadir otras excepciones para que los campos de nombre y categoria de un producto
         no puedan ser null */
    }

    // GETTERS para poder acceder al valor de los atributos privados desde fuera de la clase
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public float getPrecio() { return precio; }
    public int getStock() { return stock; }

    // SETTERS por si fuera necesario modificar algún valor
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPrecio(float precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }

    // RESTO DE MÉTODOS

    // METODO venderProducto(int cantidad)
    public void venderProducto(int cantidad) throws StockInsuficienteException {
        if(cantidad>stock){
            throw new StockInsuficienteException("El stock es de "+stock+" unidades. Es insuficiente para vender "+cantidad);
        }
        else {
            stock -= cantidad;
        }
    }
    
    // METODO reponerStock(int cantidad)
    public void reponerStock(int cantidad) throws StockInsuficienteException {
        if(cantidad<0) throw new StockInsuficienteException("La cantidad no puede ser negativa.");
        if(cantidad==0) throw new StockInsuficienteException("La cantidad no puede ser 0, no estás reponiendo stock.");
        stock += cantidad;
    }

}
