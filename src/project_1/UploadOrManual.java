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

public class UploadOrManual {

	public JFrame createUploadOrManual(int fieldID)
	{
	    JFrame frame=new JFrame();
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(800, 40 , 70, 20);
	
		ImageIcon img_1=new ImageIcon(new ImageIcon("D:\\image\\upload.jpg").getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH));
	    JButton button_2=new JButton(img_1);
	    button_2.setBounds( 300, 225, 150, 60);
	    button_2.setBackground(null);
		button_2.setForeground(Color.BLACK);

		JLabel label_1=new JLabel("Upload file");
		label_1.setBounds(315, 280, 200 , 40);
		label_1.setBackground(null);
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_2=new JLabel("or");
		label_2.setBounds(490, 225 , 80 , 40);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		ImageIcon img_2=new ImageIcon(new ImageIcon("D:\\image\\Manual.png").getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH));
		JButton button_3=new JButton(img_2);
	    button_3.setBounds( 550, 225, 150, 60);
	    button_3.setBackground(null);
		button_3.setForeground(Color.BLACK);

		JLabel label_3=new JLabel("Enter Manually");
		label_3.setBounds(555, 280 , 150 , 30);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		label.add(button_1);//Home
		label.add(button_2);//Upload File
		label.add(label_1);
		label.add(label_2);//or
		label.add(button_3);//Enter Manually
		label.add(label_3);
		
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
			    frame.dispose();
			    if(fieldID==4)
			    	new UploadTrackRecord().createUploadTrackRecord();
			    else
			    	createUpload(fieldID);
			}
		});

		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				switch(fieldID)
				{
					case 1:new StudentRegistration().createRegistration(null, false);break;
					case 2:new StudentUpdate().createUpdate();break;
					case 3:new StudentDelete().createDelete();break;
					case 4:new UploadTrackRecord().createManual();break;
					default:break;
				}
			}
		});
		
		frame.setVisible(true);
	    return frame;
	}
	
	public JFrame createUpload(int fieldID)
	{
		JFrame frame=new JFrame();
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\image\\A.jpeg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(180, 30, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(820, 40 , 70, 20);

		ImageIcon img_1=new ImageIcon(new ImageIcon("D:\\image\\upload.jpg").getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH));
	    JButton button_2=new JButton(img_1);
		button_2.setBounds(440, 200 , 150, 60);
		button_2.setBackground(Color.MAGENTA);
		
		JLabel label_1=new JLabel("Upload excel file");
		label_1.setBounds(440, 270 , 150 , 30);
		label_1.setForeground(new Color(255,255,255));
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		String a[]={"Add Students","Update Students","Delete Students"};
		JButton button_3=new JButton(a[fieldID-1]);
		button_3.setBounds(440, 370 , 150, 40);
				
		String b[]={"Student data is Successfully added","Student details is Successfully updated","Student data is deleted"};
		
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
			    	Batch.flag=1;
			    	try
			    	{
			    		DatabaseWork obj=new DatabaseWork();
			    		if(fieldID==1)
				    	{
				    		obj.excelToDBCreate(fileChooser.getSelectedFile().getPath(), AdminHomePage.batchyear, false);
				    	}	
			    		else if(fieldID==2)
			    		{
			    			obj.excelToDBUpdate(fileChooser.getSelectedFile().getPath());
			    		}
			    		else if(fieldID==3)
			    		{
			    			obj.deletefromDB(fileChooser.getSelectedFile().getPath());
			    		}
			    	}
			    	catch(Exception e){}
			    }
			    else
			    	Batch.flag=0;
			}			
		});
		
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Batch.flag==0)
					JOptionPane.showMessageDialog(button_2, "Upload the file");
				else
					JOptionPane.showMessageDialog(button_3, b[fieldID-1]);
			}
		});
		
		label.add(button_1);
		label.add(button_2);
		label.add(button_3);
		label.add(label_1);
		
        frame.setVisible(true);		
		return frame;
	}
}