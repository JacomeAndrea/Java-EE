<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>CRUD: ACCESO</h1>
<br/>
    <form action="/login" method="post">
        <label>Usuario</label>
        <input type="text" name="usuario" placeholder="Usuario" required>
        <br/>
        <label>Contraseña</label>
        <input type="password" name="password" placeholder="Contraseña" required>
        <br/>
        <input type="submit" value="Iniciar sesión">
    </form>
</body>
</html>