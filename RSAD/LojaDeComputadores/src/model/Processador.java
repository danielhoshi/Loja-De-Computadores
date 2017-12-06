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
public class Processador extends Componente {

	private Integer id;
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

	public String getFrequencia() {
		return frequencia;
	}

	public Soquete getSoquete() {
		return soquete;
	}

	public Integer getId() {
		return id;
	}
}