package br.com.fundamentosjsp.dao;

import br.com.fundamentosjsp.model.Usuario;
import br.com.fundamentosjsp.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioDAO {
	
	public void cadastrar(Usuario usu) {
		Connection con  = ConnectionFactory.getConnection();
		String sql = "insert into usuarios (nome, login, senha) values (?,?,?)"; 
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.executeUpdate();
			
			System.out.println("Cadastrado com sucesso");
			
			preparador.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Usuario usu) {
		Connection con  = ConnectionFactory.getConnection();
		String sql = "update usuarios set nome=?, login=?, senha=?  where id = ?"; 
		
		// try automaticamente fecha o PreparedStatement que implementa a classe AutoCloseable
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			preparador.executeUpdate();
			
			System.out.println("Alterado com sucesso");
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void excluir(Usuario usu) {
		Connection con  = ConnectionFactory.getConnection();
		String sql = "delete from usuarios where id = ?"; 
		
		// try automaticamente fecha o PreparedStatement que implementa a classe AutoCloseable
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setInt(1, usu.getId());
			preparador.executeUpdate();
			
			System.out.println("Excluído com sucesso");
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
