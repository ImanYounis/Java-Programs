package fileprac;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class HtmlFileHandling {

	public static void main(String[] args) {
		try {
			FileReader f1=new FileReader("myhtml.txt");
			String content=new String();
			//char diary[]=new char[400];
			int i;
			while((i=f1.read())!=-1) {
				content+=(char)i;
			}
			f1.close();
			boolean inTag=false;
			List<String> text=new ArrayList<String>();
			List<String> tags=new ArrayList<String>();
			String stag=new String();String stext=new String();
			//System.out.print(content);
			//content.toCharArray();
			for(int j=0;j<content.length();j++) {
				if(content.charAt(j)=='>') {
					tags.add(stag);
					inTag=false;
					stag=new String();
				}
				else if(content.charAt(j)=='<') {
					inTag=true;
					text.add(stext);
					stext=new String();
				}
				else {
					if(inTag) {
						stag+=content.charAt(j);
					}
					else
						stext+=content.charAt(j);
				}
			}

			FileWriter f2=new FileWriter("seperatedhtml.txt");
			for(String s:tags) {
				f2.write(s);
				f2.flush();
			}
			//f2.close();//or use f3 to write text to a seperate file
			for(String s:text) {
				f2.write(s);
				f2.flush();
			}
			f2.close();
			System.out.print("Succesfully written to file");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
