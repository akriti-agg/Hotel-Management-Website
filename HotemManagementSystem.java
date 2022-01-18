

package hotel.management.system;
//import java.util.*;
import javax.swing.*;
import java.awt.event.*; // we import this because when we import any package all its classes are imported not the packages within the package , soo event is a package within awt  
import java.awt.*;
//jframe contains all graphics like drop downs  scroll bars and is present inside package swings
public class HotemManagementSystem extends JFrame implements ActionListener {
//our all coding all jframe will be done inside constructor
	HotemManagementSystem(){
		//setSize(400,400);
		setBounds(20,100,1366,565);//takes both arguments of size and location
		
	
		//setLocation(300,300);//this function set location of frame with respect to screen ans x axis nd y axis
	ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
	//we cant put image directly to frmae need to create labels
	JLabel l1= new JLabel(i1);
	l1.setBounds(0,0,1366,565);
	add(l1);
	JLabel l2= new JLabel("Hotel Management System");
	l2.setBounds(20,420,1000,90);
	l2.setFont(new Font("serif",Font.PLAIN,70));
	l2.setForeground(Color.white);
	
	l1.add(l2);
	JButton b1 = new JButton("Next");
     
     b1.setBackground(Color.WHITE);
     b1.setForeground(Color.BLACK);
     b1.setBounds(1170,450,150,50);
     b1.addActionListener(this);
     l1.add(b1);
	setLayout(null);
	setVisible(true);//by default frame have set visible false, always used at last
	//this is used to make dipper our text using multithreading
	while(true){
        l2.setVisible(false); // l2 =  j label
    try{
    	//always used inside try catch
        Thread.sleep(500); //1000 = 1 second
    }catch(Exception e){} 
        l2.setVisible(true);
    try{
        Thread.sleep(500);
    }catch(Exception e){}
}
	//need to overwrite the method of implemented interface
	
}
	public void actionPerformed(ActionEvent ar) {
		new Login().setVisible(true);
		this.setVisible(false);//this is the current class object
	}
	
	
	
	
	public static void main(String[] args) {
		new HotemManagementSystem();
	}
	
}