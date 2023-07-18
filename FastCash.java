package ATM2;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.io.*;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
	private static final long serialVersionUID = 123456789987654321L;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin,mode,amount;

    FastCash(String pin ,String mode, String amount) {
        this.pin = pin;
        this.mode=mode;
        this.amount=amount;
        Icon icon = new ImageIcon("G:\\atm.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(0,0,960,1080);
		 add(label);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("50$");
        b2 = new JButton("100$");
        b3 = new JButton("200$");
        b4 = new JButton("500$");
        b5 = new JButton("1000$");
        b6 = new JButton("2000$");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(235, 400, 700, 35);
        label.add(l1);

        b1.setBounds(170, 499, 150, 35);
        label.add(b1);

        b2.setBounds(390, 499, 150, 35);
        label.add(b2);

        b3.setBounds(170, 543, 150, 35);
        label.add(b3);

        b4.setBounds(390, 543, 150, 35);
        label.add(b4);

        b5.setBounds(170, 588, 150, 35);
        label.add(b5);

        b6.setBounds(390, 588, 150, 35);
        label.add(b6);

        b7.setBounds(390, 633, 150, 35);
        label.add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        try {
            int selectedAmount = 0;

            if (ae.getSource() == b1) {
                selectedAmount = 50;
            } else if (ae.getSource() == b2) {
                selectedAmount = 100;
            } else if (ae.getSource() == b3) {
                selectedAmount = 200;
            } else if (ae.getSource() == b4) {
                selectedAmount = 500;
            } else if (ae.getSource() == b5) {
                selectedAmount = 1000;
            } else if (ae.getSource() == b6) {
                selectedAmount = 2000;
            }

            File bankFile = new File("notepad_Bank.txt");
            List<String> bankLines = Files.readAllLines(bankFile.toPath());
            int balance = bankLines.size() >= 3 ? Integer.parseInt(bankLines.get(2)) : 0;

            if (selectedAmount > balance) {
                System.out.println("You don't have sufficient funds in your account.");
                return;
            }

            balance -= selectedAmount;
            bankLines.set(2, String.valueOf(balance));
            bankLines.set(3, new Date().toString());

            BufferedWriter bankWriter = new BufferedWriter(new FileWriter("notepad_Bank.txt"));
            for (String updatedLine : bankLines) {
                bankWriter.write(updatedLine);
                bankWriter.newLine();
            }
            bankWriter.close();

            Date date = new Date();
            String transaction = pin + "\n" + "Withdrawal\n" + selectedAmount + "\n" + date + "\n";

            BufferedWriter withdrawWriter = new BufferedWriter(new FileWriter("notepad_Withdraw.txt", true));
            withdrawWriter.write(transaction);
            withdrawWriter.close();
            WithdrawHistory.refresh();
            BankHistory.refresh();
            JOptionPane.showMessageDialog(null, "$ " + selectedAmount + " Withdrawal Successfully");  
        } catch (IOException e) {
            e.printStackTrace();
        }
      if (ae.getSource() == b7) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }}}


