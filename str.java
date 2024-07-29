/*import javax.swing.JOptionPane;
class str{
public static void main(String[] args){
String mynum=JOptionPane.showInputDialog("enter a no");
int no=Integer.parseInt(mynum);
JOptionPane.showMessageDialog(null,"the num is:"+no,"Displaying num",JOptionPane.WARNING_MESSAGE);
}
}*/
/*import javax.swing.JOptionPane;
class str{
  public static void main(String[] args){
    String sentence=JOptionPane.showInputDialog("enter a sentence");
    String word=JOptionPane.showInputDialog("enter word to search");
    //int no=Integer.parseInt(mynum);
    int index=0,count=0,previndex=0;
    for(;;){
      index=sentence.indexOf(word,previndex);
 if(index==-1)
break;
else
      count++;
      previndex=index+1;
      //index=i;
     
    }
    JOptionPane.showMessageDialog(null,"the count is:"+count,"Displaying num",JOptionPane.WARNING_MESSAGE);
 }
}*/
/*import javax.swing.JOptionPane;
class str{
  public static void main(String[] args){
String[] words=new String[10];
for(int i=0;i<10;i++){
    words[i]=JOptionPane.showInputDialog("enter a word");
}
String temp=new String();
for(int i=0;i<words.length-1;i++){
 for(int j=0;j<words.length-i-1;j++){
  if(words[j].compareTo(words[j+1])>0){
    temp=words[j];
    words[j]=words[j+1];
    words[j+1]=temp;
  }}
}for(int i=0;i<words.length;i++)
    System.out.println(words[i]);
}
}*/
/*import javax.swing.JOptionPane;
class str{
  public static void main(String[] args){
    String s=JOptionPane.showInputDialog("enter a sentence");
    char word='*';
    //int no=Integer.parseInt(mynum);
    int index=0,count=0,previndex=0;
    for(int i=0;i<s.length()-2;i++){
     
 if(s.charAt(i)==s.charAt(i+1)&&s.charAt(i+1)==s.charAt(i+2))
word=s.charAt(i);
}
    JOptionPane.showMessageDialog(null,"the word is:"+word,"Displaying word",JOptionPane.WARNING_MESSAGE);
 }
}*/
/*import javax.swing.JOptionPane;
class str{
  public static void main(String[] args){
    String sentence=JOptionPane.showInputDialog("enter a sentence");
    int[] counts=new int[sentence.length()];
    int count=0,previndex=0,index=0;
    for(int i=0;i<sentence.length();i++){
     count=0;
     for (int j = 0; j < sentence.length(); j++) {
                index = sentence.indexOf(sentence.charAt(i), prevIndex);
                if (index == -1)
                    break;
                else {
                    count++;
                    prevIndex = index + 1;
                }
            }
      counts[i]=count;
      //index=i;
     
    }
    for(int i=0;i<counts.length;i++)
    System.out.println(counts[i]);
 }
}*/
/*import javax.swing.JOptionPane;
class str{
  public static void main(String[] args){
    String[] s={"my","name","is","iman","my","name","is","bia"};
    String word=JOptionPane.showInputDialog("enter a char or chars");
    int count=0;
    int[] index={-1,-1,-1,-1,-1,-1,-1,-1}; 
    for(int i=0;i<s.length;i++){
 	if (s[i].contains(word)) {
                index[count] = i;
		count++;
        }
    }
	if(count==0){
System.out.println("word not found");return;}
    for(int i=0;i<index.length;i++)
{if(index[i]==-1)break;
 System.out.println("Word '" + word + "' found in string at index " + index[i]);
 }}
}*/
import java.util.Scanner;

public class str {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a sentence
        System.out.print("Enter a paragraph: ");
        String para = scanner.nextLine();

        // Count words
        String[] words = para.split("\\s+");
        int wordCount = words.length;

        // Count sentences
        String[] sentences = para.split("[.!?]");
        int sentenceCount = sentences.length;

        // Count capital letters
        int count = 0;
        /*for (char c : para.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }*/
	//while(true){
            for(int i=0;i<para.length();i++){
		if(Character.isUpperCase(para.charAt(i)))  //or use : if(para.charAt(i)=='A'||para.charAt(i)=='B' and so on)
		  count++;
	    }
	//}
        // Output the results
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Number of capital letters: " + count);

        // Close the scanner
        scanner.close();
    }
}
