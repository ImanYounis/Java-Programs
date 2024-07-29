package spAlgo;

public class sdtMismatch extends Exception{

	int st,dt;
	sdtMismatch(int st,int dt){
		this.st=st;
		this.dt=dt;
	}
}
