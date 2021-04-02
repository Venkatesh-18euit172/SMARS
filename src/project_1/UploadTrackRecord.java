package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UploadTrackRecord {

	static int flag;
	
	public JFrame createUploadTrackRecord()
	{
		JFrame frame=new JFrame();
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JLabel label_1=new JLabel("Choose campus : ");
		label_1.setBounds(200, 100, 150, 20);
		label_1.setFont(new Font("Times of Roman",Font.ITALIC,17));
		label_1.setForeground(Color.white);
		
		JLabel label_2=new JLabel("SKCET");
		label_2.setBounds(350, 100, 60, 20);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_2.setForeground(Color.white);
		
		JCheckBox checkBox_1=new JCheckBox();
		checkBox_1.setBounds(415,100,22,20);
		checkBox_1.setBackground(new Color(255,255,255));	
		
		JLabel label_3=new JLabel("or");
		label_3.setBounds(445, 100, 30, 20);
		label_3.setForeground(Color.white);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));		
		
		JLabel label_4=new JLabel("SKCT");
		label_4.setBounds(470, 100, 50, 20);
		label_4.setForeground(Color.white);
		label_4.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		
		JCheckBox checkBox_2=new JCheckBox();
		checkBox_2.setBounds(525, 100 , 22 , 20);
		
		JLabel label_5=new JLabel("Choose Month");
		label_5.setBounds(200, 180, 120, 25);
		label_5.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_5.setForeground(Color.white);
		
		String s1[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		JComboBox<String> comboBox_1=new JComboBox<String>(s1);
		comboBox_1.setBounds(340, 180, 100, 30);
		comboBox_1.setBackground(Color.white);
		comboBox_1.setForeground(Color.BLACK);
		LocalDate currentdate=LocalDate.now();
		comboBox_1.setSelectedItem(s1[currentdate.getMonthValue()-1]);

		JLabel label_6=new JLabel("Choose Year");
		label_6.setBounds(620, 100, 110, 25);
		label_6.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_6.setForeground(Color.white);
		
		String s2[]={"3","4"};
		JComboBox<String> comboBox_2=new JComboBox<String>(s2);
		comboBox_2.setBounds(740, 100, 40, 30);
		comboBox_2.setBackground(Color.white);
		comboBox_2.setForeground(Color.BLACK);

		JLabel label_7=new JLabel("Choose Week");
		label_7.setBounds(620, 180, 125, 25);
		label_7.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_7.setForeground(Color.white);
		
		String s3[]={"1","2","3","4","5"};
		JComboBox<String> comboBox_3=new JComboBox<String>(s3);
		comboBox_3.setBounds(740, 180, 40, 30);
		comboBox_3.setBackground(Color.white);
		comboBox_3.setForeground(Color.BLACK);

		JLabel label_8=new JLabel("Test Number");
		label_8.setBounds(450, 250, 110, 25);
		label_8.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_8.setForeground(Color.white);
		
		String s4[]={"1","2","3"};
		JComboBox<String> comboBox_4=new JComboBox<String>(s4);
		comboBox_4.setBounds(570, 250, 50, 30);
		comboBox_4.setBackground(Color.white);
		comboBox_4.setForeground(Color.BLACK);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 10 , 70, 20);
		
		ImageIcon img_1=new ImageIcon(new ImageIcon("D:\\image\\upload.jpg").getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH));
		JButton button_2=new JButton(img_1);
		button_2.setBounds(450, 310 , 150, 60);
		
		JLabel label_9=new JLabel("Upload file");
		label_9.setBounds(470, 370, 200 , 40);
		label_9.setBackground(null);
		label_9.setForeground(Color.white);
		label_9.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JButton button_3=new JButton("Submit");
		button_3.setBounds(450, 450 , 150, 40);
				
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
				JFileChooser fileChooser=new JFileChooser();	
			    if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
			    {
			    	 UploadTrackRecord.flag=1;
			    	try
			    	{
			    		int a=0;
			    		 String columnname= (String) comboBox_1.getSelectedItem()+"_"+(String) comboBox_2.getSelectedItem()+"_"+(String) comboBox_3.getSelectedItem()+"_"+(String) comboBox_4.getSelectedItem();
			    	     if(checkBox_1.isSelected() && checkBox_2.isSelected())
			    	     {
			    	    	 	a=1;
			    	     }
			    	     else if(checkBox_1.isSelected())
			    	     {
			    	    	 	a=2;
			    	     }
			    	     else if(checkBox_2.isSelected())
			    	     {
			    	    	 	a=3;
			    	     }
			    	     else
			    	    	 JOptionPane.showMessageDialog(label_3, "Select Campus");
			    	     if(a!=0)
			    	    	 marktoDbFile(fileChooser.getSelectedFile().getPath(),columnname,a);
			    	}
			    	catch(Exception e){}
			    }
			    else
			    	 UploadTrackRecord.flag=0;
			}			
		});
		
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(UploadTrackRecord.flag==0)
					JOptionPane.showMessageDialog(button_2, "Upload a file");
				else
					JOptionPane.showMessageDialog(button_3, "Mark is successfully added!!!");
			}
		});
				
		label.add(label_1);//Choose campus
		label.add(label_2);//SKCET
		label.add(checkBox_1);
		label.add(label_3);//or
		label.add(label_4);//SKCT
		label.add(checkBox_2);
		label.add(label_5);//Month
		label.add(comboBox_1);
		label.add(label_6);//Year
		label.add(comboBox_2);
		label.add(label_7);//week
		label.add(comboBox_3);
		label.add(label_8);//Test Number
		label.add(comboBox_4);
		label.add(button_1);//Upload file
		label.add(label_9);
		label.add(button_2);
		label.add(button_3);

		frame.setVisible(true);
		return frame;
	}
	
	public JFrame createManual()
	{
		JFrame frame=new JFrame();
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JLabel label_1=new JLabel("Choose campus : ");
		label_1.setBounds(200, 150, 150, 20);
		label_1.setFont(new Font("Times of Roman",Font.ITALIC,17));
		label_1.setForeground(Color.white);
		
		JLabel label_2=new JLabel("SKCET");
		label_2.setBounds(350, 150, 60, 20);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.ITALIC,17));
		label_2.setForeground(Color.white);
		
		JCheckBox checkBox_1=new JCheckBox();
		checkBox_1.setBounds(415,150,22,20);	
		
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
		
		JButton button_2=new JButton("Click to add manually");
		button_2.setBounds(450, 360 , 180, 40);
				
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
		    				st.execute("Alter table SKCET_"+AdminHomePage.batchyear +" add "+columnname +" double ");
		    				st.execute("Alter table SKCT_"+AdminHomePage.batchyear +" add "+columnname +" double ");
		    	     }
		    	     else if(checkBox_1.isSelected())
		    	     {
		    	    	 	a=2;
		    				st.execute("Alter table SKCET_"+AdminHomePage.batchyear +" add "+columnname +" double ");
		    	     }
		    	     else if(checkBox_2.isSelected())
		    	     {
		    	    	 	a=3;
		    				st.execute("Alter table SKCT_"+AdminHomePage.batchyear +" add "+columnname +" double ");
		    	     }
		    	     else
		    	    	 JOptionPane.showMessageDialog(label_3, "Select Campus");
		    	     if(a!=0)
		    	     {
		    	    	 marktoDbManual(columnname);
		    	    	 frame.dispose();
		    	     }
		    	}
		    	catch(Exception e){}
			}
		});
		
		label.add(label_1);//Choose campus
		label.add(label_2);//SKCET
		label.add(checkBox_1);
		label.add(label_3);//or
		label.add(label_4);//SKCT
		label.add(checkBox_2);
		label.add(label_5);//Month
		label.add(comboBox_1);
		label.add(label_6);//Year
		label.add(comboBox_2);
		label.add(label_7);//week
		label.add(comboBox_3);
		label.add(label_8);//Test Number
		label.add(comboBox_4);
		label.add(button_1);
		label.add(button_2);
	 		
	  frame.setVisible(true);
      return frame;
	}
	
	public void marktoDbFile(String filepath,String columnname,int f)
	{
		try
		{
			Connection con=new DatabaseWork().getDbConnection();
			Statement st=con.createStatement();
			if(f==1)
			{
				st.execute("Alter table SKCET_"+AdminHomePage.batchyear +" add "+columnname +" double ");
				st.execute("Alter table SKCT_"+AdminHomePage.batchyear +" add "+columnname +" double ");		    	    	 
			}
			else if(f==2)
			{
				st.execute("Alter table SKCET_"+AdminHomePage.batchyear +" add "+columnname +" double ");
			}
			else if(f==3)
			{
				st.execute("Alter table SKCT_"+AdminHomePage.batchyear +" add "+columnname +" double ");
			}
			FileInputStream fis=new FileInputStream(filepath);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while(itr.hasNext())
			{
				Row row=itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				String emailId=cellIterator.next().getStringCellValue();
				double mark=cellIterator.next().getNumericCellValue();
				if(emailId.contains("@skct.edu.in"))
				{
					String query="update SKCT_"+AdminHomePage.batchyear+" set "+ columnname +" = ? where College_Email_ID= ? ";
					PreparedStatement pstmt=con.prepareStatement(query);
					pstmt.setDouble(1, mark);
					pstmt.setString(2, emailId);
					pstmt.executeUpdate();
				}
				else if(emailId.contains("@skcet.ac.in"))
				{
					String query="update SKCET_"+AdminHomePage.batchyear+" set "+ columnname +" = ? where College_Email_ID= ? ";
					PreparedStatement pstmt=con.prepareStatement(query);
					pstmt.setDouble(1, mark);
					pstmt.setString(2, emailId);
					pstmt.executeUpdate();			
				}
			}
			con.setAutoCommit(true);
			con.close();
			st.close();
			wb.close();
		}
		catch(Exception e){System.out.println(e);}
	}
	
	public JFrame marktoDbManual(String columnname)
	{
		JFrame frame=new JFrame();
		frame.setLayout(null);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JLabel label_1=new JLabel("Email ID");
		label_1.setBounds(310, 150, 150, 30);
    	label_1.setFont(new Font("Arial Black",Font.BOLD,18));
		label_1.setFont(new Font("Times of Roman",Font.BOLD,18));

		JTextField textField_1=new JTextField();
		textField_1.setBounds(500, 145, 210, 40);
		JLabel validation_1=new JLabel();
		validation_1.setBounds(160,20,150,20);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		textField_1.setForeground(Color.white);

		JLabel label_2=new JLabel("Mark");
		label_2.setBounds(310, 235, 150, 30);
		label_2.setFont(new Font("Times of Roman",Font.BOLD,18));

		JTextField textField_2=new JTextField();
		textField_2.setBounds(500, 230, 210, 40);
		JLabel validation_2=new JLabel();
		validation_2.setBounds(220,75,150,30);
		textField_2.setFont(new Font("Times of Roman",Font.BOLD,18));
		textField_2.setBackground(Color.white);
		textField_2.setForeground(Color.white);
			
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);
			
		JButton button_2=new JButton("Add");
		button_2.setBounds(425, 330, 150, 50);
			
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    frame.dispose();
				new AdminHomePage().createAdminPage();
			}
		});
		
		textField_1.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					Pattern p1=Pattern.compile("^\\d{2}(eu||tu)(cs||ec||ee||mc||mt||it)\\d{3}(@skcet\\.ac.in||@skct\\.ac.in)");
					Matcher m1=p1.matcher(textField_1.getText());
					if(!(m1.matches()))
					{
						validation_1.setFont(new Font("Serif", Font.ITALIC,14));
						validation_1.setForeground(new Color(255,0,0));
						validation_1.setText("Invalid Email");
					}
					else
					{
						validation_1.setForeground(Color.BLACK);
						validation_1.setText("Valid Email");					
					}
				}
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					
				}
			});

		button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				 
					String emailId=textField_1.getText();
					Double mark=Double.parseDouble(textField_2.getText());
					try
					{
						Connection con=new DatabaseWork().getDbConnection();
						if(emailId.contains("@skct.edu.in"))
						{
							String query="update SKCT_"+AdminHomePage.batchyear+" set "+ columnname +" = ? where College_Email_ID= ? ";
							PreparedStatement pstmt=con.prepareStatement(query);
							pstmt.setDouble(1, mark);
							pstmt.setString(2, emailId);
							pstmt.executeUpdate();
						}
						else if(emailId.contains("@skcet.ac.in"))
						{
							String query="update SKCET_"+AdminHomePage.batchyear+" set "+ columnname +" = ? where College_Email_ID= ? ";
							PreparedStatement pstmt=con.prepareStatement(query);
							pstmt.setDouble(1, mark);
							pstmt.setString(2, emailId);
							pstmt.executeUpdate();			
						}
			
					}
					catch(Exception e){}		}
			});
		
		frame.add(label_1);
		frame.add(textField_1);
		//frame.add(validation_1);
		frame.add(label_2);
		frame.add(textField_2);
		frame.add(validation_2);
		frame.add(button_1);
		frame.add(button_2);
		frame.add(label);
		
		frame.setVisible(true);
		return frame;
	}
 }