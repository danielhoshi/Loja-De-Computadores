package test;

import java.util.ArrayList;
import java.util.List;

import model.HD;
import model.Memoria;
import model.TipoMemoria;
import repositories.RepositorioItem;

public class RepositorioItemTeste extends RepositorioItem {
	
	public List<HD> getHds(){
		ArrayList<HD> hds = new ArrayList<HD>();
		HD hdTeste1 = new HD(1, (double) 500, "Seagate", "BarraCuda", "1 TB", "Disco");
		HD hdTeste2 = new HD(2, (double) 1500, "Seagate", "IronWolf", "5 TB", "Disco");
		HD hdTeste3 = new HD(3, (double) 310, "Kingston", "Now V300", "120 GB", "SSD");

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
}
