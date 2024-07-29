package mickeyMouse;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MickeyLines extends JFrame{

	MickeyLines(){
		super("Mickey plays tictactoe");	
		
		setSize(600,600);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		MickeyLines m1=new MickeyLines();
		m1.setDefaultCloseOperation(m1.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		//xoxo
		g.drawLine(50,420,200,420);
		g.drawLine(50,440,200,440);
		g.drawLine(50,460,200,460);
		g.drawLine(50,480,200,480);
		
		g.drawLine(100,400,100,500);
		g.drawLine(120,400,120,500);
		g.drawLine(140,400,140,500);
		g.drawLine(160,400,160,500);
		//arcs
		g.drawArc(350,120,200,120,25,80);
		g.drawArc(350,140,200,140,25,80);
		g.drawArc(350,160,200,160,25,80);
		g.drawArc(350,180,200,180,25,80);
		
		g.drawArc(350,50,120,200,-35,70);
		g.drawArc(350,60,140,200,-35,70);
		g.drawArc(350,70,160,200,-35,70);
		g.drawArc(350,80,180,200,-35,70);
		//mickey
		g.setColor(Color.PINK);
		g.fillOval(450, 400, 120, 120);
		g.setColor(Color.BLACK);
		g.fillOval(430, 360, 60, 60);
		g.fillOval(530, 360, 60, 60);
		g.setColor(Color.WHITE);
		g.fillOval(480, 440, 10, 10);
		g.fillOval(520, 440, 10, 10);
		g.setColor(Color.BLACK);
		g.drawLine(505,450,505,470);
		g.drawArc(485,460,40,30,0,-180);
	}

}
