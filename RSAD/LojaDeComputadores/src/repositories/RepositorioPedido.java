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

	public Integer inserirPedido(Pedido pedido) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Integer novoId = null;
		try {
			String query = "INSERT INTO Pedido(precoFinal, desconto, idCliente, idUsuario) VALUES(?, ?, ?, ?)";
			PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			state.setDouble(1, pedido.getPrecoFinal());
			state.setDouble(2, pedido.getDesconto());
			state.setInt(3, pedido.getCliente().getId());
			state.setInt(4, pedido.getUsuario().getId());
			state.executeUpdate();
			ResultSet rs = state.getGeneratedKeys();
			if (rs.next()) {
				novoId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return novoId;
	}

	public void inserirItemPedido(ItemPedido itemPedido, Integer idPedido) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			String query = "INSERT INTO ItemPedido(quantidade, idPedido, idItem) VALUES(?, ?, ?)";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, itemPedido.getQtd());
			state.setInt(2, idPedido);
			state.setInt(3, itemPedido.getItem().getIdItem());
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}
