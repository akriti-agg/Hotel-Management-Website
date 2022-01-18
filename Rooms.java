package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Rooms extends JFrame implements ActionListener{
	JTable t1;
	JButton b1,b2;
	
	
	Rooms(){
		t1= new JTable();
		t1.setBounds(0,40,1000,500);
		add(t1);
		
		b1= new JButton("Load Data");
		b1.setBounds(350,560,120,30);
		add(b1);
		b1.addActionListener(this);
		b2= new JButton("Back");
		b2.setBounds(530,560,120,30);
		b2.addActionListener(this);
		add(b2);
		JLabel l1 = new JLabel("room_number");
		 l1.setBounds(31, 11, 100, 14);
		add(l1);
		JLabel l2 = new JLabel("available");
		 l2.setBounds(250, 11, 100, 14);
		add(l2);
		JLabel l3 = new JLabel("status");
		 l3.setBounds(470, 11, 100, 14);
		add(l3);
		JLabel l4 = new JLabel("price");
		 l4.setBounds(690, 11, 100, 14);
		add(l4);
		JLabel l5 = new JLabel("bed_type");
		 l5.setBounds(800, 11, 100, 14);
		add(l5);
		setLayout(null);
		setBounds(200,100,1000,700);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c= new conn();
				String str= "select * from room";
				ResultSet rs= c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}catch(Exception e) {
				System.out.println(e);
				
			}
			
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new Rooms().setVisible(true);
	}

}
