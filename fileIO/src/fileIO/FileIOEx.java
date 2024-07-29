package fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileIOEx {
	private static final String filepath = "D:\\ObjFile.txt";

	public static void main(String args[]) {
		FileIOEx fiox = new FileIOEx();
		try {
			FileOutputStream fileOut = new FileOutputStream(filepath);

			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			FileIOEx objectIO = new FileIOEx();
			Student st[] = new Student[5];
			st[0] = new Student("abc", "xyz", 12);
			st[1] = new Student("adc", "fyz", 22);
			st[2] = new Student("wec", "hhz", 32);
			st[3] = new Student("yuc", "hz", 42);
			st[4] = new Student("asc", "ffz", 52);

			for (int i = 0; i < 5; i++) {
				objectOut.writeObject(st[i]);
			}
			objectOut.writeObject(null);
			objectOut.flush();
			objectOut.close();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("The Object  was succesfully written to a file");
		int ans = JOptionPane.showConfirmDialog(null, "Do you want to see the data");
		if (ans == 0)
			fiox.ReadObjectFromFile();
		String name = JOptionPane.showInputDialog(null, "Enter the name of the student you want to search");
		fiox.SearchObjectFromFile(name);
		String dname = JOptionPane.showInputDialog(null, "Enter the name of the student you want to delete");
		fiox.DeleteObjectFromFile(dname);
		fiox.ReadObjectFromFile();
		String uname = JOptionPane.showInputDialog(null, "Enter the name of the student you want to update");
		fiox.UpdateObjectFromFile(uname);
		fiox.ReadObjectFromFile();

	}

	public void ReadObjectFromFile() {
		try {

			String details = "";
			Student s = new Student();
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			while ((s = (Student) objectIn.readObject()) != null) {
				details += s.toString() + "\n";

			}
			JOptionPane.showMessageDialog(null, details, "Student details", JOptionPane.PLAIN_MESSAGE);
			objectIn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void SearchObjectFromFile(String n) {
		try {

			String details = "";
			boolean flag = false;
			Student s = new Student();
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			while ((s = (Student) objectIn.readObject()) != null) {
				if (s.getFirstName().matches(n)) {
					JOptionPane.showMessageDialog(null, s, "Student details", JOptionPane.PLAIN_MESSAGE);

					flag = true;
				}

			}
			if (flag == false)

				JOptionPane.showMessageDialog(null, "No data found", "Student details", JOptionPane.PLAIN_MESSAGE);
			objectIn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void DeleteObjectFromFile(String n) {
		try {
			List<Student> arr = new ArrayList<Student>();
			int count = 0, index = -1;
			boolean flag = false;
			Student s = new Student();

			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			while ((s = (Student) objIn.readObject()) != null) {
				if (s.getFirstName().equals(n)) {
					flag = true;
					continue;
				}
				arr.add(s);
			}
			objIn.close();
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			for (Student s1 : arr) {
				objOut.writeObject(s1);

			}
			objOut.writeObject(null);
			objOut.flush();
			if (flag == false)
				System.out.print("not found");
			objOut.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void UpdateObjectFromFile(String n) {
		try {
			List<Student> arr = new ArrayList<Student>();
			int count = 0, index = -1;
			boolean flag = false;
			Student s = new Student();

			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			while ((s = (Student) objIn.readObject()) != null) {
				if (s.getFirstName().equals(n)) {
					flag = true;
					String fname = JOptionPane.showInputDialog("Enter new first name");
					String lname = JOptionPane.showInputDialog("Enter new last name");
					int age = Integer.parseInt(JOptionPane.showInputDialog("Enter new age"));
					s.setAge(age);
					s.setFirstName(fname);
					s.setLastName(lname);
				}
				arr.add(s);
			}
			objIn.close();
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			for (Student s1 : arr) {
				objOut.writeObject(s1);

			}
			objOut.writeObject(null);
			objOut.flush();
			if (flag == false)
				System.out.print("not found");
			objOut.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
