<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/styles.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="container-fluid">
		<header>
			<div class="header-container">
				<h1>BIBLIOTECA UD</h1>
				<div class="text-right">
					<!-- User store in session with attribute: loginedUser -->
					Hola <strong>${usuario.nombreUsuario}</strong> <i
						class="fa fa-user" aria-hidden="true">&nbsp;</i>
				</div>
				<div class="search text-right">
					<label>Buscar</label> <input type="text" name="search"> <a
						href="#"><i class="fa fa-search" aria-hidden="true">&nbsp;</i></a>
				</div>
				<div class="register text-center">
					<a href="${pageContext.request.contextPath}/registroLibro">Registro
						Libro</a> | <a
						href="${pageContext.request.contextPath}/registroRevista">Registro
						Revista</a> | <a
						href="${pageContext.request.contextPath}/listaCompletaMaterialBibliografico">Catálogo
						Material Bibliográfico</a> | <a
						href="${pageContext.request.contextPath}/listaMaterialBibliografico">Solicitud
						Prestamo</a>| <a
						href="${pageContext.request.contextPath}/multa">Multa</a>
				</div>
				<div class="delete text-right">
					 <a href="eliminarBiblioteca" class="fa fa-trash fa-2x"></a>
				</div>
			</div>
		</header>

		<section class="home-view">
			<h3>Lista de Material Bibliografico</h3>

			<table border="1" cellpadding="5" cellspacing="1">
				<tr>
					<th>Nombre</th>
					<th>Estado</th>
					<th>Observaciones</th>
					<th>Solicitud</th>
				</tr>
				<c:forEach items="${materialBibliografico}" var="material">
					<tr>
						<td>${material.nombreMaterial}</td>
						<td>${material.estado}</td>
						<td>${material.observaciones}</td>
						<td>   <c:if test="${material.estado == 'DISPONIBLE'}">
							       <a
									href="prestamoMaterial?codigo=${material.idMaterialBibliografico}">Préstamo</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</div>
	<footer>@Copyright UD</footer>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>