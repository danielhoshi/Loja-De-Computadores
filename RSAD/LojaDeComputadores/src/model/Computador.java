package model;

import java.util.ArrayList;
import java.util.List;

public class Computador extends Item {

	private Integer idComputador;
	private List<Memoria> memorias;
	private List<HD> hds;
	private PlacaMae placa;
	private Processador processador;

	public Computador(Integer idComputador, Integer idItem, PlacaMae placa, Processador processador) {
		super();
		this.idComputador = idComputador;
		this.idItem = idItem;
		this.placa = placa;
		this.processador = processador;
		this.hds = new ArrayList<HD>();
		this.memorias = new ArrayList<Memoria>();
		calcularPrecoInicial();
	}

	private void calcularPrecoInicial() {
		this.preco = 300.0 + this.placa.getPreco() + this.processador.getPreco();
	}

	public void adicionarMemoria(Memoria... memorias) {
		for (Memoria memoria : memorias) {
			this.memorias.add(memoria);
			this.preco += memoria.getPreco();
		}
	}

	public void adicionarHD(HD... hds) {
		for (HD hd : hds) {
			this.hds.add(hd);
			this.preco += hd.getPreco();
		}
	}

	public Integer getIdComputador() {
		return idComputador;
	}

	public List<Memoria> getMemorias() {
		return memorias;
	}

	public List<HD> getHds() {
		return hds;
	}

	public PlacaMae getPlaca() {
		return placa;
	}

	public Processador getProcessador() {
		return processador;
	}

	public void setIdComputador(Integer idComputador) {
		this.idComputador = idComputador;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	@Override
	public String getNome() {
		String nome = "Computador com " + this.processador.getNome() + ", ";
		for(HD hd : this.hds) {
			nome += hd.getNome() + ", ";
		}
		for(Memoria mem : this.memorias) {
			nome += mem.getNome() + ", ";
		}
		nome += this.placa.getNome();
		return nome;
	}
}