package unitConverter;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class converterGUI implements ActionListener{
	JFrame jf;
	JLabel l1,l2,l3,lvalue;
	JComboBox<String> box1,box2;
	JTextField tf;
	JButton btn;
	JPanel jp;
	String[] options= {"km","m","cm","mm"};
	public converterGUI() {
		jf=new JFrame("Unit Converter");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500,500);
		jp=new JPanel(new GridLayout(4,2,100,100));
		btn=new JButton("Convert");
		
		lvalue=new JLabel("Enter value to be converted:");
		tf=new JTextField("");
		
		l1=new JLabel("Convert from:-");l1.setForeground(Color.MAGENTA);
		l2=new JLabel("Convert to:-");l2.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		l3=new JLabel("Result:-");l3.setFont(new Font("Verdona", 18, 10));
		box1=new JComboBox<>(options);
		box2=new JComboBox<>(options);
		btn.addActionListener(this);
		
		jp.add(lvalue);
		jp.add(tf);
		jp.add(l1);
		jp.add(l2);
		jp.add(box1);
		jp.add(box2);
		jp.add(l3);
		jp.add(btn);
		jf.add(jp);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new converterGUI();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String content=tf.getText();
		if(e.getSource()==btn && !content.isBlank()){
			float value=Float.parseFloat(content);
			String unit1=box1.getSelectedItem().toString();
			String unit2=box2.getSelectedItem().toString();
			String res=String.valueOf(convert(unit1,unit2,value));
			l3.setText("Result:- "+res);
		}
		if(content.isBlank()&&e.getSource()==btn) {
			JOptionPane.showMessageDialog(null, "Please enter a valid number in textfield first","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public float convert(String u1,String u2,float val){
		float res=-1;
		if(u1.equals(u2))
			res=Integer.parseInt(u1);
		else if(u1.equals("km")) {
			if(u2.equals("m"))
				res=val*1000;
			else if(u2.equals("cm"))
				res=val*100000;
			else if(u2.equals("mm"))
				res=val*1000000;
		}
		else if(u1.equals("cm")) {
			if(u2.equals("mm"))
				res=val*10;
			else if(u2.equals("m"))
				res=val/100;
			else if(u2.equals("km"))
				res=val/100000;
		}
		else if(u1.equals("m")) {
			if(u2.equals("cm"))
				res=val*100;
			else if(u2.equals("km"))
				res=val/1000;
			else if(u2.equals("mm"))
				res=val*1000;
		}
		else if(u1.equals("mm")) {
			if(u2.equals("cm")) 
				res=val/10;
			else if(u2.equals("km"))
				res=val/1000000;
			else if(u2.equals("m"))
				res=val*1000;
		}
		
		return res;
	}

}
