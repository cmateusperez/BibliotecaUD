package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Autor;
import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.Libro;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.IBibliotecaServicios;
import co.edu.udistrital.biblioteca.servicios.IMaterialBibliograficoServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.BibliotecaServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.MaterialBibliograficoServicios;

@WebServlet(urlPatterns = { "/doRegistroLibro" })
public class DoRegistroLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegistroLibroServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = (String) request.getParameter("nombre");
		String estado = (String) request.getParameter("estado");
		String autor = (String) request.getParameter("autor");
		String observacion = (String) request.getParameter("observacion");

		Libro materialBibliografico = new Libro();
		Autor autorOriginal = new Autor();
		autorOriginal.setIdAutor(Integer.parseInt(autor));
		Persona usuarioRegistrado = (Persona) request.getSession(false).getAttribute("usuarioRegistrado");
		IBibliotecaServicios iBibliotecaServicios = new BibliotecaServicios();
		Biblioteca biblioteca = iBibliotecaServicios.consultar(usuarioRegistrado.getBiblioteca().getIdBiblioteca());

		materialBibliografico.setNombreMaterial(nombre);
		materialBibliografico.setEstado(estado);
		materialBibliografico.setAutor(autorOriginal);
		materialBibliografico.setObservaciones(observacion);
		biblioteca.addMaterialbibliografico(materialBibliografico);
		materialBibliografico.setBiblioteca(biblioteca);

		IMaterialBibliograficoServicios iMaterialServicios = new MaterialBibliograficoServicios();
		iMaterialServicios.crearMaterialBibliografico(materialBibliografico);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}