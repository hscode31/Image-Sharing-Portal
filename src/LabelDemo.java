import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class  LabelDemo extends JFrame
{
    ImageIcon imageIcon;
    MyJLabel jLabel ;
    public LabelDemo (ImageIcon ib)
    {
        super("JLabel Demo");
        imageIcon=ib;
        createAndShowGUI(imageIcon);
        this.setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 1000);
    }
    public void createAndShowGUI(ImageIcon imageIcon)
    {
        jLabel = new MyJLabel(imageIcon);
        getContentPane().add(jLabel);
        addWindowListener( new WindowAdapter()
        {
            public void windowResized(WindowEvent evt)
            {
                jLabel.repaint();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jLabel.repaint();
    }
    /*public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                LabelDemo demo = new LabelDemo();
                demo.createAndShowGUI();
            }
        });
    }*/
}
class MyJLabel extends JLabel
{
    ImageIcon imageIcon;
    public MyJLabel(ImageIcon icon)
    {
        super();
        this.imageIcon = icon;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
    }
}