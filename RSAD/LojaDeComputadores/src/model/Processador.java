package model;

public class Processador extends Componente {

	private Integer id;

	private String frequencia;

	private Soquete soquete;

	public Processador(Integer id, Integer idItem, Double preco, String fabricante, String modelo, String frequencia,
			Soquete soquete) {
		super();
		this.id = id;
		this.idItem = idItem;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.frequencia = frequencia;
		this.soquete = soquete;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public Soquete getSoquete() {
		return soquete;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getNome() {
		return "Processador " + this.fabricante + " " + this.modelo + " " + this.frequencia;
	}
}