package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioGerente;
import model.UsuarioVendedor;
import repositories.RepositorioCargo;
import repositories.RepositorioUsuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/CadastroUsuarioController")
public class CadastroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroUsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RepositorioCargo repositorioCargo = RepositorioCargo.getInstance();
		request.setAttribute("listaCargos", repositorioCargo.findAll());
		request.setAttribute("listaTipos", Arrays.asList(TipoUsuario.values()));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cadastro-usuario.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Integer idCargo = Integer.parseInt(request.getParameter("cargo"));
		Integer idTipo = Integer.parseInt(request.getParameter("tipo"));

		Usuario novoUsuario;

		if (idTipo == TipoUsuario.GERENTE.getId()) {
			novoUsuario = new UsuarioGerente(null, login, senha, nome, cpf, new Cargo(idCargo, "cargo"));
		} else {
			novoUsuario = new UsuarioVendedor(null, login, senha, nome, cpf, new Cargo(idCargo, "cargo"));
		}

		RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();

		Integer novoId = repositorioUsuario.inserir(novoUsuario);

		request.setAttribute("listaUsuarios", repositorioUsuario.findAll());
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/lista-usuario.jsp?novo=" + novoId);
		requestDispatcher.forward(request, response);
	}

}
