package util;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.UsuarioVendedor;

public class DadosTeste {

	
	public static Usuario newUsuario(int id){
		Usuario u = new UsuarioVendedor(id,"login","senha","João Usuário","123.456.789-00");
		return u;
	}
	
	public static List<Usuario> newUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(newUsuario(1));
		usuarios.add(newUsuario(2));
		return usuarios;
	}
	
}
