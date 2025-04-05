package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("THE TRIO GROUP WELCOMES YOUUU!!!");
        text.setBounds(400,80, 1000,50);
        text.setFont(new Font("serif",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION"); 
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addemp = new JMenuItem("ADD EMPLOYEE"); 
        addemp.addActionListener(this);
        admin.add(addemp);
        
        JMenuItem addroom = new JMenuItem("ADD ROOMS"); 
        addroom.addActionListener(this);
        admin.add(addroom);
        
        JMenuItem addDriver = new JMenuItem("ADD DRIVER");
        addDriver.addActionListener(this);
        admin.add(addDriver);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (command.equals("ADD ROOMS")) { 
            new AddRooms();
        } else if (command.equals("ADD DRIVER")) {
            new AddDriver();
        }else if (command.equals("RECEPTION")) {
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
}
