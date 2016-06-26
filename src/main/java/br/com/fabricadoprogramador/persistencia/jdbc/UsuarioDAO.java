package br.com.fabricadoprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadoprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnetion();
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome , login, senha) values(?,?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setString(1,usu.getNome());//substituindo o ?
				preparador.setString(2,usu.getLogin());
				preparador.setString(3,usu.getSenha());
				//executando o comando sql no banco
				preparador.execute();
				
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alterar(Usuario usu) {
		String sql = "update usuario set nome = ?,login = ?,senha = ? where id = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setString(1,usu.getNome());//substituindo o ?
				preparador.setString(2,usu.getLogin());
				preparador.setString(3,usu.getSenha());
				preparador.setInt(4,usu.getId());
				//executando o comando sql no banco
				preparador.execute();
				
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setInt(1,usu.getId());
				//executando o comando sql no banco
				preparador.execute();
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		public void salvar(Usuario usuario){
			if(usuario.getId()!= null){
				alterar(usuario);
			}else{
				cadastrar(usuario);
			}
			
		}
		/**
		 * busca de um registro no banco de dados pelo numero do id do usuario
		 * @param id é um inteiro que representa o numero do id do usuario a ser buscado
		 * @return um objeto usuario quando encontra ou null quando não encontra
		 */
		public Usuario buscarPorId(Integer id){
			String sql = " Select * from usuario where id = ?";
	
			try (PreparedStatement preparador = con.prepareStatement(sql)){
				preparador.setInt(1, id);
				ResultSet resultado = preparador.executeQuery();
				if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * realiza a busca de todos os registros da tabela de usuarios 
		 * @return uma lista de objetos Usuario contendo 0 elementos quando tiver
		 * registro ou n elementos quando tiver resultado
		 */
		public List<Usuario> buscarTodos(){
			String sql = " Select * from usuario ";
			List<Usuario> lista = new ArrayList<Usuario>();
			try (PreparedStatement preparador = con.prepareStatement(sql)){
				
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				//adicionando usuario na lista
				lista.add(usuario);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return lista;
		}
	}

