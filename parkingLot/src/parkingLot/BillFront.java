package parkingLot;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;

public class BillFront {
	JFrame jf;
	BillBack a;
	JPanel jp;
	JButton paybill;
	JLabel regl,ownerl,edatel,etimel;
	JLabel reg,owner,edate,etime;
	JLabel cdl,ctl,totall;
	JLabel cd,ct,total;
	BillFront(){
		a=new BillBack();
		String[] results=a.calculateBill();
		if(results==null||results[0].equals("")) {
			jf.dispose();
			jf.setVisible(false);
			return;
		}
		jf=new JFrame("Bill");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300,400);
		jp=new JPanel(new GridLayout(8,2,5,5));
		regl=new JLabel("Plate NO: ");
		ownerl=new JLabel("Owner Name: ");
		edatel=new JLabel("Entry Date: ");
		etimel=new JLabel("Entry Time: ");
		cdl=new JLabel("Current Date: ");
		ctl=new JLabel("Current Time: ");
		totall=new JLabel("Total Bill: ");
		
		reg=new JLabel(results[0]);
		owner=new JLabel(results[1]);
		edate=new JLabel(results[2]);
		etime=new JLabel(results[3]);
		paybill=new JButton("PayBill");
		
		Date date = new Date();
		LocalDate d1 = LocalDate.now();
		LocalTime t1 = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm aa");
		String currentDate = d1.format(formatter);
		String currentTime = formatTime.format(date);
		
		cd=new JLabel(currentDate);
		ct=new JLabel(currentTime);
		total=new JLabel(results[4]);
		
		jp.add(regl);jp.add(reg);
		jp.add(ownerl);jp.add(owner);
		jp.add(edatel);jp.add(edate);
		jp.add(etimel);jp.add(etime);
		jp.add(cdl);jp.add(cd);
		jp.add(ctl);jp.add(ct);
		jp.add(totall);jp.add(total);
		jp.add(paybill);
		
		//double bill=a.calculateBill();
		
		paybill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.emptySpace(reg.getText());
				JOptionPane.showMessageDialog(null,"Bill Paid","Payment Successful",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		jf.add(jp);
		jf.setVisible(true);
	}

}
