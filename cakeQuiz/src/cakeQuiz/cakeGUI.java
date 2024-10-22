package cakeQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class cakeGUI implements ActionListener{
	JFrame jf;
	JTextField pid,name,telephone,cnic;
	JPanel jp;
	JButton search;
	List<JButton> order;
	List<Cake> cakes;
	StringBuilder res=new StringBuilder();
	int size;
	JTextField flavor;//,pfrom,pto;
	JLabel pfroml,ptol,flavorl,jl;
	JComboBox<String> pfrom;
	JComboBox<String> pto;
	String[] val1= {"500","1000","1500","2000"};
	String[] val2= {"3000","4000","5000","10000"};
	private Object DriverManager;
	cakeGUI(){
		size=0;
		cakes=new ArrayList<Cake>();
		jf=new JFrame("Order a cake");
		pid=new JTextField("");
		name=new JTextField("");
		cnic=new JTextField("");
	telephone=new JTextField("");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp=new JPanel();
		jl=new JLabel("Your search results will appear here");
		jp.setLayout( new BoxLayout(jp,BoxLayout.Y_AXIS));
		search=new JButton("Search");
		search.addActionListener(this);
		pfrom=new JComboBox<String>(val1);
		pfroml=new JLabel("Enter starting price:");
		pto=new JComboBox<String>(val2);
		ptol=new JLabel("Enter price range:");
		flavor=new JTextField("");
		flavorl=new JLabel("Enter flavor:");
		//  btn=new JButton("Order");
		  order=new ArrayList<JButton>();
		
		jp.add(flavorl);
		jp.add(flavor);
		jp.add(pfroml);
		jp.add(pfrom);
		
		jp.add(ptol);
		jp.add(pto);
		jp.add(search);
		jp.add(jl);
		jp.add(pid);
		jp.add(name);
		jp.add(telephone);
		jp.add(cnic);
		// jp.add(btn);
		jf.add(jp);
		
		jf.setSize(400,400);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new cakeGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			String from=pfrom.getSelectedItem().toString();
			String to=pto.getSelectedItem().toString();
			String cflavor=flavor.getText().toString();
			int fromp=Integer.parseInt(from);
			int top=Integer.parseInt(to);
			 try{
		
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= ((java.sql.DriverManager) DriverManager).getConnection("jdbc:ucanaccess://D:\\jp\\cakedb.accdb");//Establishing Connection
		            System.out.println("Connected Successfully");
		            //String pcnic=JOptionPane.showInputDialog("Enter cnic of patient:");
		            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Cake WHERE Price >= ? AND Price <= ? AND Flavor LIKE ?");
		            preparedStatement.setInt(1, fromp);	
		            preparedStatement.setInt(2, top);	
		            preparedStatement.setString(3, "%"+cflavor+"%");	
		            ResultSet resultSet=preparedStatement.executeQuery();
		           
		            while(resultSet.next()) {
		            	 name.setText(resultSet.getString("Title"));
		                 telephone.setText(String.valueOf(resultSet.getInt("Price")));
		                 cnic.setText(resultSet.getString("Size"));
		                 pid.setText(resultSet.getString("Flavor"));
		                 JButton btn=new JButton("Order"+resultSet.getString("Title"));
		                 btn.addActionListener(this);
		                 order.add(btn);
		                 //order.get(size).addActionListener(this);
		                 cakes.add(new Cake(resultSet.getString("Cake_ID"),resultSet.getString("Title"),resultSet.getInt("Price"),resultSet.getInt("Quantity"),resultSet.getString("Flavor"),resultSet.getString("Size"),resultSet.getString("Category")));
		                // size++;
		                 jp.add(btn);
		                 jf.revalidate();
		              
		                
		            	res.append(resultSet.getString("Cake_ID"));res.append("\n");
		            	res.append(resultSet.getString("Title"));res.append("\n");
		            	res.append(resultSet.getInt("Price"));res.append("\n");
		            	res.append(resultSet.getString("Category"));res.append("\n");
		            	res.append(resultSet.getString("Size"));res.append("\n");
		            	res.append(resultSet.getString("Flavor"));res.append("\n");
		            	res.append(resultSet.getInt("Quantity"));res.append("\n");
		            	System.out.print(res.toString());
		                 

	                }
    jl.setText(res.toString());
			     }
		            catch(Exception dbe){
		            	dbe.printStackTrace();
		            System.out.println("Error in connection");

		        }

		}
		for(int i=0;i<order.size();i++) {
			  if(e.getSource()==order.get(i)) {
		        	int q=cakes.get(i).getQty();
		        	q=q-1;
		        	String id=cakes.get(i).getCakeID();
		        	System.out.println("cake id="+id);
		        	try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conn=((java.sql.DriverManager) DriverManager).getConnection("jdbc:ucanaccess://D:\\jp\\cakedb.accdb");
						PreparedStatement ps=conn.prepareStatement("Update Cake set Quantity=? where Cake_ID=?");
						ps.setInt(1,q);
						ps.setString(2,id);
						System.out.print(ps.toString());
						int c=ps.executeUpdate();
						if(c>0)
							JOptionPane.showMessageDialog(null, "Your order has been placed","Order successful",JOptionPane.INFORMATION_MESSAGE);
		        	} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  }
		}
      
		
	}

}
