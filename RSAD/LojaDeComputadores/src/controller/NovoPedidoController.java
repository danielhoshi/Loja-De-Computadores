package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;

@WebServlet("/NovoPedidoController")
public class NovoPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovoPedidoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Pedido p = (Pedido) ControladorDeSolicitacao.getInstance().novoPedido(cpf);
		request.setAttribute("pedido", p);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
		requestDispatcher.forward(request, response);
	}

}
