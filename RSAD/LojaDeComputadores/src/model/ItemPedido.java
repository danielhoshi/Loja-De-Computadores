package model;

public class ItemPedido {

	private Integer id;
	private Item item;
	private Integer qtd;

	public ItemPedido(Item item, Integer qtd) {
		super();
		this.item = item;
		this.qtd = qtd;
	}

	public Integer getId() {
		return id;
	}

	public Item getItem() {
		return item;
	}

	public Integer getQtd() {
		return qtd;
	}

}