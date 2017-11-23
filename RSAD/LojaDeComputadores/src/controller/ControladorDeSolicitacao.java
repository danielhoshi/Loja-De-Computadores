package controller;

import java.util.Set;

import model.Cliente;
import model.HD;
import model.Item;
import model.Memoria;
import model.Pedido;
import model.PlacaMae;
import model.Processador;
import model.Usuario;
import repositories.RepositorioCliente;
import util.DadosTeste;

public class ControladorDeSolicitacao {

	public void solicitaNovoPedido() {

	}

	public Set<Memoria> getMemorias() {
		return null;
	}

	public Set<Processador> getProcessadores() {
		return null;
	}

	public Set<HD> getHds() {
		return null;
	}

	public Set<PlacaMae> getPlacasMae() {
		return null;
	}

	public Item selecionaItem(int idItem, int qtd) {
		return null;
	}

	public void confirmaPedido() {

	}

	public void finalizaPedido() {

	}

	public static Pedido novoPedido(String cpf) {
		Cliente c = RepositorioCliente.verificaCliente(cpf);
		Usuario u = DadosTeste.getUsuario();
		Pedido p = new Pedido(c, u);
		return p;
	}

}