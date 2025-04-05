
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
		setSize(1366,565);
		setLocation(100,100);
		setLayout(null);
                
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
                image.setBounds(0,0,1366,565); //loaction of the axis
                add(image);
                
                JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM!!!");
                text.setBounds(20,430,1000,90);
                text.setForeground(Color.WHITE);
                text.setFont(new Font("serif",Font.PLAIN,50));
                image.add(text);
                
                JButton next = new JButton("NEXT");
                next.setBounds(1150,450,150,50);
                next.setBackground(Color.WHITE);
                text.setForeground(Color.WHITE);
                next.addActionListener(this); //which button needed to operate
                next.setFont(new Font("serif",Font.PLAIN,25));
                image.add(next);
                
                
                setVisible(true);
                
                while (true){
                    text.setVisible(false);
                    try{
                        Thread.sleep(500);
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    text.setVisible(true);
                    try{
                        Thread.sleep(500);
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }
	}
    public void actionPerformed(ActionEvent ae){  // OVERRIDING THE METHOD
        setVisible(false);
        new Login(); // navigation is made by creating a constructor 
    }

    public static void main(String[] args) {
      new HotelManagementSystem();
    }
    
}
