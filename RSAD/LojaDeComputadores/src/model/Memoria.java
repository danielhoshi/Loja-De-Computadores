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
public class Memoria extends Componente {
	
	private Integer id;
	private String capacidade;
	private TipoMemoria tipoMemoria;

	public Memoria(Integer id, Double preco, String fabricante, String modelo, String capacidade,
			TipoMemoria tipoMemoria) {
		super();
		this.id = id;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.capacidade = capacidade;
		this.tipoMemoria = tipoMemoria;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public TipoMemoria getTipoMemoria() {
		return tipoMemoria;
	}

	public Integer getId() {
		return id;
	}
}