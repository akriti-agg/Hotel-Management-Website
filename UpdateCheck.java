package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener{

	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5;
	Choice c1;
	UpdateCheck(){
		JLabel l1= new JLabel("Check In Details");
		l1.setBounds(50,30,200,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,25));
		l1.setForeground(Color.BLUE);
		add(l1);
		JLabel l2= new JLabel("Customer ID");
		l2.setBounds(30,80,100,20);
		
		add(l2);
		c1= new Choice();
		try {
			conn c= new conn();
			ResultSet rs= c.s.executeQuery("select * from customer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
			
		}catch(Exception e) {
			
		}
		c1.setBounds(200,80,150,25);
		add(c1);
		
		JLabel l3= new JLabel("Room Number");
		l3.setBounds(30,130,100,20);
		
		add(l3);
		
		t1= new JTextField();
		t1.setBounds(200,130,150,25);
		add(t1);
		JLabel l4= new JLabel("Name");
		l4.setBounds(30,180,100,20);
		
		add(l4);
		t2= new JTextField();
		t2.setBounds(200,180,150,25);
		add(t2);
		JLabel l5= new JLabel("Check-In");
		l5.setBounds(30,230,100,20);
		
		add(l5);
		t3= new JTextField();
		t3.setBounds(200,230,150,25);
		add(t3);
		JLabel l6= new JLabel("Amount Piaid");
		l6.setBounds(30,280,100,20);
		
		add(l6);
		t4= new JTextField();
		t4.setBounds(200,280,150,25);
		add(t4);
		JLabel l7= new JLabel("Pending Account");
		l7.setBounds(30,330,100,20);
		
		add(l7);
		t5= new JTextField();
		t5.setBounds(200,330,150,25);
		add(t5);
		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
         JLabel l8 = new JLabel(i1);
         l8.setBounds(450,70,476,270);
         add(l8);
		
		b1= new JButton("Check");
		 b1.setForeground(Color.WHITE);
		 b1.setBackground(Color.BLACK);
		 b1.setBounds(30,380,100,30);
		 b1.addActionListener(this);
		 add(b1);
		 b2= new JButton("Update");
		 b2.setForeground(Color.WHITE);
		 b2.setBackground(Color.BLACK);
		 b2.setBounds(150,380,100,30);
		 b2.addActionListener(this);
		 add(b2);
		 b3= new JButton("Back");
		 b3.setForeground(Color.WHITE);
		 b3.setBackground(Color.BLACK);
		 b3.addActionListener(this);
		 b3.setBounds(270,380,100,30);
		 add(b3);
		 
		
		
		setBounds(300,200,1000,500);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c= new conn();
				String id=c1.getSelectedItem();
				String str="select * from customer where number = '"+id+"'";
				ResultSet rs=c.s.executeQuery(str);
				String room=null;
				String deposit=null;
				String price=null;
				int AmountPaid;
				
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposit"));
					room=rs.getString("room");
					deposit=rs.getString("deposit");
				}
				ResultSet rs2=c.s.executeQuery("select * from room where room_number = '"+room+"'");
				while(rs2.next()) {
					price=rs2.getString("price");
					AmountPaid=Integer.parseInt(price)-Integer.parseInt(deposit);
					t5.setText(Integer.toString(AmountPaid));
				}
				
			}catch(Exception e){
				
			}
			
		}else if(ae.getSource()==b2) {
			try{
                conn c = new conn();
                
                String s1 = c1.getSelectedItem();
                  String s2 = t1.getText(); //room_number;    
                String s3 = t2.getText(); //name    
                String s4 = t3.getText(); //status;    
                String s5 = t4.getText(); //deposit    

                c.s.executeUpdate("update customer set room = '"+s2+"', name = '"+s3+"', status = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reception().setVisible(true);
                setVisible(false);
            }catch(Exception ee){
                System.out.println(ee);
            }		
			
		}else if(ae.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args) {
		new UpdateCheck();
	}
}
