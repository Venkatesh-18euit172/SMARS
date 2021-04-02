package project_1;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class YearlyPerformance {

	String s1[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String s2[]={"Average Score of all Students in Particular Year","Average","Scores","Months"};
	Connection con;
	Statement st;

	public int[] overallScore(int from,int to,String year)
	{
		int a[]=new int[6];
		String month[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		int temp=0;
		if(from==6)
			temp=6;
		for(int i=0;i<6;i++)
		{
			double sum=0,sum1=0;
			int c=0;
			for(int j=1;j<=5;j++)
			{
				for(int k=1;k<=3;k++)
				{
					sum1=0;
					try
					{
						con=new DatabaseWork().getDbConnection();
						st=con.createStatement();
						ResultSet res1=st.executeQuery("Select AVG("+month[i+temp]+"_"+year+"_"+j+"_"+k+") as Value from SKCET_"+AdminHomePage.batchyear);
						sum1+=res1.getDouble("Value");
						ResultSet res2=st.executeQuery("Select AVG("+month[i+temp]+"_"+year+"_"+j+"_"+k+") as Value from SKCT_"+AdminHomePage.batchyear);
						sum1+=res2.getDouble("Value");
						sum+=sum1/2;
						c++;
					}
					catch(Exception e){}
				}	
			}
			if(c!=0)
				a[i]=(int)sum/c;
			else
				a[i]=0;
		}
		return a;
	}

	public int[] individualScore(int from,int to,String year,String emailID)
	{
		int a[]=new int[6];
		String month[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		int temp=0;
		if(from==6)
			temp=6;
		for(int i=0;i<6;i++)
		{
			double sum=0;
			int c=0;
			for(int j=1;j<=5;j++)
			{
				for(int k=1;k<=3;k++)
				{
					try
					{
						con=new DatabaseWork().getDbConnection();
						st=con.createStatement();
						if(emailID.contains("@skcet.ac.in"))
						{
							ResultSet res1=st.executeQuery("Select "+month[i+temp]+"_"+year+"_"+j+"_"+k+" from SKCET_"+AdminHomePage.batchyear +" where College_Email_ID='"+emailID+"'");
							sum+=res1.getDouble(month[i+temp]+"_"+year+"_"+j+"_"+k);			
						}
						else
						{
							ResultSet res1=st.executeQuery("Select "+month[i+temp]+"_"+year+"_"+j+"_"+k+" from SKCT_"+AdminHomePage.batchyear +" where College_Email_ID='"+emailID+"'");
							sum+=res1.getDouble(month[i+temp]+"_"+year+"_"+j+"_"+k);
						}
						c++;
					}
					catch(Exception e){}
				}
	
			}
			if(c!=0)
				a[i]=(int)sum/c;
			else
				a[i]=0;
		}
		return a;
	}
	
	
	public JPanel createYear(int from,int to,String year,String emailID)
	{
		int a[];
		if(emailID.equals(""))
			a=new YearlyPerformance().overallScore(from,to,year);
		else
			a=new YearlyPerformance().individualScore(from, to, year, emailID);
		JLabel label[]=new StudentPerformance().LabelInitialize(s2);
		JPanel panel=new JPanel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g)
			{		
				Color color[]={new Color(242, 38, 19),new Color(247, 103, 7),new Color(247, 231, 7),new Color(7, 247, 55),new Color(7, 247, 243),new Color(9, 81, 224),new Color(81, 55, 117),new Color(186, 13, 224),new Color(245, 5, 181),new Color(237, 19, 37),new Color(242, 176, 7),new Color(20, 247, 92)};	
			    int x=250,y=450;
			    g.setColor(Color.yellow);
			    g.fillRoundRect(50, 150 , 775 , 500, 50, 30);
			    int temp=0;
			    if(from==6)
			    	temp=6;
			    for(int i=0;i<6;i++)
			    {
			    	g.setColor(color[i+temp]);
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
		int temp=0;
		if(from==6)
			temp=6;
		for(int i=0;i<6;i++)
		{
			JLabel label_1=new JLabel(s1[i+temp]);
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
