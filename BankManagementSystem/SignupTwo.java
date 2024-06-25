package BankManagementSystem;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField aadhar, pan;
    JButton next, back;
    JRadioButton eYes, eNo, seniorYes, seniorNo;
    JComboBox<String> religion, category, income, education, occupation;
    String formno;


    SignupTwo(String formno){
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel addDetails = new JLabel("Page 2 : Additional Details");        
        addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addDetails.setBounds(290, 80, 400, 40);
        add(addDetails);

        JLabel religionLabel = new JLabel("Religion :");        
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel categoryLabel = new JLabel("Category :");        
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        categoryLabel.setBounds(100, 190, 150, 30);
        add(categoryLabel);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomLabel = new JLabel("Income :");        
        incomLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        incomLabel.setBounds(100, 240, 150, 30);
        add(incomLabel);

        String []valIncome = {"<30,000INR", "30,000 - 1,00,000 INR", "1,00,001-3,00,000 INR", "3,00,001-5,00,000 INR", ">5,00,001 INR"};
        income = new JComboBox<>(valIncome);
        income.setBackground(Color.WHITE);
        income.setBounds(300, 240, 400, 30);
        add(income);
        
        JLabel educational = new JLabel("Educational");        
        educational.setFont(new Font("Raleway", Font.BOLD, 18));
        educational.setBounds(100, 290, 190, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification :");        
        qualification.setFont(new Font("Raleway", Font.BOLD, 18));
        qualification.setBounds(100, 315, 190, 30);
        add(qualification);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupationLabel = new JLabel("Occupation :");        
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        occupationLabel.setBounds(100, 390, 150, 30);
        add(occupationLabel);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel panNo = new JLabel("PAN Number :");        
        panNo.setFont(new Font("Raleway", Font.BOLD, 18));
        panNo.setBounds(100, 440, 150, 30);
        add(panNo);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel aadharNum = new JLabel("Aadhar Number :");        
        aadharNum.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharNum.setBounds(100, 490, 150, 30);
        add(aadharNum);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen :");        
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 540, 150, 30);
        add(state);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300, 540, 60, 30);
        seniorYes.setBackground(Color.white);
        add(seniorYes);
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(390, 540, 60, 30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        JLabel pincode = new JLabel("Existing Account :");        
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 590, 60, 30);
        eYes.setBackground(Color.white);
        add(eYes);
        eNo = new JRadioButton("No");
        eNo.setBounds(390, 590, 60, 30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eYes);
        existingGroup.add(eNo);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(100, 660, 80, 30);
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();// setText
        String scategory = (String)category.getSelectedItem();
        String sincome =(String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(seniorYes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(seniorNo.isSelected()){
            seniorcitizen = "No";
        }

        String existingAccount = null;
        if(eYes.isSelected()){
           existingAccount = "Yes";     
        }
        else if(eNo.isSelected()){
            existingAccount = "No";
        }

        if(ae.getSource()==back){
            setVisible(false);
            new SignupOne().setVisible(true);
        }else if(ae.getSource()==next){
            setVisible(false);

        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try{
              Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);

                //SignUp3 object
                //Signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
