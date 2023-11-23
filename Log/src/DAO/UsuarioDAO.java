package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.Usuario;

public class UsuarioDAO {

	Connection conn;
	
	public ResultSet autenticacaoUsuario(Usuario objusuariodto) {
		conn = new ConexaoDB().conectaDB();
		
		try {
			String sql = "select * from usuario where nome = ? and senha = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getNome());
			pstm.setString(2, objusuariodto.getSenha());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + e);
			return null;
		}
	}
	
}
