package model;
/**
 * 
 */

import java.util.Set;

public class TipoUsuario {

	private Integer id;
	private String nome;
	
	public TipoUsuario(Integer id, String nome) {
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