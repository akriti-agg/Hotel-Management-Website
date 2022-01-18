package hotel.management.system;


import javax.swing.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;


public class CheckOut  extends JFrame implements ActionListener{
	
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
CheckOut(){
	JLabel l1= new JLabel("Check Out");
	  l1.setBounds(100,20,100,30);
	  l1.setFont(new Font("Tahoma",Font.PLAIN,18 ));
	  l1.setForeground(Color.BLUE);
	  add(l1);
	  JLabel l2= new JLabel("Customer ID");
	  l2.setBounds(30,80,100,30);
	 
	  add(l2);
	  c1= new Choice();
	  try {
		  
		  
		  conn c= new conn();
		  ResultSet rs= c.s.executeQuery("select * from customer");
		  while(rs.next()) {
			  c1.add(rs.getString("number"));
			  
		  }
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  c1.setBounds(150,80,150,30);
	  add(c1);
	  
	  JLabel l3= new JLabel("Room No.");
	  l3.setBounds(30,130,100,30);
	  
	  add(l3);
	  t1= new JTextField();
	  t1.setBounds(150,130,150,30);
	  add(t1);
	  b1= new JButton("Checkout");
	  b1.setBounds(30,180,120,30);
	  b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
	  add(b1);
	  b2= new JButton("Back");
	  b2.setBounds(180,180,120,30);
	  b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
	  add(b2);
	  
      ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
      Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
      ImageIcon i2 = new ImageIcon(i3);
      JLabel l4 = new JLabel(i2);
      l4.setBounds(300,0,500,225);
      add(l4);
      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
      Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
      ImageIcon i6 = new ImageIcon(i5);
       b3 = new JButton(i6);
      b3.setBounds(320,82,20,20);
      b3.addActionListener(this);
      add(b3);
	  
	  setBounds(250,200,980,500);
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==b1) {
		String id = c1.getSelectedItem();
        String s1 = t1.getText();
           String deleteSQL = "Delete from customer where number = "+id;
        String q2 = "update room set available = 'Available' where room_number = "+s1;
        
        
        
conn c = new conn();
try{
	
	
	c.s.executeUpdate(deleteSQL);
	c.s.executeUpdate(q2);
	JOptionPane.showMessageDialog(null, "Check Out Successful");
	new Reception().setVisible(true);
                this.setVisible(false);

	}catch(Exception e) {
		
	}}
else if(ae.getSource()==b2) {
		new Reception().setVisible(true);
		this.setVisible(false);
	}else if(ae.getSource()==b3) {
		conn c= new conn();
		String id= c1.getSelectedItem();
		try {
			ResultSet rs= c.s.executeQuery("select * from customer where number = '"+id+"'");
			while(rs.next()) {
				t1.setText(rs.getString("room"));
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		}
}
public static void main(String[] args) {
	new CheckOut().setVisible(true);
}
}
