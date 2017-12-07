package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConexaoMySQL;
import model.ItemPedido;
import model.Pedido;

public class RepositorioPedido {

	private static RepositorioPedido instance = null;
	private Connection conn = null;

	public static RepositorioPedido getInstance() {
		if (instance == null) {
			instance = new RepositorioPedido();
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
	
	public Integer inserirItemPedido(ItemPedido itemPedido, Pedido pedido) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Integer novoId = null;
		try {
			String query = "INSERT INTO Itempedido(quantidade, idPedido, idItem) VALUES(?, ?, ?)";
			PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			state.setInt(1, itemPedido.getQtd());
			state.setInt(2, pedido.getId());
			state.setInt(3, itemPedido.getItem().getIdItem());
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
