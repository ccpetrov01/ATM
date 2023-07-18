package ATM2;


import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.*;




public class SignupOne extends JFrame implements ActionListener {
	private static final long serialVersionUID = 123456789987654321L;
	JLabel formno,personalDetails , name , fname ,dob , gender , email ,marital ,address,city ,state , pincode;
	JTextField fnameTextField , emailTextField , addressTextField, cityTextField , pincodeTextField ,stateTextField , nameTextField;
	JDateChooser dateChooser;
	JRadioButton male,fmale , married , unmarried , other;
	JButton next;
	
	
	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
	
	SignupOne(){
		
		
		
		
		setLayout(null);
		
		
		 Icon icon = new ImageIcon("G:\\logo.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(20,0,100,100);
		 add(label);
		
		
		
		formno = new JLabel("APPLICATION FORM NO. " + first );
		formno.setFont(new Font("Raleway" , Font.BOLD , 38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		name = new JLabel("Name:");
		name.setFont(new Font("Raleway" , Font.BOLD , 22));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway" , Font.BOLD , 22));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway" , Font.BOLD , 22));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway" , Font.BOLD , 22));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		add(male);
		
		fmale = new JRadioButton("Female");
		fmale.setBounds(450,290,80,30);
		add(fmale);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(fmale);
		
		email = new JLabel("Email Adrress:");
		email.setFont(new Font("Raleway" , Font.BOLD , 22));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway" , Font.BOLD , 22));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,80,30);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630,390,60,30);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		address = new JLabel("Address:");
		address.setFont(new Font("Raleway" , Font.BOLD , 22));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		city = new JLabel("City:");
		city.setFont(new Font("Raleway" , Font.BOLD , 22));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		
		state = new JLabel("State:");
		state.setFont(new Font("Raleway" , Font.BOLD , 22));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway" , Font.BOLD , 22));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway" , Font.BOLD , 14));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway" , Font.BOLD , 14));
		next.setBounds(620,660,80,30);
		add(next);
		next.addActionListener(this);
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
		 public void actionPerformed(ActionEvent ae){
		        
		        String formno = first;
		        String name = nameTextField.getText();
		        String fname = fnameTextField.getText();
		        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		        String gender = null;
		        if(male.isSelected()){ 
		            gender = "Male";
		        }else if(fmale.isSelected()){ 
		            gender = "Female";
		        }
		            
		        String email = emailTextField.getText();
		        String marital = null;
		        if(married.isSelected()){ 
		            marital = "Married";
		        }else if(unmarried.isSelected()){ 
		            marital = "Unmarried";
		        }else if(other.isSelected()){ 
		            marital = "Other";
		        }
		           
		        String address = addressTextField.getText();
		        String city = cityTextField.getText();
		        String pincode = pincodeTextField.getText();
		        String state = stateTextField.getText();
		        

		        try{
		           
		            if(stateTextField.getText().equals("")){
		                JOptionPane.showMessageDialog(null, "Fill all the required fields");
		            }else{
		            	
		            	 BufferedReader reader = new BufferedReader(new FileReader("notepad_signupOne.txt"));
		                 String line;
		                 while ((line = reader.readLine()) != null) {
		                   
		                     if (line.equals(name)) {
		                         reader.close();		                         
		                         return ; 
		                     }
		                 }
		                 reader.close();
		                 
		                 BufferedWriter writer = new BufferedWriter(new FileWriter("notepad_signupOne.txt", true));
		                 

		                 writer.write("formno:" + formno);
		                 writer.newLine();
		                 writer.write("name:" + name);
		                 writer.newLine();
		                 writer.write("fname:" + fname);
		                 writer.newLine();
		                 writer.write("dob:" + dob);
		                 writer.newLine();
		                 writer.write("gender:" + gender);
		                 writer.newLine();
		                 writer.write("email:" + email);
		                 writer.newLine();
		                 writer.write("marital:" + marital);
		                 writer.newLine();
		                 writer.write("address:" + address);
		                 writer.newLine();
		                 writer.write("city:" + city);
		                 writer.newLine();
		                 writer.write("pincode:" + pincode);
		                 writer.newLine();
		                 writer.write("state:" + state);
		                 writer.newLine();

		                 writer.close();
		            
		                
		                new SignupTwo(first).setVisible(true);
		                setVisible(false);
		            }
		            
		        }catch(IOException ex) {
	                 System.out.println("Error writing to file: " + ex);
		        }
		        
		    }
		
	
	public static void main(String[] args) {
		new SignupOne();
	}

}
