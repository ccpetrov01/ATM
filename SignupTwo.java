package ATM2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener{
	private static final long serialVersionUID = 123456789987654321L;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox<String> c1,c2,c3,c4,c5;
    
    String formno;
     SignupTwo(String formno){
        
    	 Icon icon = new ImageIcon("G:\\logo.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(150,0,100,100);
		 add(label);
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1 = new JLabel("Page 2: Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        
        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup Radio1 = new ButtonGroup();
        Radio1.add(r1);
        Radio1.add(r2);
		
        
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup Radio2 = new ButtonGroup();
        Radio2.add(r3);
        Radio2.add(r4);
        
        
        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        c1 = new JComboBox<String>(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        c2 = new JComboBox<String>(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String income[] = {"Null", "500-1000$", "1000-1500$", "1500-2500$", "2500-5000$", "Above 5000$"};
        c3 = new JComboBox<String>(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        c4 = new JComboBox<String>(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        c5 = new JComboBox<String>(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
       
        
        setLayout(null);
        
        
        l12.setBounds(700,10,60,30);
        add(l12);
        
        l13.setBounds(760,10,60,30);
        add(l13);
        
        l1.setBounds(280,30,600,40);
        add(l1);
        
        l2.setBounds(100,120,100,30);
        add(l2);
        
        c1.setBounds(350,120,320,30);
        add(c1);
        
        l3.setBounds(100,170,100,30);
        add(l3);
        
        c2.setBounds(350,170,320,30);
        add(c2);
        
        l4.setBounds(100,220,100,30);
        add(l4);
        
        c3.setBounds(350,220,320,30);
        add(c3);
        
        l5.setBounds(100,270,150,30);
        add(l5);
        
        c4.setBounds(350,270,320,30);
        add(c4);
        
        l11.setBounds(100,290,150,30);
        add(l11);
        
        l6.setBounds(100,340,150,30);
        add(l6);
        
        c5.setBounds(350,340,320,30);
        add(c5);
        
        l7.setBounds(100,390,150,30);
        add(l7);
        
        t1.setBounds(350,390,320,30);
        add(t1);
        
        l8.setBounds(100,440,180,30);
        add(l8);
        
        t2.setBounds(350,440,320,30);
        add(t2);
        
        l9.setBounds(100,490,150,30);
        add(l9);
        
        r1.setBounds(350,490,100,30);
        add(r1);
        
        r2.setBounds(460,490,100,30);
        add(r2);
        
        l10.setBounds(100,540,180,30);
        add(l10);
        
        r3.setBounds(350,540,100,30);
        add(r3);
        
        r4.setBounds(460,540,100,30);
        add(r4);
        
        b.setBounds(570,640,100,30);
        add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
     
  
    
     public void actionPerformed(ActionEvent ae){
	        
    	 String religion = (String)c1.getSelectedItem(); 
         String category = (String)c2.getSelectedItem();
         String income = (String)c3.getSelectedItem();
         String education = (String)c4.getSelectedItem();
         String occupation = (String)c5.getSelectedItem();
         
         String pan = t1.getText();
         String aadhar = t2.getText();
         
         String scitizen = "";
         if(r1.isSelected()){ 
             scitizen = "Yes";
         }
         else if(r2.isSelected()){ 
             scitizen = "No";
         }
            
         String eaccount = "";
         if(r3.isSelected()){ 
             eaccount = "Yes";
         }else if(r4.isSelected()){ 
             eaccount = "No";
         }

	        try{
	           
	            if(t2.getText().equals("")){
	                JOptionPane.showMessageDialog(null, "Fill all the required fields");
	            }else{
	            	
	            	 BufferedReader reader = new BufferedReader(new FileReader("notepad_signupTwo.txt"));
	                 String line;
	                 while ((line = reader.readLine()) != null) {
	                   
	                     if (line.equals(formno)) {
	                         reader.close();		                         
	                         return ; 
	                     }
	                 }
	                 reader.close();
	                 
	                 BufferedWriter writer = new BufferedWriter(new FileWriter("notepad_signupTwo.txt", true));
	                 

	                 writer.write("formno:" + formno);
	                 writer.newLine();
	                 writer.write("religion:" + religion);
	                 writer.newLine();
	                 writer.write("category:" + category);
	                 writer.newLine();
	                 writer.write("income:" + income);
	                 writer.newLine();
	                 writer.write("education:" + education);
	                 writer.newLine();
	                 writer.write("occupation:" + occupation);
	                 writer.newLine();
	                 writer.write("pan:" + pan);
	                 writer.newLine();
	                 writer.write("addhar:" + aadhar);
	                 writer.newLine();
	                 writer.write("scitizen:" + scitizen);
	                 writer.newLine();
	                 writer.write("eaccount:" + eaccount);
	                 writer.newLine();

	                 writer.close();
	            

	                
	                new SignupThree(formno).setVisible(true);
	                setVisible(false);
	            }
	            
	        }catch(IOException ex) {
              System.out.println("Error writing to file: " + ex);
	        }
	        
	    }
    
    
    public static void main(String[] args){
        new SignupTwo("").setVisible(true);
    }
}