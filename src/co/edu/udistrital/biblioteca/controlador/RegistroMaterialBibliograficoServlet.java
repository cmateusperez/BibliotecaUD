package co.edu.udistrital.biblioteca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = { "/registroMaterialBibliografico" })
public class RegistroMaterialBibliograficoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public RegistroMaterialBibliograficoServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/registroMaterialBibliografico.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}