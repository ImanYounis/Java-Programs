package acounts;

public class CheckingAcc extends Account{
	private int overdraftlimit;
	final String status;
	CheckingAcc(){
		super();
		setOverdraftlimit(0);
		status="none";
	}
	CheckingAcc(String n,double bal,float i,int id,int overlimit){
		super(n,bal,i,id);
		overdraftlimit=overlimit;	
		this.status = "junior";
	}
	public int getOverdraftlimit() {
		return overdraftlimit;
	}
	public void setOverdraftlimit(int overdraftlimit) {
		this.overdraftlimit = overdraftlimit;
	}
	public String toString() {
		return "limit:"+overdraftlimit+" Status: "+status+" "+super.toString();
	}
	public void impinf(int val) {
		if(val==1)
			System.out.println("checking acc overriding default"+YES);
		else
			System.out.println("checking acc overriding default"+NO);
	}
}
