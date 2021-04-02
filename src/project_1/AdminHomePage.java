package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.security.*;
import java.sql.Connection;
import java.sql.Statement;


public class AdminHomePage {
   
	public static String batchyear =FirstPage.batchyear;
			
	public JFrame createAdminPage()
	{
		JFrame frame=new JFrame("S M A R S-Admin Home Page");
		frame.setBounds(240, 100, 1010, 600);
  	    ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JLabel label_1=new JLabel("Enter the Batch");
		label_1.setBounds(370, 10 , 200 , 40);
		label_1.setBackground(new Color(240, 168, 12));
		label_1.setForeground(new Color(255,255,255));
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JTextField text_1=new JTextField(batchyear);
		text_1.setBounds(540, 10 , 100 , 40);
		text_1.setForeground(Color.black);
		text_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JButton button_1=new JButton("Add Students");
		button_1.setBounds(80, 80, 225, 40);
		button_1.setContentAreaFilled(false);
		button_1.setForeground(new Color(255,255,255));
		
		JButton button_2=new JButton("Update Students Details");
		button_2.setBounds(380, 80, 225, 40);
		button_2.setContentAreaFilled(false);
		button_2.setForeground(new Color(255,255,255));
		
		JButton button_3=new JButton("Create TeamSplit Up");
		button_3.setBounds(680, 80, 225, 40);
		button_3.setContentAreaFilled(false);
		button_3.setForeground(new Color(255,255,255));
		
		JButton button_4=new JButton("Delete Students");
		button_4.setBounds(80, 160, 225, 40);
		button_4.setContentAreaFilled(false);
		button_4.setForeground(new Color(255,255,255));

		JButton button_5=new JButton("View Students Progress");
		button_5.setBounds(380, 160, 225, 40);
		button_5.setContentAreaFilled(false);
		button_5.setForeground(new Color(255,255,255));

		JButton button_6=new JButton("Change team member");
		button_6.setBounds(680, 160, 225, 40);
		button_6.setContentAreaFilled(false);
		button_6.setForeground(new Color(255,255,255));
		
		JButton button_7=new JButton("Individual Student Progress");
		button_7.setBounds(80, 250, 225, 40);
		button_7.setContentAreaFilled(false);
		button_7.setForeground(new Color(255,255,255));

		JButton button_8=new JButton("Upload track record");
		button_8.setBounds(380, 250, 225, 40);
		button_8.setContentAreaFilled(false);
		button_8.setForeground(Color.white);

		JButton button_9=new JButton("Download Team track record");
		button_9.setBounds(680, 250, 225, 40);
		button_9.setContentAreaFilled(false);
		button_9.setForeground(Color.white);

		JButton button_10=new JButton("Download Categorywise Students");
		button_10.setBounds(80, 340, 225, 40);
		button_10.setContentAreaFilled(false);
		button_10.setForeground(new Color(255,255,255));

		JButton button_11=new JButton("Download track record");
		button_11.setBounds(380, 340, 225, 40);
		button_11.setContentAreaFilled(false);
		button_11.setForeground(new Color(255,255,255));

		JButton button_12=new JButton("Add Placed Students");
		button_12.setBounds(680, 340, 225, 40);
		button_12.setContentAreaFilled(false);
		button_12.setForeground(new Color(255,255,255));
		
		JButton button_13=new JButton("Delete Track record");
		button_13.setBounds(80, 430, 225, 40);
		button_13.setContentAreaFilled(false);
		button_13.setForeground(new Color(255,255,255));

		JButton button_14=new JButton("Add admin");
		button_14.setBounds(380, 430, 225, 40);
		button_14.setContentAreaFilled(false);
		button_14.setForeground(new Color(255,255,255));

		JButton button_15=new JButton("Placement Details");
		button_15.setBounds(680, 430, 225, 40);
		button_15.setContentAreaFilled(false);
		button_15.setForeground(new Color(255,255,255));

		JButton button_16=new JButton("Delete Existing Batch");
		button_16.setBounds(80, 520, 225, 40);
		button_16.setContentAreaFilled(false);
		button_16.setForeground(Color.white);

		JButton button_17=new JButton("Create New Batch");
		button_17.setBounds(380, 520, 225, 40);
		button_17.setContentAreaFilled(false);
		button_17.setForeground(new Color(255,255,255));

		JButton button_18=new JButton("Remarks and Reviews");
		button_18.setBounds(680, 520, 225, 40);
		button_18.setContentAreaFilled(false);
		button_18.setForeground(new Color(255,255,255));

		frame.add(label_1);//Enter the batch
		frame.add(text_1);//____
		frame.add(button_1);//Add Students Details
		frame.add(button_2);//Update Students Details
		frame.add(button_3);//Create TeamSplit Up
		frame.add(button_4);//Delete Students Details
		frame.add(button_5);//View Student Progress
		frame.add(button_6);//Change Team member
		frame.add(button_7);//Individual Student progress
		frame.add(button_8);//Upload track record
		frame.add(button_9);//Download Teamwise track record
		frame.add(button_10);//Download Categorywise Student
		frame.add(button_11);//Download Track record
		frame.add(button_12);//Add Placed Student 
		frame.add(button_13);//Delete Track record
		frame.add(button_14);//Add admin
		frame.add(button_15);//Placement Details
		frame.add(button_16);//Delete Existing Batch
		frame.add(button_17);//Create New Batch
		frame.add(button_18);//Remarks and Reviews
		frame.add(label);
		
		text_1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				AdminHomePage.batchyear=text_1.getText();
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		//Add Student
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
		         frame.dispose();		
		         new UploadOrManual().createUploadOrManual(1);
				}
			}
		});
		
		//Update Student details
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new UploadOrManual().createUploadOrManual(2);
				}
			}
		});
		
		//Create Team Split Up
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new TeamSplit().createTeamSplit();
				}
			}
		});
		
		//Delete Students
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new UploadOrManual().createUploadOrManual(3);
				}
			}
		});

		//OverallPerformance
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
			        new StudentPerformance().createPerformance("Overall Performance",true);
				}
			}
		});
        
		//OverallPerformance
		button_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new TeamSplit().changeTeamMember();
				}
			}
		});
		
		//Individual Progress
		button_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
			        new StudentPerformance().getEmailID();
				}
			}
		});

		//Upload Track Record
		button_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new UploadOrManual().createUploadOrManual(4);
				}
			}
		});

		//Download Track Record
		button_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new Download().createTeamRecord();
				}
			}
		});
		
		//Categorywise Download
		button_10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new Download().createCategorywiseDownload();
				}
			}
		});

		button_11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new Download().createTrackRecordDownload(null);
				}
			}
		});

		button_12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new Placement().addPlacedStudent();
				}
				
			}
		});
	
		button_13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new DeleteTrackRecord().deleteTrackRecord();
				}
			}
		});

		button_14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				addAdmin();
			}
		});
		
		button_15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new Placement().placementDetails();
				}
			}
		});

		button_16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		         frame.dispose();
		         new Batch().deleteExistBatch();
			}
		});
		
		
		button_17.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Batch().createNewBatch();
			}
		});

		button_18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(text_1,"Batch is mandatory");
				}
				else
				{
					frame.dispose();
					new RemarkAndReview().teamOrSingle();
				}
			}
		});
		
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame addAdmin()
	{
		JFrame frame = new JFrame();
		frame.setBounds(180, 30, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);
	
		JLabel label_1=new JLabel("User name");
		label_1.setBounds(360 , 210  , 200 , 40);
		label_1.setBackground(new Color(240, 168, 12));
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JTextField textField_1=new JTextField();
		textField_1.setBounds(480, 210 , 180 , 30);
		JLabel validation_1=new JLabel();
		validation_1.setBounds(280,75,150,30);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		textField_1.setBackground(Color.white);
		textField_1.setForeground(Color.BLACK);

		JLabel label_2=new JLabel("Password");
		label_2.setBounds(360, 280 , 140 , 30);
		label_2.setFont(new Font("Times of  Roman",Font.BOLD+Font.CENTER_BASELINE,22));
		label_2.setForeground(new Color(255,255,255));

		JPasswordField password=new JPasswordField();
		password.setBounds(480, 280 , 180 , 30);
		JLabel validation_2=new JLabel();
		validation_2.setBounds(220,75,150,30);
		password.setFont(new Font("Times of Roman",Font.BOLD,18));
		password.setBackground(Color.white);
		password.setForeground(Color.BLACK);
		
		JButton button_2=new JButton("Add admin");
		button_2.setBounds(480, 380, 100, 40);
		button_2.setForeground(Color.BLACK);

		frame.add(button_1);
		frame.add(label_1);
		frame.add(textField_1);
		frame.add(validation_1);
		frame.add(label_2);
		frame.add(password);
		frame.add(validation_2);	
		frame.add(button_2);
		frame.add(label);
		
		textField_1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("[a-zA-Z\\s]{3,}");
				Matcher m1=p1.matcher(textField_1.getText());
				if(!(m1.matches()))
				{
					validation_1.setFont(new Font("Serif", Font.ITALIC,14));
					validation_1.setForeground(new Color(255,0,0));
					validation_1.setText("Invalid Name");
				}
				else
				{
					validation_1.setForeground(Color.BLACK);
					validation_1.setText("Valid Name");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    frame.dispose();
				new AdminHomePage().createAdminPage();
			}
		});

		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String username=textField_1.getText();
				String Password=String.valueOf(password.getPassword());
				if(username.trim().isEmpty()) {
	                	JOptionPane.showMessageDialog(textField_1, "Enter a valid user_name");
	                }
	                if(Password.trim().isEmpty()) {
	                	JOptionPane.showMessageDialog(password, "Enter a valid password");
	                }
	                if(Password.trim().length()<6) {
	                	JOptionPane.showMessageDialog(password, "Password should not be less than 6 characters");
	                }
	                
	                if(!(username.trim().isEmpty()) && !(Password.trim().isEmpty()) && (Password.length()>=6)) {
	                    
	                       //HASHING BEFORE STORING
	                
	                	String passwordToHash = Password;
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
	                     try {
	                         Connection con =new DatabaseWork().getDbConnection(); 
	                         Statement st = con.createStatement();
	                         
	                            String query = "INSERT INTO Admin_login values('" + username + "','" +generatedPassword + "')";
	                            
	                            textField_1.setText("");
	                            password.setText("");
	                            int x = st.executeUpdate(query);
	                            if (x == 0) {
	                                JOptionPane.showMessageDialog(button_2, "This is alredy exist");
	                            } else {
	                                JOptionPane.showMessageDialog(button_2,
	                                    "Your account is sucessfully created");
	                            }
	                            con.setAutoCommit(true);
	                            con.close();
	                            st.close();
	                            
	                        } catch (Exception exception) {
	                            exception.printStackTrace();
	                        }
	                }
			}
		});
		
		frame.setVisible(true);
		return frame;
	}
	
	public static void main(String args[])
	{
		new AdminHomePage().createAdminPage();
	}
	
}