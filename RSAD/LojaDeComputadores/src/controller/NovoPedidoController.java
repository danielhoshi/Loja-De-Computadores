package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Pedido;
import model.Usuario;
import repositories.RepositorioCliente;
import test.DadosTeste;

@WebServlet("/NovoPedidoController")
public class NovoPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovoPedidoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Cliente c = RepositorioCliente.obterCliente(cpf);
		Usuario u = DadosTeste.getUsuario();
		Pedido p = new Pedido(c, u);
		request.getSession().setAttribute("pedido", p);
		request.getSession().setAttribute("usuario", u);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
		requestDispatcher.forward(request, response);
	}

}
