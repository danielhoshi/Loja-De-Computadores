package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Processador;
import repositories.RepositorioItem;

@WebServlet("/ComputadorPlacaController")
public class ComputadorPlacaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComputadorPlacaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idPlaca = Integer.parseInt(request.getParameter("idPlaca"));
		ArrayList<Processador> processadores = (ArrayList<Processador>) RepositorioItem.getInstance()
				.getProcessadoresCompativeis(idPlaca);
		request.setAttribute("listaProcessador", processadores);
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/computador-lista-processador.jsp?idPlaca=" + idPlaca);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
