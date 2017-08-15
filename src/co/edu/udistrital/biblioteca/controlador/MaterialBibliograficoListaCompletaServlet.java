package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.servicios.BibliotecaServicios;
import co.edu.udistrital.biblioteca.serviciosImpl.IBibliotecaServicios;

@WebServlet(urlPatterns = { "/listaCompletaMaterialBibliografico" })
public class MaterialBibliograficoListaCompletaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public MaterialBibliograficoListaCompletaServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String errorString = null;
        Biblioteca biblioteca = null;
        IBibliotecaServicios iBibliotecaServicios = new BibliotecaServicios();
        
        biblioteca = iBibliotecaServicios.consultar("1");
        request.setAttribute("errorString", errorString);
        request.setAttribute("materialBibliografico", biblioteca.getListaMaterialBibliografico());
         
        // Forward to /WEB-INF/views/productListView.jsp
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