import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


public class Album extends JFrame {

	private JPanel contentPane,panel;
	File targetFile,f1;
	BufferedImage targetImg;
	static String imgpath;
	private static final int basesize=175;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Album frame = new Album();
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
	public Album(String str) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(21, 11, 403, 209);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		f1=new File(str);
		setTarget(f1);
		
		
		
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
        panel.add(new JLabel(new ImageIcon(targetImg)));
        setVisible(true);
    }
}
