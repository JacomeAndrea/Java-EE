<%@ page import="modelo.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 27/02/2023
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Cliente cliente = (Cliente) request.getAttribute("cliente");%>
<html>
<head>
    <title>Vista</title>
</head>
<body>
<h1>Bienvenido/a <%=cliente.getNombre()%></h1>
<p><%=request.getAttribute("mensaje")%></p>
</body>
</html>
