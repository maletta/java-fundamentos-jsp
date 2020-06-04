package br.com.fundamentosjsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fundamentosjsp.dao.UsuarioDAO;
import br.com.fundamentosjsp.model.Usuario;

//http://localhost:8080/fundamentosjspweb/usuarioController
@WebServlet("/usuarioController")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		System.out.println("Constructor...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init...");
		super.init();
		// útil para fazer algo antes de qualquer requisição ser feita
	}

	@Override
	public void destroy() {
		System.out.println("Destroy...");
		super.destroy();
		// útil para fazer algo antes de finalizar o objeto, tipo encerrar uma conexão
		// com banco de dados
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String nome = req.getParameter("nome"); // obtidos por query string
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usuario = new Usuario();
		if (id != null)
			usuario.setId(Integer.parseInt(id));
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		resp.getWriter().print("sucesso!");// enviar texto como resposta
		System.out.println("Chamou doPost!");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(id));

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);

		resp.getWriter().print("sucesso!");// enviar texto como resposta
		System.out.println("Chamou doDelete!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// diz que a resposta será um html,
		// assim o browser interpreta a tag br
		resp.setContentType("text/html");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();

		for (Usuario u : lista) {
			resp.getWriter().print(u + "<br>");// enviar texto como resposta
		}

		System.out.println("Chamou doGet!");
	}
}
