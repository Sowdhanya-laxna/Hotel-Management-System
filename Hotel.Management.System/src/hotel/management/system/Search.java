package hotel.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Search extends JFrame implements ActionListener {
    JComboBox<String> bedcombo;
    JTable table;
    JButton  submit,back;
    JCheckBox available;
    Search(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("SEARCH FOR ROOMS!!!!");
        text.setBounds(400, 30, 200, 30);
        text.setFont(new Font("serif", Font.PLAIN, 15));
        add(text);
        
        JLabel bedt=new JLabel("BED TYPE");
        bedt.setBounds(50,100,100,20);
        add(bedt);
        
        String bedOptions[] = { "SINGLE BED", "DOUBLE BED", "KING-SIZE BED" };
        bedcombo = new JComboBox<>(bedOptions);
        bedcombo.setBounds(150, 100, 150, 25);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);
        
        available =new JCheckBox("ONLY AVAILABLE");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1=new JLabel("ROOMNUMBER");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("AVAILABILITY");
        l2.setBounds(270, 160, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("STATUS");
        l3.setBounds(450, 160, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("PRICE");
        l4.setBounds(670, 160, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("BED-TYPE");
        l5.setBounds(870, 160, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
             
            Conn c=new Conn();
            ResultSet  rs = c.s.executeQuery("select* from room");
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
             
             String query="select * from room where bed_type='"+bedcombo.getSelectedItem()+"' ";
             String str="select * from room where avaliability = 'AVAILABLE' AND bed_type='"+bedcombo.getSelectedItem()+"' ";
             
             Conn conn=new Conn();
              ResultSet  rs ;
             if (available.isSelected()){
                rs = conn.s.executeQuery(query);
             }else{
                rs = conn.s.executeQuery(str); 
             }
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
       new Search();
    }
}

