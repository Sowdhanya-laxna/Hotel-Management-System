package hotel.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    Choice car;
    JTable table;
    JButton  submit,back;
    
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("PICKUP SERVICE!!!!");
        text.setBounds(400, 30, 200, 30);
        text.setFont(new Font("serif", Font.PLAIN, 15));
        add(text);
        
        JLabel bedt=new JLabel("TYPE-CAR");
        bedt.setBounds(50,100,100,20);
        add(bedt);
        
        car=new Choice();
        car.setBounds(150, 100, 200, 25);
        add(car);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from driver");
            while(rs.next()){
                car.add(rs.getString("brand"));
            }
        }catch(Exception e){
                    e.printStackTrace();
                    }
        
                
        JLabel l1=new JLabel("NAME");
        l1.setBounds(30, 160, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("AGE");
        l2.setBounds(200, 160, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("GENDER");
        l3.setBounds(330, 160, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("COMPANY");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("BRAND");
        l5.setBounds(630, 160, 100, 20);
        add(l5);
        
        JLabel l6=new JLabel("AVAILABLE");
        l6.setBounds(740, 160, 100, 20);
        add(l6);
        
        JLabel l7=new JLabel("LOCATION");
        l7.setBounds(860, 160, 100, 20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
             
            Conn c=new Conn();
            ResultSet  rs = c.s.executeQuery("select* from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
             
        submit = new JButton("SUBMIT");
        submit.setBounds(300, 520, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
                
        back = new JButton("BACK");
        back.setBounds(500, 520, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
           
           try{
             
             String query="select * from driver where brand='"+car.getSelectedItem()+"' ";
             
             Conn conn=new Conn();
              ResultSet  rs ;
              rs = conn.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               e.printStackTrace();
           }

        } else  {
              setVisible(false);
              new Reception();
        }
    }
    
    
    
    public static void main(String[]args){
       new Pickup();
    }
}

