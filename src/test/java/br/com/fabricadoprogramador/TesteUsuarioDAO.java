package br.com.fabricadoprogramador;

import java.util.List;

import br.com.fabricadoprogramador.persistencia.entidade.Usuario;
import br.com.fabricadoprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeSalvar();
		//testeExcluir();
		//testeBuscarPorId();
		testeBuscarTodos();
	}
	private static void testeBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(6);
		System.out.println(usuario);
		
	}
	private static void testeBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		for(Usuario u: lista){
		System.out.println(u);
		}		
	}
	public static void testeExcluir(){
		Usuario usu = new Usuario();
		usu.setId(4);
	
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Usuario excluido!");
	}
	public static void testeAlterar(){
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("Roberto");
		usu.setLogin("rrr");
		usu.setSenha("4444");
		//Cadastrando usuario no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Cadastro Alterado!");
	}
	public static void testeCadastrar(){
			Usuario usu = new Usuario();
			usu.setNome("Thiago");
			usu.setLogin("ttt");
			usu.setSenha("2222");
			//Cadastrando usuario no banco de dados
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.cadastrar(usu);
			
			System.out.println("Cadastro Efetuado!");
	}
	public static void testeSalvar(){
		Usuario usuario = new Usuario();
		//usuario.setId(1);
		usuario.setNome("Carlos");
		usuario.setLogin("car");
		usuario.setSenha("1975");
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		System.out.println("Salvo com sucesso");
		
	}
	
}
