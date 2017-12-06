package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.ConexaoMySQL;
import model.Cargo;
import model.HD;
import model.Item;
import model.Memoria;
import model.PlacaMae;
import model.Processador;
import model.Soquete;
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioGerente;
import model.UsuarioVendedor;

public class RepositorioItem {

	private static RepositorioItem instance = null;
	private Connection conn = null;

	public static RepositorioItem getInstance() {
		if (instance == null) {
			instance = new RepositorioItem();
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
	public Processador getProcessador(Integer id) {
		Connection conn = ConexaoMySQL.getConexaoMySQL();
		Processador processador = null;
		try {
			String query = "SELECT * FROM Processador p,  WHERE idProcessador = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				Integer id, Double preco, String fabricante, String modelo, String frequencia, Soquete soquete
					processador = new Processador(result.getInt("idProcessador"), result.getDouble(""),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return usuario;
	}

	public List<Memoria> getMemorias() {
		return null;
	}

	public List<HD> getHds() {
		return null;
	}

	public List<PlacaMae> getPlacasMae() {
		return null;
	}

	public List<Processador> getProcessadores() {
		return null;
	}
}