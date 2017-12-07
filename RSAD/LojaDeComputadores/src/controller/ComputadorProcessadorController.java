package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Memoria;
import model.ComponenteQuantidade;
import model.PlacaMae;
import repositories.RepositorioItem;

@WebServlet("/ComputadorProcessadorController")
public class ComputadorProcessadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComputadorProcessadorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idPlaca = Integer.parseInt(request.getParameter("idPlaca"));
		Integer idProcessador = Integer.parseInt(request.getParameter("idProcessador"));
		RepositorioItem rep = RepositorioItem.getInstance();
		PlacaMae placa = rep.getPlaca(idPlaca);
		ArrayList<Memoria> memorias = (ArrayList<Memoria>) rep.getMemoriasCompativeis(idPlaca);
		request.setAttribute("listaMemoria", memorias);
		request.getSession().setAttribute("memoriasComputador", new ArrayList<ComponenteQuantidade>());
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/computador-lista-memoria.jsp?idPlaca=" + idPlaca + "&idProcessador="
						+ idProcessador + "&numeroPentesSobrando=" + placa.getNumeroDePentes());
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
