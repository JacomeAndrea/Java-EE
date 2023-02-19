import modelo.AccesoDatos;
import modelo.Producto;
import modelo.Socio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCRUD", value = "/login")
public class ServletCRUD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Almaceno datos formulario
        String nombreUsuario = request.getParameter("usuario");
        String claveUsuario = request.getParameter("password");

        //Accedo a la base de datos
        AccesoDatos db = AccesoDatos.getInstancia();
        Socio usuario = db.getUsuario(nombreUsuario, claveUsuario);
        if (usuario == null) {
            request.setAttribute("mensaje", "El usuario o la contraseña no son correctos");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "Bienvenido " + usuario.getNombre());

            //funcion para recorrer la lista de productos
            ArrayList<Producto> listaProductos = db.getProductos();
            request.setAttribute("listaProductos", listaProductos);

            request.getRequestDispatcher("/WEB-INF/bienvenido.jsp").forward(request, response);
        }

    }
}
