package model;

public class ItemPedido {
	private Integer id;
	
	private Pedido pedido;

	private Item item;

	private Integer qtd;

	public ItemPedido(Pedido pedido, Item item, Integer qtd) {
		super();
		this.pedido = pedido;
		this.item = item;
		this.qtd = qtd;
	}

	public Integer getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Item getItem() {
		return item;
	}

	public Integer getQtd() {
		return qtd;
	}
}