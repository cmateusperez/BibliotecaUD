package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.ILoginServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.LoginServicios;
import co.edu.udistrital.biblioteca.utilidades.HibernateUtil;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HibernateUtil.openSession();
		String nombreUsuario = request.getParameter("nombreUsuario");
		String contrasena = request.getParameter("contrasena");
		Persona usuarioRegistrado = new Persona();
		usuarioRegistrado.setNombreUsuario(nombreUsuario);
		request.setAttribute("errorString", "");

		ILoginServicios iLoginServicios = new LoginServicios();
		usuarioRegistrado = iLoginServicios.validarUsuario(nombreUsuario, contrasena);
        HttpSession session = request.getSession(true);
        session.setAttribute("usuarioRegistrado", usuarioRegistrado);
		if (usuarioRegistrado == null) {
			if (nombreUsuario != null && contrasena != null) {
				request.setAttribute("errorString", "Usuario inválido");
			}
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errorString", "");
			request.setAttribute("usuario", usuarioRegistrado);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
			dispatcher.forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}