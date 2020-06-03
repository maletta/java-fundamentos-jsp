package br.com.fundamentosjsp;

import br.com.fundamentosjsp.model.*;

import java.util.Iterator;
import java.util.List;

import br.com.fundamentosjsp.dao.*;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// testCadastrar("jão", "jão", "123");
		// testAlterar(2,"mano", "mano", "123");
		// testExcluir(2);
		// testSalvar();
		// testBuscarPorId(1);
		testBuscarTodos();
	}

	public static void testCadastrar(String nome, String login, String senha) {
		// Criando usuario
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		// Cadastrando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usuario);
	}
	
	public static void testAlterar(Integer id, String nome, String login, String senha) {
		// Criando usuario
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		// Alterando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usuario);
	}
	
	public static void testExcluir(Integer id) {
		// Criando usuario
		Usuario usuario = new Usuario();
		usuario.setId(id);

		// Excluindo
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usuario);
	}

	public static void testSalvar() {
		Usuario usuario = new Usuario();
		//usuario.setId(1);
		usuario.setNome("teste");
		usuario.setLogin("teste");
		usuario.setSenha("senha");
		// Salvando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
	}
	
	private static void testBuscarPorId(Integer id) {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.buscarPorId(id);
		System.out.println(usuario);
	}
	
	private static void testBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> lista = usuDAO.buscarTodos();
		for (Usuario u: lista) {
			System.out.println(u);
		}
	}


}
