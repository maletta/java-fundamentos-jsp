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

}
