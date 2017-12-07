package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Cargo;

public class RepositorioCargo {

	private static RepositorioCargo instance = null;
	private Connection conn = null;

	public static RepositorioCargo getInstance() {
		if (instance == null) {
			instance = new RepositorioCargo();
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

	public List<Cargo> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Cargo> cargos = new ArrayList<Cargo>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Cargo ORDER BY nome";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				cargos.add(new Cargo(result.getInt("idCargo"), result.getString("nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return cargos;
	}

	public Cargo findyById(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Cargo cargo = null;
		try {
			String query = "SELECT * FROM Cargo WHERE idCargo = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				cargo = new Cargo(result.getInt("idCargo"), result.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return cargo;
	}

}
