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
public class PlacaMae extends Item {
	private Integer id;

	private List<TipoMemoria> tipoMemoria;

	private String fabricante;

	private String modelo;

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

	public List<TipoMemoria> getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(List<TipoMemoria> tipoMemoria) {
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

	public Integer getNumeroDePentes() {
		return numeroDePentes;
	}

	public void setNumeroDePentes(Integer numeroDePentes) {
		this.numeroDePentes = numeroDePentes;
	}

	public Soquete getSoquete() {
		return soquete;
	}

	public void setSoquete(Soquete soquete) {
		this.soquete = soquete;
	}

	public Integer getId() {
		return id;
	}
}