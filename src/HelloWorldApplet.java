import java.applet.Applet;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;



public class HelloWorldApplet extends Applet

{

	

/**
	 * 
	 */
	private static final long serialVersionUID = 7304898469215607673L;

class ButtonAddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

           //JOptionPane.showMessageDialog(null,"Please Fill the Input Fields.","Error",JOptionPane.WARNING_MESSAGE);

			if(tf1.getText().equals("") || tf2.getText().equals("")){

			tf3.setText("Please Enter The Inputs");

			JOptionPane.showMessageDialog(null,"Please Fill the Input Fields.","Error",JOptionPane.WARNING_MESSAGE);



			//lblMessage.setText("No number entered");

			}

			

			else{

			try{
			String stf1=tf1.getText();
			String stf2=tf2.getText();	
			Scanner scn1=new Scanner(stf1);
			Scanner scn2=new Scanner(stf2);
			//Scanner scn3=new Scanner(stf1);
			//Scanner scn4=new Scanner(stf2);
			
			int a=0,b=0;
			//double c=0,d=0;
			if(scn1.hasNextInt() && scn2.hasNextInt()){
				tf3.setDisabledTextColor(Color.BLUE);
				a=Integer.parseInt(tf1.getText());	
			    b=Integer.parseInt(tf2.getText());	
				// System.out.println("int a"+a);
				 //System.out.println("int b"+b);
				 tf3.setText(""+a+" + "+b+" = "+(a+b));
				 return;
			}
			
			
			
			else if(scn1.hasNextDouble() &&  scn2.hasNextDouble() ){
				tf3.setDisabledTextColor(Color.BLUE);
				double c=Double.parseDouble(tf1.getText());	
				double d=Double.parseDouble(tf2.getText());
				// System.out.println("dbl d"+d);
				// System.out.println("dbl c"+c);
				 tf3.setText(""+c+" + "+d+" = "+(c+d));
				 return;
			}
			
			/* These statements are written just to raise Exception for invalid Inputs*/ 
			 a=Integer.parseInt(tf1.getText());	
			 b=Integer.parseInt(tf2.getText());	
			/* End*/
			

			//tf3.setText(""+a+" + "+b+" = "+(a+b));

			

			lblMessage.setText("");

			}

			catch ( java.lang.NumberFormatException nfe){JOptionPane.showMessageDialog(null,"Enter Valid Inputs","Error",JOptionPane.WARNING_MESSAGE);}

			}

			

        }

    }

 class ButtonClearListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            //lblMessage.setText("The Cancel button was clicked");

			tf1.setText("");

			tf2.setText("");

			tf3.setText("");

			tf3.setDisabledTextColor(Color.RED);

			 //lblMessage.setText("The Clear button was clicked");

        }

    }

	

	 









  JTextField tf1,tf2,tf3;

    JButton btnAdd;

    JButton btnClear;

    JLabel lblMessage;

    JPanel pnlHolder;

    ButtonAddListener btnAddListener;

    ButtonClearListener btnClearListener;

	//ButtonCloseListener btnCloseListener;

	JButton button,picture;

//JLabel lblMessage;

    public void init() {

    	//setBackground(Color.cyan);

		//setVisible(true);

		//setLayout(null);

		//setTitle("Addition v1.0 by Mothkuri  \\m/");

		//setForeground(Color.RED);

        setSize(260, 220);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setLocationRelativeTo(null);

		//setResizable(false);

		

		

		btnAddListener = new ButtonAddListener();

       btnClearListener = new ButtonClearListener();

		//btnCloseListener=new ButtonCloseListener();



        JLabel label1=new JLabel("Enter First Number:");

		label1.setForeground(Color.blue);

		tf1=new JTextField(20);
		//tf1.addKeyListener(new KeyEvent());
		

		

		JLabel label2=new JLabel("Enter Second Number:");

		label2.setForeground(Color.blue);

		tf2=new JTextField(20);

		

		JLabel label3=new JLabel("Sum:");

		label3.setForeground(Color.red);

		tf3=new JTextField(20);

		//tf3.setForeground(color.red);

		tf3.setEnabled(false);

		

		tf3.setDisabledTextColor(Color.RED);

			//UIManager.put("tf3.disabledForeground", Color.red);  

        btnAdd = new JButton("Add");

        btnAdd.addActionListener(btnAddListener);

        btnClear = new JButton("Clear");

        btnClear.addActionListener(btnClearListener);

		

		

		

        //JButton btnClose = new JButton("Close");

		//btnClose.addActionListener(btnCloseListener);

		 

		 

        lblMessage=new JLabel();

		

		add(label1);

		add(tf1);

		

		add(label2);

		add(tf2);

		

		add(label3);

		add(tf3);

		

        add(btnAdd);

        add(btnClear);

		//add(btnClose);

       add(lblMessage);
       
       KeyListener keyListener = new KeyListener() {
    	      public void keyPressed(KeyEvent keyEvent) {
    	    	  char c=keyEvent.getKeyChar();
    	    	  if(c==keyEvent.VK_ESCAPE){
    	    		  btnClear.doClick();
    	  	       			
    	  	       		}
    	    	  
    	    	  
    	      }
    	      public void keyReleased(KeyEvent keyEvent) {}
    	        
    	   
    	      public void keyTyped(KeyEvent keyEvent) {
    	    	  char c=keyEvent.getKeyChar();
  	       		if(c==keyEvent.VK_ENTER){
  	       		//btnAddListener.actionPerformed(null);
  	       		btnAdd.doClick();
  	       			//System.out.print("hi");
  	       			
  	       		}
    	    	  
  	       	
    	    	  
    	    	  else if(!(Character.isDigit(c) || c==keyEvent.VK_BACK_SPACE 
  	       				|| c==keyEvent.VK_DELETE || c==keyEvent.VK_PERIOD)){
  	       			getToolkit().beep();
  	       			
  	       			keyEvent.consume();
  
  	       		}
    	    	  
    	      }  
    	      
    	      
    	       
    	    };
    	    
    	    
    	    tf1.addKeyListener(keyListener);
    	    tf2.addKeyListener(keyListener);
    	   
    	    //this.addKeyListener(keyListener);
    	    
    	    
    	    

    }


   




	/* public void paint (Graphics g)

   {

      g.drawString ("Hello World", 25, 50);

   } */

}