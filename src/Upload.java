import java.awt.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Upload extends JFrame {
	static final String[] tags = {"Nature","technology","Vacation", "festival", "Abstract Art", "Food and Drink", "Concept and ideas", "Friends and family", "Personal art"};
	public JPanel panel, panel_1,panel_2;
	File targetFile;
	BufferedImage targetImg;
	private static final int basesize=175;
	private static final String basepath="C:/Users";
	private JPanel contentPane;
	static long sizeimg;
	static String imgpath;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upload frame = new Upload();
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
	public Upload() {
		connect=DBConnect.dbConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		panel=new JPanel();
		panel_1=new JPanel();
		panel_2 = new JPanel();
		panel_2.setBounds(64, 63, 303, 187);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(panel_2);
		
		
		
		JLabel lblQ = new JLabel("Welcome, "+ Login.usern);
		lblQ.setBounds(10, 11, 78, 14);
		contentPane.add(lblQ);
		
		JButton btnBrowseAndUpload = new JButton("Browse");
		btnBrowseAndUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browseButtonActionPerformed(e);	
			}
			public  BufferedImage rescale(BufferedImage originalImage)
		    {
		        BufferedImage resizedImage = new BufferedImage(basesize,basesize, BufferedImage.TYPE_INT_RGB);
		        Graphics2D g = resizedImage.createGraphics();
		        g.drawImage(originalImage, 0, 0, basesize,basesize, null);
		        g.dispose();
		        System.out.println("golubbnf");
		        return resizedImage;
		    }
			 public void setTarget(File reference)
			    {
			        try {
			            targetFile = reference;
			            System.out.println(targetFile);
			            imgpath=targetFile.getPath();
			            targetImg = rescale(ImageIO.read(reference));
			        } catch (IOException ex) {
			        }
			        panel_2.add(new JLabel(new ImageIcon(targetImg)));
			        setVisible(true);
			    }
			    public void browseButtonActionPerformed(ActionEvent evt) {
			        JFileChooser fc = new JFileChooser(basepath);
			        int res = fc.showOpenDialog(null);
			        try {
			            if (res == JFileChooser.APPROVE_OPTION) {
			                File file = fc.getSelectedFile();
			                setTarget(file);
			            } 
			            else {
			                JOptionPane.showMessageDialog(null,
			                        "You must select one image to be the reference.", "Aborting...",
			                        JOptionPane.WARNING_MESSAGE);
			            }
			        } catch (Exception iOException) {
			        }

			    }
		});
		btnBrowseAndUpload.setBounds(64, 36, 67, 23);
		contentPane.add(btnBrowseAndUpload);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(135, 36, 67, 23); 
		contentPane.add(btnNewButton);
		
		final JComboBox comboBox = new JComboBox(tags);
		comboBox.setBounds(212, 37, 78, 20);
		contentPane.add(comboBox);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(300, 36, 67, 23);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					String curtag = (String) comboBox.getSelectedItem();
					String q="insert into project.upload_photo ( photo_date,tag,img,likes,dwd,uname) values (?, ?, ?, ?, ?,?) ";
					//String l="create trigger inc_tag after insert on project.upload_photo for each row mode db2sql update project.tags set count=count+1 where tag="+"'"+"curtag"+"'";
					//PreparedStatement pst1=connect.prepareStatement(l);
					//pst1.execute();
					PreparedStatement pst=connect.prepareStatement(q);
					//pst.setLong(1, sizeimg);
					pst.setDate(1, new java.sql.Date((new Date(System.currentTimeMillis())).getTime()));
					pst.setString(2, curtag);
					pst.setString(3, imgpath);
					pst.setInt(4, 0);
					pst.setInt(5, 0);
					pst.setString(6, Login.usern);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Entered");
					pst.close();
					
				}
				
				catch(Exception f)
				{
					f.printStackTrace();
				}

			}
			
			
		});
		setVisible(true);
	}
}
