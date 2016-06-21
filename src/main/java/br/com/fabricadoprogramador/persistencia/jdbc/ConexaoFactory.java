package br.com.fabricadoprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnetion() {
	
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","postgre");
		} catch (SQLException e) {
			//relançando a exception
			throw new RuntimeException(e);
		}
	}

}
