import java.util.Scanner;
class quiz1{
public static void main(String[] args){
  Scanner scanner=new Scanner(System.in);
  int[] a1=new int[10];
  int[] a2=new int[10]; boolean duplicate=true;
  for(int i=0;i<a1.length;i++){
   System.out.println("Enter "+(i+1)+" element for a1:");
   a1[i]=scanner.nextInt();
  }
  for(int i=0;i<a2.length;i++){
   System.out.println("Enter "+(i+1)+" element for a2:");
   a2[i]=scanner.nextInt();
  }
  for(int i=0;i<a1.length;i++){
   for(int j=0;j<a2.length;j++){
    if(a1[i]==a2[j])
     a1[i]=-1;
    }
   }
   for(int k=0;k<a1.length;k++){
    if(a1[k]!=-1){
     duplicate=false;
     break;
    }
   }
   if(duplicate==false)
   System.out.println("the two arrays are not the same");
   else
   System.out.println("the two arrays are same");
}}
