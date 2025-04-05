package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {
     JTextField tfroomno, tfprice;
     JComboBox<String> avaliablecombo, cleancombo, bedcombo;
     JButton add, cancel;

    AddRooms() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("serif", Font.BOLD, 18));
        add(heading);

        JLabel roomno = new JLabel("ADD ROOM-NUMBER");
        roomno.setBounds(60, 80, 120, 30);
        roomno.setFont(new Font("serif", Font.PLAIN, 16));
        add(roomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        add(tfroomno);

        JLabel avaliable = new JLabel("AVAILABILITY");
        avaliable.setBounds(60, 130, 120, 30);
        avaliable.setFont(new Font("serif", Font.PLAIN, 16));
        add(avaliable);

        String avaliableOptions[] = { "AVAILABLE", "OCCUPIED" };
        avaliablecombo = new JComboBox<>(avaliableOptions);
        avaliablecombo.setBounds(200, 130, 150, 30);
        avaliablecombo.setBackground(Color.WHITE);
        add(avaliablecombo);

        JLabel clean = new JLabel("CLEANING STATUS");
        clean.setBounds(60, 180, 120, 30);
        clean.setFont(new Font("serif", Font.PLAIN, 16));
        add(clean);

        String cleanOptions[] = { "CLEANED", "DIRTY" };
        cleancombo = new JComboBox<>(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel price = new JLabel("PRICE OF ROOM");
        price.setBounds(60, 230, 120, 30);
        price.setFont(new Font("serif", Font.PLAIN, 16));
        add(price);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel bed = new JLabel("BED TYPE");
        bed.setBounds(60, 280, 120, 30);
        bed.setFont(new Font("serif", Font.PLAIN, 16));
        add(bed);

        String bedOptions[] = { "SINGLE BED", "DOUBLE BED", "KING-SIZE BED" };
        bedcombo = new JComboBox<>(bedOptions);
        bedcombo.setBounds(200, 280, 150, 30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);

        add = new JButton("ADD");
        add.setBounds(60, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        add.addActionListener(this);

        cancel = new JButton("CANCEL");
        cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(330, 200, 940, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
           String roomnumber = tfroomno.getText();
           String avaliable = (String)avaliablecombo.getSelectedItem();
           String status = (String)cleancombo.getSelectedItem();
           String price = tfprice.getText();
           String type = (String)bedcombo.getSelectedItem();
           
           try{
             Conn conn=new Conn();
             String str ="insert into room values('"+roomnumber+"','"+avaliable+"','"+status+"','"+price+"','"+type+"')";
             
             conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null, "  NEW ROOM ADDED SUCCESSFULLY");
            setVisible(false); 
            
           }catch(Exception e){
               e.printStackTrace();
           }

        } else if (ae.getSource() == cancel) {
            setVisible(false); 
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
