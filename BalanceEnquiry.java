package ATM2;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class BalanceEnquiry extends JFrame implements ActionListener {
	private static final long serialVersionUID = 123456789987654321L;
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        Icon icon = new ImageIcon("G:\\atm.JPG");
		 Image i2 = ((ImageIcon) icon).getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel label = new JLabel(i3);
		 label.setBounds(0,0,960,1080);
		 add(label);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        label.add(l1);

        b1.setBounds(390, 633, 150, 35);
        label.add(b1);
        String fileName = "notepad_Bank.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 3) {
                    int amount = Integer.parseInt(line);
                    l1.setText("Your Current Account Balance is $ " + amount);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
}

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}