package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RemarkAndReview {

	public static JFrame teamOrSingle()
	{
		JFrame frame=new JFrame("S M A R S-Delete form");
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(240, 100, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);

		JLabel label_1=new JLabel("Email ID");
		label_1.setBounds(125, 250, 150, 30);
    	label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		
		JTextField textField_1=new JTextField();
		textField_1.setBounds(250, 250, 210, 40);
		JLabel validation_1=new JLabel();
		validation_1.setBounds(770,250,150,20);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		textField_1.setForeground(Color.BLACK);

		JButton button_2=new JButton("Individual Student");
		button_2.setBounds(200, 330, 200, 40);
		button_2.setForeground(Color.BLACK);

		JLabel label_2=new JLabel("or");
		label_2.setBounds(520, 250, 50, 30);
    	label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times of Roman",Font.BOLD,20));

		JLabel label_3=new JLabel("Team Number");
		label_3.setBounds(600, 250, 150, 30);
    	label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times of Roman",Font.BOLD,18));
		
		JTextField textField_2=new JTextField();
		textField_2.setBounds(780, 250, 100, 40);
		textField_2.setFont(new Font("Times of Roman",Font.BOLD,18));
		textField_2.setForeground(Color.BLACK);

		JButton button_3=new JButton("Team");
		button_3.setBounds(650, 330, 200, 40);
		button_3.setForeground(Color.BLACK);

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
					if(textField_1.getText().equals(""))
						JOptionPane.showMessageDialog(textField_1, "EmailID is mandatory");
					else
					{
						frame.dispose();
						new RemarkAndReview().single(textField_1.getText());	
					}
				}
			});

			button_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(textField_2.getText().equals(""))
						JOptionPane.showMessageDialog(textField_2, "Team number is mandatory");
					else
					{
						frame.dispose();
						new RemarkAndReview().team(Integer.parseInt(textField_2.getText()));
					}
				}
			});		
		label.add(button_1);//home
		label.add(label_1);//Email ID
		label.add(textField_1);//____
		label.add(validation_1);
		label.add(button_2);//Individual Student
		label.add(label_2);//or
		label.add(label_3);//Team Number
		label.add(textField_2);//______
		label.add(button_3);
		
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame single(String emailID)
	{
		JFrame frame=new JFrame("S M A R S-Individual Student Remarks");
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);

		JLabel label_1=new JLabel(emailID);
		label_1.setBounds(420, 150, 200, 30);
    	label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		
		String review="";
		try
		{
			Connection con=new DatabaseWork().getDbConnection();
			Statement st=con.createStatement();
			ResultSet res;
			if(emailID.contains("@skcet.ac.in"))
				res=st.executeQuery("Select Remarks from SKCET_"+AdminHomePage.batchyear+" where College_Email_ID='"+emailID+"'");
			else
				res=st.executeQuery("Select Remarks from SKCT_"+AdminHomePage.batchyear+" where College_Email_ID='"+emailID+"'");
			review=res.getString("Remarks");
		}
		catch(Exception e){}
		
		JTextArea textArea_1=new JTextArea(review);
		textArea_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		textArea_1.setForeground(Color.BLACK);
		JScrollPane scrollPane=new JScrollPane(textArea_1);
		scrollPane.setBounds(340, 230, 350, 150);
		
		JButton button_2=new JButton("Add Remarks");
		button_2.setBounds(450, 450, 150, 40);
		button_2.setForeground(Color.BLACK);

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
					try
					{
						Connection con=new DatabaseWork().getDbConnection();
						PreparedStatement pstmt;
						if(emailID.contains("skcet.ac.in"))
							pstmt=con.prepareStatement("update SKCET_"+AdminHomePage.batchyear+" set Remarks= ? Where College_Email_ID= ?");
						else
							pstmt=con.prepareStatement("update SKCT_"+AdminHomePage.batchyear+" set Remarks= ? Where College_Email_ID= ?");
						pstmt.setString(1, textArea_1.getText());
						pstmt.setString(2, emailID);
						pstmt.executeUpdate();
						con.setAutoCommit(true);
						con.close();
						pstmt.close();
					}
					catch(Exception e){System.out.print(e);}
					}
			});
		label.add(button_1);//home
		label.add(label_1);//Email ID
		label.add(scrollPane);//____
		label.add(button_2);//Add
		
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame team(int teamNo)
	{
		JFrame frame=new JFrame("S M A R S-Team review");
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		 JPanel Panel_1=new JPanel();
		 Panel_1.setBounds(30, 70, 400, 350);
		 Panel_1.setBackground(new Color(255,255,255));
		 Panel_1.setLayout(null);
		 
		 int x=0;
		 JLabel label_1[]=new JLabel[11];
		 for(int i=0;i<11;i++)
		 {
			 label_1[i]=new JLabel();
			 label_1[i].setBounds(10,10+x , 400, 25);
			 x+=30;
			 Panel_1.add(label_1[i]);
		 }
		ArrayList<String[]> a=new DatabaseWork().teamdetails(teamNo, 1);
		int noOfLabel=0;
		for(String i[]:a)
		{
			label_1[noOfLabel].setText(teamNo+" - "+i[0]+" - "+i[1]);					
			noOfLabel++;
		}
		
		 JTextArea textArea_1=new JTextArea();
		 textArea_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		 textArea_1.setForeground(Color.BLACK);
		 JScrollPane scrollPane=new JScrollPane(textArea_1);
		 scrollPane.setBounds(480, 70, 400, 350);

    	 JButton button_1=new JButton("Home");
		 button_1.setBounds(900, 30 , 70, 20);

		 JButton button_2=new JButton("Add Reviews");
		 button_2.setBounds(380, 450, 150, 40);
		 button_2.setForeground(Color.BLACK);

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
				try
				{
					Connection con=new DatabaseWork().getDbConnection();
					PreparedStatement pstmt;
					if(a.contains("skcet.ac.in"))
						pstmt=con.prepareStatement("update SKCET_"+AdminHomePage.batchyear+" set Reviews= ? Where College_Email_ID= ?");
					else
						pstmt=con.prepareStatement("update SKCT_"+AdminHomePage.batchyear+" set Reviews= ? Where College_Email_ID= ?");
					pstmt.setString(1, textArea_1.getText());
					pstmt.setString(2, a.get(0)[0]);
					pstmt.executeUpdate();
					con.setAutoCommit(true);
					con.close();
					pstmt.close();
				}
				catch(Exception e){}
			}
		});
		 
		 label.add(Panel_1);
		 label.add(scrollPane);
		 label.add(button_1);
		 label.add(button_2);
		 
		 frame.setVisible(true);
		 return frame;
	}
	
}