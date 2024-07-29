package spAlgo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class spGUI implements ActionListener{
	int[][] temp={{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1}};
	spLogic sp;
	JPanel jp1;
	JFrame jf;
	JLabel blank,s1,s2,s3,d1,d2,d3,d4,supplyl,demandl;
	JTextField[][] tfs;
	JButton allocatebtn;
	spGUI(){
		jf=new JFrame("Supply and Demand Verifier");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600,600);
		jp1=new JPanel(new GridLayout(6,6,1,1));
		
		sp=new spLogic();
		
		s1=new JLabel(" A");
		s2=new JLabel(" B");
		s3=new JLabel(" C");
		blank=new JLabel(" ");
		d1=new JLabel("  I");
		d2=new JLabel("  II");
		d3=new JLabel("  III");
		d4=new JLabel("  IV");
		supplyl=new JLabel(" Supply");
		demandl=new JLabel(" Demand");
		
		tfs=new JTextField[4][5];
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				tfs[i][j]=new JTextField("");
			}
		}
		allocatebtn=new JButton("Allocate");
		allocatebtn.addActionListener(this);
		
		jp1.add(blank);jp1.add(d1);jp1.add(d2);jp1.add(d3);jp1.add(d4);jp1.add(supplyl);
		jp1.add(s1);jp1.add(tfs[0][0]);jp1.add(tfs[0][1]);jp1.add(tfs[0][2]);jp1.add(tfs[0][3]);jp1.add(tfs[0][4]);
		jp1.add(s2);jp1.add(tfs[1][0]);jp1.add(tfs[1][1]);jp1.add(tfs[1][2]);jp1.add(tfs[1][3]);jp1.add(tfs[1][4]);
		jp1.add(s3);jp1.add(tfs[2][0]);jp1.add(tfs[2][1]);jp1.add(tfs[2][2]);jp1.add(tfs[2][3]);jp1.add(tfs[2][4]);
		jp1.add(demandl);jp1.add(tfs[3][0]);jp1.add(tfs[3][1]);jp1.add(tfs[3][2]);jp1.add(tfs[3][3]);jp1.add(tfs[3][4]);
		
		tfs[3][4].setBackground(Color.blue);
		tfs[3][4].setEnabled(false);
		
		jp1.add(allocatebtn);
		jf.add(jp1);
		jf.setVisible(true);
		
	}
	public static void main(String[] args) {
		new spGUI();
	}
	public void changeColor(int[][] c) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				if(temp[i][j]!=c[i][j] && !(i>=3||j>=4)) {
					tfs[i][j].setBackground(Color.red);
					tfs[i][j].setText(String.valueOf(c[i][j]));
				}
				else if(i>=3||j>=4) {
					tfs[i][j].setBackground(Color.black);
					tfs[i][j].setText(String.valueOf(c[i][j]));
				}
			}
		}
		tfs[3][4].setBackground(Color.blue);

	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==allocatebtn) {
			try {
				
			for(int i=0;i<4;i++) {
				for(int j=0;j<5;j++) {
					if(tfs[i][j].getText().equals("") && !(i == 3 && j == 4))
						throw new nullExcep(i,j);
					if(!(i == 3 && j == 4)) {
						temp[i][j]=Integer.parseInt(tfs[i][j].getText());
						tfs[i][j].setEnabled(false);
					}
				}
					
			}
				sp.processAllocation(temp);
				int total=sp.checktotal(temp);
				tfs[3][4].setText(String.valueOf(total));
				temp[3][4]=total;
				int[][] changedtemp=sp.allocate(temp);
				changeColor(changedtemp);
			}
			
			catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null,"Enter valid integer values only "+e1, "Error",JOptionPane.ERROR_MESSAGE);
				for(int i=0;i<4;i++) {
					for(int j=0;j<5;j++) {
						tfs[i][j].setEnabled(true);
					}
				}
				tfs[3][4].setEnabled(false);
			}
			catch(sdtMismatch e3) {
				JOptionPane.showMessageDialog(null,"Please fix values for supply and demand columns so that their totals match", "Error",JOptionPane.ERROR_MESSAGE);
				for(int i=0;i<4;i++) {
					for(int j=0;j<5;j++) {
						tfs[i][j].setEnabled(true);
					}
				}
				tfs[3][4].setEnabled(false);
			}
		
			catch(nullExcep e2) {
				JOptionPane.showMessageDialog(null, "Can't leave empty textfields! "+e2.getCellValue().toString(),"Error",JOptionPane.ERROR_MESSAGE);
				for(int i=0;i<4;i++) {
					for(int j=0;j<5;j++) {
						tfs[i][j].setEnabled(true);
					}
				}
				tfs[3][4].setEnabled(false);
			}
			sp.processAllocation(temp);
		}
		
	}

}
