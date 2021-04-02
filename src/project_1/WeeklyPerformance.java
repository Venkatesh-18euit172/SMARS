package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeeklyPerformance{

	String s1[]={"Tuesday","Friday","Saturday"};
	String s2[]={"Average Score of all Students in Particular Day","Average","Scores","Days"};
	Connection con;
	Statement st;
		
	public int[] overallScore(String SelectedItem[])
	{
		int pos=1;
		int a[]=new int[3];
		try
		{
			con=new DatabaseWork().getDbConnection();
			st=con.createStatement();
			String temp_s3=SelectedItem[0]+"_"+SelectedItem[1]+"_"+SelectedItem[2];
			while(pos<4)
			{
				ResultSet res1=st.executeQuery("Select AVG("+temp_s3+"_"+pos+") as Value from SKCET_"+AdminHomePage.batchyear);
				a[pos-1]=(int)res1.getDouble("Value");
				ResultSet res2=st.executeQuery("Select AVG("+temp_s3+"_"+pos+") as Value from SKCT_"+AdminHomePage.batchyear);
				a[pos-1]+=(int)res2.getDouble("Value");
				a[pos-1]/=2;
				pos++;
			}
		}
		catch(Exception e)
		{
			while(pos<4)
			{
				a[pos-1]=0;
				pos++;
			}
		}
		return a;
	}
	
	public int[] individualScore(String SelectedItem[],String emailID)
	{
		int pos=1;
		int a[]=new int[3];
		try
		{
			con=new DatabaseWork().getDbConnection();
			st=con.createStatement();
			String temp_s3=SelectedItem[0]+"_"+SelectedItem[1]+"_"+SelectedItem[2];
			while(pos<4)
			{
				if(emailID.contains("@skcet.ac.in"))
				{
					ResultSet res1=st.executeQuery("Select "+temp_s3+"_"+pos+" from SKCET_"+AdminHomePage.batchyear+" where College_email_ID='"+emailID+"'");
					a[pos-1]=(int)res1.getDouble(temp_s3+"_"+pos);		
				}
				else
				{
					ResultSet res1=st.executeQuery("Select "+temp_s3+"_"+pos+" from SKCT_"+AdminHomePage.batchyear+" where College_email_ID='"+emailID+"'");
					a[pos-1]=(int)res1.getDouble(temp_s3+"_"+pos);						
				}
				pos++;
			}
		}
		catch(Exception e)
		{
			while(pos<4)
			{
				a[pos-1]=0;
				pos++;
			}
		}
		return a;
	}	
	
	public JPanel createWeek(String emailID,String SelectedItem[])
	{
		int a[];
		if(emailID.equals(""))
			a=new WeeklyPerformance().overallScore(SelectedItem);
		else
			a=new WeeklyPerformance().individualScore(SelectedItem, emailID);
		JLabel label[]=new StudentPerformance().LabelInitialize(s2);
		JPanel panel=new JPanel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g)
			{		
			    Color color[]={Color.BLUE,new Color(0,180,0),new Color(255,0,0)};	
			    int x=250,y=450;
			    g.setColor(Color.yellow);
			    g.fillRoundRect(50, 150 , 700 , 500, 50, 30);
			    for(int i=0;i<s1.length;i++)
			    {
			    	g.setColor(color[i]);
			    	if(a[i]!=0)
			    		g.fillRect(x, y-a[i], 100, a[i]+100);
					g.setColor(Color.BLACK);
					if(a[i]!=0)
						g.drawRect(x, y-a[i], 100, a[i]+100);
					x+=150;
			    }
			    g.drawLine(225, 550, x-30, 550);
			    g.drawLine(225, 250, 225, 550);
			}		
		};
		panel.setLayout(null);
		for(int i=0;i<4;i++)
			panel.add(label[i]);
		int x=280;
		for(int i=0;i<3;i++)
		{
			JLabel label_1=new JLabel(s1[i]);
			JLabel label_2=new JLabel(String.valueOf(a[i]));
			label_1.setFont(new Font("Bazooka",Font.BOLD+Font.ITALIC,18));
			label_2.setFont(new Font("Arial Black",Font.BOLD,18));
			label_1.setBounds(x-20, 550, 100, 30);
			if(a[i]!=0)
				label_2.setBounds(x, 420-a[i], 100, 30);
			else
				label_2.setBounds(x, 525, 20, 30);
			x+=150;
			panel.add(label_1);
			panel.add(label_2);
		};
		panel.setVisible(true);
		return panel;
	}
}
