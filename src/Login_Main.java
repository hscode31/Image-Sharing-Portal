import javax.swing.SwingUtilities;


public class Login_Main {
	    public static void main(String[] args) {           
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {  
	            	try{
	                Login view = new Login();
	                Controller controller = new Controller(view);
	                controller.contol();
	            	}catch(Exception e)
	            	{
	            		
	            	}
	            }
	        });  
	    }
	}

