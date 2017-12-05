package test;

import java.util.ArrayList;
import java.util.List;

import model.Cargo;
import model.Cliente;
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioGerente;
import model.UsuarioVendedor;

public class DadosTeste {

	public static List<Cliente> getAllClientes() {

		// clientes estaticos
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		Cliente clienteTeste1 = new Cliente(1, "43296438807");
		Cliente clienteTeste2 = new Cliente(2, "01256948810");
		Cliente clienteTeste3 = new Cliente(3, "07565002810");

		clientes.add(clienteTeste1);
		clientes.add(clienteTeste2);
		clientes.add(clienteTeste3);

		return clientes;
	}

	public static Usuario getUsuario() {
		Usuario u = new UsuarioVendedor(1, "hoshida", "1234", "Daniel Hoshi", "43296438807", new Cargo(1, "Vendedor"));
		return u;
	}
}
