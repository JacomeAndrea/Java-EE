<%@ page import="modelo.Producto" %>
<%@ page import="modelo.AccesoDatos" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 19/02/2023
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenido/a</title>
</head>
<body>
<%
    ArrayList <Producto> listaProductos = (ArrayList<Producto>) request.getAttribute("listaProductos");
%>
<h1>BIENVENIDO/A AL CRUD DE PRODUCTOS</h1>
<br>
<p><%=request.getAttribute("mensaje")%></p>
<br>
<!--mostramos la lista de productos-->
<table>
  <tr>
    <th>Código Producto</th>
    <th>Nombre Producto</th>
    <th>Precio Producto</th>
  </tr>
    <%
        for (Producto producto : listaProductos) {
    %>
    <tr>
        <td><%=producto.getCodigoProducto()%></td>
        <td><%=producto.getNombreProducto()%></td>
        <td><%=producto.getPrecioProducto()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
