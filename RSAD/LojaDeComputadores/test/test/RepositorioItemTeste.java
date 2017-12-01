package test;

import java.util.ArrayList;
import java.util.List;

import model.HD;
import model.Memoria;
import model.PlacaMae;
import model.Processador;
import model.Soquete;
import model.TipoMemoria;
import repositories.RepositorioItem;

public class RepositorioItemTeste extends RepositorioItem {
	
	public List<HD> getHds(){
		ArrayList<HD> hds = new ArrayList<HD>();
		HD hdTeste1 = new HD(1, 500.0, "Seagate", "BarraCuda", "1 TB", "Disco");
		HD hdTeste2 = new HD(2, 1500.0, "Seagate", "IronWolf", "5 TB", "Disco");
		HD hdTeste3 = new HD(3, 310.0, "Kingston", "Now V300", "120 GB", "SSD");

		hds.add(hdTeste1);
		hds.add(hdTeste2);
		hds.add(hdTeste3);
		return hds;
	}
	
	public List<Memoria> getMemorias(){
		ArrayList<Memoria> memorias = new ArrayList<Memoria>();
		Memoria mTeste1 = new Memoria(1, (double) 500, "Kingston", "Fury 2133MHz", "4 GB", new TipoMemoria(1, "DDR3"));
		Memoria mTeste2 = new Memoria(2, (double) 300,"Corsair", "Vengeance 1333MHz", "2 GB", new TipoMemoria(1, "DDR3"));
		Memoria mTeste3 = new Memoria(3, (double) 800,"Crucial", "CT4G4DFS8213 2133MHz", "4 GB",  new TipoMemoria(2, "DDR4"));
		Memoria mTeste4 = new Memoria(3, (double) 800,"Crucial", "CT4G4DFS8213 2133MHz", "4 GB",  new TipoMemoria(2, "DDR4"));

		memorias.add(mTeste1);
		memorias.add(mTeste2);
		memorias.add(mTeste3);
		memorias.add(mTeste4);
		return memorias;
	}

	public List<Processador> getProcessadores(){
		ArrayList<Processador> processadores = new ArrayList<Processador>();
		Processador mTeste1 = new Processador(1, (double) 300, "Intel", "Dual Core", "2.4GHz", new Soquete(1, "LGA 775"));
		Processador mTeste2 = new Processador(2, (double) 600, "Intel", "i3", "2.4GHz", new Soquete(2, "LGA 1151"));
		Processador mTeste3 = new Processador(3, (double) 800, "Intel", "i5", "2.4GHz", new Soquete(3, "AM3+"));
		Processador mTeste4 = new Processador(4, (double) 800, "AMD", "Ryzen 5", "3.4GHz", new Soquete(4, "FM2+"));

		processadores.add(mTeste1);
		processadores.add(mTeste2);
		processadores.add(mTeste3);
		processadores.add(mTeste4);
		processadores.add(mTeste1);
		processadores.add(mTeste2);
		processadores.add(mTeste3);
		processadores.add(mTeste4);
		return processadores;
	}
	
	public List<PlacaMae> getPlacas(){
		//ArrayList<PlacaMae> placas = new ArrayList<PlacaMae>();
		//PlacaMae mTeste1 = new PlacaMae(1, (double) 300, "Asus", "Z170M-PLUS", "Dual Core", "2.4GHz", new Soquete(1, "LGA 775"));

		//placas.add(mTeste1);
		
		//return placas;
		return null;
	}
}
