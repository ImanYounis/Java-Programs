import java.util.Scanner;
//import fraction.java;
class fracdemo{
 public static void main(String[] args){
 Scanner scanner=new Scanner(System.in);
  fraction f1=new fraction(2,4);
  fraction f2=new fraction(2,5);
  fraction res=new fraction();
 System.out.println("mul");
  res=f1.mul(f2);
  res.showfrac();
 System.out.println("add");
  res=f1.add(f2);
  res.showfrac();
 System.out.println("f1 reduced");
f1.reducedfraction();
f1.showfrac();
//f2.showfrac();
 System.out.println("subtract");
  res=f1.subtract(f2);
  res.showfrac();
 System.out.println("divide");
  res=f1.divide(f2);
  res.showfrac();
 System.out.println("enter string fraction");
 String str=scanner.nextLine();
 fraction strf=new fraction(str);
 strf.showfrac();
 System.out.println("copying f to f3");
 fraction f=new fraction(9,19);
 fraction f3=new fraction(f);
 f3.showfrac();
System.out.println("using getter and setters");
f1.setnum(12);
System.out.println(""+f1.getnum());
 }
}

