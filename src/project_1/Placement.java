package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Placement {

	static int mandatoryflag=0;
	public JFrame addPlacedStudent()
	{
		JFrame frame=new JFrame("S M A R S-Placement");
		frame.setBounds(240, 100, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(900, 10 , 70, 20);
		
		JLabel label_1=new JLabel("Email ID");
		label_1.setBounds(260, 150, 100, 30);
		label_1.setFont(new Font("Arial Black",Font.BOLD,20));
		label_1.setForeground(new Color(255,255,255));
		 
		JTextField textField_1=new JTextField();
		textField_1.setBounds(460, 150, 250, 30);
		textField_1.setFont(new Font("Arial Black",Font.BOLD,20));
		textField_1.setForeground(new Color(0,0,0));
		
		JLabel label_2=new JLabel("Company Name");
		label_2.setBounds(260, 240, 200, 30);
		label_2.setFont(new Font("Arial Black",Font.BOLD,20));
		label_2.setForeground(new Color(255,255,255));
		 
		JTextField textField_2=new JTextField();
		textField_2.setBounds(490, 240, 200, 30);
		textField_2.setFont(new Font("Arial Black",Font.BOLD,20));
		textField_2.setForeground(new Color(0,0,0));
		
		JButton button_2=new JButton("Submit");
		button_2.setBounds(530, 330, 100, 30);
		
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
				{
					JOptionPane.showMessageDialog(textField_1, "EmailID is mandatory");
				}
				else
				{
					new DatabaseWork().storePlacement(textField_1.getText(), textField_2.getText());
					JOptionPane.showMessageDialog(button_2, "Placement details is added");		
				}
			}
		});
		
		label.add(button_1);//Home
		label.add(label_1);//Email_ID
		label.add(textField_1);//______
		label.add(label_2);//Company Name
		label.add(textField_2);//______
		label.add(button_2);//Submit
		frame.add(label);
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame placementDetails()
	{
		JFrame frame=new JFrame("S M A R S-Placement");
		frame.setBounds(240, 100, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);
		
		JLabel label_1=new JLabel("Choose Campus :");
		label_1.setBounds(520, 150, 180, 25);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_1.setForeground(Color.white);
		
		JCheckBox checkBox_1=new JCheckBox("SKCET");
		checkBox_1.setBounds(740, 150, 100, 30);
		checkBox_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		checkBox_1.setSelected(true);
		checkBox_1.setBackground(Color.black);
		checkBox_1.setForeground(Color.white);
		
		JCheckBox checkBox_2=new JCheckBox("SKCT");
		checkBox_2.setBounds(890, 150, 100, 30);
		checkBox_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		checkBox_2.setSelected(true);
		checkBox_2.setBackground(Color.black);
		checkBox_2.setForeground(Color.white);
		
		JLabel label_2=new JLabel("File name : ");
		label_2.setBounds(520, 210, 150, 25);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_2.setForeground(Color.white);
		
		JTextField textField_1=new JTextField();
		textField_1.setBounds(740, 210, 180, 30);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_3=new JLabel("Choose Directory: ");
		label_3.setBounds(520, 280, 200, 25);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_3.setForeground(Color.white);
		
		JButton button_2=new JButton("Directory");
		button_2.setBounds(740, 280 , 150, 40);
		
		JButton button_3=new JButton("Download");
		button_3.setBounds(670, 360 , 150, 45);
		button_3.setBackground(null);
		button_3.setForeground(Color.black);
		
		ArrayList<String[]> result=new DatabaseWork().placementDetails("YES", 2);
		JPanel panel=new JPanel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g)
			{		
			    Color color[]={new Color(16, 148, 40),new Color(237, 35, 17)};	
			    g.setColor(Color.WHITE);
			    g.fillRoundRect(10, 10 , 550 , 600, 50, 30);
			    g.setColor(color[0]);
			    int Student_placed=150;//result.size();
			    int Student_notplaced=100;//DatabaseWork.SKCET+DatabaseWork.SKCT-result.size();
			    if(Student_placed>400)
			    	Student_placed=400;
			    if(Student_notplaced>400)
			    	Student_notplaced=400;
			    g.fillRect(140, 450-Student_placed, 130, Student_placed);
			    g.setColor(Color.BLACK);
			    g.drawRect(140, 450-Student_placed, 130, Student_placed);
			    g.setColor(color[1]);
			    g.fillRect(310, 450-Student_notplaced, 130, Student_notplaced);
			    g.setColor(Color.BLACK);
			    g.drawRect(310, 450-Student_notplaced, 130, Student_notplaced);
			    g.setColor(Color.black);
			    g.drawLine(110, 50, 110, 450);
			    g.drawLine(110, 450, 450, 450);
			}		
		};
		panel.setLayout(null);
		panel.setBounds(10, 10, 500, 535);
	    int Student_placed=150;//result.size();
	    int Student_notplaced=100;//DatabaseWork.SKCET+DatabaseWork.SKCT-result.size();
	    if(Student_placed>400)
	    	Student_placed=400;
	    if(Student_notplaced>400)
	    	Student_notplaced=400;
	    JLabel label_4=new JLabel(String.valueOf(Student_placed));
	    label_4.setBounds(180, 420-Student_placed, 100 , 20);
		label_4.setFont(new Font("Arial Black",Font.BOLD,18));
		JLabel label_5=new JLabel("Placed");
		label_5.setBounds(160, 460, 100 , 20);
		label_5.setFont(new Font("Arial Black",Font.BOLD,18));
	    JLabel label_6=new JLabel(String.valueOf(Student_notplaced));
	    label_6.setBounds(370, 420-Student_notplaced, 100 , 20);
		label_6.setFont(new Font("Arial Black",Font.BOLD,18));
		JLabel label_7=new JLabel("Will be Placed");
		label_7.setBounds(315, 460, 180 , 20);
		label_7.setFont(new Font("Arial Black",Font.BOLD,18));
		JLabel	label_8=new JLabel("No of ");
		label_8.setBounds(25, 250, 100, 20);
		label_8.setFont(new Font("Arial Black",Font.BOLD,18));
		JLabel	label_9=new JLabel("Students");
		label_9.setBounds(10, 280, 100, 20);
		label_9.setFont(new Font("Arial Black",Font.BOLD,18));
		panel.add(label_4);
	    panel.add(label_5);
	    panel.add(label_6);
	    panel.add(label_7);
	    panel.add(label_8);
	    panel.add(label_9);
	    
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
			    if(!(checkBox_1.isSelected()) && !(checkBox_2.isSelected()))
					JOptionPane.showMessageDialog(checkBox_2, "Select atleast one year");
				else
				{
					if(textField_1.getText().equals(""))
						JOptionPane.showMessageDialog(textField_1, "File name is mandatory");
					else
					{
						JFileChooser fileChooser=new JFileChooser();
						fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						 if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
						 {
							 int from=3,to=4;
							 if(checkBox_1.isSelected() && !(checkBox_2.isSelected()))
								 to=3;
							 else if(checkBox_1.isSelected() && !(checkBox_2.isSelected()))
								 from=4;
							 Placement.mandatoryflag=1;
					//	 	createTeamPDF(fileChooser.getSelectedFile().getPath()+"\\"+textField_1.getText()+".pdf",from,to); 
						 }			
					}
				}
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int f=0;
				if(textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(textField_1, "File name is mandatory");
					f=1;
				}
				if(Download.mandatoryflag==0)
				{
					JOptionPane.showMessageDialog(button_2, "Directory is mandatory");
					f=1;
				}
				if(f==0)
					JOptionPane.showMessageDialog(button_3, "File "+textField_1.getText()+".pdf is Successfully downloaded");
			}
		});
		
		label.add(panel);
		label.add(label_1);//Choose year
		label.add(checkBox_1);//3
		label.add(checkBox_2);//4
		label.add(label_2);//File Name
		label.add(textField_1);//_____
		label.add(label_3);//Directory
		label.add(button_2);
		label.add(button_1);//Home
        label.add(button_3);//Download
        
		frame.add(label);

		frame.setVisible(true);
		return frame;
	}
	
	
}
