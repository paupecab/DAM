package repositorio;

import excepciones.*;
import java.util.*;

public class Disco {
    private String titulo;
    private String artista;
    private String genero;
    private ArrayList<String> canciones;
    private float precio;
    private int stock;

    public Disco(String titulo, String artista, String genero, String[] arrayCanciones, float precio, int stock)
        throws DiscoInvalidoExcepcion, StockInsuficienteExcepcion {
        
        /* Excepciones */
        if (titulo == null || titulo.isBlank()) throw new DiscoInvalidoExcepcion("Título no válido");
        if (artista == null || artista.isBlank()) throw new DiscoInvalidoExcepcion("Artista no válido");
        if (genero == null || genero.isBlank()) throw new DiscoInvalidoExcepcion("Genero no válido");
        if(precio<=0) throw new DiscoInvalidoExcepcion("El precio debe ser mayor que 0");
        if(stock<=0) throw new StockInsuficienteExcepcion("El stock inicial no puede ser 0");
        
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.canciones = new ArrayList<String>(Arrays.asList(arrayCanciones));
        this.precio = precio;
        this.stock = stock;
    }

    // Getters
    public String getTitulo(){ return titulo; }
    public String getArtista(){ return artista; }
    public String getGenero(){ return genero; }
    public ArrayList<String> getCanciones(){ return canciones; }
    public float getPrecio(){ return precio; }
    public int getStock(){ return stock; }


    // Metodo que vende un disco. Resta la cantidad al stock del disco y muestra lo que queda en stock.
    public void venderDisco(int cantidad) throws StockInsuficienteExcepcion {
        if(cantidad>stock){
            throw new StockInsuficienteExcepcion(
                "El stock actual es de "+stock+" unidades. Es insuficiente para vender "+ cantidad);}
        else {
            stock -= cantidad;
        }
    }

    // Metodo que repone stock. Suma una cantidad al stock actual y muestra el stock resultante.
    public void reponerStock(int cantidad) throws StockInsuficienteExcepcion{
        if(cantidad<=0){
            throw new StockInsuficienteExcepcion("Se debe agregar una cantidad positiva.");
        }
        else {
            stock += cantidad;
        }
    }

    public void escucharCancion(String cancion){
        boolean encontrada = false;
        for (String c : canciones){
            if (c.trim().equalsIgnoreCase(cancion.trim())){
                encontrada = true;
                break;
            }
        }
        if (encontrada) {
            System.out.println("~~Estás escuchando la canción '"+cancion+"', del álbum "+titulo+" de "+artista+"~~ Ohh yeah baby!");
        }
        else {
            System.out.println("Ups! Esa canción no es de este álbum :S");
        }
        
    }
}



