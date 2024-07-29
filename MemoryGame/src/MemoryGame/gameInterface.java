package MemoryGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameInterface implements ActionListener {
    JFrame jf;
    JLabel jl, ltime;
    JButton startbtn;
    JButton[] imgButtons;
    ImageIcon[] img;
    JPanel jp;
    Timer timer;
    int timeElapsed;
    boolean gameOver = true;
    int maxtime = 5;
    int imageSize = 100;
    int clickedCount = 0;
    int firstClickedIndex = -1;
    int secondClickedIndex = -1;
    memorylogic m;

    public gameInterface() {
        jf = new JFrame("Memory Game");
        jl = new JLabel("Memorize the sequence of pictures below");
        ltime = new JLabel("Time: 0 seconds");
        jp = new JPanel(new GridLayout(5, 2, 15, 15));
        startbtn = new JButton("Start");
        startbtn.addActionListener(this);
        imgButtons = new JButton[8];
        img = new ImageIcon[8];
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);
        jp.add(ltime);
        jp.add(startbtn);

        m = new memorylogic();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeElapsed++;
                ltime.setText("Time: " + timeElapsed + " seconds");
            }
        });

        for (int i = 0; i < 8; i++) {
            img[i] = m.show(i);
            imgButtons[i] = new JButton();
            imgButtons[i].setSize(imageSize, imageSize);
            imgButtons[i].setIcon(m.resizeImageIcon(new ImageIcon("blank.png"), imageSize, imageSize));
            imgButtons[i].addActionListener(this);
            jp.add(imgButtons[i]);
        }
        jf.add(jl);
        jf.add(jp);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new gameInterface();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startbtn) {
            if (gameOver) {
                gameOver = false;
                timeElapsed = 0;
                startbtn.setText("Restart");
                ltime.setText("Time: 0 seconds");
                showImages();
            }
            else if(!gameOver) {
            	gameOver=true;
            	new gameInterface();
            }
        } else if (e.getSource() instanceof JButton && e.getSource()!=startbtn) {
            if (clickedCount < 2) {
                int index = -1;
                for (int i = 0; i < 8; i++) {
                    if (e.getSource() == imgButtons[i]) {
                        index = i;
                        break;
                    }
                }
                if (index != -1 && index != firstClickedIndex) {
                    imgButtons[index].setIcon(m.resizeImageIcon(img[index], imageSize, imageSize));
                    if (clickedCount == 0) {
                        firstClickedIndex = index;
                        imgButtons[index].setIcon(img[index]);
                    } else {
                        secondClickedIndex = index;
                        imgButtons[index].setIcon(img[index]);
                        if(m.checkMatch(firstClickedIndex,secondClickedIndex))
                        {
                        	imgButtons[firstClickedIndex].setEnabled(false);
                        	imgButtons[secondClickedIndex].setEnabled(false);
                        }
                        else {
                        	imgButtons[firstClickedIndex].setIcon(m.resizeImageIcon(new ImageIcon("blank.png"),imageSize,imageSize));
                        	imgButtons[secondClickedIndex].setIcon(m.resizeImageIcon(new ImageIcon("blank.png"),imageSize,imageSize));
                        }
                        clickedCount=0;
                    }
                  
                }
                
            }
            clickedCount++;
            firstClickedIndex=-1;
            secondClickedIndex=-1;
            
        }
    }

    private void showImages() {
        timer.start();
        memorylogic m = new memorylogic();
        for (int i = 0; i < 8; i++) {
            img[i] = m.show(i);
            imgButtons[i].setIcon(m.resizeImageIcon(img[i], imageSize, imageSize));
        }
        Timer hideTimer = new Timer(5 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 8; i++) {
                    imgButtons[i].setIcon(new ImageIcon("blank.png"));
                }
                timer.stop();
            }
        });
        hideTimer.setRepeats(false);
        hideTimer.start();
    }

}
