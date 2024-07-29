package Datastructures;

public class fracException extends Exception {

	int n,d;
	fracException(int n,int d){
		this.n=n;
		this.d=d;
	}
}
