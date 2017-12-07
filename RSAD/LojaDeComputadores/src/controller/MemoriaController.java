package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Memoria;
import repositories.RepositorioItem;

@WebServlet("/MemoriaController")
public class MemoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemoriaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Memoria> memorias = new ArrayList<Memoria>();
		memorias = (ArrayList<Memoria>) RepositorioItem.getInstance().getMemorias();
		request.setAttribute("lista", memorias);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-memoria.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
