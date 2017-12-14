package model;

public enum TipoUsuario {

	GERENTE(1,"Gerente"),
	VENDEDOR(2,"Vendedor");
	
	
	private Integer id;
	private String nome;
	
	TipoUsuario(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
}