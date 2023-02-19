package modelo;

import java.sql.*;
import java.util.ArrayList;

public class AccesoDatos {
    private static Connection conexion = null;
    private static AccesoDatos instancia = null;

    private AccesoDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/crud_db", "root", "root");

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

    //obtenemos nombre y contraseña del usuario
    public Socio getUsuario(String codigo, String clave) {
        try {
            PreparedStatement statement =
                    conexion.prepareStatement("SELECT * FROM socio WHERE cod_socio=? AND clave=?");
            statement.setString(1, codigo);
            statement.setString(2, clave );
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Socio(rs.getString("nombre"), rs.getString("clave"), rs.getString("cod_socio"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //obtenemos los productos de la base de datos
    public static ArrayList <Producto> getProductos() {
        ArrayList <Producto> productos = new ArrayList <Producto>();
        try {
            PreparedStatement statement =
                    conexion.prepareStatement("SELECT * FROM productos");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                productos.add (new Producto(rs.getString("cod_pro"), rs.getString("nombre_pro"), rs.getInt("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }
}


