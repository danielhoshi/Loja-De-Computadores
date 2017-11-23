package repositories;

import java.util.List;

import model.Cliente;
import util.DadosTeste;

public class RepositorioCliente {

	public static Cliente verificaCliente(String cpf) {
		List<Cliente> clientes = DadosTeste.getAllClientes();
		Integer lastId = 0;
		for(Cliente c : clientes){
			if(cpf.equals(c.getCPF())){
				return c;
			}
			lastId = c.getId();
		}
		Cliente novoCliente = new Cliente(lastId + 1, cpf);
		//adicionar novo cliente
		
		return novoCliente;
	}

}