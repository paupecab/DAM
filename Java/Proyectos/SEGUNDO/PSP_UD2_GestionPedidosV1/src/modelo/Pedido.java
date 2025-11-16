package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int id;
    private final List<Producto> productos;
    private EstadoPedido estado;

    public Pedido (int id, List<Producto> productos, EstadoPedido estado){
        this.id = id;
        this.productos = productos;
        this.estado = estado;
    }

    public void setEstado(EstadoPedido estado){this.estado = estado;}


    public int getId(){return this.id;}
    public List<Producto> getProductos(){return this.productos;}
    public EstadoPedido getEstado(){return this.estado;}

    @Override
    public String toString(){
        return "Pedido | ID: "+id+" | Productos: "+productos+" | Estado: "+estado;
    }
}
