package Q3Student;
import java.util.*;

import javax.swing.JOptionPane;
public class StudentList {

	public static void main(String[] args) {
		LinkedList<Student> stdlist=new LinkedList<>();
		String options[]= {"1.Add Student","2.Search std by regno","3.Display all students","4.EXIT"};
		while(true) {
			int choice=JOptionPane.showOptionDialog(null,"Select an option:-","Student collection",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
			switch(choice) {
			case 0://put all this lower code in class stdlist and in main() only call function stdlist.addStd()
				String sname=JOptionPane.showInputDialog("Enter std name:");
				String sreg=JOptionPane.showInputDialog("Enter std regno:");
				String sadd=JOptionPane.showInputDialog("Enter std address:");
				String sdept=JOptionPane.showInputDialog("Enter dept:");
				stdlist.add(new Student(sreg,sname,sadd,sdept));
				JOptionPane.showMessageDialog(null, "student added ");
				break;
			case 1:
				boolean found=false;
				String reg=JOptionPane.showInputDialog("Enter regno of std to search for:");
				for(Student s:stdlist ) {
					if(s.getRegNo().equals(reg)) {
						found=true;
						JOptionPane.showMessageDialog(null, "student found: "+s.toString());
						break;
					}
			    }
				if(found==false) {
					JOptionPane.showMessageDialog(null, "student not found");
				}
				break;
			case 2:
				StringBuilder stds=new StringBuilder();
				for(Student s:stdlist) {
					stds.append(s).append("\n");

				}
				JOptionPane.showMessageDialog(null, ""+stds);
				break;
			case 3:
				System.exit(0);
			default:
			    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
			    break;
		}
			

	}
	}

}
