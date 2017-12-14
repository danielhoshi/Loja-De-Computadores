package model;

public abstract class Componente extends Item {

	protected String fabricante;
	protected String modelo;

	public Componente() {
		super();
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
}
