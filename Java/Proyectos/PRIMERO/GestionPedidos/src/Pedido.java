class Pedido {
    private final String nombreProducto;
    private final int cantidadSolicitada;

    public Pedido(String nombreProducto, int cantidadSolicitada) {
        this.nombreProducto = nombreProducto;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }
}