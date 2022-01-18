package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
	 public static void main(String[] args) {
	        new Dashboard().setVisible(true);
	    }
	 
	 public Dashboard()  {
	       // super("HOTEL MANAGEMENT SYSTEM");
		
		 setSize(1950,1090);
		 setVisible(true);
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2); 
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(0, 0, 1950, 1000); 
	        add(NewLabel);
	        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
	    	l2.setForeground(Color.WHITE);
	            l2.setFont(new Font("Tahoma", Font.PLAIN, 46));
	    	l2.setBounds(400, 60, 1000, 85);
	    	NewLabel.add(l2);
	    	 JMenuBar mb = new JMenuBar();
	    		setJMenuBar(mb);
	    		JMenu m = new JMenu("HOTEL MANAGEMENT");
	            m.setForeground(Color.BLUE);
	    	mb.add(m);
	    	 JMenuItem l1 = new JMenuItem("RECEPTION");
	    	 l1.addActionListener(this);
	    		m.add(l1);
	    		JMenu m2 = new JMenu("ADMIN");
	            m2.setForeground(Color.RED);
	    	mb.add(m2);
	    	JMenuItem l3 = new JMenuItem("ADD EMPLOYEE");
	    	l3.addActionListener(this);
	    	m2.add(l3);
	    	JMenuItem l4 = new JMenuItem("ADD ROOMS");
	    	l4.addActionListener(this);
	    	m2.add(l4);
	    	
	    	
	    	setForeground(Color.CYAN);
	        setLayout(null); 
	            getContentPane().setBackground(Color.WHITE);
	    	
	    		
	 }
	 public void actionPerformed(ActionEvent ae) {
		 if(ae.getActionCommand().equals("RECEPTION")){
			 new Reception().setVisible(true);
			 
			 
		 }else if(ae.getActionCommand().equals("ADD EMPLOYEE"))//this methods returns a string in our case string is the name of menuitem name{
			new AddEmployee().setVisible(true);
		 else if(ae.getActionCommand().equals("ADD ROOMS"))//this methods returns a string in our case string is the name of menuitem name{
				new AddRooms().setVisible(true); 
		 }
	 }
	 
	 
