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
import javax.swing.JTextField;

public class StudentDelete {

	public JFrame createDelete()
	{
		JFrame frame=new JFrame("S M A R S-Delete form");
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
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

		JButton button_2=new JButton("Delete");
		button_2.setBounds(450, 370, 100, 40);
		button_2.setForeground(Color.BLACK);

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
				new DatabaseWork().deleteValue(textField_1.getText());
				JOptionPane.showMessageDialog(button_2,"Successfully Deleted");
				textField_1.setText(null);
				validation_1.setText(null);
			}
		});
		
		frame.setVisible(true);
		return frame;
	}
}