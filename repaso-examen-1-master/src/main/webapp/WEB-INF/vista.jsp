<%@ page import="modelo.Producto" %>
<%@ page import="modelo.Socio" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Producto producto = (Producto) request.getAttribute("producto");
    Socio socio = (Socio) request.getAttribute("socio");
    boolean compraConfirmada = (boolean) request.getAttribute("compraConfirmada");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>BIENVENIDO/A <%= socio.getNombre()%>
</h1>
<p>
    ${compraConfirmada ? "Se": "No se"} ha efectuado la compra del
    producto: <%= producto.getCodigo()%> <%=producto.getNombre()%>por <%= producto.getPrecio()%>
</p>
<p>Su limite actual de compra es de <%=socio.getCantidadMax()%> Euros</p>
<!--mostramos la coockie-->
<p>Usted se ha metido por última vez <%=request.getAttribute("ultimoAcceso")%></p>
</body>
</html>
