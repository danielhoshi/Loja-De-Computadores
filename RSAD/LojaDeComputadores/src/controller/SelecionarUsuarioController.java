package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import util.DadosTeste;

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
		//TODO selecionar do bd
		Usuario usuario;
		for (Usuario u : (ArrayList<Usuario>) request.getSession().getAttribute("listaUsuarios")){
			if(u.getId() == idUsuario){
				request.setAttribute("usuarioSelecionado", u);
			}
		}
		request.setAttribute("listaCargos", DadosTeste.listaCargos());
		request.setAttribute("listaTipos", DadosTeste.listaTipos());
		
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
