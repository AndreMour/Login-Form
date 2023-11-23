package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDB {
	
	public Connection conectaDB() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/usuarios?user=root&password=Andre4584@";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Conexao" + e.getMessage());
		}
		
		return conn;
	}
	
}
