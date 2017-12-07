package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computador;
import model.ItemPedido;
import model.Pedido;
import repositories.RepositorioItem;

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
		RepositorioItem rep = RepositorioItem.getInstance();
		for(ItemPedido ip : itensPedido){
			if(ip.getItem() instanceof Computador){
				ItemPedido itemComputador = new ItemPedido(rep.inserirComputador((Computador)ip.getItem()), ip.getQtd());
				rep.inserirItemPedido(itemComputador);
			}else{
				rep.inserirItemPedido(ip);
			}
		}
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