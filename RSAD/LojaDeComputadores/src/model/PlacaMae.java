package model;
/**
 * 
 */

import java.util.List;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author aluno
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PlacaMae extends Componente {
	private Integer id;
	private List<TipoMemoria> tipoMemoria;
	private Integer numeroDePentes;
	private Soquete soquete;
	
	public PlacaMae(Integer id, Double preco, List<TipoMemoria> tipoMemoria, String fabricante, String modelo, Integer numeroDePentes,
			Soquete soquete) {
		super();
		this.id = id;
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
	
	
}