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
public class ItemPedido {

	private Item item;
	private Integer qtd;

	public ItemPedido(Item item, Integer qtd) {
		super();
		this.item = item;
		this.qtd = qtd;
	}

	public Item getItem() {
		return item;
	}

	public Integer getQtd() {
		return qtd;
	}

}