package model;
/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author aluno
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Memoria extends Item {
	public Integer id;

	private String fabricante;

	private String modelo;

	private String capacidade;

	private TipoMemoria tipoMemoria;

	public Memoria(Integer id, Double preco, String fabricante, String modelo, String capacidade, TipoMemoria tipoMemoria) {
		super();
		this.id = id;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.capacidade = capacidade;
		this.tipoMemoria = tipoMemoria;
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
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public TipoMemoria getTipoMemoria() {
		return tipoMemoria;
	}
	public void setTipoMemoria(TipoMemoria tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	public Integer getId() {
		return id;
	}
}