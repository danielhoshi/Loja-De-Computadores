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
import repositories.RepositorioItem;

@WebServlet("/HDController")
public class HDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HDController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<HD> hds = new ArrayList<HD>();
		hds = (ArrayList<HD>) RepositorioItem.getInstance().getHds();
		request.setAttribute("lista", hds);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-hd.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
