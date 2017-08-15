package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.servicios.BibliotecaServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.IBibliotecaServicios;

@WebServlet(urlPatterns = { "/doRegistroMaterialBibliografico" })
public class DoRegistroMaterialBibliograficoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegistroMaterialBibliograficoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo = (String) request.getParameter("codigo");
		String nombre = (String) request.getParameter("nombre");
		String estado = (String) request.getParameter("estado");

		MaterialBibliografico materialBibliografico = new MaterialBibliografico(Integer.parseInt(codigo), nombre,
				estado);
		//Datos dummy 
		IBibliotecaServicios iBibliotecaServicios = new BibliotecaServicios();
		iBibliotecaServicios.agregarMaterialBibliografico("1", materialBibliografico);
		response.sendRedirect(request.getContextPath() + "/productList");
	}

	@Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
}