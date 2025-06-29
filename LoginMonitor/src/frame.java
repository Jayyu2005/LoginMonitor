import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;
public class frame extends JFrame implements ActionListener {
	// a simple system that tracks failed login attempts and locks out users after too many tries
	JPasswordField passwordField = new JPasswordField(); 
	JTextField userfield = new JTextField();
	JButton button = new JButton("Submit");
	JButton makeacc = new JButton("Register");
	JLabel warning = new JLabel("Username or password does not match.");
	static Monitor mon = new Monitor();
	static int attempts = 0;
	Timer lockoutTimer;
	
	frame()
	{
		
	    this.setTitle("Login System");
	    this.setSize(400, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new BorderLayout());
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(5, 2, 10, 10)); // Changed to 5 rows, 2 columns

	    JLabel title = new JLabel("Login to System", JLabel.CENTER);
	    
	    // Add components in pairs (label, field)
	    panel.add(new JLabel("")); 
	    panel.add(title);
	    panel.add(new JLabel("Username:"));
	    panel.add(userfield);
	    panel.add(new JLabel("Password:"));
	    panel.add(passwordField);
	    
	    panel.add(button); 
	    panel.add(makeacc);
	    
	    warning.setFont(new Font("Arial", Font.BOLD, 9));
	    warning.setForeground(Color.RED);
	    warning.setVisible(false); // Start hidden
	    panel.add(warning);

	    this.add(panel, BorderLayout.CENTER);
	    
	    //button settings
	    button.addActionListener(this);
	    makeacc.addActionListener(this);
	    button.setFocusPainted(false);
	    makeacc.setFocusPainted(false);
	    
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == button)
	    {		
	    	// Convert char[] to String for comparison
	            String enteredPassword = new String(passwordField.getPassword());
	            String enteredUsername = userfield.getText();
	            
	            if(attempts >= mon.getAttempts())
	            {
	            	int lockoutSeconds = 600;
	            	button.setEnabled(false);
	            	
	            	lockoutTimer = new Timer(1000, new ActionListener() {
	                    int remaining = lockoutSeconds;

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							remaining--;
							if (remaining <= 0)
							{
								lockoutTimer.stop();
								button.setEnabled(true);
								attempts = 0; 
							}
							else
							{
								warning.setText("Too many failed attempts please wait");
							}
							warning.setVisible(true);
						}
	            	}
	            );
	                lockoutTimer.start();
	                return;
	    }
	
	            
	            if(mon.map.containsKey(enteredUsername))
	            {
	            	if(mon.map.get(enteredUsername).equals(enteredPassword))
	            	{
	            		new Login();
	            		this.dispose();
	            	}
	            	else 
	            	{  
	            		attempts++;
	            	}
	            }
	            else
	            {
	            	warning.setText("Username or password does not match.");
	            	warning.setVisible(true);
	            	attempts++;
	            }

	    }
		if(e.getSource() == makeacc)
		{
			new Register();
			this.dispose();
		}
	}
}
