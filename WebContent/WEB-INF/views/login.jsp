<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
					Bienvenido <strong>${usuario.nombreUsuario}</strong> <i
						class="fa fa-user" aria-hidden="true">&nbsp;</i>
				</div>
				<div class="search text-right">
					<label>Buscar</label> <input type="text" name="search"> <a
						href="#"><i class="fa fa-search" aria-hidden="true">&nbsp;</i></a>
				</div>
			</div>
		</header>
		<section class="login">
			    
			<p style="color: red;">${errorString}</p>
			<h3>INGRESE SUS DATOS DE ACCESO</h3>

			<form method="POST" action="login">
				<div class="form-group">
					<label for="email">Usuario:</label> <input type="text"
						id="nombreUsuario" name="nombreUsuario" value=""
						class="form-control">
				</div>
				<div class="form-group">
					<label for="pwd">Contraseña:</label> <input type="password"
						id="contrasena" name="contrasena" value="" class="form-control">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-warning">Enviar</button>
					<input type="submit" value="Cancelar" class="btn btn-warning">
				</div>
			</form>
		</section>
	</div>
	<footer>@Copyright UD</footer>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>