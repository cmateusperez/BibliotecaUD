<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Login</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
     
    <p style="color: red;">${errorString}</p>

    <form method="POST" action="login">
       <table border="0">
          <tr>
             <td>Usuario:</td>
             <td><input type="text" id="nombreUsuario" name="nombreUsuario" value= "" /> </td>
             <td>Contraseña:</td>
             <td><input type="password" id="contrasena" name="contrasena" value= "" /> </td>
          </tr>
          <tr>
             <td colspan ="2">
                <input type="submit" value= "Enviar" />
                <input type="button" value= "Cancelar" />
             </td>
          </tr>
       </table>
    </form>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>