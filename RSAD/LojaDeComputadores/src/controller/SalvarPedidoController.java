package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computador;
import model.ItemPedido;
import model.Pedido;
import repositories.RepositorioItem;
import repositories.RepositorioPedido;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/SalvarPedidoController")
public class SalvarPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvarPedidoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		List<ItemPedido> itensPedido = pedido.getItemPedido();
		RepositorioPedido rep = RepositorioPedido.getInstance();
		RepositorioItem repItem = RepositorioItem.getInstance();

		Integer idPedido = rep.inserirPedido(pedido);
		for (ItemPedido ip : itensPedido) {
			if (ip.getItem() instanceof Computador) {
				ItemPedido itemComputador = new ItemPedido(repItem.inserirComputador((Computador) ip.getItem()),
						ip.getQtd());
				rep.inserirItemPedido(itemComputador, idPedido);
			} else {
				rep.inserirItemPedido(ip, idPedido);
			}
		}
		request.getSession().removeAttribute("pedido");
		request.setAttribute("msg", "Pedido salvo com sucesso!");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
