package util;

import java.util.ArrayList;
import java.util.List;

import model.Cargo;
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioGerente;
import model.UsuarioVendedor;

public class DadosTeste {

	public static Usuario newUsuario(boolean isGerente) {
		if (isGerente) {
			return new UsuarioGerente(1, "login", "senha", "João Usuário", "123.456.789-00", new Cargo(1, "Vendedor"));
		}
		return new UsuarioVendedor(1, "login", "senha", "João Usuário", "123.456.789-00", new Cargo(1, "Vendedor"));
	}

	public static List<Usuario> newUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(newUsuario(true));
		usuarios.add(newUsuario(false));
		usuarios.add(newUsuario(false));
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

	public static List<TipoUsuario> listaTipos() {
		ArrayList<TipoUsuario> tipos = new ArrayList<>();
		for (TipoUsuario tipo : TipoUsuario.values()) {
			tipos.add(tipo);
		}
		return tipos;
	}
}
