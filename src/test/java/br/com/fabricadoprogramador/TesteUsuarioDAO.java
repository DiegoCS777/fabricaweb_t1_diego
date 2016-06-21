package br.com.fabricadoprogramador;

import br.com.fabricadoprogramador.persistencia.entidade.Usuario;
import br.com.fabricadoprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		testeExcluir();
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
}
