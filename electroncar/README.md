<p>Queremos realizar una proyecto web dinámico denominado electroncar que controle el acceso a la base de datos de mycardb. El proyecto es parte de una aplicación de gestión de alquiler de coches eléctricos. Para ello realizamos las siguientes operaciones:</p>
<ul>
  <li>Creamos en nuestro servidor una base de datos llamada mycardb con la tabla clientes con la siguiente estructura, que representas los datos de nuestros clientes y una tabla vehículos donde se almacena el estado de los vehículos de nuestra flota</li>
</ul>
<br>
<p>*El campo cod_car representa el código de vehículo que tiene reservado, el valor 0 indica que no ha alquilado ninguno.</p>
<p>*El estado del un vehículo puede ser : 0: Disponible, 1: Reservado, 2: Sin batería, 3: Averiado. El valor de la batería puede ser de 100 a 0 % de carga.</p>
<br><br>
<p>Dentro del proyecto electrocar crearemos los siguientes archivos:<p>
<ul>
  <li>Un archivo llamado index.html que solicita mediante un formulario el código de socio, su clave y la localidad donde quiere reservar un vehículo, enviando la petición por el método POST a un servlet que mapea la url /electroncar/reservar con el siguiente aspecto:</li>
  <li>El servlet llamado Servletreservar mapeado a la url /reservar. Este servlet procesará la petición y enviará un atributo msg al fichero vista.jsp que mostrará un mensaje de bienvenida al cliente, indicando a continuación su nombre y los datos del vehículo que ha reservado en la localidad elegida. En el caso que el código y la clave no sean correcta se mostrará un mensaje utilizando la vista error.jsp</li>
</ul>
<br>
<p>El Servlet debe tratar los siguientes casos, enviando a la vista el mensaje adecuado:</p>
<p><b>Caso 1: El código de cliente y la clave existen, y hay un vehículo disponible en su localidad</b><p>
<p><b>Caso 2: El código de cliente y la clave existen, pero ya tiene asignado un vehículo</b></p>
<p><b>Caso 3: El código de cliente y la clave existen, pero no existen vehículos disponibles</b></p>
<p><b>Caso 4: El código de cliente y/o la contraseña no son correctas</b></p>
<br><br>
<p><b>HAY QUE TENER EN CUENTA:</b></p>
<ul>
  <li>Si hay varios coches disponibles se le asignará el que tiene la batería con mayor carga</li>
  <li>Para que el ejercicio esté totalmente correcto las tablas deben actualizarse correctamente anotando en el cliente el coche que ha reservado y cambiando el estado de vehículo al valor 1 (Reservado)</li>
</ul>
<br>
<p><b>REALIZAR LOS SIGUIENTES ARCHIVOS:</b></p>
<ul>
  <li>index.html – Formulario de acces</li>
  <li>Servletreservar.java - Servlet que procesa el formulario</li>
  <li>vista.jsp y error.jsp – Muestra la vista según el mensaje que genera el servlet anterior, este árchivo no es accesible desde la web.</li>
  <li>Cliente.java – Java Bean que mapea la entidad Cliente de la BD</li>
  <li>Vehiculo.java – Java Bean que mapea la entidad Vehículo en la BD</li>
  <li>AccesoDatos.java - DAO que accede a la BD</li>
</ul>

