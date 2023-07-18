package ATM2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
	private static final long serialVersionUID = 123456789987654321L;
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        Icon icon = new ImageIcon("G:\\atm.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(0,0,960,1080);
		 add(label);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,35);
        label.add(l1);
        
        t1.setBounds(190,420,320,25);
        label.add(t1);
        
        b1.setBounds(390,588,150,35);
        label.add(b1);
        
        b2.setBounds(390,633,150,35);
        label.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();

            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    int depositAmount = Integer.parseInt(amount);

                    BufferedReader reader = new BufferedReader(new FileReader("notepad_Bank.txt"));
                    List<String> lines = new ArrayList<>();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                    reader.close();

                    if (lines.size() == 0) {
                        lines.add(pin);
                        lines.add("Deposit");
                        lines.add(String.valueOf(depositAmount));
                        lines.add(date.toString());
                    } else if (lines.size() < 3) {
                        System.out.println("Invalid file format. Please ensure the file contains the necessary data.");
                        return;
                    } else {
                        int balance = Integer.parseInt(lines.get(2).trim());
                        balance += depositAmount;
                        lines.set(2, String.valueOf(balance));
                        lines.set(3, date.toString()); 
                    }

                    BufferedWriter bankWriter = new BufferedWriter(new FileWriter("notepad_Bank.txt"));
                    for (String updatedLine : lines) {
                        bankWriter.write(updatedLine);
                        bankWriter.newLine();
                    }
                    bankWriter.close();

                    BufferedWriter depositWriter = new BufferedWriter(new FileWriter("notepad_Deposit.txt", true));
                    String transaction = pin + "\n" + "Deposit" + "\n" + depositAmount + "\n" + date.toString() + "\n";
                    depositWriter.write(transaction);
                    depositWriter.close();
                    DepositHistory.refresh();
                    BankHistory.refresh();
                    JOptionPane.showMessageDialog(null, "$. " + depositAmount + " Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}