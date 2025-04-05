package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;



public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel roomnumber,tfcheckin,tfcheckout;
    JButton  check,back;
    
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("CHECKOUT");
        text.setBounds(100, 20, 100, 30);
        text.setFont(new Font("serif", Font.PLAIN, 20));
        text.setForeground(Color.blue);
        add(text);
        
        JLabel id=new JLabel("CUSTOMER ID");
        id.setBounds(30, 80, 100, 30);
        add(id);
        
        ccustomer =new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 80, 20, 20);
        add(tick);
        
        
        JLabel num=new JLabel("ROOM NUMBER");
        num.setBounds(30, 130, 100, 30);
        add(num);
        
        roomnumber =new JLabel();
        roomnumber.setBounds(150, 130, 100, 30);
        add(roomnumber);
        
        JLabel checkin=new JLabel("CHECK-IN TIME");
        checkin.setBounds(30, 180, 100, 30);
        add(checkin);
        
        tfcheckin =new JLabel();
        tfcheckin.setBounds(150, 180, 100, 30);
        add(tfcheckin);
        
        JLabel  checkouts=new JLabel("CHECK-OUT");
        checkouts.setBounds(30, 230, 100, 30);
        add(checkouts);
        
        Date date = new Date();
        tfcheckout = new JLabel(date.toString());
        tfcheckout.setBounds(150, 230, 100, 30);
        add(tfcheckout);
        
        check = new JButton("CHECKOUT");
        check.setBounds(30, 280, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
                
        back = new JButton("BACK");
        back.setBounds(170, 520, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c=new Conn();
            ResultSet  rs = c.s.executeQuery("select* from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("num"));
                roomnumber.setText(rs.getString("room"));
                tfcheckin.setText(rs.getString("checkin"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);
        
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==check){
            String q="delete from customer where num='"+ccustomer.getSelectedItem()+"'";
            String q2="update room set avaliability='Available'where roomnumber='"+roomnumber.getText()+"'";
            
            try{
                Conn c= new Conn();
                c.s.executeUpdate(q);
                c.s.executeLargeUpdate(q2);
                
                 JOptionPane.showMessageDialog(null, " CHECKOUT DONE");
                 setVisible(false);
                 new Reception();
            }catch(Exception e){
                e.printStackTrace();           
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[]args){
        new Checkout();
    }
}
