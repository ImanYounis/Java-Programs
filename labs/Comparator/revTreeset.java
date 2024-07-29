package Datastructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class revTreeset implements Comparator<fraction>{

	@Override
	public int compare(fraction o1, fraction o2) {
		double f1=o1.getnum()/o1.getdenom();
		double f2=o2.getnum()/o2.getdenom();
		if(f1<f2)
			return -1;
		else if(f1>f2)
			return 1;
		else return 0;
	}
	
public static void main(String[] args) {
	revTreeset comp=new revTreeset();
	Set<fraction> myset=new TreeSet<fraction>(comp);
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

