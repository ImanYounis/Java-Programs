package parkinglotSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginGUI implements ActionListener{
	JFrame jf;
	Admin a;
	JPanel jp,jp1;
	JLabel ul,pl;
	JButton login;
	JTextField utf,ptf;
	public loginGUI() {
		a=new Admin();
		jf=new JFrame("Login to PLMS");
		jp=new JPanel();
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		jp1=new JPanel(new GridLayout(2,2,1,1));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login=new JButton("LOGIN");
		login.addActionListener(this);
		utf=new JTextField("");
		ul=new JLabel("Enter username:");
		pl=new JLabel("Enter password:");
		ptf=new JTextField("");
		
		jp1.add(ul);jp1.add(utf);jp1.add(pl);jp1.add(ptf);
		jp.add(jp1);
		jp.add(login);
		jf.add(jp);
		
		jf.setSize(600,300);
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			boolean found=a.login(utf.getText(), ptf.getText());
			if(found)
				new plmsGUI(a);
			else
				JOptionPane.showMessageDialog(null, "Username or password is wrong","Login Failed",JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
