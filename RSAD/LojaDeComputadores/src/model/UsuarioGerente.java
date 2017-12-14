package model;

public class UsuarioGerente extends Usuario {

	public UsuarioGerente(Integer id, String login, String senha, String nome, String cpf, Cargo cargo) {
		super(id, login, senha, nome, cpf, cargo);
	}
}