package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {
     JTextField tfname, tfage,tfcompany,tfmodel,tflocation;
     JComboBox<String> availablecombo, agecombo, bedcombo;
     JButton add, cancel;

    AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setBounds(150, 10, 200, 20);
        heading.setFont(new Font("serif", Font.BOLD, 18));
        add(heading);

        JLabel roomno = new JLabel("NAME");
        roomno.setBounds(60, 70, 120, 30);
        roomno.setFont(new Font("serif", Font.PLAIN, 16));
        add(roomno);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 110, 120, 30);
        age.setFont(new Font("serif", Font.PLAIN, 16));
        add(age);

         tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

        JLabel clean = new JLabel("GENDER ");
        clean.setBounds(60, 150, 120, 30);
        clean.setFont(new Font("serif", Font.PLAIN, 16));
        add(clean);

        String cleanOptions[] = { "MALE", "FEMALE" };
        agecombo = new JComboBox<>(cleanOptions);
        agecombo.setBounds(200, 150, 150, 30);
        agecombo.setBackground(Color.WHITE);
        add(agecombo);

        JLabel price = new JLabel("CAR COMPANY");
        price.setBounds(60, 190, 120, 30);
        price.setFont(new Font("serif", Font.PLAIN, 16));
        add(price);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel bed = new JLabel("CAR MODEL");
        bed.setBounds(60, 230, 120, 30);
        bed.setFont(new Font("serif", Font.PLAIN, 16));
        add(bed);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel available = new JLabel("AVAILABILITY MODEL");
        available.setBounds(60, 270, 120, 30);
        available.setFont(new Font("serif", Font.PLAIN, 16));
        add(available);
        
        String availableOptions[] = { "AVAILABLE", "BUSY" };
        availablecombo = new JComboBox<>(availableOptions);
        availablecombo.setBounds(200, 270, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
         JLabel location = new JLabel("LOCATION");
        location.setBounds(60, 310, 120, 30);
        location.setFont(new Font("serif", Font.PLAIN, 16));
        add(location);

        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);


        add = new JButton("ADD");
        add.setBounds(60, 370, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        add.addActionListener(this);

        cancel = new JButton("CANCEL");
        cancel.setBounds(220, 370, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(300, 200, 980, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
           String name = tfname.getText();
           String age = tfage.getText();
           String gender = (String)agecombo.getSelectedItem();
           String company = tfcompany.getText();
           String brand = tfmodel.getText();
           String available = (String)availablecombo.getSelectedItem();
            String location = tflocation.getText();
           
           try{
             Conn conn=new Conn();
             String str ="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
             
             conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null, "  NEW DRIVER ADDED SUCCESSFULLY");
            setVisible(false); 
            
           }catch(Exception e){
               e.printStackTrace();
           }

        } else if (ae.getSource() == cancel) {
            setVisible(false); 
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
