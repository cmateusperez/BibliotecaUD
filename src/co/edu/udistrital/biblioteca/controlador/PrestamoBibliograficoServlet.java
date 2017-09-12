package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.IBibliotecaServicios;
import co.edu.udistrital.biblioteca.servicios.IMaterialBibliograficoServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.BibliotecaServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.MaterialBibliograficoServicios;
import co.edu.udistrital.biblioteca.utilidades.Estado;

@WebServlet(urlPatterns = { "/prestamoMaterial" })
public class PrestamoBibliograficoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrestamoBibliograficoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Persona usuarioRegistrado = (Persona) request.getSession(false).getAttribute("usuarioRegistrado");
		String codigo = (String) request.getParameter("codigo");
		IMaterialBibliograficoServicios iMaterialServicios = new MaterialBibliograficoServicios();
		MaterialBibliografico materialBibliografico = iMaterialServicios
				.buscarMaterialBibliograficoXId(Integer.parseInt(codigo));
		materialBibliografico.setEstado(Estado.PRESTADO.toString());
		IBibliotecaServicios iBibliotecaServicios = new BibliotecaServicios();
		Biblioteca biblioteca = iBibliotecaServicios.consultar(usuarioRegistrado.getBiblioteca().getIdBiblioteca());
		biblioteca.addMaterialbibliografico(materialBibliografico);
		materialBibliografico.setBiblioteca(biblioteca);
		iMaterialServicios.actualizarMaterialBibliografico(materialBibliografico);

		List<MaterialBibliografico> materialList = iMaterialServicios
				.buscarMaterialBibliograficoXIdBiblioteca(usuarioRegistrado.getBiblioteca().getIdBiblioteca());
		request.setAttribute("materialBibliografico", materialList);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/listaMaterialBibliografico.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}