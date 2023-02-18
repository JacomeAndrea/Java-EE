<%--
  Created by IntelliJ IDEA.
  User: ceramesupersound
  Date: 18/2/23
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Introduzca los datos de su compra</h1>
<form action="/realizarcompra" method="post">
    <label>Codigo cliente<input type="text" name="codCliente"></label>
    <label>Clave<input type="text" name="clave"></label>
    <label>Codigo producto<input type="text" name="codProducto"></label>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
