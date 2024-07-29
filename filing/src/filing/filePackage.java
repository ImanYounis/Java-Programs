package filing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filePackage {

	public static void main(String[] args) throws IOException {
		File ifile=new File("input.txt");
		File ofile=new File("output.txt");
		FileReader in=new FileReader(ifile);
		FileWriter out=new FileWriter(ofile);
		FileInputStream in1=new FileInputStream(ifile);
		FileOutputStream out1=new FileOutputStream(ofile,true);
		int c;
		while((c=in.read())!=-1)//char by char r/w
			out.write(c);
		in.close();
		out.close();
		int c1;
		while((c1=in1.read())!=-1)//byte by byte r/w
			out1.write(c);
		in1.close();
		out1.close();

	}

}
