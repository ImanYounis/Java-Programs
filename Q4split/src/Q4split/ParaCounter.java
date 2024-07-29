package Q4split;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParaCounter implements ActionListener {

	JTextArea ta;
	JFrame jf;
	JButton btn,btnfind;
	JPanel jp;
	JTextField tf1,tf2;
	JLabel l1,l2,l3;
	ParaCounter(){
		btn=new JButton("Check");
		btnfind=new JButton("Replace");
		jp=new JPanel(new FlowLayout());
		jf=new JFrame("PARA COUNTER APP");
		l1=new JLabel("sentence count");
		l1.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
		l2=new JLabel("word count");
		l2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		l3=new JLabel("double quoted words count");
		l3.setBorder(BorderFactory.createEtchedBorder());
		tf1=new JTextField("enter find word");
		tf2=new JTextField("enter replace word");
		ta=new JTextArea("enter paragraph:");
		ta.setRows(10);
		ta.setColumns(40);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnfind.addActionListener(this);
		btn.addActionListener(this);
		jp.add(ta);jp.add(btn);
		jp.add(l1);
		jp.add(l2);jp.add(l3);jp.add(tf1);jp.add(tf2);jp.add(btnfind);
		jf.add(jp);
		jf.setSize(500,500);
		jf.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnfind) {
//put all lower code in textanalyzer class and only make function call here:textanalyzer.findandreplace()
			String tofind=tf1.getText();
			String toreplace=tf2.getText();
			String text=ta.getText();
			//String[] words=text.split(" ");
			/*for(int i=0;i<words.length;i++) {
				if(words[i].equals(tofind)) {
					words[i]=toreplace;
				}
			}*/
            text = text.replaceAll(tofind, toreplace);
            ta.setText(text);
		}
		if(e.getSource()==btn) {
			String text=ta.getText();
			String[] words=text.split("\\s+");
			int count=0;
			if(text.contains("\"")) {
				int index=0,previndex=0;
			    for(;;){
			      index=text.indexOf("\"",previndex);
			      if(index==-1)
			    	  break;
			      else
			    	  count++;
			      previndex=index+1;
			    }
			}
			String[] sentences=text.split("[!?.]");
			String[] quotes=text.split("\"");//or using startsWith and EndsWith()
			l1.setText(String.valueOf(sentences.length));
			l2.setText(String.valueOf(words.length));
			l3.setText(String.valueOf(count));
			//l3.setText(String.valueOf(Math.round(quotes.length/2)));
		}
		
	}
	public static void main(String[] args) {
		new ParaCounter();
	}
	
}
