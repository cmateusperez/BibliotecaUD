package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Autor;
import co.edu.udistrital.biblioteca.servicios.IAutorServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.AutorServicios;

@WebServlet(urlPatterns = { "/registroLibro" })
public class RegistroLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistroLibroServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IAutorServicios iAutorServicios = new AutorServicios();
		List<Autor> autorLista = iAutorServicios.buscarAutores();
		request.setAttribute("autorLista", autorLista);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/registroLibro.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}