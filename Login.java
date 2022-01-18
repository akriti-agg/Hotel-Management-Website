package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
//global declaration 
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	Login(){
		setBounds(500,300,600,300);
		
		l1= new JLabel("USERNAME");
		l1.setBounds(40,20,100,30);
	    add(l1);
		l2= new JLabel("PASSWORD");
		l2.setBounds(40,70,100,30);
		add(l2);
		t1= new JTextField();
		t1.setBounds(150,20,150,30);
		add(t1);
		t2= new JPasswordField();
		t2.setBounds(150,70,150,30);
		add(t2);
		
		b1= new JButton("Login");
		b1.setBounds(40,140,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this) ;
		add(b1);
		b2= new JButton("Cancel");
		b2.setBounds(170,140,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		add(b2);
		b2.addActionListener( this);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);//used to change size of image
        ImageIcon i3 =  new ImageIcon(i2);//we have done this because in label only imageicon can be passed not images
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae){
		
        if(ae.getSource()==b1){
        	conn c1 = new conn();
            String u = t1.getText();//this method return string
            String v = t2.getText();
            String q="select * from login where username = '"+u+"' and password = '"+v+"'";
           
        try{
            
            
            
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
                new Dashboard().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
               setVisible(false);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
	public static void main(String[] args) {
		new Login();
	}
}
