package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Roomsts  extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfdeposite,tfbalance;
    JButton  check,update,back;
    
    Roomsts(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("UPDATE ROOM-STATUS");
        text.setBounds(30, 20, 250, 30);
        text.setFont(new Font("serif", Font.PLAIN, 25));
        text.setForeground(Color.blue);
        add(text);
        
        
        JLabel id=new JLabel("CUSTOMER ID ");
        id.setBounds(30, 80, 100, 20);
        add(id);
        
        ccustomer =new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        
        try{
            Conn c=new Conn();
            ResultSet  rs = c.s.executeQuery("select* from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("num"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel room=new JLabel("ROOM NUMBER");
        room.setBounds(30, 130, 100, 20);
        add(room);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);
        
        
        JLabel name=new JLabel("AVAILABILITY ");
        name.setBounds(30, 180, 100, 20);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200, 180, 150, 25);
        add(tfname);
        
        
        JLabel checkin=new JLabel("CLEANING-STATUS ");
        checkin.setBounds(30, 230, 100, 20);
        add(checkin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 230, 150, 25);
        add(tfcheckin);
         
        check = new JButton("CHECK");
        check.setBounds(30, 300, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("UPDATE");
        update.setBounds(150, 300, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBounds(270, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        setBounds(300,200,980,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id=ccustomer.getSelectedItem();
            String q="select*from customer where num ='"+id+"'";
            try{
                Conn c=new  Conn();
                ResultSet  rs =c.s.executeQuery(q);
                while (rs.next()){
                    tfroom.setText(rs.getString("room"));
                    
                }
                ResultSet rs2=c.s.executeQuery("select*from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfname.setText(rs2.getString("avaliability"));
                    tfcheckin.setText(rs2.getString("clean_status"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update) {
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String availability=tfname.getText();
            String status=tfcheckin.getText();
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set avaliability ='"+availability+"',clean_status ='"+status+"'where roomnumber ='"+room+"'");
                
                
                JOptionPane.showMessageDialog(null, " DATA  UPDATED");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                
            }
            
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    
    public static void main(String[]args){
        new Roomsts();
    }
}
