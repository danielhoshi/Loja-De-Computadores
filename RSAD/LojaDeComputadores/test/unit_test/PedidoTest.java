package unit_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Computador;
import model.HD;
import model.ItemPedido;
import model.Memoria;
import model.Pedido;
import model.PlacaMae;
import model.Processador;
import model.Soquete;
import model.TipoMemoria;

public class PedidoTest {
	
	@Test
	public void calculaPrecoSemDescontoTest(){
		Memoria mem = new Memoria(1, 1, 350.0, "Kingston", "Fury 2133MHz", "4 GB", new TipoMemoria(1, "DDR3"));
		HD hd = new HD(1, 2, 500.0, "Seagate", "IronWolf", "5 TB", "Disco");
		Processador proc = new Processador(1, 3, 1000.5, "Intel", "i5", "2.4GHz", new Soquete(1, "AM3+"));
		
		ItemPedido ip1 = new ItemPedido(mem, 1);
		ItemPedido ip2 = new ItemPedido(hd, 1);
		ItemPedido ip3 = new ItemPedido(proc, 1);
		
		Pedido pedido = new Pedido(null, null);
		pedido.adicionaItemPedido(ip1, ip2, ip3);
		
		assertTrue(1850.5 == pedido.calculaPreco());
	}
	
	@Test
	public void calculaPrecoComDescontoTest(){
		Memoria mem = new Memoria(1, 1, 300.0, "Kingston", "Fury 2133MHz", "4 GB", new TipoMemoria(1, "DDR3"));
		HD hd = new HD(1, 2, 500.0, "Seagate", "IronWolf", "5 TB", "Disco");
		Processador proc = new Processador(1, 3, 200.0, "Intel", "i5", "2.4GHz", new Soquete(1, "AM3+"));
		
		ItemPedido ip1 = new ItemPedido(mem, 10);
		ItemPedido ip2 = new ItemPedido(hd, 5);
		ItemPedido ip3 = new ItemPedido(proc, 5);
		
		Pedido pedido = new Pedido(null, null);
		pedido.adicionaItemPedido(ip1, ip2, ip3);
		
		assertTrue(5955 == pedido.calculaPreco());
	}
	
	@Test
	public void calculaPrecoComputadorTest(){
		Memoria mem = new Memoria(1, 1, 300.0, "Kingston", "Fury 2133MHz", "4 GB", new TipoMemoria(1, "DDR3"));
		HD hd = new HD(1, 2, 500.0, "Seagate", "IronWolf", "5 TB", "Disco");
		Processador proc = new Processador(1, 3, 200.0, "Intel", "i5", "2.4GHz", new Soquete(1, "AM3+"));
		PlacaMae placa = new PlacaMae(1, 5, 500.0, null, "Asus", "Z170M-PLUS/BR", 4, new Soquete(1, "AM3+"));
		
		Computador computador = new Computador(1, 4, placa, proc);
		computador.adicionarMemoria(mem);
		computador.adicionarHD(hd);
		
		ItemPedido ip = new ItemPedido(computador, 1);
		Pedido pedido = new Pedido(null, null);
		pedido.adicionaItemPedido(ip);
		
		assertTrue(1620 == pedido.calculaPreco());
	}
}
