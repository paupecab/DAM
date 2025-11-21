package es.dam.add.practica.modelo;

//clientes tabla destino
public class ClienteMigra {
    //2 atributos menos que Cliente
    private int idMigra;
    private String nombreMigra;
    private String dniMigra;
    private double creditoMigra;

    //para controlar la migracion
    private boolean migrado;

    //constructor vacio
    public ClienteMigra() {}

    //constructor completo con id porque se mantiene
    public ClienteMigra(int idMigra, String nombreMigra, String dniMigra,
                        double creditoMigra, boolean migrado) {
         this.idMigra = idMigra;
         this.nombreMigra = nombreMigra;
         this.dniMigra = dniMigra;
         this.creditoMigra = creditoMigra;
         this.migrado = migrado;
    }

    //Getters
    public int getIdMigra() { return idMigra; }
    public String getNombreMigra() { return nombreMigra; }
    public String getDniMigra() { return dniMigra; }
    public double getCreditoMigra() { return creditoMigra; }
    public boolean isMigrado() { return migrado; }

    //Setters
    public void setIdMigra(int idMigra) { this.idMigra = idMigra; }
    public void setNombreMigra(String nombreMigra) { this.nombreMigra = nombreMigra; }
    public void setDniMigra(String dniMigra) { this.dniMigra = dniMigra; }
    public void setCreditoMigra(double creditoMigra) { this.creditoMigra = creditoMigra; }
    public void setMigrado(boolean migrado) { this.migrado = migrado; }

    @Override
    public String toString() {
        return "ClienteMigra [id=" + idMigra
                + ", nombre=" + nombreMigra
                + ", migrado=" + migrado + "]";
    }
}
