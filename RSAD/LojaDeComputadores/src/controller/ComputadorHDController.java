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
import model.Computador;
import model.HD;
import model.ItemPedido;
import model.Memoria;
import model.Pedido;
import model.PlacaMae;
import repositories.RepositorioItem;

@WebServlet("/ComputadorHDController")
public class ComputadorHDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComputadorHDController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idPlaca = Integer.parseInt(request.getParameter("idPlaca"));
		Integer idProcessador = Integer.parseInt(request.getParameter("idProcessador"));
		Integer idHD = Integer.parseInt(request.getParameter("idHD"));
		Integer qtdHD = Integer.parseInt(request.getParameter("quantidadeHD"));
		Integer qtdComputador = Integer.parseInt(request.getParameter("quantidade"));
		Boolean adicionarOutros = request.getParameter("adicionarOutros").equals("true");

		RepositorioItem rep = RepositorioItem.getInstance();

		ArrayList<ComponenteQuantidade> hdsComputador = (ArrayList<ComponenteQuantidade>) request.getSession()
				.getAttribute("hdsComputador");
		hdsComputador.add(new ComponenteQuantidade(idHD, qtdHD));
		request.getSession().setAttribute("hdsComputador", hdsComputador);

		if (adicionarOutros) {
			ArrayList<HD> hds = (ArrayList<HD>) rep.getHds();
			request.setAttribute("listaHD", hds);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
					"/computador-lista-hd.jsp?idPlaca=" + idPlaca + "&idProcessador=" + idProcessador);
			requestDispatcher.forward(request, response);
		} else {
			Computador computador = new Computador(null, null, rep.getPlaca(idPlaca),
					rep.getProcessador(idProcessador));
			ArrayList<ComponenteQuantidade> memoriasComputador = (ArrayList<ComponenteQuantidade>) request.getSession()
					.getAttribute("memoriasComputador");
			for (ComponenteQuantidade memoriaQtd : memoriasComputador) {
				for (int cont = 0; cont < memoriaQtd.getQuantidade(); cont++) {
					computador.adicionarMemoria(rep.getMemoria(memoriaQtd.getIdComponente()));
				}
			}
			for (ComponenteQuantidade hdQtd : hdsComputador) {
				for (int cont = 0; cont < hdQtd.getQuantidade(); cont++) {
					computador.adicionarHD(rep.getHd(hdQtd.getIdComponente()));
				}
			}
			Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
			pedido.adicionaItemPedido(new ItemPedido(computador, qtdComputador));
			request.getSession().setAttribute("pedido", pedido);

			request.getSession().removeAttribute("hdsComputador");
			request.getSession().removeAttribute("memoriasComputador");

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pedido.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
