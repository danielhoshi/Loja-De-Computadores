package model;

public class UsuarioVendedor extends Usuario {

	public UsuarioVendedor(Integer id, String login, String senha, String nome,
			String cpf, Cargo cargo) {
		super(id, login, senha, nome, cpf, cargo);
	}
}