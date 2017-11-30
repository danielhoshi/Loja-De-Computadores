package model;
/**
 * 
 */

import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author aluno
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Cargo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer id;
	private String nome;
	
	public Cargo(Integer id, String nome) {
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