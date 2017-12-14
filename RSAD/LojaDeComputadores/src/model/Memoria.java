package model;

public class Memoria extends Componente {
	
	private Integer id;
	private String capacidade;
	private TipoMemoria tipoMemoria;

	public Memoria(Integer id, Integer idItem, Double preco, String fabricante, String modelo, String capacidade,
			TipoMemoria tipoMemoria) {
		super();
		this.id = id;
		this.idItem = idItem;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.capacidade = capacidade;
		this.tipoMemoria = tipoMemoria;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public TipoMemoria getTipoMemoria() {
		return tipoMemoria;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getNome() {
		return "Pente de memória " + this.fabricante + " " + this.modelo + " " + this.capacidade + " " + this.tipoMemoria.getNome();
	}
}