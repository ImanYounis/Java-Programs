package Datastructures2;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public class revTreeComparable{
	public static void main(String[] args) {
		Set<fraction> myset=new TreeSet<fraction>();
		Random rand=new Random();
		int n=1,d=1;	
		fraction[] myfracs=new fraction[100];
		for(int i=0;i<100;i++) {
			n=rand.nextInt(50)+1;
			d=rand.nextInt(50)+1;
			myfracs[i]=new fraction(n,d);
		}
		for(fraction f:myfracs) {
			myset.add(f);
		}
		Iterator<fraction> it=myset.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println(myset.size());
	}
}
