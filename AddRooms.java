package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
  AddRooms(){
	  JLabel l1= new JLabel("ADD ROOMS");
	  l1.setBounds(150,20,100,20);
	  l1.setFont(new Font("Tahoma",Font.BOLD,15 ));
	  add(l1);
	  
	  JLabel room = new JLabel("Room Number");
	  room.setBounds(60,80,120,30);
	  room.setFont(new Font("Tahoma",Font.PLAIN,12));
	 
	  add(room);
	  t1= new JTextField();
	  t1.setBounds(180,80,150,30);
	  add(t1);
	  
	  JLabel available = new JLabel("Available");
	  available.setBounds(60,130,120,30);
	  available.setFont(new Font("Tahoma",Font.PLAIN,12));
	 
	  add(available);
	  c1= new JComboBox(new String[]  {"Available","Occupied"});
	  c1.setBounds(180,130,150,30);
	  add(c1);
	  JLabel status = new JLabel("Cleaning Status");
	  status.setBounds(60,180,120,30);
	  status.setFont(new Font("Tahoma",Font.PLAIN,12));
	 
	  add(status);
	  c2= new JComboBox(new String[]  {"Clean","Dirty"});
	  c2.setBounds(180,180,150,30);
	  add(c2);
	  JLabel price = new JLabel("Price");
	  price.setBounds(60,230,120,30);
	  price.setFont(new Font("Tahoma",Font.PLAIN,12));
	 
	  add(price);
	  t2= new JTextField();
	  t2.setBounds(180,230,150,30);
	  add(t2);
	  JLabel type = new JLabel("Bed Type");
	  type.setBounds(60,280,120,30);
	  type.setFont(new Font("Tahoma",Font.PLAIN,12));
	 
	  add(type);
	  c3= new JComboBox(new String[]  {"Single Bed","Double Bed"});
	  c3.setBounds(180,280,150,30);
	  add(c3);
	  b1= new JButton("ADD ROOM");
	  b1.setBounds(60,350,130,30);
	  b1.setBackground(Color.black);
	  b1.addActionListener(this);
		b1.setForeground(Color.white);
	  add(b1);
	  b2= new JButton("CANCEL");
	  b2.setBounds(220,350,120,30);
	  add(b2);
	  b2.addActionListener(this);
	  b2.setBackground(Color.black);
		b2.setForeground(Color.white);
	  
	  
	  setBounds(250,200,980,500);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
	  
	  JLabel l2= new JLabel(i1);
	  l2.setBounds(400,30,500,350);
	  add(l2);
	  
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setVisible(true);
	  
  }
  public void actionPerformed(ActionEvent ae) {
	  if(ae.getSource()==b1) {
		  String room= t1.getText();
		  String available= (String)c1.getSelectedItem();
		  String status= (String)c2.getSelectedItem();
		  String price= t2.getText();
		  String type= (String)c3.getSelectedItem();
		  conn c = new conn();
		  try {
			  String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
              
              
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Room Successfully Added");
		                this.setVisible(false);
		  }catch(Exception e){
			  System.out.println(e);
		  }
			  
		  }
		  
		  
	  else if(ae.getSource()==b2)
		  this.setVisible(false);
	  
  }
  public static void main(String[] args)
  {
	  new AddRooms().setVisible(true);
  }
}
