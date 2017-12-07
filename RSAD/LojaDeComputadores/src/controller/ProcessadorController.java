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
import model.Processador;
import repositories.RepositorioItem;

@WebServlet("/ProcessadorController")
public class ProcessadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArrayList<HD> hds;

	public ProcessadorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {

		} else {
			ArrayList<Processador> processadores = new ArrayList<Processador>();
			processadores = (ArrayList<Processador>) RepositorioItem.getInstance().getProcessadores();
			request.setAttribute("lista", processadores);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-processador.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
