package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Batch {

	static int flag;
	
	public JFrame createNewBatch()
	{
		JFrame frame=new JFrame();
		frame.setBounds(240, 100, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);
	
		JLabel label_1=new JLabel("Enter New Batch Year");
		label_1.setBounds(360 , 210  , 200 , 40);
		label_1.setBackground(new Color(240, 168, 12));
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JTextField text_1=new JTextField();
		text_1.setBounds(580, 210 , 80 , 40);
		text_1.setBackground(Color.WHITE);
		text_1.setForeground(Color.BLACK);
		text_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JButton button_2=new JButton("Upload Excel file");
		button_2.setBounds(420, 280 , 150, 40);
		button_2.setForeground(new Color(0,0,0));
		
		JButton button_3=new JButton("Submit");
		button_3.setBounds(440, 360 , 100, 40);
		button_3.setForeground(new Color(0,0,0));

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
				JFileChooser fileChooser=new JFileChooser("C:\\Excel");	
			    if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION && !text_1.getText().equals(""))
			    {
			    	Batch.flag=1;
			    	try
			    	{
			    		new DatabaseWork().excelToDBCreate(fileChooser.getSelectedFile().getPath(),text_1.getText(),true);
			    	}
			    	catch(Exception e){}
			    }
			    else if(text_1.getText().equals(""))
			    {
			    	JOptionPane.showMessageDialog(text_1, "Enter the Batch Year");
			    }
			    else
			    {
			    	Batch.flag=0;
			    }
			}			
		});
		
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(text_1.getText().equals(""))
					JOptionPane.showMessageDialog(text_1, "Enter the Batch Year");
				else if(Batch.flag==0)
					JOptionPane.showMessageDialog(button_2, "Upload a file");
				else
				{
					text_1.setText(" ");
					JOptionPane.showMessageDialog(button_3, "New Batch is Successfully Created!!!");
				}
			}
		});
		
		frame.add(label_1);
		frame.add(text_1);
		frame.add(button_1);
		frame.add(button_2);
		frame.add(button_3);
		frame.add(label);
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame deleteExistBatch()
	{
		JFrame frame=new JFrame();
		frame.setBounds(240, 100, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);

		JLabel label_1=new JLabel("Enter Batch Year");
		label_1.setBounds(360 , 210  , 200 , 40);
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JTextField text_1=new JTextField();
		text_1.setBounds(580, 210 , 80 , 40);
		text_1.setForeground(Color.BLACK);
		text_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JButton button_2=new JButton("Delete");
		button_2.setBounds(420, 280 , 150, 40);
		button_2.setForeground(new Color(0,0,0));
	
				
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
				new DatabaseWork().deleteExistBatch(text_1.getText());
				text_1.setText(" ");
				JOptionPane.showMessageDialog(button_2, "Batch "+text_1.getText()+" is Successfully deleted");
			}			
		});
		
		frame.add(label_1);
		frame.add(text_1);
		frame.add(button_1);
		frame.add(button_2);
		frame.add(label);
		frame.setVisible(true);
		return frame;
	}
	
	public static void main(String args[])
	{
		new Batch().deleteExistBatch();
	}
}