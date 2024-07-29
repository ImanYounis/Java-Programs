package Datastructures;

import javax.swing.JOptionPane;

class fraction
{
	private int num;
	private int denom;
	fraction(){
		
	}
	public int getdenom(){
		return denom;
	}
	public void setdenom(int d){
		denom=d;
	}
	public int getnum(){
		return num;
	}	
	public void setnum(int n){	
		num=n;
	}
	//copy constructor
	fraction(fraction f1){
		try {
			if(f1.denom==0)
				throw new fracException(num,denom);
			else {
				this.num=f1.num;
				this.denom=f1.denom;
			}
		}
		catch(fracException e) {
			JOptionPane.showMessageDialog(null, "can't input zero","error",JOptionPane.ERROR_MESSAGE);
		}
	}
	fraction(String str){
		try {
			String[] frac=str.split("/");
			int num=Integer.parseInt(frac[0]);
			int denom=Integer.parseInt(frac[1]);
			if(denom==0)
				throw new fracException(num,denom);
			else {
				this.num=num;
				this.denom=denom;
			}
		}
		catch(fracException e) {
			JOptionPane.showMessageDialog(null, "can't input zero","error",JOptionPane.ERROR_MESSAGE);
		}
	}
	fraction(int num,int denom){
		try {
			if(denom==0)
				throw new fracException(num,denom);
			else {
				this.num=num;
				this.denom=denom;
			}
		}
		catch(fracException e) {
			JOptionPane.showMessageDialog(null, "can't input zero","error",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void reducedfraction(){	
		int min=0;
		if(num<denom)min=num;
		else min=denom;
		for (int i=min;i>=2;i--){
			if(num%i==0&&denom%i==0){
				num=num/i;
				denom=denom/i;
			}
		}
	}

	public fraction add(fraction f1){
		fraction res=new fraction();
		res.denom=denom*f1.denom;;
		res.num=num*f1.denom+f1.num*denom;
		res.reducedfraction();
		//System.out.println(res.num+"/"+res.denom);
		return res;	
	}

	public fraction mul(fraction f1){
		fraction res=new fraction();
		res.num=f1.num*num;
		res.denom=f1.denom*denom;
		res.reducedfraction();
		return res;
	}
	public fraction divide(fraction f1){
		fraction res=new fraction();
		int temp;
		temp=f1.num;
		f1.num=f1.denom;
		f1.denom=temp;
		res=mul(f1);
		res.reducedfraction();
		return res;
	}
	public fraction subtract(fraction f1){
		fraction res=new fraction();
		res.denom=denom*f1.denom;
		res.num=num*f1.denom-f1.num*denom;
		res.reducedfraction();
		return res;
	}
	public String toString() {
		String f=new String();
		f=String.valueOf(this.num+"/"+this.denom+"\n");
		return f;
	}
	public boolean equals(Object o) {
		if(!(o instanceof fraction))
			return false;
		else {
			fraction f=(fraction)o;
			this.reducedfraction();
			f.reducedfraction();
			if(num==f.num) {
				if(denom==f.denom)
					return true;
			}
		}
		return false;
	}
	public int hashCode() {
		Integer numI=this.num;
		return numI.hashCode();
	}
}


