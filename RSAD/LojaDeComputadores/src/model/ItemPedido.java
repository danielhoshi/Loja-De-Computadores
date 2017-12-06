package model;

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