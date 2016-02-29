import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame{
	static String usern;
	private JFrame frame;
	private JTextField un;
	private JTextField ps;
	private JButton btnNewButton;
	private JButton btnSignUp;

	public Login() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		un = new JTextField();
		un.setBounds(273, 56, 86, 20);
		frame.getContentPane().add(un);
		un.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(87, 59, 68, 14);
		frame.getContentPane().add(lblNewLabel);
		
		ps = new JTextField();
		ps.setBounds(273, 107, 86, 20);
		frame.getContentPane().add(ps);
		ps.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(87, 110, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("Login");
	
		btnNewButton.setBounds(166, 151, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Dont have an account?");
		lblNewLabel_2.setBounds(157, 185, 111, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnSignUp = new JButton("Signup");
		
		btnSignUp.setBounds(166, 210, 89, 23);
		frame.getContentPane().add(btnSignUp);
		frame.setVisible(true);
		
		
	}
	public JButton getButton_Login()
	{
        return btnNewButton;
    }
	public JButton getButton_SU()
	{
        return btnSignUp;
    }

	public String getJLabel1()
	{
        return un.getText();
    }
	public String getJLabel2()
	{
        return ps.getText();
    }
	
}
