package bank.management.system;

import javax.swing.*;  //JFrame is inside this package
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener{
    JButton next;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JComboBox occupation,religion,income,category,education;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null); //to get rid of default border layout
        
        setSize(850,800);    //create frame with location and visibility
        setLocation(350,10);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE); //set background color of frame
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details"); //label of Page 1: Personal Details
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));//font of Page 1: Personal Details
        additionalDetails.setBounds(290,80,400,30);// location of Page 1: Personal Details
        add(additionalDetails);
        
        JLabel Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,140,100,30); 
        add(Religion);
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140, 400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel Category=new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);
        String valCategory[]={"General","OBC","SC","ST","Others"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190, 400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,240,200,30);
        add(Income);
        String incomeCategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240, 400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel Educational=new JLabel("Educational");
        Educational.setFont(new Font("Raleway",Font.BOLD,20));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        
        JLabel Qualification=new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway",Font.BOLD,20));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);
        String educationValues[]={"Non-Graduate","Graduate","Post-Graducation","Doctrate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315, 400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel Occupation=new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        String occupationValues[]={"Salaried","Self-Employed","Business","Farmer","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390, 400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        JLabel PanNumber=new JLabel("PAN Number:");
        PanNumber.setFont(new Font("Raleway",Font.BOLD,20));
        PanNumber.setBounds(100,440,200,30);
        add(PanNumber);
        pan=new JTextField();
        pan.setBounds(300,440, 400,30);
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        add(pan);
        
        JLabel AadharNumber=new JLabel("Aadhar Number:");
        AadharNumber.setFont(new Font("Raleway",Font.BOLD,20));
        AadharNumber.setBounds(100,490,200,30);
        add(AadharNumber);
        aadhar=new JTextField();
        aadhar.setBounds(300,490, 400,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadhar);
        
        JLabel SeniorCitizen=new JLabel("Senior Citizen:");
        SeniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        SeniorCitizen.setBounds(100,540,200,30);
        add(SeniorCitizen);
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup citizengroup=new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);
        
        JLabel ExistingAccount=new JLabel("Existing Account:");
        ExistingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        ExistingAccount.setBounds(100,590,200,30);
        add(ExistingAccount);
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup exaccgroup=new ButtonGroup();
        exaccgroup.add(eyes);
        exaccgroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
    }
    
    public void actionPerformed(ActionEvent ae){
                String sreligion=(String)religion.getSelectedItem();// to get selected item from dropdownbox
                String scategory=(String)category.getSelectedItem();
                String sincome=(String)income.getSelectedItem();
                String seducation=(String)education.getSelectedItem();
                String soccupation=(String)occupation.getSelectedItem();
                String span=pan.getText();
                String saadhar=aadhar.getText();
                String seniorcitizen="null";
                if(syes.isSelected()){
                    seniorcitizen="Yes";
                }else if(sno.isSelected()){
                    seniorcitizen="No";
                }
                String existingaccount="null";
                if(eyes.isSelected()){
                    existingaccount="Yes";
                }else if(eno.isSelected()){
                    existingaccount="No";
                }
                
                try{
                    Conn c=new Conn();
                    String query="insert into signuptwo value('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                    c.s.executeUpdate(query);
                    // SignupThree object
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }

//    @Override
////    public void actionPerformed(ActionEvent e) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
////    }
}

