import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Register extends JFrame implements ActionListener{
	JButton B = new JButton();
	JTextField user = new JTextField();
	JPasswordField P = new JPasswordField(); 
    JPasswordField reenterP = new JPasswordField();
	
	JLabel label = new JLabel("");

	Register()
	{
		//frameworks
	    this.setTitle("Register New Account");
	    this.setSize(400, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(6, 2, 10, 10));
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    
	    //adding items
	    this.add(new JLabel("Username:"));
	    this.add(user);
	    this.add(new JLabel("Password:"));
	    this.add(P);
	    this.add(new JLabel("Re-enter Password:"));
	    this.add(reenterP);
	    this.add(new JLabel(""));
	    this.add(B);
	    this.add(label);
	    label.setVisible(false);
	    label.setForeground(Color.RED);
	    label.setFont(new Font("Arial", Font.BOLD, 10));

	    //button settings
	    B.setText("Register");
	    B.setFocusPainted(false);
	    B.addActionListener(this);
	    
	    
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == B) {
	        String password = new String(P.getPassword());
	        String reenterPassword = new String(reenterP.getPassword());
	        String username = user.getText().trim();
	        
	        if(username.isEmpty() || password.isEmpty()) {
	            label.setText("Username and password empty!");
	            label.setVisible(true);
	            this.repaint();
	            return;
	        }
	        
	        if(username.length() < 8 || password.length() < 8) {
	            label.setText("Usernam or password too short!");
	            label.setVisible(true);
	            this.repaint();
	            return;
	        }
	        
	        if(username.equals(password))
	        {
	            label.setText("Username and password cant match!");
	            label.setVisible(true);
	            this.repaint();
	            return;
	        }

	        if(Monitor.map.containsKey(username)) {
	            label.setText("This username already exists!");
	            label.setVisible(true);
	            this.repaint();
	            return;
	        }

	        if(password.equals(reenterPassword)) {
	            
	            frame.mon.setacc(username, reenterPassword);
	            label.setVisible(false); 
	            new frame();
	            this.dispose();
	        } else {
	            label.setText("Passwords do not match"); 
	            label.setVisible(true);
	            this.repaint();
	            this.revalidate();
	        }
	    }
	}
	

}
