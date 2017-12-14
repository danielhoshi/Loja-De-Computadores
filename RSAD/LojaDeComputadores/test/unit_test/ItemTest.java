package unit_test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.Memoria;
import model.TipoMemoria;

public class ItemTest {

	@Test
	public void getPrecoFormatTest() {
		Double preco = 1352.342;
		String fabricante = "Kingston";
		String modelo = "Fury 2133MHz";
		String capacidade = "4 GB";
		Memoria mem = new Memoria(null, null, preco, fabricante, modelo, capacidade, null);
		assertEquals("1.352,34", mem.getPrecoFormat());
	}

	@Test
	public void getNomeMemoriaTest() {
		Double preco = 1352.342;
		String fabricante = "Kingston";
		String modelo = "Fury 2133MHz";
		String capacidade = "4 GB";
		TipoMemoria tipoMem = new TipoMemoria(null, "DDR3");
		Memoria mem = new Memoria(null, null, preco, fabricante, modelo, capacidade, tipoMem);
		assertEquals("Pente de memória Kingston Fury 2133MHz 4 GB DDR3", mem.getNome());
	}
}
