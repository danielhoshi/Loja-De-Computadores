package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import util.DadosTeste;

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
		request.setAttribute("listaCargos", DadosTeste.listaCargos());
		request.setAttribute("listaTipos", DadosTeste.listaTipos());
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
		Random rand = new Random();
		Integer idRand = rand.nextInt(100);
		
		if (idTipo == TipoUsuario.GERENTE.getId()) {
			novoUsuario = new UsuarioGerente(idRand, login, senha, nome, cpf, DadosTeste.newCargo(idCargo, "cargo"));
		} else {
			novoUsuario = new UsuarioVendedor(idRand, login, senha, nome, cpf, DadosTeste.newCargo(idCargo, "cargo"));
		}
		// TODO salvar no bdd

		List<Usuario> usuarios = (ArrayList<Usuario>) request.getSession().getAttribute("listaUsuarios");
		usuarios.add(novoUsuario);
		request.getSession().setAttribute("listaUsuarios", usuarios);
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/lista-usuario.jsp?novo=" + novoUsuario.getId());
		requestDispatcher.forward(request, response);
	}

}
