import java.util.Scanner;
class quiz12{
public static void main(String[] args){
  Scanner scanner=new Scanner(System.in);
  int[] a1=new int[12];
  int[] a2=new int[4]; int sum=0;
  for(int i=0;i<a1.length;i++){
   System.out.println("Enter "+(i+1)+" element for a1:");
   a1[i]=scanner.nextInt();
  }
   
  for(int i=0;i<a2.length;i++){
   for(int j=0;j<a1.length-2;j=j+3){
    sum=a1[j]+a1[j+1]+a1[j+2];
     a2[i]=sum;i++;
    }
   }
   System.out.println("printing result array");
   for(int k=0;k<a2.length;k++){
    System.out.println(""+a2[k]);
   }
  
}}