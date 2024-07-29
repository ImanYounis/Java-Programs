package parkinglotSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class searchVehicleGUI extends JFrame implements ActionListener{
	JTextField reg,clr,model,owner;
	JLabel regl,clrl,modell,ownerl,vtypel,results;
	JComboBox<String> vtype;
	JButton submit,clear,back;
	String options[]= {"car","bike","truck","bus"};
	JPanel jp;
	searchVehicleGUI(){
		new JFrame("Vehicle search form");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp=new JPanel();
		results=new JLabel("");
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		vtypel=new JLabel("Enter vehicle registration number:");
		vtype=new JComboBox<String>(options);
		regl=new JLabel("Enter vehicle registration number:");
		reg=new JTextField("");
		ownerl=new JLabel("Enter owner name:");
		owner=new JTextField("");
		modell=new JLabel("Enter vehicle model:");
		model=new JTextField("");
		clrl=new JLabel("Enter vehicle color:");
		clr=new JTextField("");
		submit=new JButton("Submit");
		submit.addActionListener(this);
		clear=new JButton("Clear");
		clear.addActionListener(this);
		back=new JButton("Go Back");
		back.addActionListener(this);
		
		jp.add(vtypel);jp.add(vtype);
		jp.add(regl);jp.add(reg);
		jp.add(ownerl);jp.add(owner);
		jp.add(modell);jp.add(model);
		jp.add(clrl);jp.add(clr);jp.add(submit);jp.add(clear);jp.add(back);
		this.add(jp);
		
		setSize(300,400);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			Admin a=new Admin();
			Vehicle v=new Vehicle();
			v.setRegNo(reg.getText());
			v.setOwnerName(owner.getText());
			v.setColor(clr.getText());
			v.setModel(model.getText());
			String str=a.searchVehicle(vtype.getSelectedIndex(),v);
			results.setText(str);
			jp.add(results);
			this.revalidate();
		}
		if(e.getSource()==clear) {
			reg.setText("");
			owner.setText("");
			model.setText("");
			clr.setText("");
		}
		if(e.getSource()==back) {
			this.setVisible(false);
		}
	}

}
