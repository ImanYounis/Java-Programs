package acounts;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account implements myinf{
	public void impinf() {
		
	}
	private String name;
	private static int accno=0;
	private double balance;
	private float interestrate;
	private int id;
	Date datecreated;
	ArrayList<Transaction> transactions;
	Account(){
		accno=0;
		name=new String();
		balance=0;
		interestrate=0;
		datecreated=new Date();
		setId(0);
		transactions=new ArrayList<>();
		accno=accno+1;
	}
	Account(String n,double bal,float i,int id){
		name=n;
		balance=bal;
		interestrate=i;
		this.id=id;
		transactions=new ArrayList<>();
		accno=accno+1;
		datecreated=new Date();
		datecreated.setdate(23, 11,1 );
	}
	class Date{
		private int yr,mon,day;
		Date(){
			yr=mon=day=1;
		}
		public void setdate(int y,int m,int d) {
			yr=y;mon=m;day=d;
		}
		public String toString() {
			return ""+day+"/"+mon+"/"+yr;
		}
	}
	public void withdraw(){
		Scanner s=new Scanner(System.in);
		System.out.print("Enter withdrawal amount:");
		double amt=s.nextDouble();
		s.nextLine();
		if(getBalance()>=amt)
			setBalance(getBalance()-amt);
		else {
			System.out.print("\ntransaction not possible. low balance!");
			//s.close();
			return;
		}
		System.out.print("\nEnter transaction description:");
		String descrip=s.nextLine();
		//s.close();
		transactions.add(new Transaction('w',amt,getBalance(),descrip));
	}
	public void deposit(){
		Scanner s=new Scanner(System.in);
		System.out.print("Enter deposit amount:");
		double amt=s.nextDouble();
		s.nextLine();
		setBalance(balance+amt);
		System.out.print("\nEnter transaction description:");
		String descrip=s.nextLine();
		//s.close();
		transactions.add(new Transaction('d',amt,balance,descrip));
	}
	public int getAccno() {
		return accno;
	}
	public float getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(float interestrate) {
		this.interestrate = interestrate;
	}
	public void setBalance(double b) {
		balance=b;
	}
	public double getBalance() {
		return balance;
	}
	public void setname(String n) {
		name=n;
	}
	public String getname() {
		return name;
	}
	public static void main(String[] args) {
//		Account a=new Account("George",1000,(float)1.5,1122);
//		a.deposit();
//		a.withdraw();
//		a.show();
		Account a=new SavingAcc();
		System.out.println(a);
		a=new CheckingAcc("George",1000,(float)1.5,1122,35);
		a.setBalance(3000);
		a.setInterestrate(30.0f);//correct way of doing it so it doesnot cast it as double
		System.out.println(String.valueOf(a.getAccno()));
		a.deposit();
		a.withdraw();
		System.out.println(a);
		a.show();
		myinf inf=new CheckingAcc();
		inf.impinf(1);
		inf=new SavingAcc();
		inf.impinf(0);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void show() {
		Transaction t;
		System.out.println(this.toString());
		for(int i=0;i<transactions.size();i++) {
			t=transactions.get(i);
			System.out.println("Transaction "+(i+1)+":"+t.toString());
		}
	}
	public String toString() {
		return ""+accno+" "+name+" "+id+" "+balance+" "+datecreated+" "+interestrate;
	}
}
