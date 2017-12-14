package model;

public class HD extends Componente {
	
	private Integer id;
	private String capacidade;
	private String tecnologia;

	public HD(Integer id, Integer idItem, Double preco, String fabricante, String modelo, String capacidade, String tecnologia) {
		super();
		this.id = id;
		this.idItem = idItem;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.capacidade = capacidade;
		this.tecnologia = tecnologia;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getNome() {
		return this.tecnologia + " " + this.fabricante + " " + this.modelo + " " + this.capacidade;
	}
}