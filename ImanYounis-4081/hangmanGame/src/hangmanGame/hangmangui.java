package hangmanGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



public class hangmangui implements ActionListener{

	JFrame frame,resultwindow;
	ImageIcon[] images;
	Timer time;
	int sec=0;
	JPanel jp,btnp,resp,imjp;
	StringBuilder currentWord;
	JLabel jl,trieslabel,timer,hintlabel,resl,lh;
	JButton[] btns;
	JButton restartbtn;
	hangman h1;
	hangmangui(){
		h1 = new hangman();
		frame = new JFrame("HangMan Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 300);
		images=new ImageIcon[12];
		imjp=new JPanel(new BorderLayout());
		
		time=new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sec++;
				timer.setText("Total time spent:"+sec);
			}
		});
		time.start();
		
		resultwindow = new JFrame("Results");
		resultwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultwindow.setSize(300, 300);
		resp = new JPanel(new FlowLayout());
		restartbtn = new JButton("Restart Game");
		restartbtn.setEnabled(false);
		restartbtn.setSize(40, 40);
		restartbtn.addActionListener(this);
		resl = new JLabel("Your result will appear here");
		resp.add(resl);
		resp.add(restartbtn);
		resultwindow.add(resp);

		jp = new JPanel(new BorderLayout());
		btnp = new JPanel(new GridLayout(7,4,5,5));

		jl = new JLabel("Your word appears here");
		trieslabel = new JLabel("No. of tries left: 11");
		timer = new JLabel("Total Time spent:0");
    	hintlabel = new JLabel("word hint");

    	jp.add(jl, BorderLayout.NORTH);
    	jp.add(hintlabel, BorderLayout.EAST);
    	jp.add(timer, BorderLayout.SOUTH);
    	jp.add(trieslabel, BorderLayout.WEST);

    	lh = new JLabel("image appears here");

    	imjp.add(lh,BorderLayout.SOUTH);
    	jp.add(imjp, BorderLayout.CENTER);
    	
    	btns = new JButton[26];
    	for (char i = 'a'; i <= 'z'; i++) {
    		btns[i - 'a'] = new JButton(String.valueOf(i));
    		btns[i - 'a'].addActionListener(this);
    		btnp.add(btns[i - 'a']);
    	}
        for (int i = 0; i < images.length; i++) {
            String imagePath = "hangman" + (i+1) + ".png"; 
            images[i] = new ImageIcon(imagePath);
        }
    	lh.setIcon(images[0]);
    	imjp.add(btnp,BorderLayout.NORTH);
    	frame.add(jp);
    	frame.setVisible(true);
    	displayword();
	}

	public void displayword() {
	    String word = h1.pickword();
	    currentWord = new StringBuilder(word.length());
	    
	    for (int i = 0; i < word.length(); i++) {
	        currentWord.append("_, ");
	    }

	    jl.setText(currentWord.toString());
	    String hint = h1.gethint();
	    hintlabel.setText(hint);
	}

	public static void main(String[] args) {
		new hangmangui();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    for (int i = 0; i < 26; i++) {
	        if (e.getSource() == btns[i]) {
	            String c = btns[i].getText();
	            StringBuilder word=h1.checkKey(c.charAt(0));
	            jl.setText(word.toString());
	            btns[i].setEnabled(false);
	            trieslabel.setText("No. of tries left:"+h1.getTriesLeft());
	            int incorrectGuesses = 11 - h1.getTriesLeft();
	            if (incorrectGuesses < images.length) {
	                lh.setIcon(images[incorrectGuesses]);
	            }
	            if(h1.isGameOver()) {
	            	time.stop();
	            	if(word.toString().contains("_"))
	            	resl.setText("You Lost");
	            	else 
	            		resl.setText("YOU WON");
	            	resultwindow.setVisible(true);
	            	frame.setVisible(false);
	            	restartbtn.setEnabled(true);
	            }

	            break;
	        }
	    }
		if(e.getSource()==restartbtn) {
			h1.restart();
			time.start();
			sec=0;
			timer.setText("Total time spent:0");
			frame.setVisible(true);
			for(int i=0;i<26;i++) {
				btns[i].setEnabled(true);
			}
			displayword();
			restartbtn.setEnabled(false);
			resultwindow.setVisible(false);
		}
	}

}
