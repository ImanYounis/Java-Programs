package fileprac;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readWOD {

	public static void main(String[] args) {
		 try {
		      FileReader myreader = new FileReader("WriteData.txt");
		      char diary[]= new char[400];
		      List<String> names=new ArrayList<String>();
		      int i;String s=new String();
		     // int j=0;
		      int newsize=0;
		    while((i= myreader.read())!=-1){
		    	if ((char)i=='%') {
		    		names.add(s);
		    		s=new String();
		    		
		    		System.out.println("\nNext Name");
		    	}
		    		
		    	else {
		    		s=s+(char)i;
		    		diary[newsize]=(char)i;
		    		newsize++;
		    		System.out.print((char)i);
		    	}
		    }
		      myreader.close();
		  	System.out.println("my string array");
		    	for(int k=0;k<5;k++)
		    	System.out.print(names.get(k));
		    	
			  	//code for writing without duplicates
		    	FileWriter myWriter = new FileWriter("DataWOD.txt");
		    	for(int a=0;a<names.size();a++) {
		    		for(int b=0;b<names.size();b++) {
		    			if(names.get(a).equals(names.get(b))&&a!=b){
		    				names.remove(b);
		    			}
		    		}
		    	}
			      for(int j=0;j<names.size();j++) {
			    	  s=names.get(j);
				      System.out.println(diary);
				      myWriter.write(s);//filewriter can write string directly instead of converting it to char[]
				      //myWriter.write("%");
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
