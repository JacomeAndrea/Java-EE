package modelo;

import java.sql.*;

public class AccesoDatos {

    private static Connection conexion = null;
    private static AccesoDatos instancia = null;

    private AccesoDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mycardb", "root", "root");

        } catch (Exception ex) {
            System.err.println(" Error - En la base de datos.");
            ex.printStackTrace();
        }
    }

    public static AccesoDatos getInstancia() {
        if (instancia == null) {
            instancia = new AccesoDatos();
        }
        return instancia;
    }

    //no lo utilizamos
    public static void closeModelo() {
        if (instancia != null) {
            try {
                conexion.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //Accedemos a los datos de la base de datos
    public Cliente getCliente (String codCliente, String clave) {
        try {
            PreparedStatement statement =
                    conexion.prepareStatement("SELECT * FROM clientes WHERE cod_cli=? AND clave=?");
            statement.setString(1, codCliente);
            statement.setString(2, clave);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(rs.getString("cod_cli"), rs.getString("nombre"), rs.getString("clave"), rs.getInt("cod_car"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vehiculo getVehiculo (String localidad) {
        try {
            PreparedStatement statement =
                    conexion.prepareStatement("SELECT * FROM vehiculos WHERE localidad=? AND estado=0 ORDER BY bateria DESC LIMIT 1");
            statement.setString(1, localidad);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Vehiculo(rs.getInt("cod_car"), rs.getString("localidad"), rs.getInt("estado"), rs.getInt("bateria"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void realizarAlquiler (int codVehiculo, String codCliente) {
        try {
            PreparedStatement statementVehiculo = conexion.prepareStatement("UPDATE vehiculos SET estado=1 WHERE cod_car=?");
            statementVehiculo.setInt(1,codVehiculo);
            statementVehiculo.executeUpdate();
            PreparedStatement statementCliente = conexion.prepareStatement("UPDATE clientes SET cod_car=? WHERE cod_cli=?");
            statementCliente.setInt(1,codVehiculo);
            statementCliente.setString(2,codCliente);
            statementCliente.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
