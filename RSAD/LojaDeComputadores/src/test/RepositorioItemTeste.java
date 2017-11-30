package test;

import java.util.ArrayList;
import java.util.List;

import model.HD;
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
}
