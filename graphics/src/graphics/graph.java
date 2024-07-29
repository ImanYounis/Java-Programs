package graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class graph extends JFrame{
	private JButton btn;
	private Color clr=Color.gray;
	private Container container;
	graph(){
		super("i am drawinggggggggggg");
		container=getContentPane();
		container.setLayout(new FlowLayout());
		btn=new JButton("choose color");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clr=JColorChooser.showDialog(graph.this, "choose a color", clr);
				if(clr==null)
					clr=Color.gray;
				container.setBackground(clr);
				
			}
			
		});
		container.add(btn);
		setSize(400,165);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		int xval[]= {20,40,50,30,20,15};
		int yval[]= {50,50,60,80,80,60};
		
		Polygon p1=new Polygon(xval,yval,6);
		g.setColor(Color.YELLOW);
		g.fillPolygon(p1);
		
		int xval2[]= {70,90,100,80,70,65,60};
		int yval2[]= {100,100,110,110,150,110,90};
		g.setColor(Color.MAGENTA);
		g.drawPolyline(xval2,yval2,7);
		int xval3[]= {220,240,250,290};
		int yval3[]= {290,270,180,160};
		g.drawPolygon(xval3,yval3,4);
		
		g.setColor(Color.RED);
		Polygon p2=new Polygon();
		p2.addPoint(465,135);
		p2.addPoint(475,150);
		p2.addPoint(470,200);
		p2.addPoint(400,210);
		p2.addPoint(420,180);
		g.fillPolygon(p2);
		
		g.setColor(Color.PINK);
		g.setFont(new Font("SERIF",Font.BOLD,12));
		g.drawString("serif",12,150);
		g.setFont(new Font("MONOSPACED",Font.ITALIC,14));
		g.drawString(g.getFont().getName()+""+g.getFont().getSize(),20,180);
		
		g.setColor(Color.red);
		g.drawLine(5, 30, 350, 30);
		g.setColor(Color.BLUE);
		g.drawRect(5, 40, 90, 55);
		g.fillRect(100, 40, 90, 55);
		g.setColor(new Color(12,23,45));
		g.drawRoundRect(290,40,90,55,20,20);
		g.fillRoundRect(195,40,90,55,50,20);
		g.setColor(new Color(0.0f,1.0f,0.0f));
		g.draw3DRect(5,100,90,55,true);
		g.fill3DRect(100,100,90,55,false);
		g.setColor(Color.cyan);
		g.drawOval(195, 100, 90, 55);
		g.fillOval(290, 100, 90, 55);
		
		g.setColor(Color.GRAY);
		g.drawArc(15,160,80,80,0,360);
		g.fillArc(5,40,90,55,0,-110);
		g.fillArc(130,160,80,40,-270,90);
		
		g.setColor(new Color(0.19f,0.5f,1f));
		int[] xvaln= {500,420,300,340,240,534};
		int[] yvaln= {230,240,220,341,320,280};
		g.drawPolyline(xvaln,yvaln,6);
		//g.drawLine(10, 300, 10, 400);
	}
	public static void main(String[] args) {
		graph g1=new graph();
		g1.setDefaultCloseOperation(g1.EXIT_ON_CLOSE);

	}

}
