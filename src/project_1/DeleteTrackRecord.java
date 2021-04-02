package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DeleteTrackRecord {

	public JFrame deleteTrackRecord()
	{
		JFrame frame=new JFrame();	
		frame.setBounds(240, 100, 1010, 600);   
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
		JLabel label_1=new JLabel("Choose campus : ");
		label_1.setBounds(200, 150, 150, 20);
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		
		JLabel label_2=new JLabel("SKCET");
		label_2.setBounds(350, 150, 60, 20);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_2.setForeground(Color.white);
		
		JCheckBox checkBox_1=new JCheckBox();
		checkBox_1.setBounds(415,150,22,20);
		checkBox_1.setBackground(new Color(255,255,255));	
		
		JLabel label_3=new JLabel("or");
		label_3.setBounds(445, 150, 30, 20);
		label_3.setForeground(Color.white);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));		
		
		JLabel label_4=new JLabel("SKCT");
		label_4.setBounds(470, 150, 50, 20);
		label_4.setForeground(Color.white);
		label_4.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		
		JCheckBox checkBox_2=new JCheckBox();
		checkBox_2.setBounds(525, 150 , 22 , 20);
		checkBox_2.setBackground(new Color(255,255,255));
		
		JLabel label_5=new JLabel("Choose Month");
		label_5.setBounds(200, 230, 120, 25);
		label_5.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_5.setForeground(Color.white);
		
		String s1[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		JComboBox<String> comboBox_1=new JComboBox<String>(s1);
		comboBox_1.setBounds(340, 230, 100, 30);
		comboBox_1.setBackground(Color.white);
		comboBox_1.setForeground(Color.BLACK);
		LocalDate currentdate=LocalDate.now();
		comboBox_1.setSelectedItem(s1[currentdate.getMonthValue()-1]);

		JLabel label_6=new JLabel("Choose Year");
		label_6.setBounds(620, 150, 110, 25);
		label_6.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_6.setForeground(Color.white);
		
		String s2[]={"3","4"};
		JComboBox<String> comboBox_2=new JComboBox<String>(s2);
		comboBox_2.setBounds(740, 150, 40, 30);
		comboBox_2.setBackground(Color.white);
		comboBox_2.setForeground(Color.BLACK);

		JLabel label_7=new JLabel("Choose Week");
		label_7.setBounds(620, 230, 125, 25);
		label_7.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_7.setForeground(Color.white);
		
		String s3[]={"1","2","3","4","5"};
		JComboBox<String> comboBox_3=new JComboBox<String>(s3);
		comboBox_3.setBounds(740, 230, 40, 30);
		comboBox_3.setBackground(Color.white);
		comboBox_3.setForeground(Color.BLACK);

		JLabel label_8=new JLabel("Test Number");
		label_8.setBounds(450, 300, 110, 25);
		label_8.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_8.setForeground(Color.white);
		
		String s4[]={"1","2","3"};
		JComboBox<String> comboBox_4=new JComboBox<String>(s4);
		comboBox_4.setBounds(570, 300, 50, 30);
		comboBox_4.setBackground(Color.white);
		comboBox_4.setForeground(Color.BLACK);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);
		
		JButton button_2=new JButton("Delete");
		button_2.setBounds(460, 400, 100, 40);
		button_2.setForeground(new Color(0,0,0));
		
		frame.add(label_1);//Choose campus
		frame.add(label_2);//SKCET
		frame.add(checkBox_1);
		frame.add(label_3);//or
		frame.add(label_4);//SKCT
		frame.add(checkBox_2);
		frame.add(label_5);//Month
		frame.add(comboBox_1);
		frame.add(label_6);//Year
		frame.add(comboBox_2);
		frame.add(label_7);//week
		frame.add(comboBox_3);
		frame.add(label_8);//Test Number
		frame.add(comboBox_4);
		frame.add(button_1);
		frame.add(button_2);
	 	frame.add(label);
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
					  Statement st=con.createStatement();
					  	 int a=0;
			    		 String columnname= (String) comboBox_1.getSelectedItem()+"_"+(String) comboBox_2.getSelectedItem()+"_"+(String) comboBox_3.getSelectedItem()+"_"+(String) comboBox_4.getSelectedItem();
			    	     if(checkBox_1.isSelected() && checkBox_2.isSelected())
			    	     {
			    	    	 	a=1;
			    	    	 	try
								  {
			    	    				st.executeUpdate("Alter table SKCET_"+AdminHomePage.batchyear +" DROP "+columnname);
					    				st.executeUpdate("Alter table SKCT_"+AdminHomePage.batchyear +" DROP "+columnname);		    	    	 							    
						                JOptionPane.showMessageDialog(button_2,"Selected record is sucessfully deleted");
								  }
								  catch(SQLSyntaxErrorException eee) {
						  	       	JOptionPane.showMessageDialog(null , "Check whether this column is present");     
								  }catch(Exception ee){
									  JOptionPane.showMessageDialog(null, "Something is wrong please try again");   
								  }  
			    	     }
			    	     else if(checkBox_1.isSelected())
			    	     {
			    	    	 	a=2;
			    	    	 	try
								  {
		    	       				st.executeUpdate("Alter table SKCET_"+AdminHomePage.batchyear +" DROP "+columnname);
					    			    JOptionPane.showMessageDialog(button_2,"Selected record is sucessfully deleted");
								  }
								  catch(SQLSyntaxErrorException eee) {
						  	       	JOptionPane.showMessageDialog(null , "Check whether this column is present");     
								  }catch(Exception ee){
									  JOptionPane.showMessageDialog(null, "Something is wrong please try again");   
								  }  
			    	     }
			    	     else if(checkBox_2.isSelected())
			    	     {
			    	    	 	a=3;
			    	    	 	try
								  {
		    	       				st.executeUpdate("Alter table SKCT_"+AdminHomePage.batchyear +" DROP "+columnname);		    	    	 							   
						                JOptionPane.showMessageDialog(button_2,"Selected record is sucessfully deleted");
								  }
								  catch(SQLSyntaxErrorException eee) {
						  	       	JOptionPane.showMessageDialog(null , "Check whether this column is present");     
								  }catch(Exception ee){
									  JOptionPane.showMessageDialog(null, "Something is wrong please try again");   
								  }  
			    	     }
			    	     else
			    	    	 JOptionPane.showMessageDialog(label_3, "Select Campus");
					  }
				  catch(Exception e){}
			}
		});
		
	  frame.setVisible(true);
      return frame;
	}
}