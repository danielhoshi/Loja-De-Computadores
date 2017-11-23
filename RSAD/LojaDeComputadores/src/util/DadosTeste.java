package util;

import java.util.ArrayList;
import java.util.List;

import model.Cargo;
import model.Cliente;
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioVendedor;

public class DadosTeste {

	public static Usuario newUsuario(int id) {
		Usuario u = new UsuarioVendedor(id, "login", "senha", "João Usuário", "123.456.789-00");
		return u;
	}

	public static List<Usuario> newUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(newUsuario(1));
		usuarios.add(newUsuario(2));
		return usuarios;
	}

	public static Cargo newCargo(Integer id, String nome) {
		Cargo c = new Cargo(id, nome);
		return c;
	}

	public static List<Cargo> listaCargos() {
		ArrayList<Cargo> cargos = new ArrayList<>();
		cargos.add(newCargo(1, "Vendedor"));
		cargos.add(newCargo(2, "Gerente "));
		return cargos;
	}

	public static TipoUsuario newTipo(Integer id, String nome) {
		TipoUsuario t = new TipoUsuario(id, nome);
		return t;
	}

	public static List<TipoUsuario> listaTipos() {
		ArrayList<TipoUsuario> tipos = new ArrayList<>();
		tipos.add(newTipo(1, "Vendedor"));
		tipos.add(newTipo(2, "Gerente "));
		return tipos;
	}

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
		Usuario u = new UsuarioVendedor(1, "hoshida", "1234", "Daniel Hoshi", "43296438807");
		return u;
	}
}
