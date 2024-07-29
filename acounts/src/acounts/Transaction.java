package acounts;

public class Transaction {
	private Account.Date date;
	private char type;
	private double amount;
	private double balance;
	private String descrip;
	Transaction(char type,double amount, double balance,String d){
		this.setType(type);
		this.setAmount(amount);
		this.balance=balance;
		setDescrip(d);
		setDate(date);
	}
	public String toString() {
		return ""+type+" "+amount+" "+balance+" "+descrip;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public void setBalance(double b) {
		balance=b;
	}
	public double getBalance() {
		return balance;
	}
	public Account.Date getDate() {
		return date;
	}
	public void setDate(Account.Date date) {
		this.date = date;
	}
}
