package br.com.fundamentosjsp;

import br.com.fundamentosjsp.model.*;
import br.com.fundamentosjsp.dao.*;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// testCadastrar("jão", "jão", "123");
		// testAlterar(2,"mano", "mano", "123");
		testExcluir(2);
	}

	public static void testCadastrar(String nome, String login, String senha) {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		// Cadastrando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
	}
	
	public static void testAlterar(Integer id, String nome, String login, String senha) {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setId(id);
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		// Alterando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
	}
	
	public static void testExcluir(Integer id) {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setId(id);

		// Excluindo
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
	}


}
