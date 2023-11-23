package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.Usuario;
import DAO.UsuarioDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class formLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private final Action action = new SwingAction();
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formLogin frame = new formLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(37, 65, 123, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome de Usuário:");
		lblNewLabel.setBounds(37, 30, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(37, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEntrarSistema = new JButton("ENTRAR");
		
		btnEntrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Logar();
			}});
		
		btnEntrarSistema.setBounds(37, 208, 89, 23);
		contentPane.add(btnEntrarSistema);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(37, 144, 123, 20);
		contentPane.add(txtPassword);
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private void Logar() {
		
		try {
			
			String nome, senha;
			
			nome = txtUser.getText();
			senha = txtPassword.getText();
			
			Usuario objusuariodto = new Usuario();
			objusuariodto.setNome(nome);
			objusuariodto.setSenha(senha);
			
			UsuarioDAO objusuariodao = new UsuarioDAO();
			ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
			
			if (rsusuariodao.next()) { //Chamar tela principal
				formPrincipal objformprincipalview = new formPrincipal();
				objformprincipalview.setVisible(true);
				
				dispose();
			} else { //Usuário e senha incorretos
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválida");
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "formLogin" + erro);
		}
	}
}
