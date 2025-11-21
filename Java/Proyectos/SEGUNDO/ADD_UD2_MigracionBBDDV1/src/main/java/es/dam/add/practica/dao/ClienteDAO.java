package es.dam.add.practica.dao;


import es.dam.add.practica.config.DBConnection;
import es.dam.add.practica.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//metodos CRUD, exists, findBy, etc.
public class ClienteDAO implements DAOGenerico<Cliente>{
    //constantes SQL
    private static final String  INSERT_SQL =
            "INSERT INTO clientes (nombre, dni, fecha_registro, credito, activo) " +
                    "VALUES (?, ?, ?, ?, ?)";
    private static final String  UPDATE_SQL =
            "UPDATE clientes SET nombre = ?, dni = ?, fecha_registro = ?," +
                    " credito = ?, activo = ? WHERE id = ?";
    private static final String  DELETE_SQL =
            "DELETE FROM clientes WHERE id = ?";
    private static final String  SELECT_BY_ID =
            "SELECT * FROM clientes WHERE id = ?";
    private static final String  SELECT_ALL =
            "SELECT * FROM clientes";
    private static final String  CHECK_EXISTS =
            "SELECT 1 FROM clientes WHERE id = ?";


    @Override
    public void insert(Cliente cliente) throws SQLException {
        //conexion a la BDD de origen, prac2
        try(Connection con = DBConnection.getInstancia().getConnection("prac2");
            PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setDate(3, cliente.getFechaRegistro());
            ps.setDouble(4, cliente.getCredito());
            ps.setBoolean(5, cliente.isActivo());

            ps.executeUpdate();

            //asignacion del id autoincremental generado por mysql al objeto
            try(ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()){
                    cliente.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Cliente get(int id) throws SQLException {
        Cliente cliente = null;
        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = mapearColumnasACliente(rs);
                }
            }
        }
        return cliente;
    }

    @Override
    public void update(Cliente cliente) throws SQLException {
        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setDate(3, cliente.getFechaRegistro());
            ps.setDouble(4, cliente.getCredito());
            ps.setBoolean(5, cliente.isActivo());
            ps.setInt(6, cliente.getId()); // El WHERE id = ?

            ps.executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public boolean exist(int id) throws SQLException {
        boolean existe = false;
        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             PreparedStatement ps = con.prepareStatement(CHECK_EXISTS)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    @Override
    public List<Cliente> buscarTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             Statement st = con.createStatement(); // Aquí vale Statement porque no hay parámetros
             ResultSet rs = st.executeQuery(SELECT_ALL)) {

            while (rs.next()) {
                lista.add(mapearColumnasACliente(rs));
            }
        }
        return lista;
    }

    @Override
    public List<Cliente> buscarPorAtributo(String columna, String valor) throws SQLException {
        List<Cliente> lista = new ArrayList<>();

        // validacion para evitar inyeccion SQL
        if (!columna.matches("[a-zA-Z0-9_]+")) {
            throw new SQLException("Nombre de columna inválido");
        }

        String instruccionSQL = "SELECT * FROM clientes WHERE " + columna + " = ?";

        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             PreparedStatement ps = con.prepareStatement(instruccionSQL)) {

            ps.setString(1, valor);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearColumnasACliente(rs));
                }
            }
        }
        return lista;
    }

    //metodo para mapear los atributos al objeto
    private Cliente mapearColumnasACliente(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();

        c.setId(rs.getInt("id"));
        c.setNombre(rs.getString("nombre"));
        c.setDni(rs.getString("dni"));
        c.setFechaRegistro(rs.getDate("fecha_registro"));
        c.setCredito(rs.getDouble("credito"));
        c.setActivo(rs.getBoolean("activo"));

        return c;
    }

    //metodo para insertar datos
    public void insertarClientes(List<Cliente> listaClientes) throws SQLException {
        try (Connection con = DBConnection.getInstancia().getConnection("prac2");
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

            // se desactiva el auto-guardado para hacerlo en una transaccion
            con.setAutoCommit(false);

            for (Cliente c : listaClientes) {
                ps.setString(1, c.getNombre());
                ps.setString(2, c.getDni());
                ps.setDate(3, c.getFechaRegistro());
                ps.setDouble(4, c.getCredito());
                ps.setBoolean(5, c.isActivo());

                //se agrega al batch
                ps.addBatch();
            }

            //ejecucion
            ps.executeBatch();
            con.commit(); // Confirmamos los cambios
            System.out.println("Se han insertado " + listaClientes.size() + " registros en lote.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
