package dbprac;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class patientForm implements ActionListener{

	JFrame jf;
	String[] dates= {"1","2","3","4","5","6","7","8","9","10","11"};
	String[] month= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String[] year= {"1950","1951","1960","2000","2003"};
	String[] depts= {"Cardiology","dental","OPD"};
	JTextField pid,name,telephone,cnic;
	JLabel pidl,namel,telephonel,cnicl,deptl,dobl;
	JComboBox<String> c1,c2,c3,dept;
	JButton clr,search,submit,update;
	
	patientForm(){
		jf=new JFrame("Patient Form");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel viewp=new JPanel(new GridLayout(7,2,1,1));
		JPanel jp=new JPanel();
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS)); 
		
		pid=new JTextField("");
		pidl=new JLabel("Patient-ID");
		name=new JTextField("");
		namel=new JLabel("Name");
		telephone=new JTextField("");
		telephonel=new JLabel("Telephone #");
		cnic=new JTextField("");
		cnicl=new JLabel("CNIC");
		dobl=new JLabel("Date of Birth");
		c1=new JComboBox<String>(dates);
		c2=new JComboBox<String>(month);
		c3=new JComboBox<String>(year);
		
		deptl=new JLabel("Dept");
		dept=new JComboBox<String>(depts);
		
		submit=new JButton("Submit");
		submit.addActionListener(this);
		update=new JButton("Update");
		update.addActionListener(this);
		update.setEnabled(false);
		clr=new JButton("Clear");
		clr.addActionListener(this);
		search=new JButton("Search");
		search.addActionListener(this);
		
		JPanel btnp=new JPanel(new FlowLayout());
		btnp.add(submit);btnp.add(clr);btnp.add(search);btnp.add(update);
		JPanel dobp=new JPanel(new FlowLayout());
		dobp.add(c1);dobp.add(c2);dobp.add(c3);
		
		viewp.add(pidl);viewp.add(pid);viewp.add(namel);viewp.add(name);viewp.add(dobl);viewp.add(dobp);viewp.add(telephonel);viewp.add(telephone);viewp.add(cnicl);viewp.add(cnic);viewp.add(deptl);viewp.add(dept);viewp.add(btnp);
		jp.add(viewp);
		jf.setSize(500,500);jf.add(jp);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new patientForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clr) {
			pid.setText("");
			name.setText("");
			cnic.setText("");
			telephone.setText("");
		}
		if(e.getSource()==submit) {
			String p_id=pid.getText();
			String pname=name.getText();
			String ptelephone=telephone.getText();
			String pcnic=cnic.getText();
			String pdept=dept.getSelectedItem().toString();
			//String pdept=depts[deptindex];
			int dateindex=c1.getSelectedIndex();
			String pdate=dates[dateindex];
			int monthindex=c2.getSelectedIndex();
			String pmonth=month[monthindex];
			int yearindex=c3.getSelectedIndex();
			String pyear=year[yearindex];
			String pdob=pdate+"/"+pmonth+"/"+pyear;
			Date tdate=new Date();
			System.out.print(tdate);
			String regdate=tdate.getDate()+"/"+tdate.getMonth()+"/"+tdate.getYear();
			//or use regdate=tdate.toString();
		
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\hospital1.accdb");//Establishing Connection
            System.out.println("Connected Successfully");
  
            System.out.print("Insert into Patient values("+p_id+","+pname+","+ptelephone+",'"+pdob+"','"+pdept+"',"+ptelephone+","+pcnic+")");
            PreparedStatement preparedStatement=connection.prepareStatement("Insert into Patient(PID,PName,DOB,Dept,TNo,CNIC,RegDate) values('"+p_id+"','"+pname+"','"+pdob+"','"+pdept+"','"+ptelephone+"','"+pcnic+"','"+regdate+"')");
           
            int c= preparedStatement.executeUpdate();
            if(c>0)
            System.out.print("Data inserted successfully");
                 
	     }
            catch(Exception dbe){
            	dbe.printStackTrace();
            System.out.println("Error in connection");

        }
		}
		if(e.getSource()==search) {
			 try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\hospital1.accdb");//Establishing Connection
		            System.out.println("Connected Successfully");
		            String pcnic=JOptionPane.showInputDialog("Enter cnic of patient:");
		            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Patient WHERE CNIC LIKE ? AND TNo LIKE '_31654'");
		            preparedStatement.setString(1, "%"+pcnic+"%");		            //"select * from Patient WHERE CNIC='"+pcnic+"'"
		            ResultSet resultSet=preparedStatement.executeQuery();
		            while(resultSet.next()){
		                 name.setText(resultSet.getString("PName"));
		                 telephone.setText(resultSet.getString("TNo"));
		                 cnic.setText(resultSet.getString("CNIC"));
		                 pid.setText(resultSet.getString("PID"));
		                 dept.setSelectedItem(resultSet.getString("Dept"));
		                 String[] pdob=resultSet.getString("DOB").split("/");
		                 c1.setSelectedItem(pdob[0]);
		                 c2.setSelectedItem(pdob[1]);
		                 c3.setSelectedItem(pdob[2]);
		                 //Printing Results
		               //  res+=PName+" Rs." +Price+"<br>";
		                 }	
		            update.setEnabled(true);
		            pid.setEnabled(false);
		            //System.out.print(res);
		            //data.setText("<html>"+res+"</html>") ;      
			     }
		            catch(Exception dbe){
		            	dbe.printStackTrace();
		            System.out.println("Error in connection");

		        }

		}
		if(e.getSource()==update) {
			
			String p_id=pid.getText();
			String pname=name.getText();
			String ptelephone=telephone.getText();
			String pcnic=cnic.getText();
			String pdept=dept.getSelectedItem().toString();
			//String pdept=depts[deptindex];
			int dateindex=c1.getSelectedIndex();
			String pdate=dates[dateindex];
			int monthindex=c2.getSelectedIndex();
			String pmonth=month[monthindex];
			int yearindex=c3.getSelectedIndex();
			String pyear=year[yearindex];
			String pdob=pdate+"/"+pmonth+"/"+pyear;
			//Date tdate=new Date();
			//System.out.print(tdate);
			//String regdate=tdate.getDate()+"/"+tdate.getMonth()+"/"+tdate.getYear();
			//or use regdate=tdate.toString();
		
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\hospital1.accdb");//Establishing Connection
            System.out.println("Connected Successfully");
            
            String updateQuery = "UPDATE Patient SET PName=?, TNo=?, CNIC=?, DOB=?, Dept=? WHERE PID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, pname);
            preparedStatement.setString(2, ptelephone);
            preparedStatement.setString(3, pcnic);
            preparedStatement.setString(4, pdob);
            preparedStatement.setString(5, pdept);
            preparedStatement.setString(6, p_id);
  
           // System.out.print("UPDATE Patient SET values("+p_id+","+pname+","+ptelephone+",'"+pdob+"','"+pdept+"',"+ptelephone+","+pcnic+")");
           // PreparedStatement preparedStatement=connection.prepareStatement("Insert into Patient(PID,PName,DOB,Dept,TNo,CNIC,RegDate) values('"+p_id+"','"+pname+"','"+pdob+"','"+pdept+"','"+ptelephone+"','"+pcnic+"','"+regdate+"')");
           
            int c= preparedStatement.executeUpdate();
            if(c>0)
            System.out.print("Data updated successfully");
            update.setEnabled(false);
            pid.setEnabled(true);
                 
	     }
            catch(Exception dbe){
            	dbe.printStackTrace();
            System.out.println("Error in connection");

        }
		}
	}
}
