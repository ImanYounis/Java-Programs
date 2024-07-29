package MemoryGame;

import java.util.Random;

import javax.swing.ImageIcon;

public class memorylogic {

	int count[]= {0,0,0,0};
	int i=0;
	int[] imgsequence=new int[8];
	String[] images= {"apple.png","home.png","fish.png","pen.png"};
	ImageIcon[] pics=new ImageIcon[8];
	public ImageIcon show(int k){
		Random rand=new Random();
		int pos=rand.nextInt(4);
		System.out.print(pos);
		while(count[pos]>=2) {
			pos=rand.nextInt(4);
			System.out.print(pos);
		}
		imgsequence[i]=pos;i++;
		pics[k]=new ImageIcon(images[pos]);
		count[pos]++;
		return pics[k];
	}
	public int getImageSeq(int id){
		return imgsequence[id];
	}

    public boolean checkMatch(int index1,int index2) {
        if (index1 != -1 && index2 != -1) {
            if (getImageSeq(index1)==getImageSeq(index2)) {
                //imgButtons[firstClickedIndex].setEnabled(false);
                //imgButtons[secondClickedIndex].setEnabled(false);
            	return true;
            } 
            	
                //imgButtons[firstClickedIndex].setIcon(new ImageIcon("blank.png"));
                //imgButtons[secondClickedIndex].setIcon(new ImageIcon("blank.png"));
            //clickedCount = 0;
            index1 = -1;
            index2 = -1; 
        }
        return false;
    }

    public ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
    }
}
