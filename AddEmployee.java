package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
	JTextField t1;//global because it is used outside function during actionlistener use
	JTextField t2;
	JTextField t3,t4,t5;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
 AddEmployee(){
	 
	 
	 ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
	 Image i2= i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
	 ImageIcon i3= new ImageIcon(i2);
	 
	 JLabel l1= new JLabel(i3);
	 l1.setBounds(400,55,500,500);
	 add(l1);
	 JLabel l2= new JLabel("ADD EMPLOYE DETAILS");
	 l2.setForeground(Color.BLUE);
	 l2.setFont(new Font("Tahoma",Font.PLAIN,26));
	 l2.setBounds(420,30,400,30);
	 add(l2);
	 JLabel name= new JLabel("NAME");
	 name.setBounds(60,30,120,30);
	 name.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(name);
	 
	 t1= new JTextField();
	 t1.setBounds(200,30,200,30);
	 add(t1);
	 
	 JLabel age= new JLabel("AGE");
	 age.setBounds(60,80,120,30);
	 age.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(age);
	 
	 t2= new JTextField();
	 t2.setBounds(200,80,200,30);
	 add(t2);
	 JLabel gender= new JLabel("GENDER");
	 gender.setBounds(60,130,120,30);
	 gender.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(gender);
	 
	 r1= new JRadioButton("Male");
	 r1.setFont(new Font("Tahoma",Font.PLAIN,14));
	 r1.setBounds(200,130,70,30);
	 add(r1);
	 r2= new JRadioButton("Female");
	 r2.setFont(new Font("Tahoma",Font.PLAIN,14));
	 r2.setBounds(290,130,70,30);
	 add(r2);
	 
	 
	 JLabel job= new JLabel("JOB");
	 job.setBounds(60,180,120,30);
	 job.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(job);
	 //this is a dropdown which contains strings soo we will create an array of strings
	 String str[]= {"Receptionist","Chef","Driver","Bell Boy","Room service","Cleaner","Dry cleaner","Manager","Waiter","Accountant"};
	  c1= new JComboBox(str);
	  c1.setBounds(200,180,120,30);
	  add(c1);
	 
	 JLabel salary= new JLabel("SALARY");
	 salary.setBounds(60,230,120,30);
	 salary.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(salary);
	 

	 t3= new JTextField();
	 t3.setBounds(200,230,200,30);
	 add(t3);
	 JLabel phone= new JLabel("PHONE NO.");
	 phone.setBounds(60,280,120,30);
	 phone.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(phone);
	 

	 t4= new JTextField();
	 t4.setBounds(200,280,200,30);
	 add(t4);
	 
	 JLabel email= new JLabel("EMAIL");
	 email.setBounds(60,330,120,30);
	 email.setFont(new Font("Tahoma",Font.PLAIN,17));
	 add(email);
	 

	 t5= new JTextField();
	 t5.setBounds(200,330,200,30);
	 add(t5);
	 
	 b1= new JButton("Submit");
	 b1.setBackground(Color.BLACK);
	 b1.setForeground(Color.WHITE);
	 b1.setBounds(200,380,200,30);
	 b1.addActionListener(this);
	 add(b1);
	 
	 getContentPane().setBackground(Color.WHITE);
	 setLayout(null);
	 setBounds(400,200,900,470);
	 setVisible(true);
	 
 }
 public void actionPerformed(ActionEvent ae) {

	 String name= t1.getText();
	 String age= t2.getText();
	 String salary= t3.getText();
	 String phone= t4.getText();
	 String email= t5.getText();
	 
	 String gender=null;
	 if(r1.isSelected())
		 gender="Male";
	 else if(r2.isSelected())
		 gender="Female";
	 String job=(String)c1.getSelectedItem();//becuase this method returns a object thus we typecast it to string
	 conn c = new conn();
	 try {
         
         String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"', '"+email+"')";
         
         c.s.executeUpdate(str);
         JOptionPane.showMessageDialog(null,"Employee Added");
         this.setVisible(false);
     
     } catch (Exception e) {
         System.out.println(e);
 }
}
	 
	 
 
 public static void main(String[] args) {
	new AddEmployee().setVisible(true);
 }
}
