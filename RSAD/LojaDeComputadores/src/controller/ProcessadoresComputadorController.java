package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HD;
import model.PlacaMae;
import repositories.RepositorioItem;
import test.RepositorioItemTeste;

@WebServlet("/ProcessadoresComputadorController")
public class ProcessadoresComputadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArrayList<HD> hds;

	public ProcessadoresComputadorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<PlacaMae> placas = new ArrayList<PlacaMae>();
		RepositorioItem rep = new RepositorioItemTeste();
		placas = (ArrayList<PlacaMae>) rep.getPlacasMae();
		request.setAttribute("listaPlacas", placas);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/computador-lista-processador.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
