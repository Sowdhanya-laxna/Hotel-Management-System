package hotel.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    
    JTable table;
    JButton  back;
    Room(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel l1=new JLabel("ROOMNUMBER");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("AVAILABILITY");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("STATUS");
        l3.setBounds(230, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("PRICE");
        l4.setBounds(330, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("BED-TYPE");
        l5.setBounds(410, 10, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
             
            Conn c=new Conn();
            ResultSet  rs = c.s.executeQuery("select* from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    }
    
    
    
    public static void main(String[]args){
       new Room();
    }
}
