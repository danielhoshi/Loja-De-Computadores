package model;

public enum TipoItem {

	PLACA(1,"Placa-Mãe"),
	PROCESSADOR(2,"Processador"),
	HD(3,"HD"),
	MEMORIA(4,"Memoria");
	
	private Integer id;
	private String nome;
	
	TipoItem(Integer id, String nome) {
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