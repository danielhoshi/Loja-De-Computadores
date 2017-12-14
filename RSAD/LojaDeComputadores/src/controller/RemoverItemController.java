package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;

@WebServlet("/RemoverItemController")
public class RemoverItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoverItemController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idItem = Integer.parseInt(request.getParameter("idItem"));
		Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		pedido.removerItemPedido(idItem, quantidade);
		request.getSession().setAttribute("pedido", pedido);
		
		String view;
		if (pedido.getItemPedido().isEmpty()) {
			view = "/pedido.jsp";
		} else {
			view = "/finalizar-pedido.jsp";
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(view);
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
