package filing;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class shapeHandling extends JFrame {
	List<String> data;
	String s;

	shapeHandling() {
		super("shapes made from file data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		data = new ArrayList<String>();
		s = new String();
		try {
			int i;
			FileReader reader = new FileReader("shapedata.txt");
			while ((i = reader.read()) != -1) {
				if ((char) i == ';') {
					data.add(s);
					System.out.print(s);
					s = "";
				} else {
					s += (char) i;
				}
			}
			System.out.print("file read successfully");
			reader.close();
			// writing back to file
			FileWriter fw = new FileWriter("shapedata.txt");
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter coordinates for arc:");
			String arc = sc.nextLine();
			data.add(arc);
			System.out.print("\nEnter coordinates for string to be drawn:");
			String str = sc.nextLine();
			data.add(str);
			System.out.print("\nEnter color:");
			String clr = sc.nextLine();
			data.add(clr);
			for (int j = 0; j < data.size(); j++) {
				fw.write(data.get(j));
				fw.write(";");
				fw.flush();
			}
			fw.close();
			System.out.println("file written successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		for (String s : data) {
			String[] parts = s.split(",");
			if (parts.length == 5) {
				String stype = parts[0];
				int x = Integer.parseInt(parts[1]);
				int y = Integer.parseInt(parts[2]);
				int w = Integer.parseInt(parts[3]);
				int h = Integer.parseInt(parts[4]);
				if (stype.equalsIgnoreCase("RECTANGLE") || stype.equalsIgnoreCase("square")) {
					g.drawRect(x, y, w, h);
				}
				if (stype.equalsIgnoreCase("ellipse") || stype.equalsIgnoreCase("circle")) {
					g.fillOval(x, y, w, h);
				}
			}
			else if(parts.length==3) {
				int x=Integer.parseInt(parts[1]);
				int y=Integer.parseInt(parts[2]);
				String str=parts[0];
				g.drawString(str, x, y);
			}
			else if(parts.length==6) {
				int x=Integer.parseInt(parts[0]);
				int y=Integer.parseInt(parts[1]);
				int w=Integer.parseInt(parts[2]);
				int h=Integer.parseInt(parts[3]);
				int st=Integer.parseInt(parts[4]);
				int end=Integer.parseInt(parts[5]);
				g.fillArc(x, y, w, h, st, end);
			}
			else if(parts.length==1) {
				String clr=parts[0];
				if(clr.equalsIgnoreCase("red"))
					g.setColor(Color.RED);
				else if(clr.equalsIgnoreCase("blue"))
					g.setColor(Color.BLUE);
			}
		}
		// drawing my own shapes to write on file
		//g.setColor(Color.RED);
		//g.fillArc(70, 90, 90, 80, 0, -270);
		//int[] points = { 70, 80, 90, 80, 0, -270 };
		//data.add(String.valueOf(points));
		//System.out.println(data.get(data.size() - 1));
		//g.drawString("my shape", 189, 178);
		//int[] points2 = { 189, 178 };
		//data.add(String.valueOf(points2) + "my shape" + "RED");
		//System.out.println(data.get(data.size() - 1));
	}

	public static void main(String[] args) {
		new shapeHandling();
	}

}
