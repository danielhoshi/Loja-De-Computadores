package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConexaoMySQL;
import model.Cliente;

public class RepositorioCliente {

	private static RepositorioCliente instance = null;
	private Connection conn = null;

	public static RepositorioCliente getInstance() {
		if (instance == null) {
			instance = new RepositorioCliente();
		}
		return instance;
	}

	private void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente getCliente(String cpf) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Cliente cliente = null;
		try {
			String query = "SELECT * FROM Cliente c WHERE c.cpf = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setString(1, cpf);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				cliente = new Cliente(result.getInt("c.idCliente"), result.getString("c.cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if (cliente == null) {
			Integer novoId = inserirCliente(cpf);
			cliente = new Cliente(novoId, cpf);
		}
		return cliente;
	}

	public Integer inserirCliente(String cpf) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Integer novoId = null;
		try {
			String query = "INSERT INTO Cliente(cpf) VALUES(?)";
			PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			state.setString(1, cpf);
			state.executeUpdate();
			ResultSet result = state.getGeneratedKeys();
			if (result.next()) {
				novoId = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return novoId;
	}
}