package spAlgo;
public class nullExcep extends NullPointerException {

	int row,col;
	StringBuilder cellvalue;
	nullExcep(int row,int col){
		this.row=row;
		this.col=col;
		cellvalue=new StringBuilder();
		if(row==0) {
			cellvalue.append("A");
		}
		else if(row==1)
			cellvalue.append("B");
		else if(row==2)
			cellvalue.append("C");
		else if(row==3)
			cellvalue.append("D");
		cellvalue.append(String.valueOf(col));
	}
	public StringBuilder getCellValue() {
		return cellvalue;
	}
}
