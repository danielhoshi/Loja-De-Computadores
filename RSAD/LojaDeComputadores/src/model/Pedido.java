package model;

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
		
		//inserir id
		this.id = 1;
		
		this.cliente = cliente;
		this.usuario = usuario;
	}

	public void adicionaItemPedido() {

	}

	public void calculaPreco() {

	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}
}