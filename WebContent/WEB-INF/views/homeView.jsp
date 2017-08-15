<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
    
      <h3>Página Inicio</h3>
      
      Sistema básico que permite registrar préstamos de material bibliografico. <br><br>
      <b>Incluye las siguientes funcionalidades:</b>
      <ul>
         <li>Ingreso al sistema</li>
         <li>Solicitar préstamos de material bibliografico</li>
         <li>Ingresar material bibliografico</li>
         <li>Ingresar usuarios al sistema</li>
      </ul>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>