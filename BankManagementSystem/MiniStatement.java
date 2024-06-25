package BankManagementSystem;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame {
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");

        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel mini = new JLabel();
        mini.setBounds(20, 80, 300, 20);
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try{
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12) );
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{              
            Conn conn = new Conn();
            int bal = 0;

            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            balance.setText("Your current account balance is Rs "+bal);

        }catch(Exception e){
            System.out.println(e);
        }

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel image = new JLabel(i3);
        // image.setBounds(0, 0, 900, 900);
        // add(image);

        mini.setBounds(20, 140,400, 200);

        setLocation(20, 20);
        setSize(400, 600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);




    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
