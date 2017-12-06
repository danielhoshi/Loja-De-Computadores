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
import model.Pedido;
import repositories.RepositorioItem;
import test.RepositorioItemTeste;

@WebServlet("/HDController")
public class HDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArrayList<HD> hds;

	public HDController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
//			int parsedId = Integer.parseInt(id);
//			HD hd = (HD) ControladorDeSolicitacao.getInstance().getItem(parsedId);
//			if (hd != null) {
//				request.setAttribute("hd", hd);
//				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/hd.jsp");
//				requestDispatcher.forward(request, response);
//			} else
//				System.out.println("HD não encontrado");
		} else {
			ArrayList<HD> hds = new ArrayList<HD>();
			RepositorioItem rep = new RepositorioItemTeste();
			hds = (ArrayList<HD>) rep.getHds();
			request.setAttribute("lista", hds);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-hd.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
