package br.ufpr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/ruSql", "root", "root");
		} catch(ClassNotFoundException erro){
			JOptionPane.showMessageDialog(null,"Driver JDBC-MySQL não encontrado!!");
			System.exit(0);
			erro.printStackTrace();
			throw new RuntimeException(erro);
		}
		catch(SQLException erro){
			JOptionPane.showMessageDialog(null,"Problema na conexão com a fonte de dados");
			System.exit(0);
			erro.printStackTrace();
			throw new RuntimeException(erro);
		}
	}
}
