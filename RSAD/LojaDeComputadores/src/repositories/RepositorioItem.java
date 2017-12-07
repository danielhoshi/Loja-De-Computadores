package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.HD;
import model.Memoria;
import model.PlacaMae;
import model.Processador;
import model.Soquete;
import model.TipoMemoria;

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

	public HD getHd(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		HD hd = null;
		try {
			String query = "SELECT * FROM hd h, item i WHERE i.idHD = h.idHD AND h.idHD = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				hd = new HD(result.getInt("h.idHD"), result.getDouble("i.preco"), result.getString("h.fabricante"),
						result.getString("h.modelo"), result.getString("h.capacidade"),
						result.getString("h.tecnologia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return hd;
	}
	
	public Memoria getMemoria(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Memoria memoria = null;
		try {
			String query = "SELECT * FROM memoria m, item i, tipomemoria t WHERE i.idMemoria = m.idMemoria AND t.idTipoMemoria = m.idTipoMemoria AND m.idMemoria = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				memoria = new Memoria(result.getInt("m.idMemoria"), result.getDouble("i.preco"),
						result.getString("m.fabricante"), result.getString("m.mdelo"),
						result.getString("m.capacidade"),
						new TipoMemoria(result.getInt("t.idTipoMemoria"), result.getString("t.nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return memoria;
	}

	public Processador getProcessador(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Processador processador = null;
		try {
			String query = "SELECT * FROM processador p, item i, soquete s WHERE i.idProcessador = p.idProcessador AND s.idSoquete = p.idSoquete AND p.idProcessador = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				processador = new Processador(result.getInt("p.idProcessador"), result.getDouble("i.preco"),
						result.getString("p.fabricante"), result.getString("p.modelo"),
						result.getString("p.frequencia"),
						new Soquete(result.getInt("s.idSoquete"), result.getString("s.nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return processador;
	}

	public PlacaMae getPlaca(Integer id) {
		List<TipoMemoria> tipos = getTiposMemoria(id);
		conn = ConexaoMySQL.getConexaoMySQL();
		PlacaMae placa = null;
		try {
			String query = "SELECT * FROM placamae p, soquete s, item i WHERE p.idPlacaMae = ? AND p.idPlacaMae = i.idPlacaMae AND s.idSoquete = p.idSoquete";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				placa = new PlacaMae(result.getInt("p.idPlacaMae"), result.getDouble("i.preco"), tipos,
						result.getString("p.fabricante"), result.getString("p.modelo"),
						result.getInt("p.numeroDePentes"),
						new Soquete(result.getInt("s.idSoquete"), result.getString("s.nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return placa;
	}

	public List<TipoMemoria> getTiposMemoria(Integer idPlaca) {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<TipoMemoria> lista = new ArrayList<TipoMemoria>();
		try {
			String query = "SELECT * FROM placamae_aceita_tipomemoria pat, tipomemoria tm WHERE pat.idPlacaMae = ? AND tm.idTipoMemoria = pat.idTipoMemoria";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, idPlaca);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				lista.add(new TipoMemoria(result.getInt("tm.idTipoMemoria"), result.getString("tm.nome")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return lista;
	}

	public List<Memoria> getMemorias() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Memoria> memorias = new ArrayList<Memoria>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM memoria m, tipomemoria t, item i WHERE t.idTipoMemoria = m.idTipoMemoria AND m.idMemoria = i.idMemoria";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				memorias.add(new Memoria(result.getInt("m.idMemoria"), result.getDouble("i.preco"), 
						result.getString("m.fabricante"), result.getString("m.mdelo"), 
						result.getString("m.capacidade"), new TipoMemoria(result.getInt("t.idTipoMemoria"), result.getString("t.nome"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return memorias;
	}

	public List<HD> getHds() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<HD> hds = new ArrayList<HD>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM hd h, item i WHERE h.idHD = i.idHD";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				hds.add(new HD(result.getInt("h.idHD"), result.getDouble("i.preco"), 
						result.getString("h.fabricante"), result.getString("h.modelo"), 
						result.getString("h.capacidade"), result.getString("h.tecnologia")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return hds;
	}

	public List<PlacaMae> getPlacasMae() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<PlacaMae> placas = new ArrayList<PlacaMae>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM placamae p, soquete s, item i WHERE p.idPlacaMae = i.idPlacaMae AND s.idSoquete = p.idSoquete";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				Integer idPlaca= result.getInt("p.idPlacaMae");
				List<TipoMemoria> tipos = getTiposMemoria(idPlaca);
				placas.add(new PlacaMae(result.getInt("p.idPlacaMae"), result.getDouble("i.preco"), tipos,
						result.getString("p.fabricante"), result.getString("p.modelo"),
						result.getInt("p.numeroDePentes"),
						new Soquete(result.getInt("s.idSoquete"), result.getString("s.nome"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return placas;
	}

	public List<Processador> getProcessadores() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Processador> processadores = new ArrayList<Processador>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM processador p, item i, soquete s WHERE i.idProcessador = p.idProcessador AND s.idSoquete = p.idSoquete";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				processadores.add(new Processador(result.getInt("p.idProcessador"), result.getDouble("i.preco"),
						result.getString("p.fabricante"), result.getString("p.modelo"),
						result.getString("p.frequencia"),
						new Soquete(result.getInt("s.idSoquete"), result.getString("s.nome"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return processadores;
	}
}