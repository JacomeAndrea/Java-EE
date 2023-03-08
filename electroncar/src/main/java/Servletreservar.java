import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import modelo.AccesoDatos;
import modelo.Cliente;
import modelo.Vehiculo;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "Servletreservar", value = "/reservar")
public class Servletreservar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String codCliente = request.getParameter("codCliente");
        String clave = request.getParameter("clave");
        String localidad = request.getParameter("localidad");

        AccesoDatos db = AccesoDatos.getInstancia();
        Cliente cliente = db.getCliente(codCliente, clave);
        if (cliente == null) {
            request.setAttribute("mensaje", "El usuario o la contraseña no son correctos");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        request.setAttribute("cliente", cliente);
        if(cliente.getCodCar()!=0){
            request.setAttribute("mensaje", "Ya tiene reservado el vehículo " + cliente.getCodCar());
            request.getRequestDispatcher("/WEB-INF/vista.jsp").forward(request,response);

        }
        Vehiculo vehiculo = db.getVehiculo(localidad);
        if(vehiculo==null){
            request.setAttribute("mensaje", "No existen vehículos en " + vehiculo.getLocalidad());
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,response);
        }
        if (vehiculo.getEstado()!=0) {
            request.setAttribute("mensaje", "No hay vehículos disponibles en " + vehiculo.getLocalidad());
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,response);
        }
        db.realizarAlquiler(vehiculo.getCodCar(), cliente.getCodCli());
        request.setAttribute("mensaje", ">Dispone en " + localidad.toUpperCase() + " del vehículo " + vehiculo.getCodCar());
        request.getRequestDispatcher("/WEB-INF/vista.jsp").forward(request, response);

    }
}
