package GUIpractice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class guiSamples {
    JFrame jf;
    JPanel jp,mainPanel,controlPanel,btnPanel;
    JButton[] btns;
    JButton[] divbtn;
    JButton[] other;
    JCheckBox chb,fd,bd,cs,ww,re,ws;
    JRadioButton rb1,rb2;
    JComboBox<String> cbf,cbr;
    String[] dropdown= {"option 1","option 2","option 3"};
    JLabel find,replace, direction,scope,options;//Q3
    JButton act,close,ok,help;
    JButton f,r,fr,ra;//Q3
    JTextArea ta;
    JLabel jl;
    ButtonGroup bg1,bg2,bg3,bg4;

    guiSamples() {
        jf = new JFrame("Calculator");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jp=new JPanel(new GridLayout(14,2,1,1));
        f=new JButton("Find");
        r=new JButton("Replace");
        fr=new JButton("Find/Replace");
        ra=new JButton("Replace All");
        
        bg1=new ButtonGroup();	//can make through box,grid,border all 3 layout
        bg2=new ButtonGroup();
        bg3=new ButtonGroup();
        bg4=new ButtonGroup();
        find=new JLabel("Find");
        replace=new JLabel("Replace");
        options=new JLabel("Options");
        scope=new JLabel("Scope");
        direction=new JLabel("Direction");
        
        cbf=new JComboBox<String>(dropdown);
        cbr=new JComboBox<String>(dropdown);
        rb1=new JRadioButton("All");
        rb2=new JRadioButton("Selected Lines");
        chb=new JCheckBox("Incremental");
        ws=new JCheckBox("Wrap Search");
        ww=new JCheckBox("Whole Word");
        re=new JCheckBox("Regular Expression");
        cs=new JCheckBox("Case Sensitive");
        fd=new JCheckBox("Forward");
        bd=new JCheckBox("Backward");
        close=new JButton("Close");
        
        bg1.add(fd);bg1.add(bd);
        bg2.add(rb1);bg2.add(rb2);
        bg3.add(cs);bg3.add(ww);bg3.add(re);bg3.add(ws);bg3.add(chb);
        bg4.add(f);bg4.add(r);bg4.add(fr);bg4.add(ra);
        jp.add(find);jp.add(cbf);
        jp.add(replace);jp.add(cbr);
        jp.add(direction);jp.add(scope);jp.add(fd);jp.add(rb1);jp.add(bd);jp.add(rb2);
        jp.add(options);jp.add(cs);jp.add(ww);jp.add(re);jp.add(ws);jp.add(chb);
        jp.add(f);jp.add(r);jp.add(fr);jp.add(ra);jp.add(close);
      /*
        mainPanel = new JPanel(new BorderLayout());
        btnPanel = new JPanel(new GridLayout(2, 1, 5, 5)); 
        controlPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        
        act = new JButton("Activate");
        act.setPreferredSize(new Dimension(80,30));
        close = new JButton("Close");
        close.setPreferredSize(new Dimension(80,30));
        help = new JButton("Help");
        help.setPreferredSize(new Dimension(80,50));
        ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(80,50));
        btnPanel.add(act);
        btnPanel.add(close);
        controlPanel.add(help);
        controlPanel.add(ok);

        jl = new JLabel("Windows");
        ta = new JTextArea();
        ta.setRows(8);
        ta.setColumns(7);
        
        mainPanel.add(jl, BorderLayout.NORTH);
        mainPanel.add(ta, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        mainPanel.add(btnPanel, BorderLayout.EAST);

        jf.add(mainPanel);
        */
/*      
 		jp = new JPanel(new BorderLayout());
 		
         jl=new JLabel("Windows");
         ta=new JTextArea();
         ta.setRows(8);
         ta.setColumns(7);
         act=new JButton("Activate");
         ok=new JButton("OK");
         help=new JButton("Help");
         close=new JButton("Close");
         jp.add(act,BorderLayout.WEST);
         jp.add(close,BorderLayout.WEST);
         jp.add(help,BorderLayout.SOUTH);
         jp.add(ok,BorderLayout.SOUTH);
         jp.add(ta,BorderLayout.CENTER);
        
         jp = new JPanel(new GridLayout(5, 4, 1, 1));
         String[] arr={"Cls","Bck","","Close","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};  
         JButton[] btns=new JButton[20];
 		for(int i=0;i<btns.length;i++){	//alternate way of it
 			btns[i]=new JButton(arr[i]);
 			jp.add(btns[i]);
 			if(arr[i].equals(""))
 				btns[i].setVisible(false);
 		}
         btns = new JButton[11]; // Increased for one additional button (0)
         other = new JButton[4];
         divbtn = new JButton[6];

         other[0] = new JButton("Cls");
         other[1] = new JButton("Bck");
         other[2] = new JButton("");
         other[3] = new JButton("Close");

         for (int i = 0; i < 10; i++) {
             btns[i] = new JButton(String.valueOf(i));
         }

         divbtn[0] = new JButton("/");
         divbtn[1] = new JButton("*");
         divbtn[2] = new JButton("-");
         divbtn[3] = new JButton("+");
         divbtn[4] = new JButton("=");
 		 divbtn[5] = new JButton(".");

        jp.add(other[0]);
        jp.add(other[1]);
        jp.add(other[2]);
        jp.add(other[3]);
        jp.add(btns[7]);
        jp.add(btns[8]);
        jp.add(btns[9]);
        jp.add(divbtn[0]);
        jp.add(btns[4]);
        jp.add(btns[5]);
        jp.add(btns[6]);
        jp.add(divbtn[1]);
        jp.add(btns[1]);
        jp.add(btns[2]);
        jp.add(btns[3]);
        jp.add(divbtn[2]);
        jp.add(btns[0]);
        jp.add(divbtn[5]);
        jp.add(divbtn[4]);
        jp.add(divbtn[3]);

*/
        jf.add(jp);
        
        jf.setSize(300, 300);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new guiSamples();
    }
}

