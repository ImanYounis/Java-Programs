package filing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
	public static void main(String[] args) {
		try {
			FileWriter myWriter = new FileWriter("d:\\filename.txt", true);
			System.out.println("How is the weather today?");
			Scanner sc = new Scanner(System.in);
			String diary = sc.next();
			System.out.println(diary);
			myWriter.write(diary);
			myWriter.write("%");
			myWriter.flush();
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
