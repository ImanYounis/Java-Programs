package spAlgo;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class spLogic {
	private int[][] arr;
	spLogic(){
		arr=new int[4][5];
	}
	public void processAllocation(int[][] temp) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++)
				arr[i][j]=temp[i][j];
		}
	}
	public int checktotal(int[][] temp) throws sdtMismatch{
		int ssum=0,dsum=0;
		for(int i=0;i<4;i++)
			dsum=dsum+arr[3][i];
		for(int j=0;j<3;j++)
			ssum=ssum+arr[j][4];
		if(ssum!=dsum) {
			throw new sdtMismatch(ssum,dsum);
		}
		arr[3][4]=dsum;
		return dsum;
	}
	public int[][] allocate(int[][] temp) {
	    int i = 0, j = 0;
	    int min = 0;

	    while (i < 3 && j < 4) {
	        if (arr[i][4] <= arr[3][j]) {
	            min = arr[i][4];
	            arr[i][4] = 0;
	            arr[3][j] = arr[3][j] - min;
	            arr[i][j]=min;	          
	            i++;
	        } else {
	            min = arr[3][j];
	            arr[3][j] = 0;
	            arr[i][4] = arr[i][4] - min;
	            arr[i][j]=min;
	            j++;
	        }
	        min = 0;
	    }

	    for (int k = 0; k < 4; k++) {
	        for (int l = 0; l < 5; l++) {
	            System.out.print(" " + arr[k][l]);
	        }
	        System.out.println();
	    }
	    return arr;
	}
}
