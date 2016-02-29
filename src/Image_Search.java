import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;


public class Image_Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	PreparedStatement pst=null,pst1=null,pst2=null;
	ResultSet rs=null,rs2=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Image_Search frame = new Image_Search();
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
	Connection connect=null;
	public Image_Search() {
		connect=DBConnect.dbConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JComboBox comboBox = new JComboBox(Upload.tags);
		comboBox.setBounds(313, 57, 97, 20);
		contentPane.add(comboBox);
		
		JButton Button1 = new JButton("Tags");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Button1.setBounds(43, 56, 89, 23);
		contentPane.add(Button1);
		
		textField = new JTextField();
		textField.setBounds(313, 127, 97, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton Button2 = new JButton("UserName");
		Button2.setBounds(43, 126, 89, 23);
		contentPane.add(Button2);
		Button1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        String tag1 =(String)comboBox.getSelectedItem();
		        System.out.println(tag1);
		        try{
		        	if(connect!=null)
		        	{
		            	System.out.println("00000");
		        	}
		        	String q="select * from project.upload_photo where tag="+"'"+tag1+"'";
		        	String j="reorg table project.upload_photo";
		        	String l="update project.upload_photo set views = views + 1 where tag="+"'"+tag1+"'";
		        	System.out.println(q);
		        	pst= connect.prepareStatement(q);
		        	//pst2= connect.prepareStatement(j);
		        	pst1= connect.prepareStatement(l);
		          	System.out.println("12345");
		          //	pst.setString(1, tag1);
		        	
		        //	pst2.executeQuery();
		        	pst1.executeUpdate();
		        	rs=pst.executeQuery();
		        	System.out.println("dgfhj");
		        	/*if(rs.next())
		        	{
		        		JOptionPane.showMessageDialog(null, "Logged in !");
		        	}*/
		        	//rs.next();
		        //	String st=rs.getString("img");
		        	//System.out.println(st);
		        	show_image3 ig=new show_image3(rs);
		        	ig.setVisible(true);
		        }catch(Exception e1)
		        {
		        	
		        }
		        
		      }
		    });
	}
}
