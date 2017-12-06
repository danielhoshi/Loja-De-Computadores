package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Integer id;
	private List<ItemPedido> itemPedido;
	private Cliente cliente;
	private Double precoFinal;
	private Double desconto;
	private Usuario usuario;

	public Pedido(Cliente cliente, Usuario usuario) {
		super();

		// TODO inserir id
		this.id = 1;
		this.itemPedido = new ArrayList<>();
		this.cliente = cliente;
		this.usuario = usuario;
	}

	public void adicionaItemPedido(ItemPedido... itens) {
		for (ItemPedido ip : itens) {
			itemPedido.add(ip);
		}
	}

	public void calculaPreco() {

	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Integer getId() {
		return id;
	}
}