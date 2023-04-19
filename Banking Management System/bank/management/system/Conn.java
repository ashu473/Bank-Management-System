package bank.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver); //driver name
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","@1SAROJsingh");
            s=c.createStatement();
        } catch(Exception e){
            System.out.println(e);   //to handle exception occur at runtime
        }
    }
}
