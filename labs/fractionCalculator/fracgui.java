package fractionGUI;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
public class fracgui {
	public static void main(String[] args) {
		Set<fraction> fracSet=new HashSet<fraction>();
		Random rand=new Random();
		int n=0,d=0;
		fraction[] myfracs=new fraction[100];
		for(int i=0;i<100;i++) {
			myfracs[i]=new fraction(n,d);
		}
		for(fraction f:myfracs) {
			fracSet.add(f);
		}
	Iterator hsit=fracSet.iterator();
		while(hsit.hasNext()) {
			System.out.print(" "+hsit.next());
		}
		System.out.println(fracSet.size());
	}
}
