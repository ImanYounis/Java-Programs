package filing;

import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
	public static void main(String[] args) {
		try {
			FileReader myreader = new FileReader("d:\\filename.txt");
			// char diary[]= new char[40];
			int i;
			while ((i = myreader.read()) != -1) {
				if ((char) i == '%')
					System.out.println("\nNext Day");
				else
					System.out.print((char) i);
			}
			myreader.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
