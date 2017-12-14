package model;
/**
 * 
 */

import java.util.List;

public class PlacaMae extends Componente {
	private Integer id;
	private List<TipoMemoria> tipoMemoria;
	private Integer numeroDePentes;
	private Soquete soquete;

	public PlacaMae(Integer id, Integer idItem, Double preco, List<TipoMemoria> tipoMemoria, String fabricante,
			String modelo, Integer numeroDePentes, Soquete soquete) {
		super();
		this.id = id;
		this.idItem = idItem;
		this.preco = preco;
		this.tipoMemoria = tipoMemoria;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.numeroDePentes = numeroDePentes;
		this.soquete = soquete;
	}

	public Integer getId() {
		return id;
	}

	public List<TipoMemoria> getTipoMemoria() {
		return tipoMemoria;
	}

	public Integer getNumeroDePentes() {
		return numeroDePentes;
	}

	public Soquete getSoquete() {
		return soquete;
	}

	@Override
	public String getNome() {
		return "Placa Mãe " + this.fabricante + " " + this.modelo + " " + this.soquete.getNome();
	}

}