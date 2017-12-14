package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemPedido;
import model.Pedido;
import model.TipoItem;
import repositories.RepositorioItem;

@WebServlet("/AdicionarItemController")
public class AdicionarItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdicionarItemController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer tipoItem = Integer.parseInt(request.getParameter("tipoItem"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer qtd = Integer.parseInt(request.getParameter("quantidade"));
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		Item item = null;
		if (tipoItem == TipoItem.PLACA.getId()) {
			item = RepositorioItem.getInstance().getPlaca(id);
		} else if (tipoItem == TipoItem.PROCESSADOR.getId()) {
			item = RepositorioItem.getInstance().getProcessador(id);
		} else if (tipoItem == TipoItem.HD.getId()) {
			item = RepositorioItem.getInstance().getHd(id);
		} else if (tipoItem == TipoItem.MEMORIA.getId()) {
			item = RepositorioItem.getInstance().getMemoria(id);
		}
		ItemPedido itemPedido = new ItemPedido(item, qtd);
		pedido.adicionaItemPedido(itemPedido);
		request.getSession().setAttribute("pedido", pedido);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
		requestDispatcher.forward(request, response);
	}

}
