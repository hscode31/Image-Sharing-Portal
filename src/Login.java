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


public class Login {
	static String usern;

	private JFrame frame;
	private JTextField un;
	private JTextField ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connect=null;
	public Login() {
		initialize();
		connect=DBConnect.dbConn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try 
					{
						String query="Select * from portal.user where username=?  and password=? ";
						PreparedStatement pst=connect.prepareStatement(query);
						pst.setString(1, un.getText());
						pst.setString(2, ps.getText());
						ResultSet rs=pst.executeQuery();
						int count=0;
						if(rs.next())
						{
						
							usern=un.getText();
							JOptionPane.showMessageDialog(null, "Logged in !");
							Myaccount my=new Myaccount();
							my.setVisible(true);
							
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "Username or Password incorrect. Try again !");
							
						}
						rs.close();
						pst.close();
					
						
					}
					catch(Exception f)
					{
						JOptionPane.showMessageDialog(null, e);
					}
			}
		});
		btnNewButton.setBounds(166, 151, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Dont have an account?");
		lblNewLabel_2.setBounds(157, 185, 111, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnSignUp = new JButton("Signup");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup sign=new Signup();
				sign.setVisible(true);
			}
		});
		btnSignUp.setBounds(166, 210, 89, 23);
		frame.getContentPane().add(btnSignUp);
		
		
	}

}
