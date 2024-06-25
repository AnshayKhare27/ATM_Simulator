package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;


public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawal, ministatement, pinchange, balanceenquiry, fastcash, exit;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber= pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your WITHDRAWAL AMOUNT");
        text.setBounds(170, 300, 700, 35);
        // add(text); // adds the text but not above the image
        image.add(text); // adds the text above the image
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));

        deposit = new JButton("RS 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawal = new JButton("RS 500");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        fastcash = new JButton("RS 2000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement = new JButton("RS 5000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("RS 10000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry = new JButton("RS 1000");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount =((JButton) ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount +" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {
        
        new FastCash("");

    }
    
}