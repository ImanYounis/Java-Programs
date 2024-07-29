package RandomSentenceGenerator;

import java.util.Random;

public class SentenceCreator {
	String articles[]= {"the","a","one","some","any"};
	String prepositions[]= {"to","from","over","under","on"};
	String[] verbs= {"jumped","drove","ran","walked","skipped"};
	String nouns[]= {"boy","girl","dog","town","car"};
	
	SentenceCreator(){
		generate();
	}
	public void generate(){
		StringBuilder sentence=new StringBuilder();
		Random rand=new Random();
		int[] index=new int[6];
		int num=0;
		while(num<20) {
		for(int i=0;i<6;i++) {
			index[i]=rand.nextInt(5);
		}
//		sentence.concat(articles[index[0]]);
//		sentence.concat(nouns[index[1]]);
//		sentence.concat(verbs[index[2]]);
//		sentence.concat(prepositions[index[3]]);
//		sentence.concat(articles[index[4]]);
//		sentence.concat(nouns[index[5]]).concat(".");
//		(Character)sentence.charAt(0);
//		.toUpperCase();
        sentence.append(articles[index[0]]).append(" ");
        sentence.append(nouns[index[1]]).append(" ");
        sentence.append(verbs[index[2]]).append(" ");
        sentence.append(prepositions[index[3]]).append(" ");
        sentence.append(articles[index[4]]).append(" ");
        sentence.append(nouns[index[5]]).append(".");
        sentence.setCharAt(0, Character.toUpperCase(sentence.charAt(0)));
		System.out.println("Sentence "+(num+1)+":"+sentence);
		num++;
		sentence.delete(0, sentence.length()-1);
		}
	}

	public static void main(String[] args) {
		new SentenceCreator();

	}

}



