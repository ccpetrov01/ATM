package ATM2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 123456789987654321L;
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin;
    Pin(String pin){
        this.pin = pin;
        Icon icon = new ImageIcon("G:\\atm.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(0,0,960,1080);
		 add(label);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("Old Pin:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("New Pin:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(280,330,800,35);
        label.add(l1);
        
        l2.setBounds(180,390,150,35);
        label.add(l2);
        
        l3.setBounds(180,440,200,35);
        label.add(l3);
        
        t1.setBounds(350,390,180,25);
        label.add(t1);
        
        t2.setBounds(350,440,180,25);
        label.add(t2);
        
        b1.setBounds(390,588,150,35);
        label.add(b1);
        
        b2.setBounds(390,633,150,35);
        label.add(b2);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String fileName1 = "notepad_Bank.txt";
        String fileName2 = "notepad_Login.txt";

        try {
            char[] oldPinChars;
            char[] newPinChars;

            if (ae.getSource() == b1) {
                oldPinChars = t1.getPassword();
                newPinChars = t2.getPassword();
            } else {
                oldPinChars = t2.getPassword();
                newPinChars = t1.getPassword();
            }

            String oldPin = String.valueOf(oldPinChars);
            String newPin = String.valueOf(newPinChars);

            if (!oldPin.equals(pin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN is incorrect");
                return;
            }

            if (newPin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter New PIN");
                return;
            }

            BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

            List<String> lines1 = new ArrayList<>();
            List<String> lines2 = new ArrayList<>();

            String line1, line2;

            while (((line1 = reader1.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
                lines1.add(line1);
                lines2.add(line2);
            }

            reader1.close();
            reader2.close();

            lines1.set(0, newPin);
            lines2.set(2, "pin:"+newPin);

            BufferedWriter writer1 = new BufferedWriter(new FileWriter(fileName1));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName2));

            for (String line : lines1) {
                writer1.write(line);
                writer1.newLine();
            }

            for (String line : lines2) {
                writer2.write(line);
                writer2.newLine();
            }

            writer1.close();
            writer2.close();

            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transaction(newPin).setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
