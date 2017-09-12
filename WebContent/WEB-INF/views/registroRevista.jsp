<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="co.edu.udistrital.biblioteca.modelo.Autor"%>
<%@page import="co.edu.udistrital.biblioteca.utilidades.Estado"%>
<%@page import="co.edu.udistrital.biblioteca.utilidades.Edicion"%>


<!DOCTYPE html>
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
					<!-- 					<i class="fa fa-trash fa-2x" aria-hidden="true" onclick="eliminarBiblioteca"></i> -->
					 <a href="eliminarBiblioteca" class="fa fa-trash fa-2x"></a>
				</div>
			</div>
		</header>

		<section class="home-view">
			<p style="color: red;">${exitoso}</p>
			<h3>Registro Revista</h3>
			<form method="POST" action="doRegistroRevista">
				<table>
					<tr>
						<td>Nombre</td>
						<td>
							<div class="form-group">
								<input type="text" id="nombre" name="nombre" value="" />
							</div>
						</td>
					</tr>
					<tr>
						<td>Estado</td>
						<td>
							<div class="form-group">
								<select name="estado" id="estado" class="form-control">
									<option value="">Seleccion una opción</option>
									<%
										for (Estado estado : Estado.values()) {
									%>
									<option value="<%=estado.name()%>"><%=estado.name()%></option>
									<%
										}
									%>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td>Edición</td>
						<td>
							<div class="form-group">
								<select name="edicion" id="edicion" class="form-control">
									<option value="">Seleccion una opción</option>
									<%
										for (Edicion edicion : Edicion.values()) {
									%>
									<option value="<%=edicion.name()%>"><%=edicion.name()%></option>
									<%
										}
									%>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td>Observaciones</td>
						<td><textarea id="observacion" name="observacion"
								class="form-control"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Enviar"
							class="btn btn-warning" /> <input type="button" value="Cancelar"
							class="btn btn-warning" /></td>
					</tr>
				</table>
			</form>
		</section>
	</div>
	<footer>@Copyright UD</footer>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>