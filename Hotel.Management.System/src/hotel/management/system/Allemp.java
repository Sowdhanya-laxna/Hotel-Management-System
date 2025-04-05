package hotel.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Allemp extends JFrame implements ActionListener {
    
    JTable table;
    JButton  back;
    Allemp(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1=new JLabel("NAME");
        l1.setBounds(40, 10, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("AGE");
        l2.setBounds(170, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("GENDER");
        l3.setBounds(290, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("JOB");
        l4.setBounds(440, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("SALARY");
        l5.setBounds(590, 10, 100, 20);
        add(l5);
        
        JLabel l6=new JLabel("PHONE");
        l6.setBounds(720, 10, 100, 20);
        add(l6);
        
        JLabel l7=new JLabel("EMAIL");
        l7.setBounds(860, 10, 100, 20);
        add(l7);
        
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
             
            Conn c=new Conn();
            ResultSet  rs = c.s.executeQuery("select* from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    }
    
    
    
    public static void main(String[]args){
       new Allemp();
    }
}
