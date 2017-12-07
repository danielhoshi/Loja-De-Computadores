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
import model.TipoUsuario;
import model.Usuario;
import model.UsuarioGerente;
import model.UsuarioVendedor;

public class RepositorioUsuario {

	private static RepositorioUsuario instance = null;
	private Connection conn = null;

	public static RepositorioUsuario getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuario();
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

	public List<Usuario> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Usuario u, Cargo c WHERE c.idCargo = u.idCargo ORDER BY u.nome";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				if (result.getInt("idTipoUsuario") == TipoUsuario.GERENTE.getId()) {
					usuarios.add(new UsuarioGerente(result.getInt("u.idUsuario"), result.getString("u.login"),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome"))));
				} else {
					usuarios.add(new UsuarioVendedor(result.getInt("u.idUsuario"), result.getString("u.login"),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome"))));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return usuarios;
	}

	public Usuario findByID(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Usuario usuario = null;
		try {
			String query = "SELECT * FROM Usuario u, Cargo c WHERE c.idCargo = u.idCargo AND u.idUsuario = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				if (result.getInt("idTipoUsuario") == TipoUsuario.GERENTE.getId()) {
					usuario = new UsuarioGerente(result.getInt("u.idUsuario"), result.getString("u.login"),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome")));
				} else {
					usuario = new UsuarioVendedor(result.getInt("u.idUsuario"), result.getString("u.login"),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return usuario;
	}

	public Integer inserir(Usuario usuario) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Integer novoId = null;
		try {
			String query = "INSERT INTO Usuario(nome, login, senha, cpf, idTipoUsuario, idCargo) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			state.setString(1, usuario.getNome());
			state.setString(2, usuario.getLogin());
			state.setString(3, usuario.getSenha());
			state.setString(4, usuario.getCpf());
			state.setInt(5,
					usuario instanceof UsuarioGerente ? TipoUsuario.GERENTE.getId() : TipoUsuario.VENDEDOR.getId());
			state.setInt(6, usuario.getCargo().getId());
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

	public void atualizar(Usuario usuario) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			String query = "UPDATE Usuario SET nome = ?, cpf = ?, login = ?, senha = ?, idTipoUsuario = ?, idCargo = ? WHERE idUsuario = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setString(1, usuario.getNome());
			state.setString(2, usuario.getCpf());
			state.setString(3, usuario.getLogin());
			state.setString(4, usuario.getSenha());
			state.setInt(5,
					usuario instanceof UsuarioGerente ? TipoUsuario.GERENTE.getId() : TipoUsuario.VENDEDOR.getId());
			state.setInt(6, usuario.getCargo().getId());
			state.setInt(7, usuario.getId());
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public void remover(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			String query = "DELETE FROM Usuario WHERE idUsuario = ?";
			PreparedStatement state = conn.prepareStatement(query);
			state.setInt(1, id);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public Usuario pegarPrimeiro() {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Usuario u, Cargo c";
			PreparedStatement state = conn.prepareStatement(query);
			ResultSet result = state.executeQuery();
			while (result.next()) {
				if (result.getInt("idTipoUsuario") == TipoUsuario.GERENTE.getId()) {
					return new UsuarioGerente(result.getInt("u.idUsuario"), result.getString("u.login"),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome")));
				} else {
					return new UsuarioVendedor(result.getInt("u.idUsuario"), result.getString("u.login"),
							result.getString("u.senha"), result.getString("u.nome"), result.getString("u.cpf"),
							new Cargo(result.getInt("c.idcargo"), result.getString("c.nome")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return null;
	}
}
