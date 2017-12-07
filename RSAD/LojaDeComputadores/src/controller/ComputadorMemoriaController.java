package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComponenteQuantidade;
import model.HD;
import model.Memoria;
import model.PlacaMae;
import repositories.RepositorioItem;

@WebServlet("/ComputadorMemoriaController")
public class ComputadorMemoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComputadorMemoriaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idPlaca = Integer.parseInt(request.getParameter("idPlaca"));
		Integer idProcessador = Integer.parseInt(request.getParameter("idProcessador"));
		Integer idMemoria = Integer.parseInt(request.getParameter("idMemoria"));
		Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
		Boolean adicionarOutras = request.getParameter("adicionarOutras").equals("true");

		RepositorioItem rep = RepositorioItem.getInstance();

		ArrayList<ComponenteQuantidade> memoriasComputador = (ArrayList<ComponenteQuantidade>) request.getSession()
				.getAttribute("memoriasComputador");
		memoriasComputador.add(new ComponenteQuantidade(idMemoria, quantidade));
		request.getSession().setAttribute("memoriasComputador", memoriasComputador);

		if (adicionarOutras) {
			PlacaMae placa = rep.getPlaca(idPlaca);
			Integer pentesSobrando = placa.getNumeroDePentes();
			for (ComponenteQuantidade mq : memoriasComputador) {
				pentesSobrando -= mq.getQuantidade();
			}

			ArrayList<Memoria> memorias = (ArrayList<Memoria>) rep.getMemoriasCompativeis(idPlaca);
			request.setAttribute("listaMemoria", memorias);
			RequestDispatcher requestDispatcher = getServletContext()
					.getRequestDispatcher("/computador-lista-memoria.jsp?idPlaca=" + idPlaca + "&idProcessador="
							+ idProcessador + "&numeroPentesSobrando=" + pentesSobrando);
			requestDispatcher.forward(request, response);
		} else {
			ArrayList<HD> hds = (ArrayList<HD>) rep.getHds();
			request.setAttribute("listaHD", hds);
			request.getSession().setAttribute("hdsComputador", new ArrayList<ComponenteQuantidade>());
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
					"/computador-lista-hd.jsp?idPlaca=" + idPlaca + "&idProcessador=" + idProcessador);
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
