package model;

import java.util.ArrayList;
import java.util.Collections;
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
		this.itemPedido = new ArrayList<>();
		this.cliente = cliente;
		this.usuario = usuario;
		this.precoFinal = 0.0;
		this.desconto = 0.0;
	}

	public void adicionaItemPedido(ItemPedido... itens) {
		for (ItemPedido ip : itens) {
			itemPedido.add(ip);
		}
		this.precoFinal = calculaPreco();
	}

	public void removerItemPedido(Integer idItem) {
		int indexARemover = 0;
		for (int i = 0; i < itemPedido.size(); i++) {
			if (itemPedido.get(i).getItem().getIdItem() == idItem) {
				indexARemover = i;
			}
		}
		if (indexARemover != 0) {
			itemPedido.remove(indexARemover);
			this.precoFinal = calculaPreco();
		}
	}

	public Double calculaPreco() {
		Double novoDesconto = 0.0;
		int menorQtd;
		int computadores = 0, memorias = 0, placas = 0, processadores = 0, hds = 0;
		Double precoTotalComputadores = 0.0, precoTotalMemorias = 0.0, precoTotalProcessadores = 0.0,
				precoTotalHds = 0.0, precoTotalPlacas = 0.0, precoTotal = 0.0;
		List<Double> listaPlacas = new ArrayList<Double>();
		List<Double> listaHd = new ArrayList<Double>();
		List<Double> listaProcessador = new ArrayList<Double>();

		for (ItemPedido ip : this.itemPedido) {
			if (ip.getItem() instanceof Computador) {
				computadores += ip.getQtd();
				precoTotalComputadores += ip.getQtd() * ip.getItem().getPreco();
			} else if (ip.getItem() instanceof Memoria) {
				memorias += ip.getQtd();
				precoTotalMemorias += ip.getQtd() * ip.getItem().getPreco();
			} else if (ip.getItem() instanceof PlacaMae) {
				placas += ip.getQtd();
				precoTotalPlacas += ip.getQtd() * ip.getItem().getPreco();
				for (int cont = 0; cont < placas; cont++) {
					listaPlacas.add(ip.getItem().getPreco());
				}
				Collections.sort(listaPlacas);
			} else if (ip.getItem() instanceof Processador) {
				processadores += ip.getQtd();
				precoTotalProcessadores += ip.getQtd() * ip.getItem().getPreco();
				for (int cont = 0; cont < processadores; cont++) {
					listaProcessador.add(ip.getItem().getPreco());
				}
				Collections.sort(listaProcessador);
			} else {
				hds += ip.getQtd();
				precoTotalHds += ip.getQtd() * ip.getItem().getPreco();
				for (int cont = 0; cont < hds; cont++) {
					listaHd.add(ip.getItem().getPreco());
				}
				Collections.sort(listaHd);
			}
		}
		if (computadores >= 5) {
			novoDesconto += precoTotalComputadores * 0.15;
		} else {
			novoDesconto += precoTotalComputadores * 0.1;
		}
		if (memorias >= 8) {
			novoDesconto += precoTotalMemorias * 0.1;
		}
		if (placas >= 5) {
			novoDesconto += precoTotalPlacas * 0.08;
		}
		if (processadores >= 5) {
			novoDesconto += precoTotalProcessadores * 0.07;
		}
		if (hds >= 5) {
			novoDesconto += precoTotalHds * 0.07;
		}
		if (placas < 5 && placas > 0 && (processadores < 5 && processadores > 0) || (hds < 5 && hds > 0)) {
			if (placas > processadores + hds)
				menorQtd = processadores + hds;
			else
				menorQtd = placas;
			int contProcessador = 0, contHd = 0;
			for (int cont = 0; cont < menorQtd; cont++) {
				novoDesconto += listaPlacas.get(cont) * 0.05;
				if (contProcessador >= processadores) {
					novoDesconto += listaHd.get(contHd) * 0.05;
					contHd++;
				} else if (contHd >= hds) {
					novoDesconto += listaProcessador.get(contProcessador) * 0.05;
					contProcessador++;
				} else if (listaHd.get(contHd) < listaProcessador.get(contProcessador)) {
					novoDesconto += listaProcessador.get(contProcessador) * 0.05;
					contProcessador++;
				} else {
					novoDesconto += listaHd.get(contHd) * 0.05;
					contHd++;
				}
			}
		}
		this.desconto = novoDesconto;
		precoTotal = precoTotalComputadores + precoTotalHds + precoTotalMemorias + precoTotalPlacas
				+ precoTotalProcessadores;
		return precoTotal - this.desconto;
	}

	public List<ItemPedido> getItemLista(Class classe) {
		List<ItemPedido> list = new ArrayList<ItemPedido>();
		for (ItemPedido ip : this.itemPedido) {
			if (classe.isInstance(ip.getItem())) {
				list.add(ip);
			}
		}
		return list;
	}

	public Double getPrecoLista(List<ItemPedido> list) {
		Double preco = 0.0;
		for (ItemPedido ip : list) {
			preco += ip.getItem().getPreco() * ip.getQtd();
		}
		return preco;
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

	public Double getDesconto() {
		return desconto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Integer getId() {
		return id;
	}
}