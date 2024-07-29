package parkinglotSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class plmsGUI implements ActionListener{
	Admin a;
	JFrame jf;
	JPanel jp;
	double bill;
	String options[]= {"RegNo","Model","Color","Owner Name"};
	JComboBox<String> searchoptions;
	JLabel jl,emptyslot,billl;
	JTextField tf;
	JButton logout,searchFreeSlot,searchVehicle,release,payBill;
	public plmsGUI(Admin a1){
		a=a1;
		bill=0;
		jf=new JFrame("Parking Lot Management System");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp=new JPanel();
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		jl=new JLabel("Welcome to the PLMS Dashboard "+a.getName());
		billl=new JLabel("your bill is: "+bill);
		logout=new JButton("Logout");
		logout.addActionListener(this);
		release=new JButton("Release Vehicle");
		release.addActionListener(this);
		searchFreeSlot=new JButton("Search Free Slot");
		searchFreeSlot.addActionListener(this);
		searchVehicle=new JButton("Find Vehicle");
		searchVehicle.addActionListener(this);
		
		payBill=new JButton("PayBill");
		payBill.addActionListener(this);
		
		searchoptions=new JComboBox<String>(options);
		
		jp.add(jl);
		jp.add(logout);jp.add(searchFreeSlot);jp.add(searchVehicle);jp.add(release);
		jf.add(jp);
		
		jf.setSize(800,600);
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout) {
			a.logout();
			jf.setVisible(false);
		}
		if(e.getSource()==searchFreeSlot) {
			String vtype=JOptionPane.showInputDialog("Enter vehicle type:");
			String slot=a.searchSlot(vtype);
			emptyslot=new JLabel(slot);
			jp.add(emptyslot);
			jf.revalidate();
			
		}
		if(e.getSource()==searchVehicle) {
			new searchVehicleGUI();
		}
		if(e.getSource()==release) {
			bill=a.calculateBill();
			billl.setText("Your bill is: "+bill);
			jp.add(billl);jp.add(payBill);
			jf.revalidate();
		}
		if(e.getSource()==payBill) {
			JOptionPane.showMessageDialog(null,"Bill paid successfully" ,"Successful!",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
