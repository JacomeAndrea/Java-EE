package modelo;

import java.sql.*;

public class AccesoDatos {
    private static Connection conexion = null;

    private static AccesoDatos instancia = null;

    private AccesoDatos() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/comprasdb", "root", "root");


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

    public Socio getSocio(String codCliente, String clave) {
        try {
            PreparedStatement statement =
                    conexion.prepareStatement("SELECT * FROM socios WHERE cod_socio=? AND clave=?");
            statement.setString(1, codCliente);
            statement.setString(2, clave );
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Socio(rs.getString("cod_socio"), rs.getString("nombre"), rs.getString("clave"), rs.getInt("cantidad_max"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Producto getProducto(String codProducto) {
        try {
            PreparedStatement statement =
                    conexion.prepareStatement("SELECT * FROM productos WHERE cod_pro=?");
            statement.setString(1, codProducto);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Producto(rs.getString("cod_pro"), rs.getString("nombre_pro"), rs.getInt("precio"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
