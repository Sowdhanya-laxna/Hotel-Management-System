package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton news,rooms,department,allemp,customer,manager,checkout,update,roomsts,pickup,search,logout;
    
    
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        news = new JButton("NEW CUSTOMER FORM");
        news.setBounds(10, 30, 200, 30);
        news.setBackground(Color.BLACK);
        news.setForeground(Color.WHITE);
        news.addActionListener(this);
        add(news);
        
          rooms = new JButton(" ROOMS ");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
           department = new JButton("DEPARTMENT");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
         allemp = new JButton("ALL EMPLOYEE");
        allemp.setBounds(10, 150, 200, 30);
        allemp.setBackground(Color.BLACK);
        allemp.setForeground(Color.WHITE);
        allemp.addActionListener(this);
        add(allemp);
        
         customer = new JButton("CUSTOMER INFO");
        customer.setBounds(10, 190, 200, 30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.addActionListener(this);
        add(customer);
        
         manager = new JButton("MANAGER INFO");
        manager.setBounds(10, 230, 200, 30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.addActionListener(this);
        add(manager);
        
         checkout = new JButton("CHECK OUT ");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);  
        
         update = new JButton("UPDATE STATUS ");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
         roomsts = new JButton("UPDATE  ROOM STATUS ");
        roomsts.setBounds(10, 350, 200, 30);
        roomsts.setBackground(Color.BLACK);
        roomsts.setForeground(Color.WHITE);
        roomsts.addActionListener(this);
        add(roomsts);
        
         pickup = new JButton("PICKUP STATUS ");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
         search = new JButton("SEARCH ROOM ");
        search.setBounds(10, 430, 200, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
         logout = new JButton("LOGOUT  ");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==news){
            setVisible(false);
            new AddCustomer();
        }else if (ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }else if (ae.getSource()==department){
            setVisible(false);
            new Department();
        }else if (ae.getSource()==allemp){
            setVisible(false);
            new Allemp();
        }else if (ae.getSource()==customer){
            setVisible(false);
            new Customer();
        }else if (ae.getSource()==manager){
            setVisible(false);
            new Manager();
        }else if (ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }else if (ae.getSource()==update){
            setVisible(false);
            new Update();
        }else if (ae.getSource()==roomsts){
            setVisible(false);
            new Roomsts();
        }else if (ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }else if (ae.getSource()==search){
            setVisible(false);
            new Search();
        }
        
    }
    
    
    public static void main(String[] args) {
        new Reception();
    }
}
