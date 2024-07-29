package dbConn;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class GuiShow implements ActionListener{
	JTextField PID1,PName1,PQuan1,PPrice1;
	JButton jb;
	GuiShow()
	{
		JFrame jf=new JFrame("Product Details");
		JPanel jp=new JPanel(new FlowLayout());
		JLabel PID=new JLabel("Product ID");
		JLabel PName=new JLabel("Product Name");
		JLabel PQuan=new JLabel("Product Quantity");
		JLabel PPrice=new JLabel("Product Price");
		 PID1 =new JTextField("",30);
		 PName1 =new JTextField("",30);
		 PQuan1 =new JTextField("",30);
		PPrice1 =new JTextField("",30);
		 jb=new JButton("Submit Data");
		jp.add(PID);
		jp.add(PID1);
		jp.add(PName);
		jp.add(PName1);
		jp.add(PPrice);
		jp.add(PPrice1);
		jp.add(PQuan);
		jp.add(PQuan1);
		jp.add(jb);
		jf.add(jp);
		jf.setSize(300,400);
		jf.setVisible(true);
		
	jb.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent AE)
	{
		if (AE.getSource()==jb)
		{
			String pid=PID1.getText();
			String pname=PName1.getText();
			String pq=PQuan1.getText();
			String pprice1=PPrice1.getText();
		
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\company.accdb");//Establishing Connection
            System.out.println("Connected Successfully");
            System.out.print("Insert into Product values("+pid+",'"+pname+"',"+pq+","+pprice1+")");
            PreparedStatement preparedStatement=connection.prepareStatement("Insert into Product(PID,PName,PQuantity,PPrice) values("+pid+",'"+pname+"',"+pq+","+pprice1+")");;
           
            int c= preparedStatement.executeUpdate();
            if(c>0)
            System.out.print("Data inserted successfully");
                 
	     }
            catch(Exception e){
            System.out.println("Error in connection");

        }
		}
	}

}
