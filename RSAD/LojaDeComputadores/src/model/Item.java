package model;

import java.text.DecimalFormat;
import java.util.List;

public abstract class Item {

	protected Integer idItem;
	private List<ItemPedido> itemPedido;

	protected Double preco;

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public String getPrecoFormat() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(preco);
	}
	
	public abstract String getNome();
}