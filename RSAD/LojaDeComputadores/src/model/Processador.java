package model;

public class Processador extends Item {
	private Integer id;

	private String fabricante;

	private String modelo;

	private String frequencia;

	private Soquete soquete;
	public Processador(Integer id, Double preco, String fabricante, String modelo, String frequencia, Soquete soquete) {
		super();
		this.id = id;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.frequencia = frequencia;
		this.soquete = soquete;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public Soquete getSoquete() {
		return soquete;
	}
	public void setSoquete(Soquete soquete) {
		this.soquete = soquete;
	}
	public Integer getId() {
		return id;
	}
}