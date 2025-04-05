package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;





public class Update  extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfdeposite,tfbalance;
    JButton  check,update,back;
    
    
    Update(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("UPDATE STATUS");
        text.setBounds(90, 20, 200, 30);
        text.setFont(new Font("serif", Font.PLAIN, 15));
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
        room.setBounds(30, 120, 100, 20);
        add(room);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);
        
        
        JLabel name=new JLabel("NAME ");
        name.setBounds(30, 160, 100, 20);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200, 200, 150, 25);
        add(tfname);
        
        
        JLabel checkin=new JLabel("CHECK-IN ");
        checkin.setBounds(30, 200, 100, 20);
        add(checkin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 180, 150, 25);
        add(tfcheckin);
        
        
        JLabel deposite=new JLabel("DEPOSITE");
        deposite.setBounds(30, 240, 100, 20);
        add(deposite);
        
        tfdeposite = new JTextField();
        tfdeposite.setBounds(200, 240, 150, 25);
        add(tfdeposite);

        
        JLabel balance=new JLabel("BALANCE ");
        balance.setBounds(30, 280, 100, 20);
        add(balance);
        
        tfbalance = new JTextField();
        tfbalance.setBounds(200, 280, 150, 25);
        add(tfbalance);
        
        check = new JButton("CHECK");
        check.setBounds(30, 340, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("UPDATE");
        update.setBounds(150, 340, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBounds(270, 340, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
        setBounds(300,200,900,500);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkin"));
                    tfdeposite.setText(rs.getString("deposite"));
                    
                }
                ResultSet rs2=c.s.executeQuery("select*from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfdeposite.getText());
                    tfbalance.setText(""+amountpaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update) {
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposite=tfdeposite.getText();
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room ='"+room+"',name ='"+name+"',checkin ='"+checkin+"',deposite ='"+deposite+"'where num ='"+number+"'");
                
                
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
        new Update();
    }
}
