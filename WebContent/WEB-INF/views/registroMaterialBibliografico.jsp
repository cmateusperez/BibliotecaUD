<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Material Bibliograficar</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Registrar Material Bibliografico</h3>

	<form method="POST" action="doRegistroMaterialBibliografico">
		<table border="0">
			<tr>
				<td>Código</td>
				<td><input type="text"  id="codigo" name="codigo" value="" /></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" id="nombre"  name="nombre" value="" /></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><input type="text" id="estado"  name="estado" value="" /></td>
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