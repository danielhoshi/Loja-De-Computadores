package model;
/**
 * 
 */

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author aluno
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class HD extends Componente {
	
	private Integer id;
	private String capacidade;
	private String tecnologia;

	public HD(Integer id, Double preco, String fabricante, String modelo, String capacidade, String tecnologia) {
		super();
		this.id = id;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.capacidade = capacidade;
		this.tecnologia = tecnologia;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public Integer getId() {
		return id;
	}
}