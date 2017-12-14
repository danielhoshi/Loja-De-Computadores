package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.RepositorioUsuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/ExcluirUsuarioController")
public class ExcluirUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluirUsuarioController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idUsuario = Integer.parseInt(request.getParameter("id"));

		RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();

		repositorioUsuario.remover(idUsuario);
		request.setAttribute("listaUsuarios", repositorioUsuario.findAll());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-usuario.jsp");
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
