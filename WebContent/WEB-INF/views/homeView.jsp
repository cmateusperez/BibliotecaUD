
<%@page import="co.edu.udistrital.biblioteca.modelo.Persona"%>
<%@page import="co.edu.udistrital.biblioteca.modelo.Biblioteca"%>

<%
	Persona persona = (Persona)session.getAttribute("usuarioRegistrado");
	Biblioteca biblioteca = persona.getBiblioteca();
%>
<!DOCTYPE html>
<html xmlns:p="http://primefaces.org/ui">
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css" />
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
			<h3>Información básica biblioteca</h3>
			<% if(biblioteca != null){%>
				<p>
					<%=biblioteca.getNombreBiblioteca()%>
				</p>
				<strong>Información sede biblioteca:</strong>
				<ul>
					<li><%=biblioteca.getSede().getNombreSede()%></li>
					<li><%=biblioteca.getSede().getUbicacionSede()%></li>
				</ul>
			<%}%>
		</section>
	</div>
	<footer>@Copyright UD</footer>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>




