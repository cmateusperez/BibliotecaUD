package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.IBibliotecaServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.BibliotecaServicios;

@WebServlet(urlPatterns = { "/eliminarBiblioteca" })
public class BibliotecaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BibliotecaServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IBibliotecaServicios iBibliotecaServicios = new BibliotecaServicios();

		Persona usuarioRegistrado = (Persona) request.getSession(false).getAttribute("usuarioRegistrado");
		Biblioteca biblioteca = iBibliotecaServicios.consultar(usuarioRegistrado.getBiblioteca().getIdBiblioteca());
		biblioteca.getPersonas().add(usuarioRegistrado);
		iBibliotecaServicios.eleminarBiblioteca(biblioteca);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}