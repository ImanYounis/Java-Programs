package balloonPopper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class bpgui implements MouseListener,MouseMotionListener {

	JFrame jf;//can use 'this' instead of JFrame jf; if i am extending from it
	final int XWIDTH=150;
	final int YHEIGHT=150;
	int xvelocity,yvelocity;
	Timer timer;
	JPanel jp;
	
	bpgui(){
		timer=new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jp.setLocation(xvelocity, yvelocity);
				xvelocity+=2;
				yvelocity+=2;
			}
		});
		jf=new JFrame("Balloon Popper");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500,500);
		jf.setLayout(null);
		jp=new JPanel();
		jp.setBounds(0,0,XWIDTH,YHEIGHT);
		jp.setBackground(Color.red);
		xvelocity=yvelocity=0;
		jp.addMouseListener(this);
		jp.addMouseMotionListener(this);
		jf.add(jp);
		jf.setVisible(true);
		timer.start();
		
	}
	
	public static void main(String args[]) {
		new bpgui();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jp.setBackground(Color.blue);
		int x=e.getX();
		int y=e.getY();
		JOptionPane.showMessageDialog(null, "you popped bubble at: "+x+y,"Important",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		jp.setBackground(Color.green);
		System.out.println("Losing aiiiirrrrrrrrrrr!");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		jp.setBackground(Color.yellow);
		System.out.println("air lost!");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		jp.setBackground(Color.orange);
		System.out.println("I am a red balloon, pop me if you can!");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		jp.setBackground(Color.pink);
		System.out.println("hah! you failed to pop me");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		jp.setBackground(Color.darkGray);
		System.out.println("Its no use dragging over me! I am not a file!");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		jp.setBackground(Color.cyan);
		System.out.println("You need to click me to pop!");
		
	}
}
