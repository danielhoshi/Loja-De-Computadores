package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HD;

@WebServlet("/HDController")
public class HDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArrayList<HD> hds;

	public HDController() {
		super();
		// TODO Auto-generated constructor stub
		hds = new ArrayList<HD>();

		HD hdTeste1 = new HD(1, 500, "Seagate", "BarraCuda", "1 TB", "Disco");

		HD hdTeste2 = new HD(2, 1500, "Seagate", "IronWolf", "5 TB", "Disco");

		HD hdTeste3 = new HD(3, 310, "Kingston", "Now V300", "120 GB", "SSD");

		hds.add(hdTeste1);
		hds.add(hdTeste2);
		hds.add(hdTeste3);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			int parsedId = Integer.parseInt(id);
			HD hd = null;
			for (HD item : hds) {
				if (item.getId() == parsedId) {
					hd = item;
				}
			}
			if (hd != null) {
				request.setAttribute("hd", hd);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/hd.jsp");
				requestDispatcher.forward(request, response);
			} else
				System.out.println("HD não encontrado");
		} else {
			request.setAttribute("lista", hds);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista-hd.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
