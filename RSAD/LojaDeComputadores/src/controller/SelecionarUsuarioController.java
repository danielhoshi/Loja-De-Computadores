package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TipoUsuario;
import repositories.RepositorioCargo;
import repositories.RepositorioUsuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/SelecionarUsuarioController")
public class SelecionarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelecionarUsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idUsuario = Integer.parseInt(request.getParameter("id"));

		RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();
		RepositorioCargo repositorioCargo = RepositorioCargo.getInstance();

		request.setAttribute("usuarioSelecionado", repositorioUsuario.findByID(idUsuario));
		request.setAttribute("listaCargos", repositorioCargo.findAll());
		request.setAttribute("listaTipos", Arrays.asList(TipoUsuario.values()));

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/usuario.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
