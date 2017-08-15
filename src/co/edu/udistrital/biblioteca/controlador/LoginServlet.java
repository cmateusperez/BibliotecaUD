package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Usuario;
import co.edu.udistrital.biblioteca.servicios.LoginServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.ILoginServicios;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreUsuario = request.getParameter("nombreUsuario");
		String contrasena = request.getParameter("contrasena");
		Usuario usuarioRegistrado = new Usuario();
		usuarioRegistrado.setContrasena(contrasena);
		usuarioRegistrado.setNombreUsuario(nombreUsuario);
		
		ILoginServicios iLoginServicios = new LoginServicios();

		String errorUsuario = iLoginServicios.validarUsuario(nombreUsuario, contrasena);
		if (errorUsuario != null) {
			request.setAttribute("errorString", errorUsuario);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("usuario", usuarioRegistrado);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/homeView.jsp");
			dispatcher.forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}