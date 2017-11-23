package model;

public class Cliente {

	private Integer id;
	private String CPF;

	public Cliente(Integer id, String CPF) {
		super();
		this.id = id;
		this.CPF = CPF;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Integer getId() {
		return id;
	}

}