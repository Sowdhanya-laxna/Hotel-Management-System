package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer  extends JFrame implements ActionListener{
    JTextField tfnum,tfname,tfcountry,tfdeposite;
     JComboBox<String> comboid;
     JRadioButton rbmale, rbfemale;
     Choice croom;
     JLabel checkin;
     JButton add, back;
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("serif", Font.PLAIN, 14));
        add(text);
        
        JLabel id = new JLabel("CUSTOMER ID");
        id.setBounds(35, 80, 100, 20);
        id.setFont(new Font("serif", Font.PLAIN, 14));
        add(id);
        
        String Options[] = { "AADHAR", "PANCARD" ,"DRIVING LICENSE","VOTER-ID","PASSPORT"};
        comboid = new JComboBox<>(Options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel number = new JLabel("NUMBER ");
        number.setBounds(35, 120, 100, 20);
        number.setFont(new Font("serif", Font.PLAIN, 14));
        add(number);
        
        tfnum = new JTextField();
        tfnum.setBounds(200, 120, 150, 25);
        add(tfnum);
        
        JLabel name = new JLabel("NAME ");
        name.setBounds(35, 160, 100, 20);
        name.setFont(new Font("serif", Font.PLAIN, 14));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel gender = new JLabel("GENDER ");
        gender.setBounds(35, 200, 100, 20);
        gender.setFont(new Font("serif", Font.PLAIN, 14));
        add(gender);
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 200, 60, 25);
        rbmale.setFont(new Font("serif", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
       
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(270, 200, 100, 25);
        rbfemale.setFont(new Font("serif", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
       
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel country = new JLabel("COUNTRY ");
        country.setBounds(35, 240, 100, 20);
        country.setFont(new Font("serif", Font.PLAIN, 14));
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);
        
        
        JLabel room = new JLabel(" ROOM-NUMBER ");
        room.setBounds(35, 280, 150, 20);
        room.setFont(new Font("serif", Font.PLAIN, 14));
        add(room);
        
        croom=new Choice();
        
        try{
            Conn conn=new Conn();
            String query="select*from room where avaliability = 'AVAILABLE'";
            ResultSet  rs= conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        croom.setBounds(200, 280, 150, 25);
        add(croom);
        
        JLabel time = new JLabel("CHECK-IN ");
        time.setBounds(35, 320, 150, 20);
        time.setFont(new Font("serif", Font.PLAIN, 14));
        add(time);
        
        Date date = new Date();
        
         checkin = new JLabel(" "+date);
        checkin.setBounds(200, 320, 120, 25);
        checkin.setFont(new Font("serif", Font.PLAIN, 14));
        add(checkin);
        
        JLabel deposite = new JLabel("DEPOSITE ");
        deposite.setBounds(35, 360, 100, 20);
        deposite.setFont(new Font("serif", Font.PLAIN, 14));
        add(deposite);
        
        tfdeposite = new JTextField();
        tfdeposite.setBounds(200, 360, 150, 25);
        add(tfdeposite);
        
        add = new JButton("ADD");
        add.setBounds(50, 410, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        add.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(280, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
           String id = (String)comboid.getSelectedItem();
           String number = tfnum.getText();
           String name = tfname.getText();
           String gender = null;
           if (rbmale.isSelected()) {
            gender = "MALE";
        } else if (rbfemale.isSelected()) {
            gender = "FEMALE";
        }
           String country = tfcountry.getText();
           String room = croom.getSelectedItem();
           String time = checkin.getText();
           String deposite = tfdeposite.getText();
           
           
           try{
             
             String str ="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposite+"')";
             String str2="update room set avaliability ='occupied' where roomnumber='"+room+"' ";
             
             
             Conn conn=new Conn();
             
             conn.s.executeUpdate(str);
             conn.s.executeUpdate(str2);
             
            JOptionPane.showMessageDialog(null, "NEW CUSTOMER ADDED SUCCESSFULLY");
            setVisible(false); 
            new Reception();
            
           }catch(Exception e){
               e.printStackTrace();
           }

        } else if (ae.getSource() == back) {
            setVisible(false); 
            new Reception();
        }
    }
    public static void main(String[]args){
       new AddCustomer();
    }
}
