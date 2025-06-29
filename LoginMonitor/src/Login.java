import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
JLabel label = new JLabel("Login success!");
JTextArea description = new JTextArea(
        "This program is a Java-based GUI application that allows users to register and log into a system securely.\n"
      + "It also locks the login button after too many failed attempts and starts a 10-minute lockout timer."
    );
JButton back = new JButton("Back");
	Login()
	{
		this.setTitle("Welcome");
        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        // Label styling
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setForeground(new Color(0, 128, 0));
        this.add(label, BorderLayout.NORTH);

        // Description styling
        description.setFont(new Font("SansSerif", Font.PLAIN, 16));
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setOpaque(false);
        description.setFocusable(false);
        description.setBackground(UIManager.getColor("Label.background"));
        description.setMargin(new Insets(10, 20, 10, 20));
        this.add(description, BorderLayout.CENTER);

        // Back button styling
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(back);
        back.setFocusPainted(false);
        back.addActionListener(this);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back)
		{
			new frame();
			this.dispose();
		}
	}

}
