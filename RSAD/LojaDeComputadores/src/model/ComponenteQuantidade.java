package model;

public class ComponenteQuantidade {
	
	private Integer idComponente;
	private Integer quantidade;
	
	public ComponenteQuantidade(Integer idComponente, Integer quantidade) {
		super();
		this.idComponente = idComponente;
		this.quantidade = quantidade;
	}

	public Integer getIdComponente() {
		return idComponente;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
}
