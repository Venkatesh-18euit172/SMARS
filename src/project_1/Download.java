package project_1;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Download {

	static int sum=0,numOfcampus=2,from=3,to=4,mandatoryflag=0;
	static int noOfStudent[]=new int[5];
	
	public JFrame createCategorywiseDownload()
	{
		JFrame frame=new JFrame();
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
	    JLabel label=new JLabel(icon);
		frame.setBounds(240, 100, 1010, 600);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);

		JLabel label_1=new JLabel("Category");
		label_1.setBounds(40, 80, 100, 30);
		label_1.setBackground(new Color(240, 168, 12));
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JLabel label_2=new JLabel("No of Students");
		label_2.setBounds(180, 80, 150, 30);
		label_2.setBackground(new Color(240, 168, 12));
		label_2.setForeground(Color.white);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_3=new JLabel("Choose");
		label_3.setBounds(360, 80, 100, 30);
		label_3.setBackground(new Color(240, 168, 12));
		label_3.setForeground(Color.white);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JLabel label_4=new JLabel("A");
		label_4.setBounds(50, 140, 50, 50);
		label_4.setForeground(new Color(100, 122, 46));
		label_4.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD+Font.CENTER_BASELINE,40));

		JLabel label_5=new JLabel("B");
		label_5.setBounds(50, 200, 50, 50);
		label_5.setForeground(new Color(7, 173, 15));
		label_5.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD+Font.CENTER_BASELINE,40));
		
		JLabel label_6=new JLabel("C");
		label_6.setBounds(50, 260, 50, 50);
		label_6.setForeground(Color.YELLOW);
		label_6.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD+Font.CENTER_BASELINE,40));

		JLabel label_7=new JLabel("D");
		label_7.setBounds(50, 320, 50, 50);
		label_7.setForeground(new Color(250, 205, 2));
		label_7.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD+Font.CENTER_BASELINE,40));

		JLabel label_8=new JLabel("X");
		label_8.setBounds(50, 380, 50, 50);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD+Font.CENTER_BASELINE,40));

		Download.noOfStudent=noOfStudent(2, 3, 4);
		JLabel label_9=new JLabel(String.valueOf(Download.noOfStudent[0]));
		label_9.setBounds(210, 140, 50, 50);
		label_9.setForeground(new Color(100, 122, 46));
		label_9.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,40));

		JLabel label_10=new JLabel(String.valueOf(Download.noOfStudent[1]));
		label_10.setBounds(210, 200, 50, 50);
		label_10.setForeground(new Color(7, 173, 15));
		label_10.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,40));
		
		JLabel label_11=new JLabel(String.valueOf(Download.noOfStudent[2]));
		label_11.setBounds(210, 260, 50, 50);
		label_11.setForeground(Color.YELLOW);
		label_11.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,40));

		JLabel label_12=new JLabel(String.valueOf(Download.noOfStudent[3]));
		label_12.setBounds(210, 320, 50, 50);
		label_12.setForeground(new Color(250, 205, 2));
		label_12.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,40));

		JLabel label_13=new JLabel(String.valueOf(Download.noOfStudent[4]));
		label_13.setBounds(210, 380, 50, 50);
		label_13.setForeground(Color.RED);
		label_13.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,40));
		
		JCheckBox checkBox_1=new JCheckBox();
		checkBox_1.setBounds(370, 140, 50, 50);
		checkBox_1.setBackground(new Color(100, 122, 46));
       
		JCheckBox checkBox_2=new JCheckBox();
		checkBox_2.setBounds(370, 200, 50, 50);
		checkBox_2.setBackground(new Color(7, 173, 15));

		JCheckBox checkBox_3=new JCheckBox();
		checkBox_3.setBounds(370, 260, 50, 50);
		checkBox_3.setBackground(Color.YELLOW);

		JCheckBox checkBox_4=new JCheckBox();
		checkBox_4.setBounds(370, 320, 50, 50);
		checkBox_4.setBackground(new Color(250, 205, 2));

		JCheckBox checkBox_5=new JCheckBox();
		checkBox_5.setBounds(370, 380, 50, 50);
		checkBox_5.setBackground(Color.RED);

		JButton button_1=new JButton("Home");
		button_1.setBounds(880, 50 , 70, 20);

		JTextField textField_1=new JTextField("0");
		textField_1.setBounds(180, 460 , 100, 40);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		textField_1.setEditable(false);
			
		JLabel label_14=new JLabel("Choose campus : ");
		label_14.setBounds(450, 140, 170, 20);
		label_14.setBackground(null);
		label_14.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_14.setForeground(Color.white);
		
		JLabel label_15=new JLabel("SKCET");
		label_15.setBounds(620, 140, 100, 20);
		label_15.setBackground(Color.white);
		label_15.setForeground(Color.white);
		label_15.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JCheckBox checkBox_6=new JCheckBox();
		checkBox_6.setBounds(690, 140 , 30 , 20);
		checkBox_6.setBackground(null);
		checkBox_6.setSelected(true);
		
		JLabel label_16=new JLabel("or");
		label_16.setBounds(745, 140, 30, 20);
		label_16.setBackground(null);
		label_16.setForeground(Color.white);
		label_16.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));		
		
		JLabel label_17=new JLabel("SKCT");
		label_17.setBounds(780, 140, 70, 20);
		label_17.setBackground(null);
		label_17.setForeground(Color.white);
		label_17.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JCheckBox checkBox_7=new JCheckBox();
		checkBox_7.setBounds(840, 140 , 30 , 20);
		checkBox_7.setBackground(null);
		checkBox_7.setSelected(true);
		
		JLabel label_18=new JLabel("Choose Year : ");
		label_18.setBounds(450, 200, 170, 20);
		label_18.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_18.setForeground(Color.white);
		
		JLabel label_19=new JLabel("3");
		label_19.setBounds(620, 200, 100, 20);
		label_19.setForeground(Color.white);
		label_19.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JCheckBox checkBox_8=new JCheckBox();
		checkBox_8.setBounds(640, 200 , 30 , 20);
		checkBox_8.setBackground(null);
		checkBox_8.setSelected(true);
		
		JLabel label_20=new JLabel("4");
		label_20.setBounds(700, 200, 70, 20);
		label_20.setForeground(Color.white);
		label_20.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JCheckBox checkBox_9=new JCheckBox();
		checkBox_9.setBounds(720, 200 , 30 , 20);
		checkBox_9.setBackground(null);
		checkBox_9.setSelected(true);
		
		JLabel label_21=new JLabel("File name : ");
		label_21.setBounds(450, 260, 170, 30);
		label_21.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_21.setForeground(Color.white);

		JTextField textField_2=new JTextField();
		textField_2.setBounds(620, 260, 200, 30);
		textField_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_22=new JLabel("Choose Directory: ");
		label_22.setBounds(450, 320, 170, 30);
		label_22.setForeground(Color.white);
		label_22.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));

		JButton button_2=new JButton("Directory");
		button_2.setBounds(620, 320, 200, 30);
		button_2.setBackground(null);

		JButton button_3=new JButton("Download");
		button_3.setBounds(500, 440, 200, 40);
		button_3.setBackground(null);
		button_3.setForeground(Color.black);
	
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
				if(checkBox_1.isSelected())
				{
					Download.sum+=Download.noOfStudent[0];
					textField_1.setText(String.valueOf(Download.sum));
				}
				else
				{
					Download.sum-=Download.noOfStudent[0];
					textField_1.setText(String.valueOf(Download.sum));
				}
			}
		});
	
		checkBox_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(checkBox_2.isSelected())
				{
					Download.sum+=Download.noOfStudent[1];
					textField_1.setText(String.valueOf(Download.sum));
				}
				else
				{
					Download.sum-=Download.noOfStudent[1];
					textField_1.setText(String.valueOf(Download.sum));
				}
			}
		});
		
		checkBox_3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(checkBox_3.isSelected())
			{
				Download.sum+=Download.noOfStudent[2];
				textField_1.setText(String.valueOf(Download.sum));
			}
			else
			{
				Download.sum-=Download.noOfStudent[2];
				textField_1.setText(String.valueOf(Download.sum));
			}
		}
		});
		
		checkBox_4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(checkBox_4.isSelected())
			{
				Download.sum+=Download.noOfStudent[3];
				textField_1.setText(String.valueOf(Download.sum));
			}
			else
			{
				Download.sum-=Download.noOfStudent[3];
				textField_1.setText(String.valueOf(Download.sum));
			}
		}
		});
		
		checkBox_5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(checkBox_5.isSelected())
			{
				Download.sum+=Download.noOfStudent[4];
				textField_1.setText(String.valueOf(Download.sum));
			}
			else
			{
				Download.sum-=Download.noOfStudent[4];
				textField_1.setText(String.valueOf(Download.sum));
			}
		}
		});
		
		checkBox_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int f=0;
				if(checkBox_6.isSelected() && checkBox_7.isSelected())
				{
					Download.numOfcampus=2;
				}
				else if(checkBox_6.isSelected()&& !(checkBox_7.isSelected()))
				{
					Download.numOfcampus=1;
				}
				else if(!(checkBox_6.isSelected()) && checkBox_7.isSelected())
				{
					Download.numOfcampus=0;
				}
				else
				{
					f=1;
					JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
				}
				if(f==0)
				{
					Download.noOfStudent=noOfStudent(Download.numOfcampus, Download.from, Download.to);
					label_9.setText(String.valueOf(Download.noOfStudent[0]));
					label_10.setText(String.valueOf(Download.noOfStudent[1]));
					label_11.setText(String.valueOf(Download.noOfStudent[2]));
					label_12.setText(String.valueOf(Download.noOfStudent[3]));
					label_13.setText(String.valueOf(Download.noOfStudent[4]));
					Download.sum=0;
					if(checkBox_1.isSelected())
						Download.sum+=Integer.parseInt(label_9.getText());
					if(checkBox_2.isSelected())
						Download.sum+=Integer.parseInt(label_10.getText());
					if(checkBox_3.isSelected())
						Download.sum+=Integer.parseInt(label_11.getText());
					if(checkBox_4.isSelected())
						Download.sum+=Integer.parseInt(label_12.getText());
					if(checkBox_5.isSelected())
						Download.sum+=Integer.parseInt(label_13.getText());
					textField_1.setText(String.valueOf(Download.sum));
				}
				else
				{
					Download.sum=0;
					label_9.setText("0");
					label_10.setText("0");
					label_11.setText("0");
					label_12.setText("0");
					label_13.setText("0");					
				}
			}
		});
		
		checkBox_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int f=0;
				if(checkBox_7.isSelected() && checkBox_6.isSelected())
				{
					Download.numOfcampus=2;
				}
				else if(checkBox_7.isSelected()&& !(checkBox_6.isSelected()))
				{
					Download.numOfcampus=0;
				}
				else if(!(checkBox_7.isSelected()) && checkBox_6.isSelected())
				{
					Download.numOfcampus=1;
				}
				else
				{
					f=1;
					JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
				}
				if(f==0)
				{
					Download.noOfStudent=noOfStudent(Download.numOfcampus, Download.from, Download.to);
					label_9.setText(String.valueOf(Download.noOfStudent[0]));
					label_10.setText(String.valueOf(Download.noOfStudent[1]));
					label_11.setText(String.valueOf(Download.noOfStudent[2]));
					label_12.setText(String.valueOf(Download.noOfStudent[3]));
					label_13.setText(String.valueOf(Download.noOfStudent[4]));
					Download.sum=0;
					if(checkBox_1.isSelected())
						Download.sum+=Integer.parseInt(label_9.getText());
					if(checkBox_2.isSelected())
						Download.sum+=Integer.parseInt(label_10.getText());
					if(checkBox_3.isSelected())
						Download.sum+=Integer.parseInt(label_11.getText());
					if(checkBox_4.isSelected())
						Download.sum+=Integer.parseInt(label_12.getText());
					if(checkBox_5.isSelected())
						Download.sum+=Integer.parseInt(label_13.getText());
					textField_1.setText(String.valueOf(Download.sum));
				}
				else
				{
					Download.sum=0;
					label_9.setText("0");
					label_10.setText("0");
					label_11.setText("0");
					label_12.setText("0");
					label_13.setText("0");					
				}
			}
		});		
		
		checkBox_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int f=0;
				if(checkBox_8.isSelected() && checkBox_9.isSelected())
				{
					Download.from=3;
					Download.to=4;
				}
				else if(checkBox_8.isSelected()&& !(checkBox_9.isSelected()))
				{
					Download.from=3;
					Download.to=3;
				}
				else if(!(checkBox_8.isSelected()) && checkBox_9.isSelected())
				{
					Download.from=4;
					Download.to=4;
				}
				else
				{
					f=1;
					JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
				}
				if(f==0)
				{
					Download.noOfStudent=noOfStudent(Download.numOfcampus, Download.from, Download.to);
					label_9.setText(String.valueOf(Download.noOfStudent[0]));
					label_10.setText(String.valueOf(Download.noOfStudent[1]));
					label_11.setText(String.valueOf(Download.noOfStudent[2]));
					label_12.setText(String.valueOf(Download.noOfStudent[3]));
					label_13.setText(String.valueOf(Download.noOfStudent[4]));
					Download.sum=0;
					if(checkBox_1.isSelected())
						Download.sum+=Integer.parseInt(label_9.getText());
					if(checkBox_2.isSelected())
						Download.sum+=Integer.parseInt(label_10.getText());
					if(checkBox_3.isSelected())
						Download.sum+=Integer.parseInt(label_11.getText());
					if(checkBox_4.isSelected())
						Download.sum+=Integer.parseInt(label_12.getText());
					if(checkBox_5.isSelected())
						Download.sum+=Integer.parseInt(label_13.getText());
					textField_1.setText(String.valueOf(Download.sum));
				}
				else
				{
					Download.sum=0;
					label_9.setText("0");
					label_10.setText("0");
					label_11.setText("0");
					label_12.setText("0");
					label_13.setText("0");					
				}
			}
		});

		checkBox_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int f=0;
				if(checkBox_9.isSelected() && checkBox_8.isSelected())
				{
					Download.from=3;
					Download.to=4;
				}
				else if(checkBox_9.isSelected()&& !(checkBox_8.isSelected()))
				{
					Download.from=4;
					Download.to=4;
				}
				else if(!(checkBox_9.isSelected()) && checkBox_8.isSelected())
				{
					Download.from=3;
					Download.to=3;
				}
				else
				{
					f=1;
					JOptionPane.showMessageDialog(null, "You have to select atleast one Campus");
				}
				if(f==0)
				{
					Download.noOfStudent=noOfStudent(Download.numOfcampus, Download.from, Download.to);
					label_9.setText(String.valueOf(Download.noOfStudent[0]));
					label_10.setText(String.valueOf(Download.noOfStudent[1]));
					label_11.setText(String.valueOf(Download.noOfStudent[2]));
					label_12.setText(String.valueOf(Download.noOfStudent[3]));
					label_13.setText(String.valueOf(Download.noOfStudent[4]));
					Download.sum=0;
					if(checkBox_1.isSelected())
						Download.sum+=Integer.parseInt(label_9.getText());
					if(checkBox_2.isSelected())
						Download.sum+=Integer.parseInt(label_10.getText());
					if(checkBox_3.isSelected())
						Download.sum+=Integer.parseInt(label_11.getText());
					if(checkBox_4.isSelected())
						Download.sum+=Integer.parseInt(label_12.getText());
					if(checkBox_5.isSelected())
						Download.sum+=Integer.parseInt(label_13.getText());
					textField_1.setText(String.valueOf(Download.sum));
				}
				else
				{
					Download.sum=0;
					label_9.setText("0");
					label_10.setText("0");
					label_11.setText("0");
					label_12.setText("0");
					label_13.setText("0");					
				}
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().equals(""))
					JOptionPane.showMessageDialog(textField_2, "File name is mandatory");
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
				 {
					 int a=2;
					 if(checkBox_6.isSelected() && checkBox_7.isSelected())
						 a=2;
					 else if(checkBox_6.isSelected())
						 a=1;
					 else if(checkBox_7.isSelected())
						 a=0;
					 if(checkBox_8.isSelected() && !(checkBox_9.isSelected()))
						 Download.to=3;
					 else if(checkBox_9.isSelected() && !(checkBox_8.isSelected()))
						 Download.from=4;
					 String categories="";
					 if(checkBox_1.isSelected())
						 categories+="A";
					 if(checkBox_2.isSelected())
						 categories+="B";
					 if(checkBox_3.isSelected())
							categories+="C";
					 if(checkBox_4.isSelected())
							categories+="D";
					 if(checkBox_5.isSelected())
							categories+="X";
					 Download.mandatoryflag=1;
					createPDF(fileChooser.getSelectedFile().getPath()+"\\"+textField_2.getText()+".pdf",a,Download.from,Download.to,true,categories); 
				 }
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int f=0;
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(textField_2, "File name is mandatory");
					f=1;
				}
				if(Download.mandatoryflag==0)
				{
					JOptionPane.showMessageDialog(button_2, "Directory is mandatory");
					f=1;
				}
				if(f==0)
					JOptionPane.showMessageDialog(button_3, "File "+textField_2.getText()+".pdf is Successfully downloaded");
			}
		});
		
		label.add(label_1);
		label.add(label_2);
		label.add(label_3);
		label.add(label_4);
		label.add(label_5);
		label.add(label_6);
		label.add(label_7);
		label.add(label_8);
		label.add(label_9);
		label.add(label_10);
		label.add(label_11);
		label.add(label_12);
		label.add(label_13);
		label.add(label_14);
		label.add(label_15);
		label.add(label_16);
		label.add(label_17);
		label.add(label_18);
		label.add(label_19);
		label.add(label_20);
		label.add(label_21);
		label.add(label_22);
		label.add(checkBox_1);
		label.add(checkBox_2);
		label.add(checkBox_3);
		label.add(checkBox_4);
		label.add(checkBox_5);
		label.add(checkBox_6);
		label.add(checkBox_7);
		label.add(checkBox_8);
		label.add(checkBox_9);
		label.add(button_1);
		label.add(button_2);
		label.add(button_3);
		label.add(textField_1);
		label.add(textField_2);
		
		frame.setVisible(true);
		return frame;
	}
	
	public JFrame createTrackRecordDownload(String batchyear)
	{
		JFrame frame=new JFrame();
	   	ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
    	JLabel label=new JLabel(icon);
    	frame.setBounds(240,100,1010, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(label);

		JButton button_1=new JButton("Home");
		button_1.setBounds(820, 30 , 70, 20);
		
		JLabel label_1=new JLabel("Choose campus : ");
		label_1.setBounds(300, 130, 170, 20);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_1.setForeground(Color.white);
		
		JLabel label_2=new JLabel("SKCET");
		label_2.setBounds(520, 130, 100, 20);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_2.setForeground(Color.white);
		
		JCheckBox checkBox_1=new JCheckBox();
		checkBox_1.setBounds(600, 130 , 30 , 20);
		
		JLabel label_3=new JLabel("or");
		label_3.setBounds(635, 130, 30, 20);
		label_3.setBackground(null);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));		
		label_3.setForeground(Color.white);
		
		JLabel label_4=new JLabel("SKCT");
		label_4.setBounds(670, 130, 70, 20);
		label_4.setBackground(null);
		label_4.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_4.setForeground(Color.white);
		
		JCheckBox checkBox_2=new JCheckBox();
		checkBox_2.setBounds(735, 130 , 30 , 20);

		JLabel label_5=new JLabel("Choose Year : ");
		label_5.setBounds(300, 190, 150, 25);
		label_5.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_5.setForeground(Color.white);
		
		JLabel label_6=new JLabel("3");
		label_6.setBounds(530, 190, 20, 30);
		label_6.setForeground(Color.white);
		label_6.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_6.setForeground(Color.white);		
		
		JCheckBox checkBox_3=new JCheckBox();
		checkBox_3.setBounds(560, 190, 30, 30);

		JLabel label_7=new JLabel("4");
		label_7.setBounds(600, 190, 30, 30);
		label_7.setForeground(Color.white);
		label_7.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_7.setForeground(Color.white);
		
		JCheckBox checkBox_4=new JCheckBox();
		checkBox_4.setBounds(630, 190, 30, 30);
		checkBox_4.setBackground(null);
		
		JLabel label_8=new JLabel("File name : ");
		label_8.setBounds(300, 240, 150, 25);
		label_8.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_8.setForeground(Color.white);
		
		JTextField textField_1=new JTextField();
		textField_1.setBounds(520, 240, 180, 30);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_9=new JLabel("Choose Directory: ");
		label_9.setBounds(300, 300, 200, 25);
		label_9.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_9.setForeground(Color.white);
		
		JButton button_2=new JButton("Directory");
		button_2.setBounds(520, 300 , 150, 40);
		
		JButton button_3=new JButton("Download");
		button_3.setBounds(420, 380 , 150, 50);
		button_3.setBackground(null);
		button_3.setForeground(Color.black);
		
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
					JOptionPane.showMessageDialog(textField_1, "File name is mandatory");
				if(!(checkBox_1.isSelected()) && !(checkBox_2.isSelected()))
					JOptionPane.showMessageDialog(checkBox_1, "Select atleast one campus");
				else if(!(checkBox_3.isSelected()) && !(checkBox_4.isSelected()))
					JOptionPane.showMessageDialog(checkBox_3, "Select atleast one year");
				else
				{
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
						 int from=3,to=4;
						 if(checkBox_3.isSelected() && !(checkBox_4.isSelected()))
							 to=3;
						 else if(checkBox_4.isSelected() && !(checkBox_3.isSelected()))
							 from=4;
						 Download.mandatoryflag=1;
						createPDF(fileChooser.getSelectedFile().getPath()+"\\"+textField_1.getText()+".pdf",a,from,to,false,""); 
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
		
		label.add(label_1);//Choose campus
		label.add(label_2);//SKCET
		label.add(checkBox_1);
		label.add(label_3);
		label.add(label_4);//SKCT
		label.add(checkBox_2);
		label.add(label_5);//Choose Year
		label.add(label_6);//3
		label.add(checkBox_3);
		label.add(label_7);//4
		label.add(checkBox_4);
		label.add(label_8);//File name
		label.add(textField_1);
		label.add(label_9);//Directory
		label.add(button_2);
		label.add(button_1);//Home
        label.add(button_3);//Download
        
        frame.setVisible(true);
		return frame;
	}
	
	public int[] noOfStudent(int numOfcampus,int from ,int to)
	{
		  int a[]=new int[5];
		  ArrayList<String[]> result1=null;;
		  ArrayList<String[]> result2=null;
		  if(numOfcampus==2)
		  {
			  result1=new DatabaseWork().fullTrackRecord("SKCET",from,to,false);
		      result2=new DatabaseWork().fullTrackRecord("SKCT",from,to,false);  
		  }
		  else if(numOfcampus==1)
		  {
			  result1=new DatabaseWork().fullTrackRecord("SKCET",from,to,false);
		  }
		  else if(numOfcampus==0)
		  {
		      result2=new DatabaseWork().fullTrackRecord("SKCT",from,to,false);  
		  }
		int i=0,j=0;
		if(numOfcampus==2)
		{
			while(i<result1.size() && j<result2.size())
			{
				int skcetmark=Integer.parseInt(result1.get(i)[5]);
	        	int skctmark=Integer.parseInt(result2.get(j)[5]);
				if(skcetmark<=100 && skcetmark>=90)
					a[0]++;
				else if(skcetmark<90 && skcetmark>80)
					a[1]++;
				else if(skcetmark>=50 && skcetmark<=80)
					a[2]++;
				else if(skcetmark<50 && skcetmark>15)
					a[3]++;
				else
					a[4]++;
				
				if(skctmark<=100 && skctmark>=90)
					a[0]++;
				else if(skctmark<90 && skctmark>80)
					a[1]++;
				else if(skctmark>=50 && skctmark<=80)
					a[2]++;
				else if(skctmark<50 && skctmark>15)
					a[3]++;
				else
					a[4]++;
				i++;j++;
			}
		}
	   if(numOfcampus==2 || numOfcampus==1)
	   {
			while(i<result1.size())
			{
				int skcetmark=Integer.parseInt(result1.get(i)[5]);
	    		if(skcetmark<=100 && skcetmark>=90)
					a[0]++;
				else if(skcetmark<90 && skcetmark>80)
					a[1]++;
				else if(skcetmark>=50 && skcetmark<=80)
					a[2]++;
				else if(skcetmark<50 && skcetmark>15)
					a[3]++;
				else
					a[4]++;
	    		i++;
			}
	   }
	   if(numOfcampus==2 || numOfcampus==0)
       {
			while(j<result2.size())
			{
				int skctmark=Integer.parseInt(result2.get(j)[5]);
				if(skctmark<=100 && skctmark>=90)
					a[0]++;
				else if(skctmark<90 && skctmark>80)
					a[1]++;
				else if(skctmark>=50 && skctmark<=80)
					a[2]++;
				else if(skctmark<50 && skctmark>15)
					a[3]++;
				else
					a[4]++;
				j++;
			}
       }
		return a;
	}
	
	public void createPDF(String filename,int numOfcampus,int from,int to,boolean flag,String categories)
	{
		Document  doc=new Document();
		
		try
		{
			PdfWriter.getInstance(doc, new FileOutputStream(filename));
			doc.open();
		  
		  PdfPTable table =new PdfPTable(7);
		  
		  String a[]={"College_Email_ID" , "Student_Name" , "Gender" , "Department" ,"Campus","Mark","Category"};
		  
		  PdfPCell c1;
		  for(String i:a)
		  {
			  c1=new PdfPCell(new Phrase(i));
			  table.addCell(c1);
		  }
		  ArrayList<String[]> result1=null;;
		  ArrayList<String[]> result2=null;
		  if(numOfcampus==2)
		  {
			  result1=new DatabaseWork().fullTrackRecord("SKCET",from,to,false);
		      result2=new DatabaseWork().fullTrackRecord("SKCT",from,to,false);  
		  }
		  else if(numOfcampus==1)
		  {
			  result1=new DatabaseWork().fullTrackRecord("SKCET",from,to,false);
		  }
		  else if(numOfcampus==0)
		  {
		      result2=new DatabaseWork().fullTrackRecord("SKCT",from,to,false);  
		  }
		 	int i=0;
			int j=0;
			int skcetmark;
			int skctmark;
			if(numOfcampus==2)
			{
				while(i<result1.size() && j<result2.size())
				{
		        	skcetmark=Integer.parseInt(result1.get(i)[5]);
		        	skctmark=Integer.parseInt(result2.get(j)[5]);
		        	if(skcetmark>skctmark)
		        	{
		        		String category;
						if(skcetmark<=100 && skcetmark>=90)
							category="A";
						else if(skcetmark<90 && skcetmark>80)
							category="B";
						else if(skcetmark>=50 && skcetmark<=80)
							category="C";
						else if(skcetmark<50 && skcetmark>15)
							category="D";
						else
							category="X";
						if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
						{
							for(String s:result1.get(i))
							{
								table.addCell(s);	
							}
							table.addCell(category);
						}
		        		i++;
		        	}
		        	else if(skcetmark<skctmark)
		        	{
		         		String category;
						if(skctmark<=100 && skctmark>=90)
							category="A";
						else if(skctmark<90 && skctmark>80)
							category="B";
						else if(skctmark>=50 && skctmark<=80)
							category="C";
						else if(skctmark<50 && skctmark>15)
							category="D";
						else
							category="X";
						if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
						{
							for(String s:result2.get(j))
							{
								table.addCell(s);	
							}
							table.addCell(category);
						}
						j++;
		        	}
		        	else
		        	{
		        		if((result1.get(i)[1]).compareToIgnoreCase(result2.get(j)[1])<0)
		        		{
		        	 		String category;
							if(skcetmark<=100 && skcetmark>=90)
								category="A";
							else if(skcetmark<90 && skcetmark>80)
								category="B";
							else if(skcetmark>=50 && skcetmark<=80)
								category="C";
							else if(skcetmark<50 && skcetmark>15)
								category="D";
							else
								category="X";
							
							if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
							{
								for(String s:result1.get(i))
								{
									table.addCell(s);	
								}
								table.addCell(category);
							}
							i++;
		        		}
		        		else if((result1.get(i)[1]).compareToIgnoreCase(result2.get(j)[1])>0)
		        		{
		        			String category;
							if(skctmark<=100 && skctmark>=90)
								category="A";
							else if(skctmark<90 && skctmark>80)
								category="B";
							else if(skctmark>=50 && skctmark<=80)
								category="C";
							else if(skctmark<50 && skctmark>15)
								category="D";
							else
								category="X";
							
							if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
							{
								for(String s:result2.get(j))
								{
									table.addCell(s);	
								}
								table.addCell(category);
							}
							j++;
		        		}
		        		else
		        		{
		        	 		String category;
							if(skcetmark<=100 && skcetmark>=90)
								category="A";
							else if(skcetmark<90 && skcetmark>80)
								category="B";
							else if(skcetmark>=50 && skcetmark<=80)
								category="C";
							else if(skcetmark<50 && skcetmark>15)
								category="D";
							else
								category="X";
							
							if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
							{
								for(String s:result1.get(i))
								{
									table.addCell(s);	
								}
								table.addCell(category);
							}
							i++;
		        		}
		        	}
				}	
			}
	        if(numOfcampus==2 || numOfcampus==1)
	        {
	        	while(i<result1.size())
		        {
		        	skcetmark=Integer.parseInt(result1.get(i)[5]);
		     		String category;
					if(skcetmark<=100 && skcetmark>=90)
						category="A";
					else if(skcetmark<90 && skcetmark>80)
						category="B";
					else if(skcetmark>=50 && skcetmark<=80)
						category="C";
					else if(skcetmark<50 && skcetmark>15)
						category="D";
					else
						category="X";
					
					if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
					{
						for(String s:result1.get(i))
						{
							table.addCell(s);	
						}
						table.addCell(category);
					}
					i++;
		        }	
	        }
	        if(numOfcampus==2 || numOfcampus==0)
	        {
	        	while(j<result2.size())
		        {
		        	skctmark=Integer.parseInt(result2.get(j)[5]);
		        	String category;
					if(skctmark<=100 && skctmark>=90)
						category="A";
					else if(skctmark<90 && skctmark>80)
						category="B";
					else if(skctmark>=50 && skctmark<=80)
						category="C";
					else if(skctmark<50 && skctmark>15)
						category="D";
					else
						category="X";
					
					if((categories.contains(category) && flag) || (categories.equals("") && !(flag)))
					{
						for(String s:result2.get(j))
						{
							table.addCell(s);	
						}
						table.addCell(category);
					}
					j++;
		        }
	        }
	          doc.add(table);
		  doc.close();
		}
		catch(Exception e){System.out.println(e);}
	}
	
	public JFrame createTeamRecord()
	{
		JFrame frame=new JFrame("S M A R S-Admin Home Page");
		frame.setBounds(240, 100, 1010, 600);
		ImageIcon icon=new ImageIcon(new ImageIcon("D:\\Programming\\JAVA\\image\\A.jpg").getImage().getScaledInstance(1010, 600, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(icon); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JButton button_1=new JButton("Home");
		button_1.setBounds(850, 60 , 70, 20);
		
		JLabel label_1=new JLabel("Choose Year : ");
		label_1.setBounds(300, 150, 150, 25);
		label_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_1.setForeground(Color.white);
		
		JCheckBox checkBox_1=new JCheckBox("3");
		checkBox_1.setBounds(520, 150, 50, 30);
		checkBox_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		checkBox_1.setSelected(true);
		
		JCheckBox checkBox_2=new JCheckBox("4");
		checkBox_2.setBounds(630, 150, 50, 30);
		checkBox_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		checkBox_2.setSelected(true);
		
		JLabel label_2=new JLabel("File name : ");
		label_2.setBounds(300, 210, 150, 25);
		label_2.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_2.setForeground(Color.white);
		
		JTextField textField_1=new JTextField();
		textField_1.setBounds(520, 210, 180, 30);
		textField_1.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		
		JLabel label_3=new JLabel("Choose Directory: ");
		label_3.setBounds(300, 280, 200, 25);
		label_3.setFont(new Font("Times of Roman",Font.BOLD+Font.CENTER_BASELINE,20));
		label_3.setForeground(Color.white);
		
		JButton button_2=new JButton("Directory");
		button_2.setBounds(520, 280 , 150, 40);
		
		JButton button_3=new JButton("Download");
		button_3.setBounds(450, 360 , 150, 45);
		button_3.setBackground(null);
		button_3.setForeground(Color.black);
		
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
							 Download.mandatoryflag=1;
						 	createTeamPDF(fileChooser.getSelectedFile().getPath()+"\\"+textField_1.getText()+".pdf",from,to); 
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
	
	public void createTeamPDF(String filename,int from,int to)
	{
		Document  doc=new Document();
		try
		{
			PdfWriter.getInstance(doc, new FileOutputStream(filename));
			doc.open();
			String a[]={"Team No","Email ID","Name","Mark","Category"};
			PdfPTable table =new PdfPTable(5);
			PdfPCell c1;
			for(String i:a)
			{
				  c1=new PdfPCell(new Phrase(i));
				  table.addCell(c1);
			}
			TreeMap<Integer, Integer> details=new DatabaseWork().teamtrackrecord(from, to);
			Map<Integer, Integer> c = details.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
					Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			ArrayList<Integer> pos=new ArrayList<Integer>();
			ArrayList<Integer> value=new ArrayList<Integer>();
			for(Map.Entry<Integer, Integer> m:c.entrySet())
			{ 
				pos.add(m.getKey());
				value.add(m.getValue());
			}
			int k=pos.size()-1;
			for(Map.Entry<Integer, Integer> m:c.entrySet())
			{
				ArrayList<String []> b=new DatabaseWork().teamdetails(pos.get(k), 1);
				table.addCell(String.valueOf(m.getKey()));
				String email="",name="";
				for(String[] i:b)
				{
				
					email+=i[0]+"\n\n";
					name+=i[1]+"\n\n";
				}
				table.addCell(email);
				table.addCell(name);
				table.addCell(String.valueOf(value.get(k)));
				if(value.get(k)<=100 && value.get(k)>=90)
					table.addCell("A");
				else if(value.get(k)<90 && value.get(k)>80)
					table.addCell("B");
				else if(value.get(k)>=50 && value.get(k)<=80)
					table.addCell("C");
				else if(value.get(k)<50 && value.get(k)>15)
					table.addCell("D");
				else
					table.addCell("X");
				k--;
			}
	       doc.add(table);
		  doc.close();
		}
		catch(Exception e){}
}
	
	public static void main(String args[])
	{
		new Download().createTeamRecord();
	}
}
