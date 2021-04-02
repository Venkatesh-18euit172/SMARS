package project_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatabaseWork {

	String s[]={"Student_Name","Register_No","DOB","Gender","Department","College_Email_ID","Campus","Student_Mobile_No","Other_Mobile_No","Student_Type","Current_CGPA","No_of_Arrear","Coding_Level","Father_Name","Father_Occupation","Father_Mobile_No","Mother_Name","Mother_Occupation","Mother_Mobile_No","Address","Pincode","District","State","Mark_10","Mark_12"};
	static int SKCET=0;
	static int SKCT=0;
	
	public Connection getDbConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bootcamp_project_1", "root","");
	    return con;
	}
	
	public void storeValue(String details[],String batchyear)
	{
		try
		{
			Connection con=getDbConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into Student_details_"+batchyear+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, details[0]);//Student Name
			pstmt.setString(2, details[1]);//Register No
			pstmt.setString(3, details[2]);//DOB
			pstmt.setString(4, details[3]);//Gender
			pstmt.setString(5, details[4]);//Department
			pstmt.setString(6, details[5]);//College Email ID
			pstmt.setString(7, details[6]);//Campus
			pstmt.setString(8, details[7]);//Student Mobile No
			pstmt.setString(9, details[8]);//Other Mobile No
			pstmt.setString(10, details[9]);//Student Type
			if(details[10].equals(null))
			{
				pstmt.setFloat(11, 0);//Current CGPA
			}
			else
			{
				pstmt.setFloat(11, Float.parseFloat((details[10])));//Current CGPA
			}
			if(details[11].equals(null))
			{
				pstmt.setInt(12, 0);//No of Arrear
			}
			else
			{
				pstmt.setInt(12, Integer.parseInt(details[11]));//No of Arrear	
			}
			pstmt.setString(13, details[12]);//Coding level
			pstmt.setString(14, details[13]);//Father Name
			pstmt.setString(15, details[14]);//Father Occupation
			pstmt.setString(16, details[15]);//Father Mobile No
			pstmt.setString(17, details[16]);//Mother Name
			pstmt.setString(18, details[17]);//Mother Occupation
			pstmt.setString(19, details[18]);//Mother Mobile No
			pstmt.setString(20, details[19]);//Address
			pstmt.setString(21, details[20]);//Pincode
			pstmt.setString(22, details[21]);//District
			pstmt.setString(23, details[22]);//State
			if(details[23].equals(null))
			{
				pstmt.setFloat(24, 0);//10th Mark
			}
			else
			{
				pstmt.setFloat(24, Float.parseFloat((details[23])));//10th Mark
			}
			if(details[24].equals(null))
			{
				pstmt.setFloat(25, 0);//12th Mark
			}
			else
			{
				pstmt.setFloat(25, Float.parseFloat((details[24])));//12th Mark
			}
			
			pstmt.executeUpdate();
			
			if(details[6].equals("SKCET"))
			{
				PreparedStatement pstmt1=con.prepareStatement("insert into SKCET_"+batchyear+" (College_Email_ID) values(?)");
				pstmt1.setString(1, details[5]);
				pstmt1.executeUpdate();
			}
			else
			{
				PreparedStatement pstmt1=con.prepareStatement("insert into SKCT_"+batchyear+" (College_Email_ID) values(?)");
				pstmt1.setString(1, details[5]);
				pstmt1.executeUpdate();
			}
			
			con.setAutoCommit(true);
			con.close();
		}
		catch(Exception e){}
	}
	
	public String[] getValue(String emailID)
	{
		String a[]=new String[25];
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
		    ResultSet res=st.executeQuery("select * from Student_details_"+AdminHomePage.batchyear+" where College_email_ID='"+emailID+"'");
		    res.next();
		    int j=0,f=0;
		    while(j<25)
		    {
		    	f=0;
		    	switch(s[j])
		    	{
		    	    case "Student_Mobile_No":f=1;break;
		    	    case "Other_Mobile_No":f=1;break;
		    	    case "Current_CGPA":f=1;break;
		    	    case "No_of_Arrear":f=1;break;
		    	    case "Father_Mobile_No":f=1;break;
		    	    case "Mother_Mobile_No":f=1;break;
		    	    case "Pincode":f=1;break;
		    	    case "Mark_10":f=1;break;
		    	    case "Mark_12":f=1;break; 
		    	}
		    	if(f==1)
		    		a[j]=String.valueOf(res.getLong(s[j]));
		    	else
		    		a[j]=res.getString(s[j]);
		    	j++;
		    }
			con.setAutoCommit(true);
			con.close();
		    st.close();
		}
		catch(Exception e){System.out.println("From getValue the Exception is "+e);}
		return a;
	}	
	
	public void updateValue(String details[],String emailID)
	{
		try
		{
			Connection con=getDbConnection();
            String statement="update Student_details_"+ AdminHomePage.batchyear +" set ";
	        for(int i=0;i<25;i++)
	        {
	        	if(i==24)
	            	statement+=s[i]+" = "+" ? ";
	        	else
	            	statement+=s[i]+" = "+" ? , ";
	        }
	        statement+="where College_Email_ID = '"+emailID+"'";
	        
	        PreparedStatement pstmt=con.prepareStatement(statement);
			
			pstmt.setString(1, details[0]);//Student Name
			pstmt.setString(2, details[1]);//Register No
			pstmt.setString(3, details[2]);//DOB
			pstmt.setString(4, details[3]);//Gender
			pstmt.setString(5, details[4]);//Department
			pstmt.setString(6, details[5]);//College Email ID
			pstmt.setString(7, details[6]);//Campus
			pstmt.setString(8, details[7]);//Student Mobile No
			pstmt.setString(9, details[8]);//Other Mobile No
			pstmt.setString(10, details[9]);//Student Type
			if(details[10].equals(null))
			{
				pstmt.setFloat(11, 0);//Current CGPA
			}
			else
			{
				pstmt.setFloat(11, Float.parseFloat((details[10])));//Current CGPA
			}
			if(details[11].equals(null))
			{
				pstmt.setInt(12, 0);//No of Arrear
			}
			else
			{
				pstmt.setInt(12, Integer.parseInt(details[11]));//No of Arrear	
			}
			pstmt.setString(13, details[12]);//Coding level
			pstmt.setString(14, details[13]);//Father Name
			pstmt.setString(15, details[14]);//Father Occupation
			pstmt.setString(16, details[15]);//Father Mobile No
			pstmt.setString(17, details[16]);//Mother Name
			pstmt.setString(18, details[17]);//Mother Occupation
			pstmt.setString(19, details[18]);//Mother Mobile No
			pstmt.setString(20, details[19]);//Address
			pstmt.setString(21, details[20]);//Pincode
			pstmt.setString(22, details[21]);//District
			pstmt.setString(23, details[22]);//State
			if(details[23].equals(null))
			{
				pstmt.setFloat(24, 0);//10th Mark
			}
			else
			{
				pstmt.setFloat(24, Float.parseFloat((details[23])));//10th Mark
			}
			if(details[24].equals(null))
			{
				pstmt.setFloat(25, 0);//12th Mark
			}
			else
			{
				pstmt.setFloat(25, Float.parseFloat((details[24])));//12th Mark
			}
			
			pstmt.executeUpdate();
			con.setAutoCommit(true);
			con.close();
		    }
		catch(Exception e){System.out.println("From updateValue the Exception is "+e);}
	}
	
	public void deleteValue(String emailID)
	{
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
		    st.execute("Delete  from Student_details_"+AdminHomePage.batchyear+" where  College_Email_ID = '"+emailID+"'");
		    if(emailID.contains("@skcet.ac.in"))
		    	st.execute("Delete from SkCET_"+AdminHomePage.batchyear+" where  College_Email_ID = '"+emailID+"'");
		    else
		    	st.execute("Delete from SkCT_"+AdminHomePage.batchyear+" where  College_Email_ID = '"+emailID+"'");
			con.setAutoCommit(true);
			con.close();
		    st.close();		}
		catch(Exception e){System.out.println("From deleteValue the Exception is "+e);}
	}
	
	public void createNewBatch(String batchyear)
	{
		try
		{
			String datatype[]={"varchar(50) , ","varchar(9) , ","varchar(10) , ","varchar(6) , ","varchar(100) , ","varchar(25) PRIMARY KEY , ","varchar(5) , ","varchar(15) , ","varchar(15) , ","varchar(20) , ","float , ","int , ","varchar(10) , ","varchar(50) , ","varchar(50) , ","varchar(15) , ","varchar(50) , ","varchar(50) , ","varchar(15) , ","varchar(100) ,","varchar(6) ,","varchar(50) ,","varchar(50) ,","float ,","float "};
			Connection con=getDbConnection();
			Statement st=con.createStatement();
    	    String query="create table Student_details_"+batchyear+" (";
		    for(int i=0;i<25;i++)
		    	query+=s[i]+" "+datatype[i];
		    query+=" )";
		    st.execute(query);
			st.execute("create table SKCET_"+batchyear+" ( College_Email_ID VARCHAR (25) REFERENCES Student_details_"+batchyear +" (College_Email_ID), Team_No int , Company_Name VARCHAR(50),Placed VARCHAR(3),Remarks VARCHAR(250),Reviews VARCHAR(250))");
			st.execute("create table SKCT_"+batchyear+" ( College_Email_ID VARCHAR (25) REFERENCES Student_details_"+batchyear +" (College_Email_ID), Team_No int , Company_Name VARCHAR(50),Placed VARCHAR(3),Remarks VARCHAR(250),Reviews VARCHAR(250))");
		    con.setAutoCommit(true);
			con.close();
		    st.close();
		    }
		catch(Exception e){System.out.println("From createNewBatchTable the Exception is "+e);}
			}
	
	public void deleteExistBatch(String batchyear)
	{
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
			
			st.execute("Drop table Student_details_"+batchyear.trim());
			st.execute("Drop table SKCET_"+batchyear.trim());
			st.execute("Drop table SKCT_"+batchyear.trim());
			con.setAutoCommit(true);
			con.close();
			st.close();
		}
		catch(Exception e){}
	}
	
	public void excelToDBCreate(String filepath,String batchyear,boolean newbatch) throws IOException  
	{  
		if(newbatch)
			createNewBatch(batchyear);
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);   
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     
		Iterator<Row> itr = sheet.iterator();
		itr.next();
		while (itr.hasNext())                 
		{  
			String details[]=new String[25];
			int j=0;
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();
			for(int i=0;i<5;i++)
				cellIterator.next();
			for(int i=0;i<2;i++)
			{
				Cell cell = cellIterator.next();  
				details[j]=cell.getStringCellValue().trim().toUpperCase();
				j++;
			}
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				switch (cell.getCellTypeEnum())               
				{  
					case STRING:   
						details[j]=cell.getStringCellValue();  
						break;  
					case NUMERIC:
						details[j]=NumberToTextConverter.toText(cell.getNumericCellValue());  
						break;  
					default:  
				}  
				j++;
			}
			if(checker(details[5]) && !(newbatch))
			{
				int n = JOptionPane.showConfirmDialog(
					    null,
					    details[1] + " is already exist.Want to replace it??",
					    "confirmation",
					    JOptionPane.YES_NO_OPTION);
				if(n==0)
				{
					  updateValue(details, details[5]);
				}
			}
			else
			{
				storeValue(details,batchyear);
			}
		}  
		wb.close();
	}
	
	public void excelToDBUpdate(String filepath) throws IOException  
	{  
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);   
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext())                 
		{  
			String details[]=new String[25];
			int j=0;
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();
			for(int i=0;i<5;i++)
				cellIterator.next();
			for(int i=0;i<2;i++)
			{
				Cell cell = cellIterator.next();  
				details[j]=cell.getStringCellValue().trim().toUpperCase();
				j++;
			}
			while (cellIterator.hasNext())   
			{  
				Cell cell = cellIterator.next();  
				switch (cell.getCellTypeEnum())               
				{  
					case STRING:   
						details[j]=cell.getStringCellValue();  
						break;  
					case NUMERIC:   
						details[j]=NumberToTextConverter.toText(cell.getNumericCellValue());
						break;  
					default:  
				}  
				j++;
			}
			if(checker(details[5]))
			{
				updateValue(details, details[5]);
			}
			else
			{
				int n = JOptionPane.showConfirmDialog(
					    null,
					    details[1] + " is not present.Do you want to add??",
					    "confirmation",
					    JOptionPane.YES_NO_OPTION);
				if(n==0)
				{
					storeValue(details,AdminHomePage.batchyear);					  
				}
			}
		}  
		wb.close();
	}

	public void deletefromDB(String filepath) throws IOException  
	{  
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);   
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext())                 
		{
			Iterator<Cell> cellIterator = itr.next().cellIterator();
			deleteValue(cellIterator.next().getStringCellValue());
		}
		wb.close();
	}
	
	
	public HashSet<String> getCollegeEmailID()
	{

		HashSet<String> emailID=new HashSet<String>();
		try
		{
			 Connection con=getDbConnection();
			 Statement st=con.createStatement();
			 
			 ResultSet res=st.executeQuery("select College_Email_ID from Student_details_"+AdminHomePage.batchyear);
			 while(res.next())
			 {
				 emailID.add(res.getString("College_Email_ID"));
			 }

		}
		catch(Exception e){}
		return  emailID;
	}
	
	public boolean checker(String emailID)
	{
		
		HashSet<String> set=getCollegeEmailID();
		if(set.contains(emailID))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<String[]> fullTrackRecord(String campus,int from,int to,boolean teamsplit)
	{
		String s1[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		ArrayList<String[]> result=new ArrayList<String[]>(); 
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
			String query="select "+campus+"_"+AdminHomePage.batchyear+ ".College_Email_ID , Student_Name , Gender , Department ,Campus , (";
			int c=0;
			String s2;
			for(int i=from;i<=to;i++)
			{
				for(int j=0;j<12;j++)
				{
					s2=s1[j];
					for(int k=1;k<=5;k++)
					{
							for(int l=1;l<=3;l++)
							{
								String s3=s2+"_"+i+"_"+k+"_"+l;
								try
								{
									st.execute("select "+ s3 +" from "+campus+"_"+AdminHomePage.batchyear);
									query+=s3+"+";
									c++;
								}
								catch(Exception e){}
							}
					}
				}				
			}
			query=query.substring(0, query.length()-1)+")/"+c+" as Mark from "+campus +"_"+AdminHomePage.batchyear+" INNER JOIN Student_details_"+AdminHomePage.batchyear+" on "+campus +"_"+AdminHomePage.batchyear+".College_Email_ID=Student_details_"+AdminHomePage.batchyear+".College_Email_ID ORDER BY Mark DESC";			
			ResultSet res =st.executeQuery(query);
	    	while(res.next())
			{
	    		String a[]=new String[6];
	    		if(teamsplit)
	    		{
	    			a[0]=res.getString("Student_Name");
	    			a[1]=res.getString("Campus");
	    			switch(res.getString("Department"))
	    			{
	    				case "Civil Engineering":a[2]="Civil";break;
	    				case "Computer Science and Business Systems":a[2]="CSBS";break;
	    				case "Computer Science and Engineering":a[2]="CSE";break;
	    				case "Electrical and Electronics Engineering":a[2]="EEE";break;
	    				case "Electrical and Communication Engineering":a[2]="ECE";break;
	    				case "Information Technology":a[2]="IT";break;
	    				case "Mechanical Engineering":a[2]="MECH";break;
	    				case "Mechatronics Engineering":a[2]="MCT";break;
	    			}
	    			a[3]=res.getString("College_Email_ID");
	    			a[4]=res.getString("Gender");
					a[5]=String.valueOf(res.getInt("Mark"));
	    		}
	    		else
	    		{
	    			a[0]=res.getString("College_Email_ID");
					a[1]=res.getString("Student_Name");
					a[2]=res.getString("Gender");
					a[3]=res.getString("Department");
					a[4]=res.getString("Campus"); 
					a[5]=String.valueOf(res.getInt("Mark"));	
	    		}
				result.add(a);
			}	
		}
		catch(Exception e){System.out.println();}
		return result;
	}
	
	public void storePlacement(String emailID,String companyname)
	{
		try
		{
			Connection con=getDbConnection();
			if(emailID.contains("skcet.ac.in"))
			{
				String statement="update SKCET_"+ AdminHomePage.batchyear +" set Company_Name = ? ,Placed = ? where College_Email_ID = '"+emailID+"'";
				PreparedStatement pstmt=con.prepareStatement(statement);
				pstmt.setString(1, companyname);
				pstmt.setString(2, "YES");
				pstmt.executeUpdate();
				pstmt.close();
			}
			else
			{
				String statement="update SKCT_"+ AdminHomePage.batchyear +" set Company_Name = ? ,Placed = ? where College_Email_ID = '"+emailID+"'";
				PreparedStatement pstmt=con.prepareStatement(statement);
				pstmt.setString(1, companyname);
				pstmt.setString(2, "YES");
				pstmt.executeUpdate();
				pstmt.close();
			}
			con.setAutoCommit(true);
			con.close();
		}
		catch(Exception e){System.out.println(e);}
	}
	
	public TreeMap<Integer, Integer> teamtrackrecord(int from,int to)
	{
		String s1[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		TreeMap<Integer,Integer> result=new TreeMap<Integer, Integer>();
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
			int a=0,b=0,max=0;
			ResultSet res=st.executeQuery("select max(Team_No) as A from SKCET_"+AdminHomePage.batchyear);
			res.next();
			a=res.getInt("A");
			res=st.executeQuery("select max(Team_No) as A from SKCT_"+AdminHomePage.batchyear);
			res.next();
			b=res.getInt("A");
			if(a>b)
				max=a;
			else
				max=b;
			String query1="select Team_No , (";
			int c=0;
			String s2;
			for(int i=from;i<=to;i++)
			{
				for(int j=0;j<12;j++)
				{
					s2=s1[j];
					for(int k=1;k<=5;k++)
					{
							for(int l=1;l<=3;l++)
							{
								String s3=s2+"_"+i+"_"+k+"_"+l;
								try
								{
									st.execute("select "+ s3 +" from SKCET_"+AdminHomePage.batchyear);
									query1+=s3+"+";
									c++;
								}
								catch(Exception e){}
							}
					}
				}				
			}
			query1=query1.substring(0, query1.length()-1)+")/"+c+" as Mark from SKCET_"+AdminHomePage.batchyear;			
			String query2="select Team_No , (";
			c=0;
			s2="";
			for(int i=from;i<=to;i++)
			{
				for(int j=0;j<12;j++)
				{
					s2=s1[j];
					for(int k=1;k<=5;k++)
					{
							for(int l=1;l<=3;l++)
							{
								String s3=s2+"_"+i+"_"+k+"_"+l;
								try
								{
									st.execute("select "+ s3 +" from SKCT_"+AdminHomePage.batchyear);
									query2+=s3+"+";
									c++;
								}
								catch(Exception e){}
							}
					}
				}				
			}
			query2=query2.substring(0, query2.length()-1)+")/"+c+" as Mark from SKCT_"+AdminHomePage.batchyear;
			ResultSet res1=null,res2=null;
			for(int i=1;i<=max;i++)
			{
				int sum1=0,sum2=0;
				int count1=0,count2=0;
				try
				{
					res1=st.executeQuery("select count(mark) as noOfStudents, sum(Mark) as Total from ("+query1+") where Team_No="+i);
					sum1=(int)res1.getDouble("Total");
					count1=res1.getInt("noOfStudents");
				}
				catch(Exception e){}
				try
				{
					res2=st.executeQuery("select count(mark) as noOfStudents, sum(Mark) as Total from ("+query2+") where Team_No="+i);
					sum2=(int)res2.getDouble("Total");
					count2=res2.getInt("noOfStudents");			}
				catch(Exception e){}
				if(count1!=0 && count2!=0)
				{
					result.put(i, (sum1+sum2)/(count1+count2));
				}
				else if(count1!=0)
				{
					result.put(i,sum1/count1);
				}
				else if(count2!=0)
				{
					result.put(i,sum2/count2);
				}
			}
		}
		catch(Exception e){System.out.println();}
		return result;
	}
	
	public ArrayList<String[]> teamdetails(int teamNo,int purpose)
	{
		ArrayList<String[]> result=new ArrayList<String[]>();
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
			ResultSet res=null;
			String query1="select SKCET_"+AdminHomePage.batchyear+".College_Email_ID as email_ID, Student_Name , Gender , Department ,Campus  from SKCET_"+AdminHomePage.batchyear +" INNER JOIN Student_details_"+AdminHomePage.batchyear +" on SKCET_"+AdminHomePage.batchyear+".College_Email_ID=Student_details_"+AdminHomePage.batchyear+".College_Email_ID WHERE Team_No="+teamNo;
			String query2="select SKCT_"+AdminHomePage.batchyear+".College_Email_ID as email_ID, Student_Name , Gender , Department ,Campus  from SKCT_"+AdminHomePage.batchyear +" INNER JOIN Student_details_"+AdminHomePage.batchyear +" on SKCT_"+AdminHomePage.batchyear+".College_Email_ID=Student_details_"+AdminHomePage.batchyear+".College_Email_ID WHERE Team_No="+teamNo;
			res=st.executeQuery(query1);
			while(res.next())
			{
				if(purpose==1)
				{
					String detail[]=new String[2];
				   	detail[0]=res.getString("email_ID");
				   	detail[1]=res.getString("Student_Name");
				   	result.add(detail);
				}
			}
			res=st.executeQuery(query2);
			while(res.next())
			{
				if(purpose==1)
				{
					String detail[]=new String[2];
				   	detail[0]=res.getString("email_ID");
				   	detail[1]=res.getString("Student_Name");
				   	result.add(detail);
				}
			}
		}
		catch(Exception e){System.out.println(e);}
		return result;
	}
	public void changeTeam(String emailID,int teamNO)
	{
		try
		{
			Connection con=getDbConnection();
			if(emailID.contains("skcet.ac.in"))
			{
				PreparedStatement pstmt=con.prepareStatement("Update SKCET_"+AdminHomePage.batchyear+" set Team_No = ? Where College_Email_ID = ?");
				pstmt.setInt(1, teamNO);
				pstmt.setString(2, emailID);
				System.out.print(pstmt.executeUpdate());
			}
			else
			{
				PreparedStatement pstmt=con.prepareStatement("Update SKCT_"+AdminHomePage.batchyear+" set Team_No = ? Where College_Email_ID = ?");
				pstmt.setInt(1, teamNO);
				pstmt.setString(2, emailID);
				pstmt.executeUpdate();
			}
		}
		catch(Exception e){System.out.println("From changeteam the Exception is "+e);}
	}
	
	public ArrayList<String[]> placementDetails(String yesOrno,int numOfcampus)
	{
		ArrayList<String[]> result=new ArrayList<String[]>();
		try
		{
			Connection con=getDbConnection();
			Statement st=con.createStatement();
			ResultSet res=null;
			if(numOfcampus==2 || numOfcampus==1)
			{
				res=st.executeQuery("Select College_Email_ID , Team_No , Company_Name from SKCET_"+AdminHomePage.batchyear+" where Placed='"+yesOrno+"'");
				while(res.next())
				{
					String a[]=new String[3];
					a[0]=res.getString("College_Email_ID");
					a[1]=String.valueOf(res.getInt("Team_No"));
					a[2]=res.getString("Company_Name");
					result.add(a);
				}	
				res=st.executeQuery("SELECT count(*) as SKCET FROM SKCET_"+AdminHomePage.batchyear);
				res.next();
				DatabaseWork.SKCET=res.getInt("SKCET");
			}
			if(numOfcampus==2 || numOfcampus==3)
			{
				res=st.executeQuery("Select College_Email_ID , Team_No , Company_Name from SKCT_"+AdminHomePage.batchyear+" where Placed='"+yesOrno+"'");
				while(res.next())
				{
					String a[]=new String[3];
					a[0]=res.getString("College_Email_ID");
					a[1]=String.valueOf(res.getInt("Team_No"));
					a[2]=res.getString("Company_Name");
					result.add(a);
				}
				res=st.executeQuery("SELECT count(*) as SKCT FROM SKCT_"+AdminHomePage.batchyear);
				res.next();
				DatabaseWork.SKCT=res.getInt("SKCET");
			}
		}
		catch(Exception e){}
		return result;
	}

	
	public static void main(String args[])
	{
		TreeMap<Integer, Integer> a=new DatabaseWork().teamtrackrecord(3, 4);
		Map<Integer, Integer> c = a.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
				Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		for(Map.Entry<Integer, Integer> m:c.entrySet())
		{
			ArrayList<String []> b=new DatabaseWork().teamdetails(m.getKey(), 1);
			System.out.print(m.getKey()+" ");
			for(String[] i:b)
			{
				for(String j:i)
					System.out.print(j+" ");
			}
			System.out.println(m.getValue());
		}
	}
}