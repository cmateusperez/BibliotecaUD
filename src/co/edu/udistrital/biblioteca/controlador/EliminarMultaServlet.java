package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Multa;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.IMultaServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.MultaServicios;

@WebServlet(urlPatterns = { "/eliminarMulta" })
public class EliminarMultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EliminarMultaServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo = (String) request.getParameter("codigo");
		IMultaServicios iMultaServicios = new MultaServicios();
		Multa multa = iMultaServicios.buscarMultaXId(Integer.parseInt(codigo));
		iMultaServicios.eliminarMulta(multa);
		Persona usuarioRegistrado = (Persona) request.getSession(false).getAttribute("usuarioRegistrado");
		List<Multa> multaLista = iMultaServicios.buscarMulta(usuarioRegistrado.getIdPersona());
		request.setAttribute("multaLista", multaLista);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/multa.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}