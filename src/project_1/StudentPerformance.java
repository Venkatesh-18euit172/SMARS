package project_1;

import java.util.Calendar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentPerformance {
	
	public JLabel[] LabelInitialize(String s[])
	{
	   JLabel label[]=new JLabel[5];
	   int c[][]={{130, 180, 550, 30},{90, 350, 100, 30},{110, 380, 100, 30},{400, 600, 100, 30}}; 
	   for(int i=0;i<4;i++)
	   {
		   label[i]=new JLabel(s[i]);
		   label[i].setFont(new Font("Arial Black",Font.BOLD,18));
		   label[i].setBounds(c[i][0], c[i][1], c[i][2], c[i][3]);
	   }
		return label;
	}
	
	public JFrame createPerformance(String s,boolean flag) {
	
		JFrame frame=new JFrame(s);
		frame.setBounds(200, 10, 800, 700);
		frame.setBackground(Color.cyan);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JButton button_1=new JButton("Home");
		button_1.setBounds(710, 10 , 80, 25);
		button_1.setBackground(Color.GREEN);
		
		String name;
		if(s.equals("Overall Performance"))
			name=s;
		else
			name=s.substring(0, 9).toUpperCase();
		JLabel label_1=new JLabel(name);
		label_1.setForeground(Color.RED);
		label_1.setBounds(320, 0, 200, 25);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_2=new JLabel("Choose for broad view");
		label_2.setBounds(70, 40, 180, 25);
		label_2.setFont(new Font("Times of Roman",Font.ITALIC,17));
		
		String s1[]={"Weekly","Monthly","Yearly"};
		JComboBox<String> choice_1=new JComboBox<String>(s1);
		choice_1.setBounds(250, 40, 70, 30);
		choice_1.setBackground(Color.white);
		choice_1.setForeground(Color.BLACK);
		
		JLabel label_3=new JLabel("Choose Month");
		label_3.setBounds(340, 40, 110, 25);
		label_3.setFont(new Font("Times of Roman",Font.ITALIC,17));
		
		String s2[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		JComboBox<String> choice_2=new JComboBox<String>(s2);
		choice_2.setBounds(460, 40, 100, 30);
		choice_2.setBackground(Color.white);
		choice_2.setForeground(Color.BLACK);
		LocalDate currentdate=LocalDate.now();
		choice_2.setSelectedItem(s2[currentdate.getMonthValue()-1]);

		JLabel label_4=new JLabel("Choose Year");
		label_4.setBounds(580, 40, 110, 25);
		label_4.setFont(new Font("Times of Roman",Font.ITALIC,17));
		
		String s3[]={"3","4"};
		JComboBox<String> choice_3=new JComboBox<String>(s3);
		choice_3.setBounds(690, 40, 40, 30);
		choice_3.setBackground(Color.white);
		choice_3.setForeground(Color.BLACK);

		JLabel label_5=new JLabel("Choose Week");
		label_5.setBounds(150, 100, 110, 25);
		label_5.setFont(new Font("Times of Roman",Font.ITALIC,17));
		
		String last_added_week="1";
		String s4[]={"1","2","3","4","5"};
		JComboBox<String> choice_4=new JComboBox<String>(s4);
		choice_4.setBounds(275, 100, 50, 30);
		choice_4.setBackground(Color.white);
		choice_4.setForeground(Color.BLACK);
		choice_4.setSelectedItem(last_added_week);
		
		JLabel label_6=new JLabel("Click here to View");
		label_6.setBounds(400, 100, 140, 25);
		label_6.setFont(new Font("Times of Roman",Font.ITALIC,17));
		JButton button_2=new JButton("VIEW");
		button_2.setBounds(550, 100, 70, 30);
		button_2.setBackground(new Color(255,80,0));
		button_2.setForeground(Color.BLACK);

		String SelectedItem[]={(String) choice_2.getSelectedItem(),(String) choice_3.getSelectedItem(),(String)choice_4.getSelectedItem()};
		JPanel panel=new WeeklyPerformance().createWeek("",SelectedItem);
		
		if(!(s.equals("Overall Performance")))
		{
			JButton	button_3=new JButton("Profile");
			button_3.setBounds(660, 90 , 100, 30);
		    button_3.setBackground(new Color(240, 168, 12));
			button_3.setForeground(Color.BLACK);

			frame.add(button_3);
			
			button_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			
					new StudentProfile().createProfile(s);
				}
			});
		}
		
		if(flag)
			frame.add(button_1);//Home
		frame.add(label_1);//Overall Performance
		frame.add(label_2);//Choose for broad view
		frame.add(choice_1);//{Weekly,Monthly,Yearly}
		frame.add(label_3);//Choose Month
		frame.add(choice_2);//{JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC};
		frame.add(label_4);//Choose Year
		frame.add(choice_3);//{3,4}
		frame.add(label_5);//Choose Week
		frame.add(choice_4);//{1,2,3,4,5}
		frame.add(label_6);//Click here to View
		frame.add(button_2);//View
		frame.add(panel);//Bar Graph Panel
		
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
				if(choice_1.getSelectedItem().equals("Weekly"))
				{
					JFrame frame=new JFrame();
					frame.setBounds(195, 15, 835, 710);
					frame.setBackground(Color.cyan);
					
					String SelectedItem[]={(String) choice_2.getSelectedItem(),(String) choice_3.getSelectedItem(),(String)choice_4.getSelectedItem()};
					
					JPanel panel;
					if(s.equals("Overall Performance"))
						panel=new WeeklyPerformance().createWeek("",SelectedItem);
					else
						panel=new WeeklyPerformance().createWeek(s, SelectedItem);
						
					frame.add(panel);
					frame.setVisible(true);
				}
				else if(choice_1.getSelectedItem().equals("Monthly"))
				{
					int month=0;
					String s4=(String) choice_2.getSelectedItem();
					for(String i:s2)
					{
						if(i.equals(s4))
							break;
						month++;
					}
					Calendar cal = Calendar.getInstance();
				    cal.set(Calendar.YEAR, 2020);
				    cal.set(Calendar.MONTH,month );
				    cal.set(Calendar.DAY_OF_MONTH, 1);
		            String s5=(String) choice_2.getSelectedItem()+"_"+(String) choice_3.getSelectedItem();
                    int a=5;
                    if(s4.equals("FEBRUARY") && cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
                    	a=4;
                    JFrame frame=new JFrame();
					frame.setBounds(195, 15, 835, 710);
					frame.setBackground(Color.cyan);
					
					JPanel panel;
					if(s.equals("Overall Performance"))
						panel=new MonthlyPerformance().createMonth(s5, a,"");
					else
						panel=new MonthlyPerformance().createMonth(s5, a, s);
                    frame.add(panel);
                    frame.setVisible(true);
				}
				else
				{
					JFrame frame=new JFrame();
					frame.setLayout(null);
					frame.setBounds(195, 15, 870, 710);
					frame.getContentPane().setBackground(Color.cyan);
					
					JPanel panel;
					if(s.equals("Overall Performance"))
						panel=new YearlyPerformance().createYear(0, 6,(String) choice_3.getSelectedItem(),"");
					else
						panel=new YearlyPerformance().createYear(0, 6,(String) choice_3.getSelectedItem() , s);

					panel.setSize(825, 700);
			        
			        JButton button=new JButton("Click to view JUL-DEC"); 
			        button.setBounds(320, 50, 220, 50);
			        button.setBackground(new Color(255,80,0));
			        button.setForeground(Color.WHITE);
			        button.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,17));
			        
			        frame.add(panel);
			        frame.add(button);
			        frame.setVisible(true);

			        button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							frame.dispose();
							JFrame frame=new JFrame();
							frame.setLayout(null);
							frame.setBounds(195, 15, 870, 710);
							frame.getContentPane().setBackground(Color.cyan);
							
							JPanel panel;
							if(s.equals("Overall Performance"))
								panel=new YearlyPerformance().createYear(6, 12,(String) choice_3.getSelectedItem(),"");
							else
								panel=new YearlyPerformance().createYear(6, 12,(String) choice_3.getSelectedItem() , s);
							
							panel.setSize(825, 700);
					        frame.add(panel);
					        frame.setVisible(true);
						}
					});
				}
			}
		});
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame getEmailID()
	{
		JFrame frame=new JFrame("S M A R S-Individual form");
		frame.setBounds(180, 30, 1010, 600);   
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);

		JLabel label_1=new JLabel("Email ID");
		label_1.setBounds(345, 250, 150, 30);
    	label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		
		JTextField textField_1=new JTextField();
		textField_1.setBounds(500, 250, 210, 40);
		JLabel validation_1=new JLabel();
		validation_1.setBounds(770,250,150,20);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD,18));
		textField_1.setForeground(Color.BLACK);

		JButton button_2=new JButton("View");
		button_2.setBounds(450, 370, 100, 40);
		button_2.setForeground(Color.BLACK);

		frame.add(label);
		label.add(button_1);//home
		label.add(label_1);//Email ID
		label.add(textField_1);//____
	//	label.add(validation_1);
		label.add(button_2);//Delete

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
					validation_1.setText("Invalid EmailID");
				}
				else
				{
					validation_1.setForeground(Color.BLACK);
					validation_1.setText("Valid EmailID");					
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
				createPerformance(textField_1.getText(),true);
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
		return frame;
	}
}
