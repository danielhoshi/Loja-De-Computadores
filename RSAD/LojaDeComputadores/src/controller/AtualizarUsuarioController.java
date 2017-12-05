package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TipoUsuario;
import model.Usuario;
import model.UsuarioGerente;
import model.UsuarioVendedor;
import repositories.RepositorioCargo;
import repositories.RepositorioUsuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/AtualizarUsuarioController")
public class AtualizarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarUsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		Integer idUsuario = Integer.parseInt(request.getParameter("id"));

		RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();
		RepositorioCargo repositorioCargo = RepositorioCargo.getInstance();

		Usuario usuarioAtualizado;
		if (idTipo == TipoUsuario.GERENTE.getId()) {
			usuarioAtualizado = new UsuarioGerente(idUsuario, login, senha, nome, cpf,
					repositorioCargo.findyById(idCargo));
		} else {
			usuarioAtualizado = new UsuarioVendedor(idUsuario, login, senha, nome, cpf,
					repositorioCargo.findyById(idCargo));
		}

		repositorioUsuario.atualizar(usuarioAtualizado);

		request.setAttribute("listaUsuarios", repositorioUsuario.findAll());
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/lista-usuario.jsp?novo=" + usuarioAtualizado.getId());
		requestDispatcher.forward(request, response);
	}

}
