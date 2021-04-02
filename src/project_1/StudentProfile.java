package project_1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentProfile {

	public JFrame createProfile(String emailID)
	{		
		String details[]=new DatabaseWork().getValue(emailID);
	
		JFrame frame=new JFrame("S M A R S- Student Profile");
		frame.setLayout(null);
		frame.setBounds(100,10,1010, 580);
     	frame.setFont(new Font("Times Of Roman", Font.BOLD,12));
     	frame.setResizable(false);
				    
		JButton button_1=new JButton("Home");
		button_1.setBounds(900, 10 , 90, 30);
		button_1.setBackground(Color.GREEN);

		JPanel panel_1=new JPanel();
		panel_1.setBackground(Color.cyan);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 500, 550);

			JLabel label_1=new JLabel("STUDENT DETAILS");
			label_1.setBounds(150 , 0, 200 , 30);	
			
			JLabel label_2=new JLabel("Student Name :");
			JLabel label_2_value=new JLabel(details[0]);
			label_2_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_2_value.setForeground(Color.RED);
			label_2.setBounds(50, 40, 100, 30);
			label_2_value.setBounds(210, 40, 150, 25);
						
			JLabel label_3=new JLabel("Register No :");
			JLabel label_3_value=new JLabel(details[1]);
			label_3_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_3_value.setForeground(Color.RED);
			label_3.setBounds(50, 80, 100, 30);
			label_3_value.setBounds(210, 80, 150, 25);
			
			JLabel label_4=new JLabel("DOB");
			JLabel label_4_value=new JLabel(details[2]);
			label_4_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_4_value.setForeground(Color.RED);
			label_4.setBounds(50, 120, 120, 30);
			label_4_value.setBounds(210, 120, 100, 25);
			
			JLabel label_5=new JLabel("Gender");
			JLabel label_5_value=new JLabel(details[3]);
			label_5_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_5_value.setForeground(Color.RED);
			label_5.setBounds(50, 160, 80, 30);
			label_5_value.setBounds(210, 160, 80, 30);

			JLabel label_6=new JLabel("Department");
			JLabel label_6_value=new JLabel(details[4]);
			label_6_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_6_value.setForeground(Color.RED);
			label_6.setBounds(50, 200, 80, 30);
			label_6_value.setBounds(210 , 200 , 200, 30 );
			
			JLabel label_7=new JLabel("College Email ID");
			JLabel label_7_value=new JLabel(details[5]);
			label_7_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_7_value.setForeground(Color.RED);
			label_7.setBounds(50, 240, 150, 30);
			label_7_value.setBounds(210, 235 ,245, 40);

			JLabel label_8=new JLabel("Campus");
			JLabel label_8_value=new JLabel(details[6]);
			label_8_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_8_value.setForeground(Color.RED);
			label_8_value.setBounds(210, 280, 80, 30);
			label_8.setBounds(50, 280, 150, 30);

			JLabel label_9=new JLabel("Student Mobile No");
			JLabel label_9_value=new JLabel(details[7]);
			label_9_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_9_value.setForeground(Color.RED);
			label_9.setBounds(50, 320, 150, 30);
			label_9_value.setBounds(210, 320, 100, 25);

			JLabel label_10=new JLabel("Other Mobile No");
			JLabel label_10_value=new JLabel(details[8]);
			label_10_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_10_value.setForeground(Color.RED);
			label_10.setBounds(50, 360, 150, 30);
			label_10_value.setBounds(210, 360, 100, 25);
		
			JLabel label_11=new JLabel("Student Type");
			label_11.setBounds(50, 400, 80, 30);
			JLabel label_11_value=new JLabel(details[9]);
			label_11_value.setBounds(210, 400, 100, 30);
			label_11_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_11_value.setForeground(Color.RED);
			
			JLabel label_12=new JLabel("Current CGPA in %");
			JLabel label_12_value=new JLabel(details[10]);
			label_12.setBounds(50, 440, 110, 30);
			label_12_value.setBounds(210, 440, 100, 25);
			label_12_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_12_value.setForeground(Color.RED);
			
			JLabel label_13=new JLabel("No of Arrear");
			JLabel label_13_value=new JLabel(details[11]);
			label_13.setBounds(50, 480, 100, 30);
			label_13_value.setBounds(210, 480, 100, 25);
			label_13_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_13_value.setForeground(Color.RED);
			
			JLabel label_14=new JLabel("Coding Level");
			JLabel label_14_value=new JLabel(details[12]);
			label_14_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
			label_14_value.setForeground(Color.RED);
			label_14.setBounds(50, 520, 80, 20);
			label_14_value.setBounds(210, 520, 100, 20);
		
			panel_1.add(label_1);//Student Details	
			panel_1.add(label_2);//Student Name
			panel_1.add(label_2_value);
			panel_1.add(label_3);//Register Number
			panel_1.add(label_3_value);
			panel_1.add(label_4);//DOB
			panel_1.add(label_4_value);
			panel_1.add(label_5);//Gender
			panel_1.add(label_5_value);
			panel_1.add(label_6);//Department
			panel_1.add(label_6_value);
			panel_1.add(label_7);//College Email ID
			panel_1.add(label_7_value);
			panel_1.add(label_8);//Campus
			panel_1.add(label_8_value);
			panel_1.add(label_9);//Student Mobile No
			panel_1.add(label_9_value);
			panel_1.add(label_10);//Other Mobile No
			panel_1.add(label_10_value);
			panel_1.add(label_11);//Student type
			panel_1.add(label_11_value);
			panel_1.add(label_12);//Current CGPA
			panel_1.add(label_12_value);
			panel_1.add(label_13);//No of Arrear
			panel_1.add(label_13_value);
			panel_1.add(label_14);//Coding Level
			panel_1.add(label_14_value);//Low
			
		JPanel panel_2=new JPanel();
		panel_2.setBackground(Color.orange);
		panel_2.setLayout(null);
		panel_2.setBounds(500, 0, 510, 550);
			
				JLabel label_15=new JLabel("PERSONAL DETAILS");
				label_15.setBounds(150 , 0, 150 , 30);
				
				JLabel label_16=new JLabel("Father Name ");
				JLabel label_16_value=new JLabel(details[13]);
				label_16_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_16_value.setForeground(new Color(39, 138, 17));
				label_16.setBounds(50, 40, 100, 30);
				label_16_value.setBounds(210, 40, 150, 25);
		
				JLabel label_17=new JLabel("Father's Occupation");
				JLabel label_17_value=new JLabel(details[14]);
				label_17_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_17_value.setForeground(new Color(39, 138, 17));
				label_17.setBounds(50, 80, 150, 30);
				label_17_value.setBounds(210, 80, 150, 25);
				
				JLabel label_18=new JLabel("Father's Mobile No");
				JLabel label_18_value=new JLabel(details[15]);
				label_18_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_18_value.setForeground(new Color(39, 138, 17));
				label_18.setBounds(50, 120, 150, 30);
				label_18_value.setBounds(210, 120, 100, 25);
		
				JLabel label_19=new JLabel("Mother Name");
				JLabel label_19_value=new JLabel(details[16]);
				label_19_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_19_value.setForeground(new Color(39, 138, 17));
				label_19.setBounds(50, 160, 100, 30);
				label_19_value.setBounds(210, 160, 150, 25);
				
				JLabel label_20=new JLabel("Mother's Occupation");
				JLabel label_20_value=new JLabel(details[17]);
				label_20_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_20_value.setForeground(new Color(39, 138, 17));
				label_20.setBounds(50, 200, 150, 30);
				label_20_value.setBounds(210, 200, 150, 25);
			
				JLabel label_21=new JLabel("Mother's Mobile No");
				JLabel label_21_value=new JLabel(details[18]);
				label_21_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_21_value.setForeground(new Color(39, 138, 17));
				label_21.setBounds(50, 240, 150, 30);
				label_21_value.setBounds(210, 240, 100, 25);
				
				JLabel label_22=new JLabel("Address");
				JLabel label_22_value=new JLabel(details[19]);
				label_22_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_22_value.setForeground(new Color(39, 138, 17));
				label_22.setBounds(50, 280, 100, 30);
				label_22_value.setBounds(210, 280, 200, 50);
				
				JLabel label_23=new JLabel("Pincode");
				JLabel label_23_value=new JLabel(details[20]);
				label_23_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_23_value.setForeground(new Color(39, 138, 17));
				label_23.setBounds(50, 340, 80, 30);
				label_23_value.setBounds(210, 340, 100, 25);
			
				JLabel label_24=new JLabel("District");
				label_24.setBounds(50, 380, 80, 30);
				JLabel label_24_value=new JLabel(details[21]);
				label_24_value.setBounds(210, 380, 150, 25);
				label_24_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_24_value.setForeground(new Color(39, 138, 17));
			
				JLabel label_25=new JLabel("State");
				label_25.setBounds(50, 420, 80, 30);
				JLabel label_25_value=new JLabel(details[22]);
				label_25_value.setBounds(210, 420, 150, 25);
				label_25_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_25_value.setForeground(new Color(39, 138, 17));
				
			    JLabel label_26=new JLabel("10th mark in %");
				JLabel label_26_value=new JLabel(details[23]);
				label_26_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_26_value.setForeground(new Color(39, 138, 17));
				label_26.setBounds(50, 460, 150, 30);
				label_26_value.setBounds(210, 460, 80, 25);
				
				JLabel label_27=new JLabel("12th mark in %");
				JLabel label_27_value=new JLabel(details[24]);
				label_27.setBounds(50, 500, 150, 30);
				label_27_value.setBounds(210, 500, 80, 25);
				label_27_value.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,15));
				label_27_value.setForeground(new Color(39, 138, 17));
				
				panel_2.add(label_15);//Personal Details
				panel_2.add(label_16);//Father Name
				panel_2.add(label_16_value);
				panel_2.add(label_17);//Father's Occupation
				panel_2.add(label_17_value);
				panel_2.add(label_18);//Father's Mobile No
				panel_2.add(label_18_value);
				panel_2.add(label_19);//Mother Name
				panel_2.add(label_19_value);
				panel_2.add(label_20);//Mother's Occupation
				panel_2.add(label_20_value);
				panel_2.add(label_21);//Mother's Mobile number
				panel_2.add(label_21_value);
				panel_2.add(label_22);//Address
				panel_2.add(label_22_value);
				panel_2.add(label_23);//Pincode
				panel_2.add(label_23_value);
				panel_2.add(label_24);//District
				panel_2.add(label_24_value);
				panel_2.add(label_25);//State
				panel_2.add(label_25_value);
				panel_2.add(label_26);//10th Mark in %
				panel_2.add(label_26_value);
				panel_2.add(label_27);//12th Mark in %
				panel_2.add(label_27_value);
				       
		frame.add(panel_1);
		frame.add(panel_2);
	    
	    frame.setVisible(true);
	    return frame;
	}
}
