<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Material</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Lista de Material Bibliografico</h3>

		<table border="1" cellpadding="5" cellspacing="1">
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Estado</th>
			    <th>Solicitud</th>
			</tr>
			<c:forEach items="${materialBibliografico}" var="material">
				<tr>
					<td>${material.codigo}</td>
					<td>${material.nombre}</td>
					<td>${material.estado}</td>
					<td>
                		<a href="prestamoMaterial?codigo=${material.codigo}">Préstamo</a>
					</td>
				</tr>
			</c:forEach>
		</table>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>