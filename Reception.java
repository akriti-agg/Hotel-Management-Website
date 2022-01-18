package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener {
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
Reception(){
	b1= new JButton("New Customer Form");
	b1.setBounds(10,30,200,30);
	b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
	b1.addActionListener(this);
	add(b1);
	
	b2= new JButton("Room");
	b2.setBounds(10,70,200,30);
	b2.setBackground(Color.BLACK);
	b2.setForeground(Color.WHITE);
	b2.addActionListener(this);
	add(b2);
	
	b3= new JButton("Department");
	b3.setBounds(10,110,200,30);
	b3.setBackground(Color.BLACK);
	b3.setForeground(Color.WHITE);
	b3.addActionListener(this);
	add(b3);
	b4= new JButton("All Employee info");
	b4.setBounds(10,150,200,30);
	b4.setBackground(Color.BLACK);
	b4.setForeground(Color.WHITE);
	b4.addActionListener(this);
	add(b4);
	
	b5= new JButton("Customer info");
	b5.setBounds(10,190,200,30);
	b5.setBackground(Color.BLACK);
	b5.setForeground(Color.WHITE);
	b5.addActionListener(this);
	add(b5);
	b6= new JButton("Manager info");
	b6.setBounds(10,230,200,30);
	b6.setBackground(Color.BLACK);
	b6.setForeground(Color.WHITE);
	b6.addActionListener(this);
	add(b6);
	
	b7= new JButton("Checkout");
	b7.setBounds(10,270,200,30);
	b7.setBackground(Color.BLACK);
	b7.setForeground(Color.WHITE);
	b7.addActionListener(this);
	add(b7);
	b8= new JButton("Update check Status");
	b8.setBounds(10,310,200,30);
	b8.setBackground(Color.BLACK);
	b8.setForeground(Color.WHITE);
	b8.addActionListener(this);
	add(b8);
	
	b9= new JButton("update room status");
	b9.setBounds(10,350,200,30);
	b9.setBackground(Color.BLACK);
	b9.setForeground(Color.WHITE);
	b9.addActionListener(this);
	add(b9);
	
	b10= new JButton("Pickup service");
	b10.setBounds(10,390,200,30);
	b10.setBackground(Color.BLACK);
	b10.setForeground(Color.WHITE);
	b10.addActionListener(this);
	add(b10);
	b11= new JButton("Search");
	b11.setBounds(10,430,200,30);
	b11.setBackground(Color.BLACK);
	b11.setForeground(Color.WHITE);
	b11.addActionListener(this);
	add(b11);
	b12= new JButton("LOGOUT");
	b12.setBounds(10,470,200,30);
	b12.setBackground(Color.BLACK);
	b12.setForeground(Color.WHITE);
	b12.addActionListener(this);
	add(b12);
	
	ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
	JLabel l1= new JLabel(i1);
	l1.setBounds(250,30,500,470);
	add(l1);
	
	
	
	
	
	
	
	
	
	
	
	
	
	getContentPane().setBackground(Color.WHITE);
	setBounds(300,100,800,550);
	setLayout(null);
	setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==b1) {
		new AddCustomer().setVisible(true);
		this.setVisible(false);
		
	}else if(ae.getSource()==b2) {
		new Rooms().setVisible(true);
		this.setVisible(false);
	}
	
	else if(ae.getSource()==b3) {
		
	}
	
	else if(ae.getSource()==b4) {
		new EmployeeInfo().setVisible(true);
		this.setVisible(false);
	}
	
	else if(ae.getSource()==b5) {
		new CustomerInfo().setVisible(true);
		this.setVisible(false);
		
	}
	
	else if(ae.getSource()==b6) {
		
	}
	
	else if(ae.getSource()==b7) {
		new CheckOut().setVisible(true);
		this.setVisible(false);
		
	}
	
	else if(ae.getSource()==b8) {
		new UpdateCheck().setVisible(true);
		this.setVisible(false);
	}
	
	else if(ae.getSource()==b9) {
		new UpdateRoom().setVisible(true);
		this.setVisible(false);
	}
	
	else if(ae.getSource()==b10) {
		
	}
	
	else if(ae.getSource()==b12) {
		this.setVisible(false);
	}
	
}
public static void main(String[] args) {
	new Reception().setVisible(true);
}
}
