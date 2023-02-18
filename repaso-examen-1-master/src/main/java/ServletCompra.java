import modelo.AccesoDatos;
import modelo.Producto;
import modelo.Socio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCompra", value = "/realizarcompra")
public class ServletCompra extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Almaenar en una cookie
        String fecha = new java.util.Date().toString().replace(" ", "_");
        Cookie cookieAcceso = new Cookie("ultimoAcceso", fecha);
        cookieAcceso.setMaxAge(60 * 60 * 24 * 365);
        //Si hay cookies en general
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                //Si encontramos la cookie de ultimoAcceso previamente guardada
                if (cookie.getName().equals("ultimoAcceso")) {
                    //Mandamos a la vista el valor de la cookie guardada
                    request.setAttribute("ultimoAcceso", cookie.getValue());
                    break;
                } else {
                    //Mandamos a la vista el valor de la cookie nueva (que hemos creado arriba)
                    request.setAttribute("ultimoAcceso", cookieAcceso.getValue());
                }
            }
            //Mandamos la cookie al cliente para que se almacene en su navegador
            response.addCookie(cookieAcceso);

        } else {
            //Mandamos la cookie al cliente para que se almacene en su navegador
            response.addCookie(cookieAcceso);
            //Mandamos a la vista el valor de la cookie nueva (que hemos creado arriba)
            request.setAttribute("ultimoAcceso", cookieAcceso.getValue());

        }


        String codCliente = request.getParameter("codCliente");
        String clave = request.getParameter("clave");
        String codProducto = request.getParameter("codProducto");

        AccesoDatos db = AccesoDatos.getInstancia();
        Socio socio = db.getSocio(codCliente, clave);
        if (socio == null) {
            request.setAttribute("mensaje", "El usuario o la contraseña no son correctos");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        //caso 4
        Producto producto = db.getProducto(codProducto);
        if (producto == null) {
            request.setAttribute("mensaje", "El producto no existe");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        if (socio != null && producto != null && socio.getCantidadMax() >= producto.getPrecio()) {
            request.setAttribute("compraConfirmada", true);
            request.setAttribute("socio", socio);
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("/WEB-INF/vista.jsp").forward(request, response);

        }
        if (socio != null && producto != null && socio.getCantidadMax() < producto.getPrecio()) {
            request.setAttribute("compraConfirmada", false);
            request.setAttribute("socio", socio);
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("/WEB-INF/vista.jsp").forward(request, response);
        }
    }
}
