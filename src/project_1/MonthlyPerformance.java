package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonthlyPerformance {

	String s2[]={"Average Score of all Students in Particular Month","Average","Scores","Weeks"};
	Connection con;
	Statement st;

	public int[] overallScore(String SelectedItem,int b)
	{
		int a[]=new int[b];
		for(int i=1;i<=b;i++)
		{
			double sum=0,sum1=0;
			int c=0;
			for(int j=1;j<=3;j++)
			{
				sum1=0;
				try
				{
					con=new DatabaseWork().getDbConnection();
					st=con.createStatement();
					ResultSet res1=st.executeQuery("Select AVG("+SelectedItem+"_"+i+"_"+j+") as Value from SKCET_"+AdminHomePage.batchyear);
					sum1+=res1.getDouble("Value");
					ResultSet res2=st.executeQuery("Select AVG("+SelectedItem+"_"+i+"_"+j+") as Value from SKCT_"+AdminHomePage.batchyear);
					sum1+=res2.getDouble("Value");
					sum+=sum1/2;
					c++;
				}
				catch(Exception e){}
			}
			if(c!=0)
				a[i-1]=(int)sum/c;
			else
				a[i-1]=0;
		}
		return a;
	}

	public int[] individualScore(String SelectedItem,int b,String emailID)
	{
		int a[]=new int[b];
		for(int i=1;i<=b;i++)
		{
			double sum=0;
			int c=0;
			for(int j=1;j<=3;j++)
			{
				try
				{
					con=new DatabaseWork().getDbConnection();
					st=con.createStatement();
					if(emailID.contains("@skcet.ac.in"))
					{
						ResultSet res1=st.executeQuery("Select "+SelectedItem+"_"+i+"_"+j+" from SKCET_"+AdminHomePage.batchyear+" where College_Email_ID='"+emailID+"'");
						sum+=res1.getDouble(SelectedItem+"_"+i+"_"+j);	
					}
					else
					{
						ResultSet res1=st.executeQuery("Select "+SelectedItem+"_"+i+"_"+j+" from SKCT_"+AdminHomePage.batchyear+" where College_Email_ID='"+emailID+"'");
						sum+=res1.getDouble(SelectedItem+"_"+i+"_"+j);	
					}
					c++;
				}
				catch(Exception e){}
			}
			if(c!=0)
				a[i-1]=(int)sum/c;
			else
				a[i-1]=0;
		}
		return a;
	}
	
	public JPanel createMonth(String SelectedItem,int b,String emailID)
	{
		int a[];
		if(emailID.equals(""))
			a=new MonthlyPerformance().overallScore(SelectedItem, b);
		else
			a=new MonthlyPerformance().individualScore(SelectedItem, b,emailID);
		JLabel label[]=new StudentPerformance().LabelInitialize(s2);
		JPanel panel=new JPanel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g)
			{		
				Color color[]={Color.BLUE,new Color(247, 103, 7),new Color(0,180,0),new Color(255,0,0),new Color(9, 81, 224)};
			    int x=250,y=450;
			    g.setColor(Color.yellow);
			    g.fillRoundRect(50, 150 , 700 , 500, 50, 30);
			    for(int i=0;i<b;i++)
			    {
			    	g.setColor(color[i]);
			    	if(a[i]!=0)
			    		g.fillRect(x, y-a[i], 50, a[i]+100);
					g.setColor(Color.BLACK);
					if(a[i]!=0)
						g.drawRect(x, y-a[i], 50, a[i]+100);
					x+=100;
			    }
			    g.drawLine(225, 550, x-30, 550);
			    g.drawLine(225, 250, 225, 550);
			}		
		};
		panel.setLayout(null);
		for(int i=0;i<4;i++)
			panel.add(label[i]);
		int x=280;
		for(int i=0;i<b;i++)
		{
			JLabel label_1=new JLabel("Week"+String.valueOf(i+1));
			JLabel label_2=new JLabel(String.valueOf(a[i]));
			label_1.setFont(new Font("Bazooka",Font.BOLD+Font.ITALIC,18));
			label_2.setFont(new Font("Arial Black",Font.BOLD,18));
			label_1.setBounds(x-20, 550, 100, 30);
			if(a[i]!=0)
				label_2.setBounds(x, 420-a[i], 50, 30);
			else
				label_2.setBounds(x, 525, 20, 30);
			x+=95;
			panel.add(label_1);
			panel.add(label_2);
		};
		panel.setVisible(true);
		return panel;
	}
}
