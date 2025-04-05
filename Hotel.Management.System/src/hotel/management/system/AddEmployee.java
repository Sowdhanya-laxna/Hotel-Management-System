package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfage, tfsalary, tfphone, tfemail;
    JRadioButton rbmale, rbfemale;
    JComboBox<String> cbjob;
    JButton submit;
    
    AddEmployee() {
        setLayout(null);
       
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblname);
       
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
       
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblage);
       
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
       
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblgender);
       
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("serif", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
       
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 130, 110, 30);
        rbfemale.setFont(new Font("serif", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
       
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
       
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("serif", Font.PLAIN, 17));
        add(lbljob);
       
        String jobs[] = {"Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Chef", "Manager", "Accountant"};
        cbjob = new JComboBox<>(jobs);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);
       
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblsalary);
       
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
       
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblphone);
       
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
       
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblemail);
       
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
       
        submit = new JButton("SUBMIT");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
       
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText().trim();
        String ageStr = tfage.getText().trim();
        String salaryStr = tfsalary.getText().trim();
        String phone = tfphone.getText().trim();
        String email = tfemail.getText().trim();
        String job = (String) cbjob.getSelectedItem();
        
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "MALE";
        } else if (rbfemale.isSelected()) {
            gender = "FEMALE";
        }

        // Validation
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty");
            return;
        }

        if (ageStr.isEmpty() || !ageStr.matches("\\d+") || Integer.parseInt(ageStr) < 18 || Integer.parseInt(ageStr) > 65) {
            JOptionPane.showMessageDialog(null, "Enter a valid age (18-65)");
            return;
        }

        if (gender == null) {
            JOptionPane.showMessageDialog(null, "Select a gender");
            return;
        }

        if (salaryStr.isEmpty() || !salaryStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Enter a valid salary");
            return;
        }

        if (phone.isEmpty() || !phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Enter a valid 10-digit phone number");
            return;
        }

        if (email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, "Enter a valid email address");
            return;
        }

        try {
            Conn conn = new Conn();
            String query = "INSERT INTO employee (name, age, gender, job, salary, phone, email) VALUES ('" 
                           + name + "', '" + ageStr + "', '" + gender + "', '" + job + "', '" + salaryStr + "', '" + phone + "', '" + email + "')";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "EMPLOYEE ADDED SUCCESSFULLY");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
}
