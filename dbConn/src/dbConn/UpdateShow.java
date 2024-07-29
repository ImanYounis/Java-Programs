package dbConn;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import javax.swing.*;
	public class UpdateShow implements ActionListener{
		JTextField PID1,PName1,PQuan1,PPrice1;
		JButton jb;
		UpdateShow(int id)
		{
			int pid=id;
			System.out.print(pid);
			String pn=new String();
			int pq=0,pp=0;
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\company.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");
	            PreparedStatement preparedStatement=connection.prepareStatement("select * from Product where PID="+pid);
	            ResultSet resultSet=preparedStatement.executeQuery();
	            while(resultSet.next()){
	                 pn=resultSet.getString("PName");
	                 pp=resultSet.getInt("PPrice");
	                 pq=resultSet.getInt("PQuantity");
	                 }

			}catch(Exception e) {
				System.out.print("connection error");
			}
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
			  PID1.setText(String.valueOf(pid));PID1.setEnabled(false);
	            PName1.setText(pn);
	            PQuan1.setText(String.valueOf(pp));
	            PPrice1.setText(String.valueOf(pq));
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
			        if (AE.getSource() == jb) {
			            String pid = PID1.getText();
			            String pname = PName1.getText();
			            String pq = PQuan1.getText();
			            String pprice1 = PPrice1.getText();

			            try {
			                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\company.accdb");
			                System.out.println("Connected Successfully");

			                String updateQuery = "UPDATE Product SET PPrice=?, PQuantity=?, PName=? WHERE PID=?";
			                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			                preparedStatement.setString(1, pprice1);
			                preparedStatement.setString(2, pq);
			                preparedStatement.setString(3, pname);
			                preparedStatement.setString(4, pid);

			                int rowsAffected = preparedStatement.executeUpdate();
			                if (rowsAffected > 0) {
			                    System.out.println("Data updated successfully");
			                } else {
			                    System.out.println("No data updated");
			                }
			            } catch (Exception e) {
			                System.out.println("Error in connection or update");
			                e.printStackTrace();
			            }
			        }

		}
}
