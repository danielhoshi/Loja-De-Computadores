package model;

public abstract class Usuario {
	
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private Cargo cargo;
	
	protected Usuario(Integer id, String login, String senha, String nome, String cpf, Cargo cargo) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
	}
	
	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

}