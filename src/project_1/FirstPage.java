package project_1;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FirstPage {
	
	public static String batchyear; 
	
	public JFrame createFrontForm ()
	{
		JFrame frame=new JFrame();
		frame.setTitle("S M A R S");
		frame.setBounds(240, 100, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JButton button_1=new JButton("Student");
		button_1.setBounds(230, 280 , 150 , 50);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,18));

		JLabel label_1=new JLabel("or");
		label_1.setBounds(510, 280 , 50 , 50);
		label_1.setBackground(new Color(240, 168, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times of Roman",Font.BOLD,18));
	
		JButton button_2=new JButton("Admin");
		button_2.setBounds(650, 280 , 150 , 50);
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,18));

		JLabel label_2=new JLabel("Enter the Batch");
		label_2.setBounds(450, 340 , 200 , 50);
		label_2.setBackground(new Color(240, 168, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JTextField text_1=new JTextField();
		text_1.setBounds(440, 400 , 150 , 30);
		text_1.setBackground(Color.WHITE);
		text_1.setForeground(Color.BLACK);
		text_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		ImageIcon img_1=new ImageIcon(new ImageIcon("D:\\image\\SMARS.jpeg").getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH));
		ImageIcon img_2=new ImageIcon(new ImageIcon("D:\\image\\Student.png").getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		ImageIcon img_3=new ImageIcon(new ImageIcon("D:\\image\\Admin.png").getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
		
		JLabel label_3=new JLabel();
		label_3.setIcon(img_1);
		label_3.setBounds(20, -5, 150, 130);
		
		JLabel label_4=new JLabel();
		label_4.setIcon(img_2);
		label_4.setBounds(250, 170, 100, 100);
		
		JLabel label_5=new JLabel();
		label_5.setIcon(img_3);
		label_5.setBounds(680, 175, 100, 100);
		
		JLabel label_6=new JLabel("SMARS ");
		label_6.setBounds(460, 25, 250, 40);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial Black",Font.BOLD,30));
		JLabel label_7=new JLabel("STUDENT  MARK  ANALYSIS");
		label_7.setBounds(300, 70, 3400, 40);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial Black",Font.BOLD,26));
		JLabel label_8=new JLabel("REPORT  SERVICE");
		label_8.setBounds(380, 110, 3400, 40);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial Black",Font.BOLD,26));
		
		label.add(button_1);//Student
		label.add(label_1);//or
		label.add(button_2);//Admin
		
		
		
		label.add(label_2);//Enter the batch
		label.add(text_1);//__________
		label.add(label_3);
		label.add(label_4);
		label.add(label_5);
		label.add(label_6);
	    label.add(label_7);	 
	    label.add(label_8);
	    
		//Student Selected
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
					JOptionPane.showMessageDialog(text_1, "Batch is mandatory");
				else
				{
					FirstPage.batchyear=text_1.getText();
					frame.dispose();
				    new Login().createStudentLogin(); 		
				}
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login().createAdminLogin();
			}
		});
		
		frame.setVisible(true);
		return frame;
	}
	
	public static void main(String args[]) {
		new FirstPage().createFrontForm();
	}
}