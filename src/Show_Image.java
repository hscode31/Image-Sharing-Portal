import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;


public class Show_Image extends JFrame {

	//protected static final ResultSet ResultSet = null;
	private JPanel contentPane;
	File targetFile;
	BufferedImage targetImg;
	static ResultSet rd=null;

	JButton j[]=new JButton[2];
	JPanel j1;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Show_Image frame = new Show_Image(rd);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Show_Image(ResultSet rs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 2));
		contentPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		//setContentPane(contentPane);
		int i=0;
		try{
				while(rs.next())
				{
				System.out.println("00000");
				j[i]=new JButton();
				//j1[i].setBounds(0,10,100,10);
				contentPane.add(j[i]);
				String str=rs.getString("img");
				System.out.println(str);
				File f=new File(str);
				setTarget(f,i);
				i++;
				}
		}catch(Exception e3)
		{
		
		}
	}
		 public void setTarget(File reference,int i)
		    {
		        try {
		            targetFile = reference;
		            System.out.println(targetFile);
		            targetImg = rescale(ImageIO.read(reference));
		        } catch (IOException ex) {
		        }

				//panel_2.setLayout(new GridLayout(1, 1));
		       // j[i]=new JLabel(new ImageIcon(targetImg));
		        //j1[i].add(j[i]);
		        System.out.println(targetFile);
		        
	}
		 public BufferedImage rescale(BufferedImage originalImage)
		    {
		        BufferedImage resizedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		        Graphics2D g = resizedImage.createGraphics();
		        g.drawImage(originalImage, 0, 0, 10, 10, null);
		        g.dispose();
		        return resizedImage;
		    }

}
