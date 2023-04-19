package bank.management.system;
import javax.swing.*; //JFrame
import java.awt.*;
import java.awt.event.*;
import java.sql.*;//resutset is in this package
import java.util.Date;// if two package have date class compiler wont able to know which package has to be used so this is used

public class FastCash extends JFrame implements ActionListener{
    JButton Back,OneHundred,FiveHundred,OneThousand,TwoThousand,FiveThousand,TenThousand;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);//so that it will visible on image otherwise on frame
        
        OneHundred=new JButton("Rs.100");
        OneHundred.setBounds(170,415,150,30);
        OneHundred.addActionListener(this);
        image.add(OneHundred);
        
        FiveHundred=new JButton("Rs.500");
        FiveHundred.setBounds(355,415,150,30);
        FiveHundred.addActionListener(this);
        image.add(FiveHundred);
        
        OneThousand=new JButton("Rs.1000");
        OneThousand.setBounds(170,450,150,30);
        OneThousand.addActionListener(this);
        image.add(OneThousand);
        
        TwoThousand=new JButton("Rs.2000");
        TwoThousand.setBounds(355,450,150,30);
        TwoThousand.addActionListener(this);
        image.add(TwoThousand);
        
        FiveThousand=new JButton("Rs.5000");
        FiveThousand.setBounds(170,485,150,30);
        FiveThousand.addActionListener(this);
        image.add(FiveThousand);
        
        TenThousand=new JButton("Rs.10000");
        TenThousand.setBounds(355,485,150,30);
        TenThousand.addActionListener(this);
        image.add(TenThousand);
        
        Back=new JButton("BACK");
        Back.setBounds(355,520,150,30);
        Back.setBackground(Color.RED);
        Back.addActionListener(this);
        image.add(Back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);//get the amount as text and remove the Rs.part
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");//getting the value which pinnumber is given
                int balance=0;
                while(rs.next()){  //rs.next used to loop each row
                    if(rs.getString("type").equals("Deposite")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=Back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrwal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);         
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
       new FastCash(""); 
    }
}
