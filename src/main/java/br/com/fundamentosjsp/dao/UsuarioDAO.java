package br.com.fundamentosjsp.dao;

import br.com.fundamentosjsp.model.Usuario;
import br.com.fundamentosjsp.dao.*;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

	public void cadastrar(Usuario usuario) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "insert into usuarios (nome, login, senha) values (?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.executeUpdate();

			System.out.println("Cadastrado com sucesso");

			preparador.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usuario) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "update usuarios set nome=?, login=?, senha=?  where id = ?";

		// try automaticamente fecha o PreparedStatement que implementa a classe
		// AutoCloseable
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			preparador.executeUpdate();

			System.out.println("Alterado com sucesso");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Usuario usuario) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "delete from usuarios where id = ?";

		// try automaticamente fecha o PreparedStatement que implementa a classe
		// AutoCloseable
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setInt(1, usuario.getId());
			preparador.executeUpdate();

			System.out.println("Excluído com sucesso");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}

	/*
	 * Busca registro no banco pelo id do usuário
	 * 
	 * @param id é um inteiro que representa o número do id do usuário a ser buscado
	 * 
	 * @return Um objeto Usuario quando o encontra ou null quando não encontra
	 * registro
	 */

	public Usuario buscarPorId(Integer id) {

		Usuario usuario = new Usuario();
		Connection con = ConnectionFactory.getConnection();
		String sql = "select nome, login, senha from usuarios where id = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet result = preparador.executeQuery();

			while (result.next()) {
				usuario.setId(id);
				usuario.setLogin(result.getString("login"));
				usuario.setNome(result.getString("nome"));
				usuario.setSenha(result.getString("senha"));
			}

			result.close();
			preparador.close();
			con.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return usuario;
	}

	/*
	 * Busca todos os registros no banco da tabela usuário
	 * 
	 * 
	 * @return Uma lista de objetos Usuario contendo 0 elementos quando não encontrar registros ou
	 * n elementos quando encontrar registros
	 */
	public List<Usuario> buscarTodos() {

		List<Usuario> lista = new ArrayList<Usuario>();
		Connection con = ConnectionFactory.getConnection();
		String sql = "select id,nome, login, senha from usuarios";
		try {
			Statement preparador = con.createStatement();
			ResultSet result = preparador.executeQuery(sql);

			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(result.getInt("id"));
				usuario.setLogin(result.getString("login"));
				usuario.setNome(result.getString("nome"));
				usuario.setSenha(result.getString("senha"));
				lista.add(usuario);
			}

			result.close();
			preparador.close();
			con.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return lista;
	}
}
