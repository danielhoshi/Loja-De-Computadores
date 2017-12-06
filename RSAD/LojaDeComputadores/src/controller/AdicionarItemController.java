package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.Memoria;
import model.Pedido;
import model.TipoItem;
import repositories.RepositorioItem;
import test.RepositorioItemTeste;

@WebServlet("/AdicionarItemController")
public class AdicionarItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdicionarItemController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Pedido pedido = (Pedido) request.getAttribute("pedido");
		request.setAttribute("pedido", pedido);
		if (id != null) {

		} else {
			ArrayList<Memoria> memorias = new ArrayList<Memoria>();
			RepositorioItem rep = new RepositorioItemTeste();
			memorias = (ArrayList<Memoria>) rep.getMemorias();
			request.setAttribute("lista", memorias);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-memoria.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer tipoItem = Integer.parseInt(request.getParameter("tipoItem"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer qtd = Integer.parseInt(request.getParameter("qtd"));
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		Item item = null;
		if(tipoItem == TipoItem.PLACA.getId()) {
			item = RepositorioItem.getPlaca(id);
		} else if(tipoItem == TipoItem.PROCESSADOR.getId()) {
			
		} else if(tipoItem == TipoItem.HD.getId()) {
			
		} else if(tipoItem == TipoItem.MEMORIA.getId()) {
			
		}
	}

}
