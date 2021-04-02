package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class StudentRegistration{
	
	
	public JFrame createRegistration(String details[],boolean setFlag) {

		JFrame frame=new JFrame("S M A R S- Student Registration form");
		frame.setLayout(null);
		frame.setBounds(100,10,1010, 680);
     	frame.setFont(new Font("Times Of Roman", Font.BOLD,12));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame.setResizable(false);
		
		JPanel panel_1=new JPanel();
		panel_1.setBackground(Color.yellow);
		panel_1.setVisible(true); 
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1000, 50);

		    JLabel label_0=new JLabel("STUDENTS REGISTRATION FORM");
		    label_0.setBounds(400, 0, 400, 50);
		    
		    JButton button_1=new JButton("Home");
		    button_1.setBounds(900, 10 , 90, 30);
		    button_1.setBackground(Color.GREEN);
		    
		    panel_1.add(label_0);
		    panel_1.add(button_1);
		    
		JPanel panel_2=new JPanel();
		panel_2.setBackground(Color.cyan);
		panel_2.setLayout(null);
		panel_2.setBounds(0, 50, 500, 550);

			JLabel label_1=new JLabel("STUDENT DETAILS");
			label_1.setBounds(150 , 0, 200 , 30);	
			
			JLabel label_2=new JLabel("Student Name ");
			JLabel validation_1=new JLabel();
			JTextField textField_1=new JTextField();
			label_2.setBounds(50, 40, 100, 30);
			validation_1.setBounds(370, 40, 135, 30);
			textField_1.setBounds(210, 40, 150, 25);
						
			JLabel label_3=new JLabel("Register No ");
			JLabel validation_2=new JLabel();
			JTextField textField_2=new JTextField();
			label_3.setBounds(50, 80, 100, 30);
			validation_2.setBounds(370, 80, 135, 30);
			textField_2.setBounds(210, 80, 150, 25);
			
			JLabel label_4=new JLabel("DOB (DD/MM/YYYY)");
			JLabel validation_3=new JLabel();
			JTextField textField_3=new JTextField();
			label_4.setBounds(50, 120, 120, 30);
			validation_3.setBounds(370, 120, 135, 30);
			textField_3.setBounds(210, 120, 100, 25);
			
			JLabel label_5=new JLabel("Gender");
			JRadioButton radioButton_1=new JRadioButton("Male",false);
			JRadioButton radioButton_2=new JRadioButton("Female",false);
			ButtonGroup buttonGroup_1=new ButtonGroup();
			buttonGroup_1.add(radioButton_1);
			buttonGroup_1.add(radioButton_2);
			label_5.setBounds(50, 160, 80, 30);
			radioButton_1.setBackground(Color.CYAN);
			radioButton_2.setBackground(Color.CYAN);
			radioButton_1.setBounds(210, 160, 80, 30);
			radioButton_2.setBounds(310, 160, 80, 30);

			String department[]={"select","Civil Engineering","Computer Science and Business Systems","Computer Science and Engineering","Electrical and Electronics Engineering",
					"Electrical and Communication Engineering","Information Technology","Mechanical Engineering","Mechatronics Engineering"};
			JLabel label_6=new JLabel("Department");
			JComboBox<String> chComboBox_1=new JComboBox<String>(department);
			label_6.setBounds(50, 200, 80, 30);
			chComboBox_1.setBounds(210, 200, 250, 25);
			chComboBox_1.setEditable(true);
			AutoCompleteDecorator.decorate(chComboBox_1);
			
			JLabel label_7=new JLabel("College Email ID");
			JLabel validation_4=new JLabel();
			JTextField textField_4=new JTextField();
			label_7.setBounds(50, 240, 150, 30);
			textField_4.setBounds(210, 240, 230, 25);
			validation_4.setBounds(225, 255,245, 40);

			JLabel label_8=new JLabel("Campus");
			JRadioButton radioButton_3=new JRadioButton("SKCET",false);
			JRadioButton radioButton_4=new JRadioButton("SKCT",false);
			ButtonGroup buttonGroup_2=new ButtonGroup();
			buttonGroup_2.add(radioButton_3);
			buttonGroup_2.add(radioButton_4);
			radioButton_3.setBackground(Color.CYAN);
			radioButton_4.setBackground(Color.CYAN);
			radioButton_3.setBounds(210, 280, 80, 30);
			radioButton_4.setBounds(310, 280, 80, 30);
			label_8.setBounds(50, 280, 150, 30);

			JLabel label_9=new JLabel("Student Mobile No");
			JTextField textField_5=new JTextField();
			JLabel validation_5=new JLabel();
			label_9.setBounds(50, 320, 150, 30);
			textField_5.setBounds(210, 320, 100, 25);
			validation_5.setBounds(310,320,120,20);

			JLabel label_10=new JLabel("Other Mobile No");
			JTextField textField_6=new JTextField();
			JLabel validation_6=new JLabel();
			label_10.setBounds(50, 360, 150, 30);
			textField_6.setBounds(210, 360, 100, 25);
			validation_6.setBounds(310,360,120,20);

			JLabel label_11=new JLabel("Student Type");
			JRadioButton radioButton_5=new JRadioButton("Hosteler");
			JRadioButton radioButton_6=new JRadioButton("Days Scholar");
			ButtonGroup buttonGroup_3=new ButtonGroup();
			buttonGroup_3.add(radioButton_5);
			buttonGroup_3.add(radioButton_6);
			label_11.setBounds(50, 400, 80, 30);
			radioButton_5.setBackground(Color.CYAN);
			radioButton_6.setBackground(Color.CYAN);
			radioButton_5.setBounds(210, 400, 100, 30);
			radioButton_6.setBounds(330, 400, 100, 30);
			
			JLabel label_12=new JLabel("Current CGPA in %");
			JTextField textField_7=new JTextField();
			JLabel validation_7=new JLabel();
			label_12.setBounds(50, 440, 110, 30);
			textField_7.setBounds(210, 440, 100, 25);
			validation_7.setBounds(310,440,120,20);
			
			JLabel label_13=new JLabel("No of Arrear");
			JTextField textField_8=new JTextField();
			JLabel validation_8=new JLabel();
			label_13.setBounds(50, 480, 100, 30);
			textField_8.setBounds(210, 480, 100, 25);
			validation_8.setBounds(310,480,120,20);
		
			JLabel label_14=new JLabel("Coding Level");
			JRadioButton radioButton_7=new JRadioButton("Low");
			JRadioButton radioButton_8=new JRadioButton("Medium");
			JRadioButton radioButton_9=new JRadioButton("High");
			ButtonGroup buttonGroup_4=new ButtonGroup();
			buttonGroup_4.add(radioButton_7);
			buttonGroup_4.add(radioButton_8);
			buttonGroup_4.add(radioButton_9);
			label_14.setBounds(50, 520, 80, 20);
			radioButton_7.setBackground(Color.CYAN);
			radioButton_8.setBackground(Color.CYAN);
			radioButton_9.setBackground(Color.CYAN);
			radioButton_7.setBounds(210, 520, 50, 20);
			radioButton_8.setBounds(270, 520, 80, 20);
			radioButton_9.setBounds(350, 520, 50, 20);					
		
			panel_2.add(label_1);//Student Details	
			panel_2.add(label_2);//Student Name
			panel_2.add(textField_1);
			panel_2.add(validation_1);
			panel_2.add(label_3);//Register Number
			panel_2.add(textField_2);
			panel_2.add(validation_2);
			panel_2.add(label_4);//DOB
			panel_2.add(textField_3);
			panel_2.add(validation_3);
			panel_2.add(label_5);//Gender
			panel_2.add(radioButton_1);
			panel_2.add(radioButton_2);
			panel_2.add(label_6);//Department
			panel_2.add(chComboBox_1);
			panel_2.add(label_7);//College Email ID
			panel_2.add(textField_4);
	//		panel_2.add(validation_4);
			panel_2.add(label_8);//Campus
			panel_2.add(radioButton_3);
			panel_2.add(radioButton_4);
			panel_2.add(label_9);//Student Mobile No
			panel_2.add(textField_5);
			panel_2.add(validation_5);
			panel_2.add(label_10);//Other Mobile No
			panel_2.add(textField_6);	
			panel_2.add(validation_6);
			panel_2.add(label_11);//Student type
			panel_2.add(radioButton_5);
			panel_2.add(radioButton_6);
			panel_2.add(label_12);//Current CGPA
			panel_2.add(textField_7);
			panel_2.add(validation_7);
			panel_2.add(label_13);//No of Arrear
			panel_2.add(textField_8);
			panel_2.add(validation_8);
			panel_2.add(label_14);//Coding Level
			panel_2.add(radioButton_7);//Low
			panel_2.add(radioButton_8);//Medium
			panel_2.add(radioButton_9);//High
			
			String States[]={"select","Andra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telagana","Tripura","Uttaranchal","Uttar Pradesh","West Bengal"};
			String Districts[]={"select",
					"Anantapur","Chittoor","East Godavari","Guntur","Krishna","Kurnool","Prakasam","Srikakulam","Nellore","Visakhapatnam","Vizianagaram","West Godavari","YSR District", "Cuddapah",
					"Changlang","Upper Dibang Vally","East Kameng","East Siang","Lohit","Lower Subansiri","Papum-Pare","Tawang","Tirap","Upper Siang","Upper Subansiri","West Kameng","West Siang","Anjaw","Lower Dibang Vally","Kurung Kumey",		
					"Baksa","Barpeta","Biswanath","Bongaigaon","Cachar","Charaideo","Chirang","Darrang","Dhemaji","Dhubri","Dibrugarh","Dima Hasao",
					"Araria","Arwal","Aurangabad","Banka","Begusarai","Bhabhua","Bhagalpur","Bhojpur","Buxar","Darbhanga","East Champaran","Gaya","Gopalganj","Jamui","Jehanabad","Katihar","Khagaria","Kishanganj","Lakhisarai","Madhepura","Madhubani","Monghyr","Muzaffarpur","Nalanda","Nawada","Patna","Purnea","Rohtas","Saharsa","Samastipur","Saran","Sheikhpura","Sheohar","Sitamarhi","Siwan","Supaul","Vaishali","West Champaran",
					"Balod","Baloda Bazar","Balrampur","Bastar","Bemetara","Bijapur","Bilaspur","Dantewada","Dhamtari","Durg","Gariyaband","Janjgir-Champa","Jashpur","Kabirdham","Kanker","Kondagaon","Korba","Korea","Mahasamund","Mungeli","Narayanpur","Raigarh","Raipur","Rajnandgaon","Sukma","Surajpur","Surguja",
					"North Goa","South Goa",
					"Ahmedabad","Amreli","Anand","Aravalli","Banaskantha","Bharuch","Bhavnagar","Botad","Chhota Udaipur","Dahod","Dang","Devbhoomi Dwarka",
					"Ambala","Bhiwani","Charkhi Dadri","Faridabad","Fatehabad","Gurugram","Hisar","Jhajjar","Jind","Kaithal","Karnal","Kurukshetra","Mahendragarh","Nuh","Palwal","Panchkula","Panipat","Rewari","Rohtak","Sirsa","Sonipat","Yamunanagar",
					"Bilaspur","Chamba","Hamirpur","Kangra","Kinnaur","Kullu","Lahaul & Spiti","Mandi","Shimla","Sirmaur","Solan","Una",
					"Doda","Jammu","Kathua","Kishtwar","Poonch","Rajouri","Ramban","Reasi","Samba","Udhampur","Anantnag","Bandipora","Baramulla","Budgam","Ganderbal","Kulgam","Kupwara","Pulwama","Shopian","Srinagar","Kargil","Leh",
					"Bokaro","Chatra","Deoghar","Dhanbad","Dumka","East Singhbhum","Garhwa","Giridih","Godda","Gumla","Hazaribagh","Jamtara","Khunti","Koderma","Latehar","Lohardaga","Pakur","Palamu","Ramgarh","Ranchi","Sahebganj","Seraikela","Simdega","West Singhbhum",
					"Bagalkot","Bengaluru Urban","Bengaluru Rural","Belagavi","Ballari","Bidar","Vijayapur","Chamarajanagar","Chikballapur","Chikkamagaluru","Chitradurga","Dakshina Kannada","Davanagere","Dharwad","Gadag","Kalaburagi","Hassan","Haveri","Kodagu","Kolar","Koppal","Mandya","Mysuru","Raichur","Ramanagara","Shivamogga","Tumakuru","Udupi","Uttara Kannada","Yadgir",
					"Alappuzha","Ernakulam","Idukki","Kannur","Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad",
					"Agar Malwa","Alirajpur","Anuppur","Ashoknagar","Balaghat","Barwan","Betul","Bhind","Bhopal","Burhanpur","Chhatarpur","Chhindwara","Damoh","Datia","Dewas","Dhar","Dindori","East Nimar","Guna","Gwalior","Harda","Hoshangabad","Indore","Jabalpur","Jhabua","Katni","Mandla","Mandsaur","Morena","Narsinghpur","Neemuch","Niwari","Panna","Raisen","Rajgarh","Ratlam","Rewa","Sagar","Satna","Sehore","Seoni","Shahdol","Shajapur","Sheopur","Shivpuri","Sidhi","Singrauli","Tikamgarh","Ujjain","Umaria","Vidisha","West Nimar",
					"Ahmednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gadchiroli","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai City","Mumbai Suburban","Nagpur","Nanded","Nandurbar","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal",
					"Bishnupur","Thoubal","Imphal East","Imphal West","Senapati","Ukhrul","Chandel","Churachandpur","Tamenglong",
					"East Garo Hills","East Khasi Hills","Jaintia Hills","Ri Bhoi","South Garo Hills","West Garo Hills","West Khasi Hills",
					"Aizawl","Kolasib","Lawngtlai","Lunglei","Mamit","Saiha","Serchhip","Champhai",
					"Dimapur","Kiphire","Kohima","Longleng","Mokokchung","Mon","Peren","Phek","Tuensang","Wokha","Zunheboto","Noklak",
					"Angul","Boudh","Balangir","Bargarh","Balasore","Bhadrak","Cuttack","Deogarh","Dhenkanal","Ganjam","Gajapati","Jharsuguda","Jajpur","Jagatsinghapur","Khordha","Keonjhar","Kalahandi","Kandhamal","Koraput","Kendrapara","Malkangiri","Mayurbhanj","Nabarangpur","Nuapada","Nayagarh","Puri","Rayagada","Sambalpur","Subarnapur","Sundargarh",
					"Amritsar","Barnala","Bathinda","Faridkot","Fatehgarh Sahib","Fazilka","Ferozepur","Gurdaspur","Hoshiarpur","Jalandhar","Kapurthala","Ludhiana","Mansa","Moga","Muktsar","Nawanshahr","Pathankot","Patiala","Rupnagar","Sahibzada Ajit Singh Nagar","Sangrur","Tarn Taran",
					"Ajmer","Alwar","Banswara","Baran","Barmer","Bharatpur","Bhilwara","Bikaner","Bundi","Chittorgarh","Churu","Dausa","Dholpur","Dungarpur","Hanumangarh","Jaipur","Jaisalmer","Jalor","Jhalawar","Jhunjhunu","Jodhpur","Karauli","Kota","Nagaur","Pali","Pratapgarh","Rajsamand","Sawai Madhopur","Sikar","Sirohi","Sri Ganganagar","Tonk","Udaipur",
					"East Sikkim","North Sikkim","South Sikkim","West Sikkim",			
					"Chennai","Coimbatore","Madurai","Tiruchirappally","Dindigul","Erode","Cuddalore","Dharmapuri","Nagapattinam","Namakkal","Perambalur","Pudukottai","Ramanathapuram","Salem","Sivagangai","Thanjavur","Theni","The Nilgiris","Thirunelveli","Thiruvallur","Thiruvannamalai","Thiruvarur","Thoothukudi","Tiruppur","Vellore","Villupuram","Virudhunagar","Ariyalur","Kancheepuram","Kanniyakumari","Karur","Krishnagiri","Kallakkurichi","Thenkasi","Chengalpattu","Ranipet","Thirupattur",
					"Adilabad","Bhadradri Kothagudem","Hyderabad","Jagitial","Jangaon","Jayashankar Bhupalapally","Jogulamba Gadwal","Kamareddy","Karimnagar","Khammam","Kumarambheem Asifabad","Mahabubabad","Mahabubnagar","Mancherial district","Medak","Medchal–Malkajgiri","Mulugu","Nagarkurnool","Narayanpet","Nalgonda","Nirmal","Nizamabad","Peddapalli","Rajanna Sircilla","Ranga Reddy","Sangareddy","Siddipet","Suryapet","Vikarabad","Wanaparthy","Warangal Rural","Warangal Urban","Yadadri Bhuvanagiri",
					"Dhalai","North Tripura","South Tripura","West Tripura",
					"Almora","Bageshwar","Chamoli","Champawat","Dehradun","Haridwar","Nainital","Pauri Garhwal","Pithoragarh","Rudraprayag","Tehri Garhwal","Udham Singh Nagar","Uttarkashi",
					"Agra","Aligarh","Allahabad","Ambedkar Nagar","Amethi","Amroha","Auraiya","Azamgarh","Baghpat","Bahraich","Ballia","Balrampur","Banda","Barabanki","Bareilly","Basti","Bhadohi","Bijnor","Budaun","Bulandshahr","Chandauli","Chitrakoot","Deoria","Etah","Etawah","Faizabad","Farrukhabad","Fatehpur","Firozabad","Gautam Buddha Nagar","Ghaziabad","Ghazipur","Gonda","Gorakhpur","Hamirpur","Hapur","Hardoi","Hathras","Jalaun","Jaunpur","Jhansi","Kannauj","Kanpur Dehat","Kanpur Nagar","Kanshiram Nagar","Kaushambi","Kushinagar","Lakhimpur - Kheri","Lalitpur","Lucknow","Maharajganj","Mahoba","Mainpuri","Mathura","Mau","Meerut","Mirzapur","Moradabad","Muzaffarnagar","Pilibhit","Pratapgarh","RaeBareli","Rampur","Saharanpur","Sambhal","Sant Kabir Nagar","Shahjahanpur","Shamali","Shravasti","Siddharth Nagar","Sitapur","Sonbhadra","Sultanpur","Unnao","Varanasi",
					"Alipurduar","Bankura","Birbhum","Cooch Behar","Dakshin Dinajpur","Darjeeling","Hooghly","Howrah","Jalpaiguri","Jhargram","Kalimpong","Kolkata","Malda","Murshidabad","Nadia","North 24 Parganas","Paschim Bardhaman","Paschim Medinipur","Purba Bardhaman","Purba Medinipur","Purulia","South 24 Parganas","Uttar Dinajpur"
			};
		
			
	    JPanel panel_3=new JPanel();
		panel_3.setBackground(Color.orange);
		panel_3.setLayout(null);
		panel_3.setBounds(500, 50, 500, 550);
			
				JLabel label_15=new JLabel("PERSONAL DETAILS");
				label_15.setBounds(150 , 0, 150 , 30);
				
				JLabel label_16=new JLabel("Father Name ");
				JTextField textField_9=new JTextField();
				JLabel validation_9=new JLabel();
				label_16.setBounds(50, 40, 100, 30);
				textField_9.setBounds(210, 40, 150, 25);
				validation_9.setBounds(360,40,150,20);

				JLabel label_17=new JLabel("Father's Occupation");
				JTextField textField_10=new JTextField();
				JLabel validation_10=new JLabel();
				label_17.setBounds(50, 80, 150, 30);
				textField_10.setBounds(210, 80, 150, 25);
				validation_10.setBounds(360,80,150,20);
				
				JLabel label_18=new JLabel("Father's Mobile No");
				JTextField textField_11=new JTextField();
				JLabel validation_11=new JLabel();
				label_18.setBounds(50, 120, 150, 30);
				textField_11.setBounds(210, 120, 100, 25);
				validation_11.setBounds(360,120,100,20);

				JLabel label_19=new JLabel("Mother Name");
				JTextField textField_12=new JTextField();
				JLabel validation_12=new JLabel();
				label_19.setBounds(50, 160, 100, 30);
				textField_12.setBounds(210, 160, 150, 25);
				validation_12.setBounds(360,160,150,20);
				
				JLabel label_20=new JLabel("Mother's Occupation");
				JTextField textField_13=new JTextField();
				JLabel validation_13=new JLabel();
				label_20.setBounds(50, 200, 150, 30);
				textField_13.setBounds(210, 200, 150, 25);
				validation_13.setBounds(360,200,150,20);

				JLabel label_21=new JLabel("Mother's Mobile No");
				JTextField textField_14=new JTextField();
				JLabel validation_14=new JLabel();
				label_21.setBounds(50, 240, 150, 30);
				textField_14.setBounds(210, 240, 100, 25);
				validation_14.setBounds(360,240,100,20);
				
				JLabel label_22=new JLabel("Address");
				JTextArea textArea_1=new JTextArea();
				JLabel validation_15=new JLabel();
				JScrollPane scrollPane_1=new JScrollPane(textArea_1);
				label_22.setBounds(50, 280, 100, 30);
				scrollPane_1.setBounds(210, 280, 200, 50);
				validation_15.setBounds(420,280,200,45);
				
				
				JLabel label_23=new JLabel("Pincode");
				JTextField textField_15=new JTextField();
				JLabel validation_16=new JLabel();
				label_23.setBounds(50, 340, 80, 30);
				textField_15.setBounds(210, 340, 100, 25);
				validation_16.setBounds(330,340,100,20);
				
				JLabel label_24=new JLabel("District");
				JComboBox<String>  chComboBox_2=new JComboBox<String>(Districts);
				label_24.setBounds(50, 380, 80, 30);
				chComboBox_2.setBounds(210, 380, 150, 25);
				chComboBox_2.setEditable(true);
				AutoCompleteDecorator.decorate(chComboBox_2);

				JLabel label_25=new JLabel("State");
				JComboBox<String> chComboBox_3=new JComboBox<String>(States);
				label_25.setBounds(50, 420, 80, 30);
				chComboBox_3.setBounds(210, 420, 150, 25);
				chComboBox_3.setEditable(true);
				AutoCompleteDecorator.decorate(chComboBox_3);
								
			    JLabel label_26=new JLabel("10th mark in %");
				JTextField textField_16=new JTextField();
				JLabel validation_17=new JLabel();
				label_26.setBounds(50, 460, 150, 30);
				textField_16.setBounds(210, 460, 80, 25);
				validation_17.setBounds(320,460,80,20);
				
				JLabel label_27=new JLabel("12th mark in %");
				JTextField textField_17=new JTextField();
				JLabel validation_18=new JLabel();
				label_27.setBounds(50, 500, 150, 30);
				textField_17.setBounds(210, 500, 80, 25);
				validation_18.setBounds(320,500,80,20);
				
				panel_3.add(label_15);//Personal Details
				panel_3.add(label_16);//Father Name
				panel_3.add(textField_9);
				panel_3.add(validation_9);
				panel_3.add(label_17);//Father's Occupation
				panel_3.add(textField_10);
				panel_3.add(validation_10);
				panel_3.add(label_18);//Father's Mobile No
				panel_3.add(textField_11);
				panel_3.add(validation_11);
				panel_3.add(label_19);//Mother Name
				panel_3.add(textField_12);
				panel_3.add(validation_12);
				panel_3.add(label_20);//Mother's Occupation
				panel_3.add(textField_13);
				panel_3.add(validation_13);
				panel_3.add(label_21);//Mother's Mobile number
				panel_3.add(textField_14);
				panel_3.add(validation_14);
				panel_3.add(label_22);//Address
				panel_3.add(scrollPane_1);
				panel_3.add(validation_15);
				panel_3.add(label_23);//Pincode
				panel_3.add(textField_15);
				panel_3.add(validation_16);
				panel_3.add(label_24);//District
				panel_3.add(chComboBox_2);
				panel_3.add(label_25);//State
				panel_3.add(chComboBox_3);
				panel_3.add(label_26);//10th Mark in %
				panel_3.add(textField_16);
				panel_3.add(validation_17);
				panel_3.add(label_27);//12th Mark in %
				panel_3.add(textField_17);
				panel_3.add(validation_18);
			
		JPanel panel_4=new JPanel();
		panel_4.setBackground(Color.green);
		panel_4.setVisible(true);
		panel_4.setLayout(null);
		panel_4.setBounds(0, 600, 1000, 50);
		
		       JButton Button=new JButton("Submit");
		       Button.setBounds(450 ,10 , 100 , 30);
		       panel_4.add(Button);
		       
		frame.add(panel_1);
		frame.add(panel_2);
		frame.add(panel_3);
		frame.add(panel_4);

		//If setFlag is true we storing the value in the form from DB
		if(setFlag)
		{
			//Student Details
			textField_1.setText(details[0]);
			textField_2.setText(details[1]);
			textField_3.setText(details[2]);
		    if(details[3].equals("Male"))
		    {
		    	radioButton_1.setSelected(true);
		    	radioButton_2.setSelected(false);
		    }
		    else
		    {
		    	radioButton_1.setSelected(false);
		    	radioButton_2.setSelected(true);		    	
		    }
		    chComboBox_1.setSelectedItem(details[4]);
			textField_4.setText(details[5]);
			if(details[6].equals("Campus"))
		    {
		    	radioButton_3.setSelected(true);
		    	radioButton_4.setSelected(false);
		    }
		    else
		    {
		    	radioButton_3.setSelected(false);
		    	radioButton_4.setSelected(true);		    	
		    }
			textField_5.setText(details[7]);
			textField_6.setText(details[8]);
			if(details[9].equals("Hosteler"))
		    {
		    	radioButton_5.setSelected(true);
		    	radioButton_6.setSelected(false);
		    }
		    else
		    {
		    	radioButton_5.setSelected(false);
		    	radioButton_6.setSelected(true);		    	
		    }
			textField_7.setText(details[10]);
			textField_8.setText(details[11]);
			if(details[12].equals("Low"))
		    {
		    	radioButton_7.setSelected(true);
		    	radioButton_8.setSelected(false);
		    	radioButton_9.setSelected(false);
		    }
			else if(details[12].equals("Medium"))
		    {
		    	radioButton_7.setSelected(false);
		    	radioButton_8.setSelected(true);
		    	radioButton_9.setSelected(false);
		    }
		    else
		    {
		    	radioButton_7.setSelected(false);
		    	radioButton_8.setSelected(false);
		    	radioButton_9.setSelected(true);
		    }
			
			//Personal Details
			textField_9.setText(details[13]);
			textField_10.setText(details[14]);
			textField_11.setText(details[15]);
			textField_12.setText(details[16]);
			textField_13.setText(details[17]);
			textField_14.setText(details[18]);
			textArea_1.setText(details[19]);
			textField_15.setText(details[20]);
			chComboBox_2.setSelectedItem(details[21]);
			chComboBox_3.setSelectedItem(details[22]);
			textField_16.setText(details[23]);
			textField_17.setText(details[24]);
		}
		
		textField_1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("[a-zA-Z\\s]{3,}");
				Matcher m1=p1.matcher(textField_1.getText());
				if(!(m1.matches()))
				{
					validation_1.setFont(new Font("Serif", Font.ITALIC,12));
					validation_1.setForeground(new Color(255,0,0));
					validation_1.setText("Invalid Name");
				}
				else
				{
					validation_1.setForeground(Color.BLACK);
					validation_1.setText("Valid Name");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});

		textField_2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^\\d{2}(eu||tu)(cs||ec||ee||mc||mt||it)\\d{3}$",Pattern.CASE_INSENSITIVE);
				Matcher m1=p1.matcher(textField_2.getText());
				if(!(m1.matches()))
				{
					validation_2.setFont(new Font("Serif", Font.ITALIC,12));
					validation_2.setForeground(new Color(255,0,0));
					validation_2.setText("Invalid Register Number");
				}
				else
				{
					validation_2.setForeground(Color.BLACK);
					validation_2.setText("Valid Register Number");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		textField_3.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^(0[1-9]|[12]\\d|3[01])[/.-](0[1-9]|1[012])[/.-](19|20)\\d\\d$");
				Matcher m1=p1.matcher(textField_3.getText());
				if(!(m1.matches()))
				{
					validation_3.setFont(new Font("Serif", Font.ITALIC,12));
					validation_3.setForeground(new Color(255,0,0));
					validation_3.setText("Invalid DOB");
				}
				else
				{
					validation_3.setForeground(Color.BLACK);
					validation_3.setText("Valid DOB");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
       textField_4.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^"+textField_2.getText().toLowerCase()+"+(@skcet\\.ac.in||@skct\\.ac.in)");
				Matcher m1=p1.matcher(textField_4.getText());
				if(!(m1.matches()))
				{
					validation_4.setFont(new Font("Serif", Font.ITALIC,12));
					validation_4.setForeground(new Color(255,0,0));
					validation_4.setText("Invalid College Email Id");
				}
				else
				{
					validation_4.setForeground(Color.BLACK);
					validation_4.setText("Valid College Email Id");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_5.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("[6-9][0-9]{9}");
				Matcher m1=p1.matcher(textField_5.getText());
				if(!(m1.matches()))
				{
					validation_5.setFont(new Font("Serif", Font.ITALIC,12));
					validation_5.setForeground(new Color(255,0,0));
					validation_5.setText("Invalid mobile number");
				}
				else
				{
					validation_5.setForeground(Color.BLACK);
					validation_5.setText("Valid mobile number");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_6.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[6-9][0-9]{9}");
				Matcher m1=p1.matcher(textField_6.getText());
				if(!(m1.matches()))
				{
					validation_6.setFont(new Font("Serif", Font.ITALIC,12));
					validation_6.setForeground(new Color(255,0,0));
					validation_6.setText("Invalid mobile number");
				}
				else
				{
					validation_6.setForeground(Color.BLACK);
					validation_6.setText("Valid mobile number");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_7.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^100(\\.[0]{1,2})?|([0-9]|[1-9][0-9])(\\.[0-9]{1,2})?$");
				Matcher m1=p1.matcher(textField_7.getText());
				if(!(m1.matches()))
				{
					validation_7.setFont(new Font("Serif", Font.ITALIC,12));
					validation_7.setForeground(new Color(255,0,0));
					validation_7.setText("Invalid cgpa");
				}
				else
				{
					validation_7.setForeground(Color.BLACK);
					validation_7.setText("Valid cgpa");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_8.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("[0-9]|[1-9][0-9]");
				Matcher m1=p1.matcher(textField_8.getText());
				if(!(m1.matches()))
				{
					validation_8.setFont(new Font("Serif", Font.ITALIC,12));
					validation_8.setForeground(new Color(255,0,0));
					validation_8.setText("Invalid count");
				}
				else
				{
					validation_8.setForeground(Color.BLACK);
					validation_8.setText("Valid count");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_9.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[a-zA-Z\\s]{3,}");
				Matcher m1=p1.matcher(textField_9.getText());
				if(!(m1.matches()))
				{
					validation_9.setFont(new Font("Serif", Font.ITALIC,12));
					validation_9.setForeground(new Color(255,0,0));
					validation_9.setText("Invalid Name");
				}
				else
				{
					validation_9.setForeground(Color.BLACK);
					validation_9.setText("Valid Name");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_10.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[a-zA-Z\\s]{3,}");
				Matcher m1=p1.matcher(textField_10.getText());
				if(!(m1.matches()))
				{
					validation_10.setFont(new Font("Serif", Font.ITALIC,12));
					validation_10.setForeground(new Color(255,0,0));
					validation_10.setText("Invalid occupation");
				}
				else
				{
					validation_10.setForeground(Color.BLACK);
					validation_10.setText("Valid occupation");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_11.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[6-9][0-9]{9}");
				Matcher m1=p1.matcher(textField_11.getText());
				if(!(m1.matches()))
				{
					validation_11.setFont(new Font("Serif", Font.ITALIC,12));
					validation_11.setForeground(new Color(255,0,0));
					validation_11.setText("Invalid Number");
				}
				else
				{
					validation_11.setForeground(Color.BLACK);
					validation_11.setText("Valid Number");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_12.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[a-zA-Z\\s]{3,}");
				Matcher m1=p1.matcher(textField_12.getText());
				if(!(m1.matches()))
				{
					validation_12.setFont(new Font("Serif", Font.ITALIC,12));
					validation_12.setForeground(new Color(255,0,0));
					validation_12.setText("Invalid Name");
				}
				else
				{
					validation_12.setForeground(Color.BLACK);
					validation_12.setText("Valid Name");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_13.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[a-zA-Z\\s]{3,}");
				Matcher m1=p1.matcher(textField_13.getText());
				if(!(m1.matches()))
				{
					validation_13.setFont(new Font("Serif", Font.ITALIC,12));
					validation_13.setForeground(new Color(255,0,0));
					validation_13.setText("Invalid Name");
				}
				else
				{
					validation_13.setForeground(Color.BLACK);
					validation_13.setText("Valid Name");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
       textField_14.addKeyListener(new KeyListener() {
			
   			@Override
   			public void keyTyped(KeyEvent arg0) {
   				
   			}
   			
   			@Override
   			public void keyReleased(KeyEvent arg0) {
   				Pattern p1=Pattern.compile("^[6-9][0-9]{9}");
   				Matcher m1=p1.matcher(textField_14.getText());
   				if(!(m1.matches()))
   				{
   					validation_14.setFont(new Font("Serif", Font.ITALIC,12));
   					validation_14.setForeground(new Color(255,0,0));
   					validation_14.setText("Invalid number");
   				}
   				else
   				{
   					validation_14.setForeground(Color.BLACK);
   					validation_14.setText("Valid number");					
   				}
   			}
   			
   			@Override
   			public void keyPressed(KeyEvent arg0) {
   				
   			}
   		});
       
      textArea_1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("[a-zA-Z0-9\\s]{3,}");
				Matcher m1=p1.matcher(textArea_1.getText());
				if(!(m1.matches()))
				{
					validation_15.setFont(new Font("Serif", Font.ITALIC,12));
					validation_15.setForeground(new Color(255,0,0));
					validation_15.setText("Invalid address");
				}
				else
				{
					validation_15.setForeground(Color.BLACK);
					validation_15.setText("Valid address");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
      textField_15.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^[1-9]{1}[0-9]{2}[0-9]{3}$");
				Matcher m1=p1.matcher(textField_15.getText());
				if(!(m1.matches()))
				{
					validation_16.setFont(new Font("Serif", Font.ITALIC,12));
					validation_16.setForeground(new Color(255,0,0));
					validation_16.setText("Invalid pin code");
				}
				else
				{
					validation_16.setForeground(Color.BLACK);
					validation_16.setText("Valid pin code");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
      textField_16.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^100(\\.[0]{1,2})?|([0-9]|[1-9][0-9])(\\.[0-9]{1,2})?$");
				Matcher m1=p1.matcher(textField_16.getText());
				if(!(m1.matches()))
				{
					validation_17.setFont(new Font("Serif", Font.ITALIC,12));
					validation_17.setForeground(new Color(255,0,0));
					validation_17.setText("Invalid ");
				}
				else
				{
					validation_17.setForeground(Color.BLACK);
					validation_17.setText("Valid ");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
      textField_17.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				Pattern p1=Pattern.compile("^100(\\.[0]{1,2})?|([0-9]|[1-9][0-9])(\\.[0-9]{1,2})?$");
				Matcher m1=p1.matcher(textField_17.getText());
				if(!(m1.matches()))
				{
					validation_18.setFont(new Font("Serif", Font.ITALIC,12));
					validation_18.setForeground(new Color(255,0,0));
					validation_18.setText("Invalid ");
				}
				else
				{
					validation_18.setForeground(Color.BLACK);
					validation_18.setText("Valid ");					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
      
		Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String a[]=new String[25];
				
				//Student Details
				
				a[0]=textField_1.getText().trim().toUpperCase();	
				a[1]=textField_2.getText().trim().toUpperCase();
				a[2]=textField_3.getText();
				if(radioButton_1.isSelected())
					a[3]=radioButton_1.getText();
			    else
			    	 a[3]=radioButton_2.getText();
				a[4]=(String) chComboBox_1.getSelectedItem();
				a[5]=textField_4.getText();
				if(radioButton_3.isSelected())
					a[6]=radioButton_3.getText();
			    else
			    	 a[6]=radioButton_4.getText();			
				a[7]=textField_5.getText();
				a[8]=textField_6.getText();		
			    if(radioButton_5.isSelected())
			    	 a[9]=radioButton_5.getText();
			    else
			    	 a[9]=radioButton_6.getText();
				a[10]=textField_7.getText();
			    a[11]=textField_8.getText();
			    if(radioButton_7.isSelected())
			    	 a[12]=radioButton_7.getText();
			    else if(radioButton_8.isSelected())
			    	 a[12]=radioButton_8.getText();
			    else
			    	 a[12]=radioButton_9.getText();
			    
			    
			    //Personal Details
				a[13]=textField_9.getText().toUpperCase();
			    a[14]=textField_10.getText().toUpperCase();
				a[15]=textField_11.getText().toUpperCase();
			    a[16]=textField_12.getText().toUpperCase();
				a[17]=textField_13.getText().toUpperCase();
			    a[18]=textField_14.getText().toUpperCase();
			    a[19]=textArea_1.getText().toUpperCase();
				a[20]=textField_15.getText().toUpperCase();
				a[21]=((String) chComboBox_2.getSelectedItem()).toUpperCase();
			    a[22]=((String) chComboBox_3.getSelectedItem()).toUpperCase();
				a[23]=textField_16.getText().toUpperCase();
				a[24]=textField_17.getText().toUpperCase();
				
				int f=0;
				if(a[0].equals(""))
				{
					JOptionPane.showMessageDialog( textField_1,"Student Name is Mandatory");
					f=1;
				}
				if(a[1].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textField_2,"Register Number is Mandatory");
				}
				if(a[2].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textField_3,"DOB is Mandatory");
				}
				if(!(radioButton_1.isSelected() || radioButton_2.isSelected()))
				{
					f=1;
					JOptionPane.showMessageDialog(radioButton_1,"Gender is Mandatory");
				}
				if(a[4].equals("select"))
				{
					JOptionPane.showMessageDialog(chComboBox_1,"Department is Mandatory");
					f=1;
				}
				if(a[5].equals(""))
				{
					JOptionPane.showMessageDialog(textField_4,"College Email ID is Mandatory");
					f=1;
				}
				if(!(radioButton_3.isSelected() || radioButton_4.isSelected()))
				{
					f=1;
					JOptionPane.showMessageDialog(radioButton_3,"Campus Mandatory");
				}				
				if(a[7].equals(""))
				{
					JOptionPane.showMessageDialog(textField_5,"Mobile No is Mandatory");
					f=1;
				}
				if(a[10].equals(""))
				{
					JOptionPane.showMessageDialog(textField_7,"CGPA is Mandatory");
					f=1;
				}
				if(a[11].equals(""))
				{
					JOptionPane.showMessageDialog(textField_8,"No of Arrear is Mandatory");
					f=1;
				}
				if(a[13].equals(""))
				{
					JOptionPane.showMessageDialog( textField_9,"Father Name is Mandatory");
					f=1;
				}
				if(a[16].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textField_12,"Mother Name is Mandatory");
				}
				if(a[15].equals("") && a[18].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textField_11,"Either Father or Mother Number is Mandatory");
					
				}
				if(a[19].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textArea_1,"Address is Mandatory");
				}
				if(a[20].equals(""))
				{
					JOptionPane.showMessageDialog( textField_15,"Pincode is Mandatory");
					f=1;
				}
				if(a[21].equals("select"))
				{
					f=1;
					JOptionPane.showMessageDialog(chComboBox_2,"District is Mandatory");
				}
				if(a[22].equals("select"))
				{
					f=1;
					JOptionPane.showMessageDialog(chComboBox_3,"State is Mandatory");
				}
				if(a[23].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textField_16,"10th mark is Mandatory");
				}
				if(a[24].equals(""))
				{
					f=1;
					JOptionPane.showMessageDialog(textField_17,"12th mark is Mandatory");
				}
				if(f==0)
				{
					DatabaseWork obj=new DatabaseWork();
					if(setFlag)
				    {
				        obj.updateValue(a, textField_4.getText());
						JOptionPane.showMessageDialog(null,"Details are Successfully Updated");
				    }
				    else
				    {
						if(new DatabaseWork().checker(textField_2.getText().toUpperCase()) )
						{
							int n = JOptionPane.showConfirmDialog(
								    frame,
								    "Already exist.Want to replace it??",
								    "confirmation",
								    JOptionPane.YES_NO_OPTION);
							if(n==0)
							{
								  obj.updateValue(a, textField_4.getText());
								 JOptionPane.showMessageDialog(null,"Details are Successfully replaced");
							}
						}
						else
						{
							obj.storeValue(a,AdminHomePage.batchyear);
						}
				    	textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
					    textField_4.setText(null);
					    textField_5.setText(null);
						textField_6.setText(null);
					    textField_7.setText(null);
					    textField_8.setText(null);
						textField_9.setText(null);
						textField_10.setText(null);
					    textField_11.setText(null);
						textField_12.setText(null);
					    textField_13.setText(null);
					    textField_14.setText(null);
						textField_15.setText(null);
					    textField_16.setText(null);
					    textField_17.setText(null);
						textArea_1.setText(null);
					    buttonGroup_1.clearSelection();
						buttonGroup_2.clearSelection();
						buttonGroup_3.clearSelection();
						buttonGroup_4.clearSelection();
						chComboBox_1.setSelectedItem("select");
						chComboBox_2.setSelectedItem("select");
						chComboBox_3.setSelectedItem("select");
						validation_1.setText(null);
						validation_2.setText(null);
						validation_3.setText(null);
						validation_4.setText(null);
						validation_5.setText(null);
						validation_6.setText(null);
						validation_7.setText(null);
						validation_8.setText(null);
						validation_9.setText(null);
						validation_10.setText(null);
						validation_11.setText(null);
						validation_12.setText(null);
						validation_13.setText(null);
						validation_14.setText(null);
						validation_15.setText(null);
						validation_16.setText(null);
						validation_17.setText(null);
						validation_18.setText(null);
				    }
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    frame.dispose();
				new AdminHomePage().createAdminPage();
			}
		});
		
		frame.setVisible(true);
		return frame;
	}
	public static void main(String args[])
	{
		new StudentRegistration().createRegistration(null, false);
	}
}