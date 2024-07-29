package hangmanGame;


import java.util.Random;

public class hangman {
	private String[] words={"destination","consumer","capital","fraudulent","clause","falseCeiling","raspberry","projection","nitrate","methylSalicate","ethanol"};
	private String[] hints= {"place to reach","user of something","every country has it","type of activity done by criminal","almost a sentence","good for keeping room temperature low","sweet","shadow","chemical","chemical","fragrance"};
	private int hindex;
	private String picked;
    private StringBuilder currentWord; 
    private int tries;
    boolean found=false;
    private boolean gameOver;
    hangman(){
    	tries=11;
    	gameOver=false;
    	hindex=0;
    }
    public String pickword() {
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        picked = words[index];
        hindex = index;
        currentWord = new StringBuilder(picked.length());
        
        for (int i = 0; i < picked.length(); i++) {
            currentWord.append("_");
        }
        
        return picked;
    }

	public String gethint() {
		return hints[hindex];
	}
	public StringBuilder checkKey(char c) {
	    char[] alphabets = picked.toCharArray();
	    found=false;
	    for (int i = 0; i < alphabets.length; i++) {
	        if (Character.toLowerCase(c) == Character.toLowerCase(alphabets[i])) {
	    	    currentWord.setCharAt(i,c);
	    	    found=true;
	        }
	    }
	    if(found==false)
	    tries--;
	    return currentWord;
	}
	public String getCurrentWord() {
	    return currentWord.toString();
	}

	public int getTriesLeft() {
	    return tries;
	}

    public boolean isGameOver() {
    	String w=currentWord.toString();
    	if(tries<=0||w.equalsIgnoreCase(picked))
    		gameOver=true;
        return gameOver;
	}
    public void restart() {
    	gameOver=false;
    	tries=11;
    	hindex=0;
    }
}
