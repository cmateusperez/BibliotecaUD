package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.IMaterialBibliograficoServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.MaterialBibliograficoServicios;

@WebServlet(urlPatterns = { "/listaCompletaMaterialBibliografico" })
public class MaterialBibliograficoListaCompletaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MaterialBibliograficoListaCompletaServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IMaterialBibliograficoServicios iMaterialBibliografico = new MaterialBibliograficoServicios();
		Persona usuarioRegistrado = (Persona) request.getSession(false).getAttribute("usuarioRegistrado");
		List<MaterialBibliografico> materialBibliograficoLista = new ArrayList<MaterialBibliografico>();
		if (usuarioRegistrado.getBiblioteca() != null) {
			materialBibliograficoLista = iMaterialBibliografico
					.buscarMaterialBibliograficoXIdBiblioteca(usuarioRegistrado.getBiblioteca().getIdBiblioteca());
		}
		request.setAttribute("materialBibliografico", materialBibliograficoLista);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/listaCompletaMaterialBibliografico.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}