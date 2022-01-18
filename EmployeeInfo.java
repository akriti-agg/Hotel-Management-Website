package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
	JTable t1;
	JButton b1,b2;
	
	
	EmployeeInfo(){
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
		
		JLabel l1 = new JLabel("Name");
		 l1.setBounds(31, 11, 46, 14);
		add(l1);
		JLabel l2 = new JLabel("Age");
		 l2.setBounds(150, 11, 46, 14);
		add(l2);
		JLabel l3 = new JLabel("Gender");
		 l3.setBounds(270, 11, 46, 14);
		add(l3);
		JLabel l4 = new JLabel("Job");
		 l4.setBounds(490, 11, 46, 14);
		add(l4);
		JLabel l5 = new JLabel("Salary");
		 l5.setBounds(650, 11, 46, 14);
		add(l5);
		
		JLabel l6 = new JLabel("Phone");
		 l6.setBounds(750, 11, 46, 14);
		add(l6);
		JLabel l7 = new JLabel("Email");
		 l7.setBounds(850, 11, 46, 14);
		add(l7);
		
		setLayout(null);
		setBounds(200,100,1000,700);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c= new conn();
				String str= "select * from employee";
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
		new EmployeeInfo().setVisible(true);
	}

}
