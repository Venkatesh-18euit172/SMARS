package project_1;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class TeamSplit {

	static TreeMap<Integer, ArrayList<String>> teamsplit=new TreeMap<Integer, ArrayList<String>>();
	static int noOfStudent,numOfcampus=2,from=3,to=4,mandatoryflag=0;
	static ArrayList<JRadioButton> radioButtons=new ArrayList<JRadioButton>();
	static ButtonGroup buttonGroup;
	
	public JFrame createTeamSplit()
	{
		 JFrame frame = new JFrame();
		 ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	     JLabel label=new JLabel(icon);
		 frame.setBounds(180, 30, 1010, 600);   
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     JButton button_1=new JButton("Home");
		 button_1.setBounds(900, 10 , 70, 20);
			
		 JLabel label_1=new JLabel("Choose campus : ");
		 label_1.setBounds(540, 45, 170, 30);
		 label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_1.setForeground(new Color(255,255,255));
		 
		 JCheckBox checkBox_1=new JCheckBox("SKCET");
		 checkBox_1.setBounds(720, 45, 90, 30);
		 checkBox_1.setSelected(true);
		 checkBox_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 checkBox_1.setForeground(new Color(255,255,255));
		 checkBox_1.setBackground(new Color(0,0,0));
		 
		 JLabel label_2=new JLabel("or");
		 label_2.setBounds(820, 45, 30, 30);
		 label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));		
		 label_2.setForeground(new Color(255,255,255));
		 
  		 JCheckBox checkBox_2=new JCheckBox("SKCT");
		 checkBox_2.setBounds(850,45 , 100 , 30);
		 checkBox_2.setSelected(true);
		 checkBox_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 checkBox_2.setForeground(new Color(255,255,255));
		 checkBox_2.setBackground(new Color(0,0,0));
		 
		 JLabel label_3=new JLabel("Based on Which Year track record: ");
		 label_3.setBounds(540, 90, 350, 20);
		 label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_3.setForeground(new Color(255,255,255));
		 
		 JCheckBox checkBox_3=new JCheckBox("3");
		 checkBox_3.setBounds(870, 90 , 50 , 20);
		 checkBox_3.setSelected(true);
		 checkBox_3.setForeground(new Color(255,255,255));	
		 checkBox_3.setBackground(new Color(0,0,0));
		 
		 JCheckBox checkBox_4=new JCheckBox("4");
		 checkBox_4.setBounds(930, 90 , 50 , 20);
		 checkBox_4.setSelected(true);
		 checkBox_4.setForeground(new Color(255,255,255));
		 checkBox_4.setBackground(new Color(0,0,0));
		 
		 getStudent(2, 3, 4, 5);
		 
		 JLabel label_4=new JLabel("No of Student : ");
		 label_4.setBounds(540, 130, 200, 30);
		 label_4.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_4.setForeground(new Color(255,255,255));
		 
		 JLabel label_5=new JLabel(String.valueOf(TeamSplit.noOfStudent));
		 label_5.setBounds(750, 130, 350, 30);
		 label_5.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_5.setForeground(new Color(255,255,255));
		 
		 JLabel label_6=new JLabel("Choose no of member per team");
		 label_6.setBounds(540, 170, 350, 30);
		 label_6.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_6.setForeground(new Color(255,255,255));
		
		 JTextField textField_1=new JTextField("5");
		 textField_1.setBounds(900, 170, 60, 30);
		 textField_1.setFont(new Font("Arial Black",Font.BOLD,18));
		 textField_1.setForeground(new Color(0,0,0));
		 
		 JButton button_2=new JButton("Apply");
		 button_2.setBounds(700, 210, 100, 30);
		 
		 JLabel label_7=new JLabel();
		 label_7.setBounds(600, 250, 300, 30);
		 label_7.setFont(new Font("Arial Black",Font.BOLD,18));
		 label_7.setForeground(new Color(255,255,255));
		 
		 JLabel label_8=new JLabel();
		 label_8.setBounds(550, 285, 380, 30);
		 label_8.setFont(new Font("Arial Black",Font.BOLD,18));
		 label_8.setForeground(new Color(255,255,255));
		 
		 JLabel label_9=new JLabel("Enter the team number");
		 label_9.setBounds(540, 330, 350, 20);
		 label_9.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_9.setForeground(new Color(255,255,255));
		 
		 JTextField textField_2=new JTextField();
		 textField_2.setBounds(780, 330, 60, 30);
		 textField_2.setFont(new Font("Arial Black",Font.BOLD,18));
		 textField_2.setForeground(new Color(0,0,0));
		 	 
		 JButton button_3=new JButton("Change the team");
		 button_3.setBounds(680, 390, 200, 30);
		 
		 int a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
		 int b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
		 if(b!=0)
			 a++;
		 label_7.setText(String.valueOf(a)+" teams can be created");
		 if(b!=0)
			label_8.setText("Team "+String.valueOf(a)+" will have only "+b+" member");
		 else
			label_8.setText("");
		 
		 
		 JLabel label_11 = new JLabel("   Team Number  Student Name  -  Campus  -  Department  -  EmailID  -  Gender  -  Mark");
		 label_11.setBounds(0, 20, 550, 20);
		 label_11.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,13));
		 label_11.setForeground(new Color(255,255,255));
		 
		 JLabel label_12=new JLabel("File name");
		 label_12.setBounds(540, 450, 100, 30);
		 label_12.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		 label_12.setForeground(new Color(255,255,255));
		 
		 JTextField textField_3=new JTextField();
		 textField_3.setBounds(650, 450, 120, 30);
		 textField_3.setFont(new Font("Arial Black",Font.BOLD,18));
		 textField_3.setForeground(new Color(0,0,0));
		 
		 JButton button_4=new JButton("Directory");
		 button_4.setBounds(800, 450, 130, 30);
	
		 JButton button_5=new JButton("Download");
		 button_5.setBounds(680, 500, 200, 30);
	
		 button_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				    frame.dispose();
					new AdminHomePage().createAdminPage();
				}
		});
		 
		 checkBox_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int f=0;
					if(checkBox_1.isSelected() && checkBox_2.isSelected())
					{
						TeamSplit.numOfcampus=2;
					}
					else if(checkBox_1.isSelected()&& !(checkBox_2.isSelected()))
					{
						TeamSplit.numOfcampus=1;
					}
					else if(!(checkBox_1.isSelected()) && checkBox_2.isSelected())
					{
						TeamSplit.numOfcampus=0;
					}
					else
					{
						f=1;
						label_5.setText("0");
						label_7.setText("");
						label_8.setText("");
						JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
					}
					if(f==0)
					{
						getStudent(TeamSplit.numOfcampus, TeamSplit.from, TeamSplit.to,Integer.parseInt(textField_1.getText()));
						 int a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
						 int b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
						 if(b!=0)
							 a++;
						 label_7.setText(String.valueOf(a)+" teams can be created");
						 if(b!=0)
							label_8.setText("Team "+String.valueOf(a)+" will have only "+b+" member");
						 else
							label_8.setText("");
						 label_5.setText(String.valueOf(TeamSplit.noOfStudent));
					}
				}
			});
			
			checkBox_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int f=0;
					if(checkBox_1.isSelected() && checkBox_2.isSelected())
					{
						TeamSplit.numOfcampus=2;
					}
					else if(checkBox_1.isSelected()&& !(checkBox_2.isSelected()))
					{
						TeamSplit.numOfcampus=1;
					}
					else if(!(checkBox_1.isSelected()) && checkBox_2.isSelected())
					{
						TeamSplit.numOfcampus=0;
					}
					else
					{
						f=1;
						label_5.setText("0");
						label_7.setText("");
						label_8.setText("");
						JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
					}
					if(f==0)
					{
						getStudent(TeamSplit.numOfcampus, TeamSplit.from, TeamSplit.to,Integer.parseInt(textField_1.getText()));
						 int a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
						 int b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
						 if(b!=0)
							 a++;
						 label_7.setText(String.valueOf(a)+" teams can be created");
						 if(b!=0)
							label_8.setText("Team "+String.valueOf(a)+" will have only "+b+" member");
						 else
							label_8.setText("");		
						 label_5.setText(String.valueOf(TeamSplit.noOfStudent));
					}
				}
			});		
			
			checkBox_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int f=0;
					if(checkBox_3.isSelected() && checkBox_4.isSelected())
					{
						TeamSplit.from=3;
						TeamSplit.to=4;
					}
					else if(checkBox_3.isSelected()&& !(checkBox_4.isSelected()))
					{
						TeamSplit.from=3;
						TeamSplit.to=3;
					}
					else if(!(checkBox_3.isSelected()) && checkBox_4.isSelected())
					{
						TeamSplit.from=4;
						TeamSplit.to=4;
					}
					else
					{
						f=1;
						label_5.setText("0");
						label_7.setText("");
						label_8.setText("");
						JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
					}
					if(f==0)
					{
						getStudent(TeamSplit.numOfcampus, TeamSplit.from, TeamSplit.to,Integer.parseInt(textField_1.getText()));
						 int a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
						 int b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
						 if(b!=0)
							 a++;
						 label_7.setText(String.valueOf(a)+" teams can be created");
						 if(b!=0)
							label_8.setText("Team "+String.valueOf(a)+" will have only "+b+" member");
						 else
							label_8.setText("");
						 label_5.setText(String.valueOf(TeamSplit.noOfStudent));			 
					}
				}
			});

			checkBox_4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int f=0;
					if(checkBox_3.isSelected() && checkBox_4.isSelected())
					{
						TeamSplit.from=3;
						TeamSplit.to=4;
					}
					else if(checkBox_3.isSelected()&& !(checkBox_4.isSelected()))
					{
						TeamSplit.from=3;
						TeamSplit.to=3;
					}
					else if(!(checkBox_3.isSelected()) && checkBox_4.isSelected())
					{
						TeamSplit.from=4;
						TeamSplit.to=4;
					}
					else
					{
						f=1;
						label_5.setText("0");
						label_7.setText("");
						label_8.setText("");
						JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
					}
					if(f==0)
					{
						getStudent(TeamSplit.numOfcampus, TeamSplit.from, TeamSplit.to,Integer.parseInt(textField_1.getText()));
						 int a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
						 int b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
						 if(b!=0)
							 a++;
						 label_7.setText(String.valueOf(a)+" teams can be created");
						 if(b!=0)
							label_8.setText("Team "+String.valueOf(a)+" will have only "+b+" member");
						 else
							label_8.setText("");
						 label_5.setText(String.valueOf(TeamSplit.noOfStudent));		 
					}
				}
			});

		 Box box = Box.createVerticalBox();
		 
		 a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
		 b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
		 if(b!=0)
			 a++;
		 int numradiobutton=0;
		 TeamSplit.buttonGroup=new ButtonGroup();
		 for(Map.Entry<Integer,ArrayList<String>> m:TeamSplit.teamsplit.entrySet()){    
		       String s=String.valueOf(m.getKey());
		       for(String i:m.getValue())
		       {
			       TeamSplit.radioButtons.add(new JRadioButton(s+" "+i));
			       TeamSplit.radioButtons.get(numradiobutton).setBackground(new Color(255,255,255));
			       TeamSplit.buttonGroup.add(TeamSplit.radioButtons.get(numradiobutton));
			       box.add(TeamSplit.radioButtons.get(numradiobutton));
			       numradiobutton++;
		       }
		  }    

		 button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					 int a=TeamSplit.noOfStudent/Integer.parseInt(textField_1.getText());
					 int b=TeamSplit.noOfStudent%Integer.parseInt(textField_1.getText());
					 if(b!=0)
						 a++;
					 label_7.setText(String.valueOf(a)+" teams can be created");
					 if(b!=0)
						label_8.setText("Team "+String.valueOf(a)+" will have only "+b+" member");
					 else
						label_8.setText("");
					 getStudent(TeamSplit.numOfcampus, TeamSplit.from, TeamSplit.to, Integer.parseInt(textField_1.getText()));
					 if(checkBox_1.isSelected() && checkBox_2.isSelected())
					 {
						 int numradiobutton=0;
						 TeamSplit.buttonGroup =new ButtonGroup();
						 for(Map.Entry<Integer,ArrayList<String>> m:TeamSplit.teamsplit.entrySet()){    
						       String s=String.valueOf(m.getKey());
						       for(String i:m.getValue())
						       {
						    	   TeamSplit.radioButtons.get(numradiobutton).setText(s+"  "+i);
							       TeamSplit.radioButtons.get(numradiobutton).setEnabled(true);
							       TeamSplit.buttonGroup.add(TeamSplit.radioButtons.get(numradiobutton));
							       numradiobutton++;
						       }
						  } 
					 }
					 else if(checkBox_1.isSelected() || checkBox_2.isSelected())
					 {
						 int numradiobutton=0;
						 TeamSplit.buttonGroup=new ButtonGroup();
						 for(Map.Entry<Integer,ArrayList<String>> m:TeamSplit.teamsplit.entrySet()){    
						       String s=String.valueOf(m.getKey());
						       for(String i:m.getValue())
						       {
						    	   TeamSplit.radioButtons.get(numradiobutton).setText(s+"  "+i);
						    	   TeamSplit.radioButtons.get(numradiobutton).setEnabled(true);
						    	   TeamSplit.buttonGroup.add(TeamSplit.radioButtons.get(numradiobutton));
						    	   numradiobutton++;
						       }
						 }
						 while(numradiobutton<TeamSplit.radioButtons.size())
						 {
							   TeamSplit.radioButtons.get(numradiobutton).setText("  ");
							   TeamSplit.radioButtons.get(numradiobutton).setEnabled(false);
							   TeamSplit.buttonGroup.add(TeamSplit.radioButtons.get(numradiobutton));
						       numradiobutton++;
						 }
					 }
					 else
					 {
						 int numradiobutton=0;
						 TeamSplit.buttonGroup=new ButtonGroup();
						 JOptionPane.showMessageDialog(null, "Select atleast one campus");
						 while(numradiobutton<TeamSplit.radioButtons.size())
						 {
							   TeamSplit.radioButtons.get(numradiobutton).setText("  ");
							   TeamSplit.radioButtons.get(numradiobutton).setEnabled(false);
							   TeamSplit.buttonGroup.add(TeamSplit.radioButtons.get(numradiobutton));
						       numradiobutton++;
						 }						 
					 }
				}
		});   
		 
		 button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter the team number");
				}
				else
				{
					ArrayList<String> replace1=TeamSplit.teamsplit.get(Integer.parseInt(textField_2.getText()));
					String remove="";
					int numradiobutton=0;
					int flag=0;
					while(numradiobutton<TeamSplit.radioButtons.size())
					{
						if(TeamSplit.radioButtons.get(numradiobutton).isSelected())
						{
							remove=TeamSplit.radioButtons.get(numradiobutton).getText();
							flag=1;
						}
						numradiobutton++;
					}
					if(flag==1)
					{
						String num="";
						int i=0;
						while(remove.charAt(i)!=' ')
						{
							num+=remove.charAt(i);
							i++;
						}
						int from=Integer.parseInt(num);
						ArrayList<String> replace2=TeamSplit.teamsplit.get(from);
						String add=remove.substring(2, remove.length()).trim();
						replace1.add(add);
						replace2.remove(add);
						TeamSplit.teamsplit.replace(Integer.parseInt(textField_2.getText()), replace1);
						if(replace2.isEmpty())
						{
							TeamSplit.teamsplit.remove(from);
						}
						else
						{
							TeamSplit.teamsplit.replace(from, replace2);
						}
						 numradiobutton=0;
						 TeamSplit.buttonGroup=new ButtonGroup();
						 for(Map.Entry<Integer,ArrayList<String>> m:TeamSplit.teamsplit.entrySet()){    
						       String s=String.valueOf(m.getKey());
						       for(String j:m.getValue())
						       {
						    	   TeamSplit.radioButtons.get(numradiobutton).setText(s+"  "+j);
						    	   TeamSplit.radioButtons.get(numradiobutton).setEnabled(true);
						    	   TeamSplit.buttonGroup.add(TeamSplit.radioButtons.get(numradiobutton));
						    	   numradiobutton++;
						       }
						 }
						 TeamSplit.buttonGroup.clearSelection();	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Choose atleast one Student to change");
					}	
				}
			}
		});
		 	
		 button_4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(textField_3.getText().equals(""))
						JOptionPane.showMessageDialog(textField_3, "File name is mandatory");
					JFileChooser fileChooser=new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					 if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
					 {
						 int a=2;
						 if(checkBox_1.isSelected() && checkBox_2.isSelected())
							 a=2;
						 else if(checkBox_1.isSelected())
							 a=1;
						 else if(checkBox_2.isSelected())
							 a=0;
						 if(checkBox_3.isSelected() && !(checkBox_4.isSelected()))
							 TeamSplit.to=3;
						 else if(checkBox_3.isSelected() && !(checkBox_4.isSelected()))
							 TeamSplit.from=4;
						 TeamSplit.mandatoryflag=1;
						 createPdf(fileChooser.getSelectedFile().getPath()+"\\"+textField_3.getText()+".pdf"); 
					 }
				}
			});
			
			button_5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int f=0;
					if(textField_3.getText().equals(""))
					{
						JOptionPane.showMessageDialog(textField_3, "File name is mandatory");
						f=1;
					}
					if(TeamSplit.mandatoryflag==0)
					{
						JOptionPane.showMessageDialog(button_4, "Directory is mandatory");
						f=1;
					}
					if(f==0)
						JOptionPane.showMessageDialog(button_5, "File "+textField_3.getText()+".pdf is Successfully downloaded");
				}
			});
			
		    JScrollPane scrollPane = new JScrollPane(box);
		    scrollPane.setBounds(10, 50,500 , 470);
		    scrollPane.getViewport().setBackground(new Color(255,255,255));
		    label.add(button_1);//Home
		    label.add(label_1);//Choose campus
		    label.add(checkBox_1);//SKCET
		    label.add(label_2);//or
		    label.add(checkBox_2);//SKCT
		    label.add(label_3);//Choose year
		    label.add(checkBox_3);//3
		    label.add(checkBox_4);//4
		    label.add(label_4);//No of Student
		    label.add(label_5);//_____
		    label.add(label_6);//Choose no of person
		    label.add(textField_1);//____
		    label.add(button_2);//Apply
		    label.add(label_7);//msg
		    label.add(label_8);//msg
		    label.add(label_9);//Enter team number
		    label.add(textField_2);//___
		    label.add(label_11);
		    label.add(button_3);//Change the team
		    label.add(scrollPane);
		    label.add(label_12);//File Name
		    label.add(textField_3);//______
		    label.add(button_4);//Directory
		    label.add(button_5);//Download
		    frame.add(label);
		    
		    frame.setVisible(true);
		    return frame;
	}
	
	public void getStudent(int numOfcampus,int from,int to,int numOfperson)
	{
		
		try
		{
		  ArrayList<String[]> result1=null;;
		  ArrayList<String[]> result2=null;
		  if(numOfcampus==2)
		  {
			  result1=new DatabaseWork().fullTrackRecord("SKCET",from,to,true);
		      result2=new DatabaseWork().fullTrackRecord("SKCT",from,to,true);  
		  }
		  else if(numOfcampus==1)
		  {
			  result1=new DatabaseWork().fullTrackRecord("SKCET",from,to,true);
		  }
		  else if(numOfcampus==0)
		  {
		      result2=new DatabaseWork().fullTrackRecord("SKCT",from,to,true);  
		  }
		 	int i=0,j=0,position=0;
			int skcetmark,skctmark;
			ArrayList<String> record=new ArrayList<String>();
			if(numOfcampus==2)
			{
				 while(i<result1.size() && j<result2.size())
				 {
				   	skcetmark=Integer.parseInt(result1.get(i)[5]);
				   	skctmark=Integer.parseInt(result2.get(j)[5]);
				   	if(skcetmark>skctmark)
				    {
				   		record.add(String.join(" - ", result1.get(i)));
				        i++;
				    }
				    else if(skcetmark<skctmark)
				    {
				    	record.add(String.join(" - ", result2.get(j)));
				    	j++;
				    }
				    else
				    {
				    	if((result1.get(i)[0]).compareToIgnoreCase(result2.get(j)[0])<0)
				    	{
				    		record.add(String.join(" - ", result1.get(i)));
					   		i++;
				    	}
				    	else if((result1.get(i)[0]).compareToIgnoreCase(result2.get(j)[0])>0)
				    	{
				     		record.add(String.join(" - ", result2.get(j)));
					   		j++;
				    	}
				    	else
				    	{
				    		record.add(String.join(" - ", result1.get(i)));
					   		i++;
				    	}
				     }
				}
			 }
	        if(numOfcampus==2 || numOfcampus==1)
	        {
		     	while(i<result1.size())
		     	{
			    	record.add(String.join(" - ", result1.get(i)));
			    	i++;
			    }	
	        }
	        if(numOfcampus==2 || numOfcampus==0)
	        {
	        	while(j<result2.size())
			    {
	        		record.add(String.join(" - ", result2.get(j)));
	        		j++;
			    }
	        }
	        int numOfteam=record.size()/numOfperson;
	        TeamSplit.teamsplit=new TreeMap<Integer, ArrayList<String>>();
	        while(position<numOfteam)
			{
				ArrayList<String> a=new ArrayList<String>();
				i=position;j=0;
				while(j<numOfperson)
				{
					a.add(record.get(i));
					i+=numOfteam;
					j++;
				}
		        TeamSplit.teamsplit.put(position+1, a);
		        position++;
			}
			if(record.size()%numOfperson!=0)
			{
				i=record.size()-1;
				j=0;
				ArrayList<String> a=new ArrayList<String>();
				while(j<record.size()%numOfperson)
				{
					a.add(record.get(i));
					i--;
					j++;
				}
				TeamSplit.teamsplit.put(numOfteam+1, a);
			}
			TeamSplit.noOfStudent=record.size();
		}
		catch(Exception e){System.out.println(e);}
	}
	
	public void createPdf(String filename)
	{
		Document  doc=new Document();
		try
		{
			PdfWriter.getInstance(doc, new FileOutputStream(filename));
			doc.open();	  
		    PdfPTable table =new PdfPTable(4);
		    PdfPCell c1;
		    String a[]={"S No","Email ID","Name","Team"};
		    for(String i:a)
		    {
		    	 c1=new PdfPCell(new Phrase(i));
		    	 table.addCell(c1);
		    }
		    int num=1;
		    for(Map.Entry<Integer,ArrayList<String>> m:TeamSplit.teamsplit.entrySet()){    
			       String S_No="";
			       String Email_ID="";
			       String Name="";
			       String team="      "+"\n\n\n"+String.valueOf(m.getKey());
			       for(String j:m.getValue())
			       {
			    	  String temp[]=j.split("\\-");
			    	  S_No+=num+"\n\n\n";
			    	  Email_ID+=temp[3].trim()+"\n\n";
			    	  Name+=temp[0]+"\n\n\n";
			    	  num++;
			       }
			   	   table.addCell(S_No);
			   	   table.addCell(Email_ID);
			   	   table.addCell(Name);
			   	   table.addCell(team);
			 }	  
		    doc.add(table);
		    doc.close();
		}
		catch(Exception e){System.out.println(e);}	
	}
	public JFrame changeTeamMember()
	{
		 JFrame frame = new JFrame();
		 ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	     JLabel label=new JLabel(icon);
		 frame.setBounds(180, 30, 1010, 600);   
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
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
		 
		 JTextField textField_1=new JTextField();
		 textField_1.setBounds(200, 450, 60, 30);
		 textField_1.setFont(new Font("Arial Black",Font.BOLD,18));
		 textField_1.setForeground(new Color(0,0,0));
		 
		 JButton button_2=new JButton("From");
		 button_2.setBounds(180, 500, 100, 30);
		 
		 JPanel Panel_2=new JPanel();
		 Panel_2.setBounds(565, 70, 400, 350);
		 Panel_2.setBackground(new Color(255,255,255));
		 Panel_2.setLayout(null);
		 
		 x=0;
		 JLabel label_2[]=new JLabel[11];
		 for(int i=0;i<11;i++)
		 {
			 label_2[i]=new JLabel();
			 label_2[i].setBounds(10,10+x , 400, 25);
			 x+=30;
			 Panel_2.add(label_2[i]);
		 }
		 
		 JTextField textField_2=new JTextField();
		 textField_2.setBounds(735, 450, 60, 30);
		 textField_2.setFont(new Font("Arial Black",Font.BOLD,18));
		 textField_2.setForeground(new Color(0,0,0));
		 
		 JTextField textField_3=new JTextField();
		 textField_3.setBounds(380, 450, 260, 30);
		 textField_3.setFont(new Font("Arial Black",Font.BOLD,18));
		 textField_3.setForeground(new Color(0,0,0));

		 JLabel label_3=new JLabel("EmailID");
		 label_3.setBounds(450, 500, 100, 30);
		 label_3.setForeground(new Color(255,255,255));
		 label_3.setFont(new Font("Arial Black",Font.BOLD,18));
		 
		 JButton button_3=new JButton("To");
		 button_3.setBounds(715, 500, 100, 30);
		 
		 JButton button_4=new JButton("Change");
		 button_4.setBounds(450, 250, 100, 30);
		 
		 JButton button_1=new JButton("Home");
		 button_1.setBounds(880, 20, 70, 20); 
		  
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
				ArrayList<String[]> a=new DatabaseWork().teamdetails(Integer.parseInt(textField_1.getText()), 1);
				int noOfLabel=0;
				for(String i[]:a)
				{
					label_1[noOfLabel].setText(textField_1.getText()+" - "+i[0]+" - "+i[1]);					
					noOfLabel++;
				}
			}
		});
		 
		 button_3.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String[]> a=new DatabaseWork().teamdetails(Integer.parseInt(textField_2.getText()), 1);
				int noOfLabel=0;
				for(String i[]:a)
				{
					label_2[noOfLabel].setText(textField_2.getText()+" - "+i[0]+" - "+i[1]);					
					noOfLabel++;
				}
			}
		});
		 
		 button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String[]> a=new DatabaseWork().teamdetails(Integer.parseInt(textField_1.getText()), 1);
				ArrayList<String[]> b=new DatabaseWork().teamdetails(Integer.parseInt(textField_2.getText()), 1);
				int noOfLabel=0;
				String add="";
				for(String i[]:a)
				{
					if(i[0].contains(textField_3.getText()))
					{
						add=textField_2.getText()+" - "+i[0]+" - "+i[1];
						label_1[noOfLabel].setText("");
					}
					else
					{
						label_1[noOfLabel].setText(textField_1.getText()+" - "+i[0]+" - "+i[1]);						
					}
					noOfLabel++;
				}
				 noOfLabel=0;
				for(String i[]:b)
				{
					label_2[noOfLabel].setText(textField_2.getText()+" - "+i[0]+" - "+i[1]);					
					noOfLabel++;
				}
				label_2[noOfLabel].setText(add);
				new DatabaseWork().changeTeam(textField_3.getText(), Integer.parseInt(textField_2.getText()));
			}
		});
		 
		 label.add(button_1);
		 label.add(Panel_1);
		 label.add(textField_1);
		 label.add(button_2);
		 label.add(button_4);
		 label.add(Panel_2);
		 label.add(textField_2);
		 label.add(button_3);
		 label.add(textField_3);
		 label.add(label_3);
		 frame.add(label);
		 frame.setVisible(true);
		 return frame;
	}
	
	public static void main(String args[])
	{
		new TeamSplit().changeTeamMember(); 
	}
}
