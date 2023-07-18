package ATM2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class WithdrawHistory extends JFrame {
	private static final long serialVersionUID = 123456789987654321L;
	private static WithdrawHistory historyWindow;
	private JTextArea textArea;
    WithdrawHistory() {
        setTitle("Withdrawal History");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        try {
            BufferedReader reader = new BufferedReader(new FileReader("notepad_Withdraw.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(520, 1080);
        setLocation(0, 0);
        setVisible(true);
        historyWindow = this;
        
        addComponentListener((ComponentListener) new ComponentAdapter() {
            
            public void componentMoved(ComponentEvent e) {
                setLocation(1450,0); 
            }
        });
    }
    
    public static void refresh() {
        if (historyWindow == null) {
            historyWindow = new WithdrawHistory();
        } else {
            historyWindow.updateContent();
        }
    }

    private void updateContent() {
        try {
            StringBuilder content = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader("notepad_Withdraw.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            textArea.setText(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }
}