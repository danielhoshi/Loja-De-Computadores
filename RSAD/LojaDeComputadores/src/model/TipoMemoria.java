package model;
/**
 * 
 */

import java.util.Set;

public class TipoMemoria {
	private Integer id;

	private String nome;

	private Set<Memoria> memoria;

	private Set<PlacaMae> placaMae;

	public TipoMemoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Memoria> getMemoria() {
		return memoria;
	}

	public void setMemoria(Set<Memoria> memoria) {
		this.memoria = memoria;
	}

	public Set<PlacaMae> getPlacaMae() {
		return placaMae;
	}

	public void setPlacaMae(Set<PlacaMae> placaMae) {
		this.placaMae = placaMae;
	}

	public Integer getId() {
		return id;
	}
}