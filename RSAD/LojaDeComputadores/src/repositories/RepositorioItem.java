package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Computador;
import model.HD;
import model.ItemPedido;
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
			String query = "SELECT * FROM HD h, Item i WHERE i.idHD = h.idHD AND h.idHD = ?";
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
			String query = "SELECT * FROM Memoria m, Item i, TipoMemoria t WHERE i.idMemoria = m.idMemoria AND t.idTipoMemoria = m.idTipoMemoria AND m.idMemoria = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				memoria = new Memoria(result.getInt("m.idMemoria"), result.getDouble("i.preco"),
						result.getString("m.fabricante"), result.getString("m.mdelo"), result.getString("m.capacidade"),
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
			String query = "SELECT * FROM Processador p, Item i, Soquete s WHERE i.idProcessador = p.idProcessador AND s.idSoquete = p.idSoquete AND p.idProcessador = ?";
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
			String query = "SELECT * FROM PlacaMae p, Soquete s, Item i WHERE p.idPlacaMae = ? AND p.idPlacaMae = i.idPlacaMae AND s.idSoquete = p.idSoquete";
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
			String query = "SELECT * FROM PlacaMae_aceita_TipoMemoria pat, TipoMemoria tm WHERE pat.idPlacaMae = ? AND tm.idTipoMemoria = pat.idTipoMemoria";
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
			String query = "SELECT * FROM Memoria m, TipoMemoria t, Item i WHERE t.idTipoMemoria = m.idTipoMemoria AND m.idMemoria = i.idMemoria";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				memorias.add(new Memoria(result.getInt("m.idMemoria"), result.getDouble("i.preco"),
						result.getString("m.fabricante"), result.getString("m.mdelo"), result.getString("m.capacidade"),
						new TipoMemoria(result.getInt("t.idTipoMemoria"), result.getString("t.nome"))));
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
			String query = "SELECT * FROM HD h, Item i WHERE h.idHD = i.idHD";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				hds.add(new HD(result.getInt("h.idHD"), result.getDouble("i.preco"), result.getString("h.fabricante"),
						result.getString("h.modelo"), result.getString("h.capacidade"),
						result.getString("h.tecnologia")));
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
			String query = "SELECT * FROM PlacaMae p, Soquete s, Item i WHERE p.idPlacaMae = i.idPlacaMae AND s.idSoquete = p.idSoquete";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				Integer idPlaca = result.getInt("p.idPlacaMae");
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
			String query = "SELECT * FROM Processador p, Item i, Soquete s WHERE i.idProcessador = p.idProcessador AND s.idSoquete = p.idSoquete";
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

	public List<Processador> getProcessadoresCompativeis(Integer idPlaca) {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Processador> processadores = new ArrayList<Processador>();
		try {
			String query = "SELECT * FROM Processador p, Item i, Soquete s, PlacaMae pm WHERE i.idProcessador = p.idProcessador AND s.idSoquete = p.idSoquete  AND pm.idSoquete = p.idSoquete  AND pm.idPlacaMae = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, idPlaca);
			ResultSet result = state.executeQuery();
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

	public List<Memoria> getMemoriasCompativeis(Integer idPlaca) {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Memoria> memorias = new ArrayList<Memoria>();
		try {
			String query = "SELECT * FROM Memoria m, TipoMemoria t, Item i, PlacaMae_aceita_TipoMemoria pat"
					+ " WHERE t.idTipoMemoria = m.idTipoMemoria AND m.idMemoria = i.idMemoria AND pat.idPlacaMae = ? AND pat.idTipoMemoria = m.idTipoMemoria";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, idPlaca);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				memorias.add(new Memoria(result.getInt("m.idMemoria"), result.getDouble("i.preco"),
						result.getString("m.fabricante"), result.getString("m.mdelo"), result.getString("m.capacidade"),
						new TipoMemoria(result.getInt("t.idTipoMemoria"), result.getString("t.nome"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return memorias;
	}

	public Computador inserirComputador(Computador comp) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			String query = "INSERT INTO Computador(idPlacaMae, idProcessador) VALUES(?, ?)";
			PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			state.setInt(1, comp.getPlaca().getId());
			state.setInt(2, comp.getProcessador().getId());
			state.executeUpdate();
			ResultSet result = state.getGeneratedKeys();
			if (result.next()) {
				Integer novoId = result.getInt(1);
				comp.setIdComputador(novoId);
				for (Memoria memoria : comp.getMemorias()) {
					query = "INSERT INTO Computador_tem_Memoria(idComputador, idMemoria) VALUES(?, ?)";
					state = conn.prepareStatement(query);
					state.setInt(1, novoId);
					state.setInt(2, memoria.getId());
					state.executeUpdate();
				}
				for (HD hd : comp.getHds()) {
					query = "INSERT INTO Computador_tem_Hd(idComputador, idHD) VALUES(?, ?)";
					state = conn.prepareStatement(query);
					state.setInt(1, novoId);
					state.setInt(2, hd.getId());
					state.executeUpdate();
				}
				query = "INSERT INTO Item(preco, idComputador) VALUES(?, ?)";
				state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				state.setDouble(1, comp.getPreco());
				state.setInt(2, novoId);
				state.executeUpdate();
				ResultSet rs = state.getGeneratedKeys();
				if (rs.next()) {
					comp.setIdItem(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return comp;
	}

	public void inserirItemPedido(ItemPedido itemPedido) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			String query = "INSERT INTO ItemPedido(quantidade, idPedido, idItem) VALUES(?, ?, ?)";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, itemPedido.getQtd());
			// TODO pegar idPedido
			state.setInt(3, itemPedido.getItem().getIdItem());
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}