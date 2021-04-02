package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	 
	    public JFrame createAdminLogin()
	    {
	    	JFrame frame=new JFrame();
	   	 	frame.setBounds(240, 100, 1010, 600);  
	   	    ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
			JLabel label = new JLabel(icon); 
	    	frame.setTitle("S M A R S - Admin Login Form");
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			
			
	    	JLabel label_1 = new JLabel("USERNAME");
	        label_1.setBounds(310, 150, 150, 30);
	        label_1.setFont(new Font("Arial Black",Font.BOLD,18));
	        label_1.setForeground(new Color(255,255,255));
	        
	        JTextField textField_1 = new JTextField();
	        textField_1.setBounds(500, 145, 210, 40);
	    	textField_1.setFont(new Font("Times of Roman",Font.BOLD,18));
	    	textField_1.setBackground(Color.white);
	    	textField_1.setForeground(Color.BLACK);
		    
	    	JLabel label_2 = new JLabel("PASSWORD");
	     	label_2.setBounds(310, 235, 150, 30);
	    	label_2.setFont(new Font("Arial Black",Font.BOLD,18));
	    	label_2.setForeground(new Color(255,255,255));
			
		    JPasswordField textField_2 = new JPasswordField();
			textField_2.setBounds(500, 230, 210, 40);
			textField_2.setFont(new Font("Times of Roman",Font.BOLD,18));
			textField_2.setBackground(Color.white);
			textField_2.setForeground(Color.BLACK);
		    
			JCheckBox checkBox_1 = new JCheckBox("Show Password");
			checkBox_1.setBounds(530, 290, 150, 30);
	        
		    JButton button_1 = new JButton("Clear");
			button_1.setBounds(360, 370, 100, 50);
			button_1.setForeground(Color.BLACK);

		    JButton button_2 = new JButton("LOGIN");
			button_2.setBounds(560, 370, 100, 50);
			button_2.setForeground(Color.BLACK);
			
	        frame.add(label);
	        label.add(label_1);//Username
	        label.add(textField_1);//______
	        label.add(label_2);//Password
	        label.add(textField_2);//_____
	        label.add(checkBox_1);//Show password
	        label.add(button_1);//Login
	        label.add(button_2);//reset
	        
	        checkBox_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			        if (checkBox_1.isSelected())
		                textField_2.setEchoChar((char) 0);
		            else 
		                textField_2.setEchoChar('*');	
				}
			});
     
	        button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
		
					if(checkAdmin(textField_1.getText(), String.valueOf(textField_2.getPassword())))
					{
						   frame.dispose();
						   new AdminHomePage().createAdminPage();
					}
					else
					{
						 JOptionPane.showMessageDialog(textField_1, "Invalid Username or Password");
					}
				}
			});
	     
	        button_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					textField_1.setText("");
					textField_2.setText("");
				}
			});
	        
	        frame.setVisible(true);
		    return frame;
    	
	    }

	    public boolean checkAdmin(String username,String password)
	    {
	    	String passwordToHash = password;
            String generatedPassword = null;
            try {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Add password bytes to digest
                md.update(passwordToHash.getBytes());
                //Get the hash's bytes 
                byte[] bytes = md.digest();
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                //Get complete hashed password in hex format
                generatedPassword = sb.toString();
            } 
            catch (NoSuchAlgorithmException ee) 
            {
                ee.printStackTrace();
            }
	    	try
	    	{
	    		Connection con=new DatabaseWork().getDbConnection();
	    		Statement st=con.createStatement();
            	ResultSet res=st.executeQuery("select password from admin_login where username='"+username+"'");
	    		res.next();
            	if(res.getString("password").equals(generatedPassword))
	    		{
	    			return true;
	    		}
	    		else
	    		{
	    			return false;
	    		}
	    	}
	    	catch(Exception e){System.out.println(e);}
	    	return false;
	    }
	    
	    public boolean checkStudent(String username,String password)
	    {
	    	try
	    	{
	    		Connection con=new DatabaseWork().getDbConnection();
	    		Statement st=con.createStatement();
            	ResultSet res=st.executeQuery("select DOB from Student_details_"+AdminHomePage.batchyear+ " where College_Email_ID='"+username+"' and "+"DOB='"+password+"'");
	    		res.next();
            	if(res.getString("DOB").equals(password))
	    		{
	    			return true;
	    		}
	    		else
	    		{
	    			return false;
	    		}
	    	}
	    	catch(Exception e){}
	    	return false;
	    }
	    
	    public JFrame createStudentLogin()
	    {
	    	JFrame frame=new JFrame();
	    	frame.setTitle("S M A R S - Student Login Form");
	   	 	ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	   	 	JLabel label=new JLabel(icon);
	   	 	frame.setBounds(180, 30, 1010, 600);   
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);

	    	JLabel label_1 = new JLabel("USERNAME");
	        label_1.setBounds(310, 150, 150, 30);
	        label_1.setFont(new Font("Arial Black",Font.BOLD,18));
	        label_1.setForeground(new Color(255,255,255));
			
	        JTextField textField_1 = new JTextField();
	        textField_1.setBounds(500, 145, 210, 40);
	    	textField_1.setFont(new Font("Times of Roman",Font.BOLD,18));
	    	textField_1.setBackground(Color.white);
	    	textField_1.setForeground(Color.BLACK);
		    
	    	JLabel label_2 = new JLabel("PASSWORD");
	    	label_2.setBounds(310, 235, 150, 30);
	    	label_2.setFont(new Font("Arial Black",Font.BOLD,18));
	    	label_2.setForeground(new Color(255,255,255));
	        
		    JPasswordField textField_2 = new JPasswordField();
		    textField_2.setBounds(500, 230, 210, 40);
			textField_2.setFont(new Font("Times of Roman",Font.BOLD,18));
			textField_2.setBackground(Color.white);
			textField_2.setForeground(Color.BLACK);
		    
			JCheckBox checkBox_1 = new JCheckBox("Show Password");
	        checkBox_1.setBounds(530, 290, 150, 30);
	        
		    JButton button_1 = new JButton("CLEAR");
			button_1.setBounds(360, 370, 100, 50);
			button_1.setForeground(Color.BLACK);
		
			JButton button_2 = new JButton("LOGIN");
			button_2.setBounds(560, 370, 100, 50);
			button_2.setForeground(Color.BLACK);

			JLabel enquiry = new JLabel("for enquiries: bootcamp@skcet.ac.in");
			enquiry.setBounds(800, 600, 500, 100);
			 
	        frame.add(label_1);//Username
	        frame.add(textField_1);//______
	        frame.add(label_2);//Password
	        frame.add(textField_2);//_____
	        frame.add(checkBox_1);//Show password
	        frame.add(button_1);//Login
	        frame.add(button_2);//Clear
	        frame.add(enquiry);//Enquiry
	        frame.add(label);
	        
	        checkBox_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			        if (checkBox_1.isSelected())
		                textField_2.setEchoChar((char) 0);
		            else 
		                textField_2.setEchoChar('*');	
				}
			});
     
	        button_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					textField_1.setText("");
					textField_2.setText("");
				}
			});
	        
	        button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
		
					if(checkStudent(textField_1.getText(), String.valueOf(textField_2.getPassword())))
					{
						   new StudentPerformance().createPerformance(textField_1.getText(),false);
						   frame.dispose();
					}
					else
					{
						 JOptionPane.showMessageDialog(textField_1, "Invalid Username or Password");
					}
				}
			});
	        
	        frame.setVisible(true);
		    return frame;
	    }	    
}