package fileprac;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class rwWOD {
	public static void main(String[] args) {
		String diary;
		  try {
		      FileWriter myWriter = new FileWriter("WriteData.txt",true);
		      System.out.println("Enter 5 names:");
		      Scanner sc=new Scanner(System.in);
		      for(int i=0;i<5;i++) {
		    	  diary=sc.next();
			      System.out.println(diary);
			      myWriter.write(diary);
			      myWriter.write("%");
			      myWriter.flush();
		      }	
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
