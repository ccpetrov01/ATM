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


public class Withdrawl extends JFrame implements ActionListener{
	private static final long serialVersionUID = 123456789987654321L;
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        Icon icon = new ImageIcon("G:\\atm.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(0,0,960,1080);
		 add(label);
		 
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS 2000$");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        b3 = new JButton("Withdrawal History");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,20);
        label.add(l1);
        
        l2.setBounds(190,400,400,20);
        label.add(l2);
        
        t1.setBounds(190,450,330,30);
        label.add(t1);
        
        b1.setBounds(390,588,150,35);
        label.add(b1);
        
        b2.setBounds(390,633,150,35);
        label.add(b2);
        
        b3.setBounds(200, 633, 150, 35);
        label.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
      /*  WithdrawHistory historyWindow = new WithdrawHistory();
        historyWindow.setLocation(0, 0);
        historyWindow.setVisible(true); 
 */
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();

            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    BufferedReader reader = new BufferedReader(new FileReader("notepad_Bank.txt"));
                    List<String> lines = new ArrayList<>();
                    String line;
                    int lineCount = 0;
                    while ((line = reader.readLine()) != null) {
                        lineCount++;
                        lines.add(line);
                        if (lineCount == 3) {
                            int balance = lines.size() >= 3 ? Integer.parseInt(lines.get(2)) : 0;
                            int withdrawAmount = Integer.parseInt(amount);
                            if (balance < withdrawAmount) {
                                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                                reader.close();
                                return;
                            }
                            balance -= withdrawAmount;
                            lines.set(2, String.valueOf(balance));
                        }
                    }
                    reader.close();

                    BufferedWriter bankWriter = new BufferedWriter(new FileWriter("notepad_Bank.txt"));
                    for (String updatedLine : lines) {
                        bankWriter.write(updatedLine);
                        bankWriter.newLine();
                    }
                    bankWriter.close();

                    BufferedWriter withdrawWriter = new BufferedWriter(new FileWriter("notepad_Withdraw.txt", true));
                    String transaction = pin + "\n" + "Withdrawal" + "\n" + amount + "\n" + date.toString() + "\n";
                    withdrawWriter.write(transaction);
                    withdrawWriter.close();
                    WithdrawHistory.refresh();
                    BankHistory.refresh();
                    
                    

                    JOptionPane.showMessageDialog(null, "$ " + amount + " Withdrawn Successfully");
                    setVisible(false);
                    new Withdrawl(pin).setVisible(true);
                    
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
            else if (ae.getSource() == b3) {
            	setVisible(false);
                WithdrawHistory.refresh();
                BankHistory.refresh();
            }setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}