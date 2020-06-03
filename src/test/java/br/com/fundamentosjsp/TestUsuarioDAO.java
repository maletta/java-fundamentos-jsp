package br.com.fundamentosjsp;
import br.com.fundamentosjsp.model.*;
import br.com.fundamentosjsp.dao.*;
public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		//Criando usuario
		Usuario usu = new Usuario();
		usu.setNome("Maletta");
		usu.setLogin("maletta");
		usu.setSenha("123");
		
		// Cadastrando
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

	}

}
