import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Controller2 {

    private Signup view1;
    private ActionListener actionListener1;
    Connection connect=null;
    
    public Controller2(Signup view){
        this.view1 = view1;
                          
    }
    
    public void contol(){  
    	connect=DBConnect.dbConn();
    	actionListener1 = new ActionListener() {
    		public void actionPerformed(ActionEvent actionEvent) {

    		 try 
				{
					String q="insert into project.user (fname,lname,age,uname,pwd,emailid) values (?, ?, ?, ?, ?, ?) ";
					PreparedStatement pst=connect.prepareStatement(q);
					pst.setString(1, view1.getFname());
					pst.setString(2, view1.getLname());
					pst.setString(3, view1.getAge());
					pst.setString(4, view1.getUname());
					pst.setString(5, view1.getPassword());
					pst.setString(6, view1.getEmail());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Successfully Registered");
					pst.close();
					Myaccount up=new Myaccount();
					
					Controller controller=new Controller(up);
					controller.contol();
					
				}
				
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, "Same Username try some thing different !");
					f.printStackTrace();
				}
			}
    	};
    	view1.getButton_Submit().addActionListener(actionListener1);
    }
}