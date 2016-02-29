import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Myaccount extends JFrame {

	private JPanel contentPane;
	private JButton btnUpload;
	private JButton btnSearch;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myaccount frame = new Myaccount();
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
	public Myaccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setBounds(10, 11, 137, 14);
		contentPane.add(lblWelcome);
		
		btnUpload = new JButton("Upload");
		
		btnUpload.setBounds(175, 64, 89, 23);
		contentPane.add(btnUpload);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(175, 98, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(175, 166, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnMyImages = new JButton("My Images");
		btnMyImages.setBounds(175, 132, 89, 23);
		contentPane.add(btnMyImages);
		setVisible(true);
	}
	public JButton getButton_Upload()
	{
        return btnUpload;
    }
	public JButton getButton_Search()
	{
        return btnSearch;
    }
}
