package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, stateTextField, cityTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, others, married, unmarried;
    JDateChooser dateChooser;
    

    SignupOne(){
        setLayout(null);

        Random ran = new Random();
        random  = (Math.abs(ran.nextLong() % 9000L + 1000L));

        JLabel formno = new JLabel("Application Form No." + random);        
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(190, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");        
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 40);
        add(personalDetails);

        JLabel name = new JLabel("Full Name :");        
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name :");        
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 190, 150, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth :");        
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 240, 150, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender :");        
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 290, 150, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(390, 290, 90, 30);
        female.setBackground(Color.WHITE);
        add(female);
        others = new JRadioButton("Others");
        others.setBounds(480, 290, 70, 30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);
        genderButtonGroup.add(others);

        JLabel email = new JLabel("Email :");        
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 340, 100, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");        
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(100, 390, 150, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 70, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(390, 390, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalButtonGroup = new ButtonGroup();
        maritalButtonGroup.add(married);
        maritalButtonGroup.add(unmarried);
        

        JLabel address = new JLabel("Address :");        
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 440, 150, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City :");        
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 490, 150, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State :");        
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 540, 150, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code :");        
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100, 590, 150, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+ random; //long
        String name = nameTextField.getText(); // setText
        String fname = fnameTextField.getText();
        String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        else if(others.isSelected()){
            gender = "Others";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
           marital = "married";     
        }
        else if(unmarried.isSelected()){
            marital = "unmarried";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            // else if(fname.equals("")){
            //     JOptionPane.showMessageDialog(null, "Father's Name cannot be empty");
            // }
            // else if(dob.equals("")){
            //     JOptionPane.showMessageDialog(null, "dob cannot be empty");
            // }
            // else if(gender.equals("")){
            //     JOptionPane.showMessageDialog(null, "select a valid gender");
            // }
            // else if(email.equals("")){
            //     JOptionPane.showMessageDialog(null, "EMail cannot be blank");
            // }
            // else if(marital.equals("")){
            //     JOptionPane.showMessageDialog(null, "Choose atleast one valid option");
            // }
            // else if(address.equals("")){
            //     JOptionPane.showMessageDialog(null, "Address field cannot be Empty");
            // }
            // else if(city.equals("")){
            //     JOptionPane.showMessageDialog(null, "City field cannot be empty");
            // }
            // else if(state.equals("")){
            //     JOptionPane.showMessageDialog(null, "State field cannot be empty");
            // }
            // else if(pin.equals(null)){
            //     JOptionPane.showMessageDialog(null, "Pincode field cannot be empty");
            // }
        }catch(Exception e){
            System.out.println(e);
        }


    }

    
    public static void main(String[] args) {
        new SignupOne();
    }
}