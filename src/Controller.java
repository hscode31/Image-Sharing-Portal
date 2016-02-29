import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Controller {

    private Login view;
    private Signup view1;
    private Myaccount view2;
    private ActionListener actionListener1;
    private ActionListener actionListener2;
    private ActionListener actionListener3;
    private ActionListener actionListener4;
    private ActionListener actionListener5;
    Connection connect;
    
    public Controller(Login view){
        this.view = view;
        connect=null;
                          
    }
    public Controller(Signup view1){
        this.view1 = view1;
        connect=null;
                          
    }
    public Controller(Myaccount view2){
        this.view2 = view2;
        connect=null;
                          
    }
    
    public void contol(){  
    	connect=DBConnect.dbConn();
        actionListener1 = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
            	  try 
					{
						String query="Select * from project.user where uname=?  and pwd=? ";
						PreparedStatement pst=connect.prepareStatement(query);
						pst.setString(1,view.getJLabel1());
						pst.setString(2, view.getJLabel2());
						ResultSet rs=pst.executeQuery();
						int count=0;
						if(rs.next())
						{
							String usern=view.getJLabel1();
							count++;
							JOptionPane.showMessageDialog(null, "Logged in !");
							Myaccount up=new Myaccount();
							up.setVisible(true);
							Controller controller=new Controller(up);
							controller.contol();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Username or Password incorrect. Try again or First Signup!");
							
						}
						rs.close();
						pst.close();
					
						
					}
					catch(SQLException f)
					{
						JOptionPane.showMessageDialog(null,"exception generated");
					}
			}
        };
        actionListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                  
				 SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {  
			            	try{
			            		Signup sign=new Signup();
			    				Controller2 controller2=new Controller2(sign);
			    				controller2.contol();
			            	}catch(Exception e)
			            	{
			            		
			            	}
			            }
			        });  
            }
      };
     
    actionListener4 = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {                  
				Upload up=new Upload();
				up.setVisible(true);
			}
  };
  actionListener5 = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {                  
    	  Image_Search up=new Image_Search();
			up.setVisible(true);
      }
};
      	view.getButton_SU().addActionListener(actionListener2);  
        view.getButton_Login().addActionListener(actionListener1);
        view2.getButton_Upload().addActionListener(actionListener4);
        view2.getButton_Search().addActionListener(actionListener5);
    }
        
}