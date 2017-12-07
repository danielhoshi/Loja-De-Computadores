package model;

public class Cargo {

	private Integer id;
	private String nome;

	public Cargo(Integer id, String nome) {
		super();
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