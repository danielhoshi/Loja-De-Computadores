package model;

import java.util.ArrayList;
import java.util.List;

public class Computador extends Item {

	private Integer idComputador;
	private List<Memoria> memorias;
	private List<HD> hds;
	private PlacaMae placa;
	private Processador processador;

	public Computador(Integer idComputador, PlacaMae placa, Processador processador) {
		super();
		this.idComputador = idComputador;
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

}