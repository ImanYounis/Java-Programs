/*import java.util.Scanner;
class First{
  public static void main(String[] args){
   Scanner scanner=new Scanner(System.in);
   System.out.println("Enter 1st number:");
   int a=scanner.nextInt();
   System.out.println("Enter 2nd number:");
   int b=scanner.nextInt();
   System.out.println("Enter 3rd number:");
   int c=scanner.nextInt();
   System.out.println("Printing roots of given numbers");
   double disc=b*b-4*a*c;
   double r1,r2;
    if(disc>0){
     r1=(-b+Math.sqrt(disc))/(2*a);
     r2=(-b-Math.sqrt(disc))/(2*a);
     System.out.println("roots are= "+r1+" "+r2);
    }
    else if(disc==0){
     r1=r2=-b/(2*a);
     System.out.println("roots are= "+r1);
    }
    else{
     r1=-b/(2*a);
     r2=Math.sqrt(-disc)/(2*a);
     System.out.println("roots are= "+r1+" "+r2);
    }
  }
}*/
/*import java.util.Scanner;
class First{
  public static void main(String[] args){
   Scanner scanner=new Scanner(System.in);
int a[]={31,24,33,12,3,2,4,5,6,33,0};
boolean found=false;
   System.out.println("Enter a number:");
   int num=scanner.nextInt();
   for(int i=0;i<a.length;i++){
found=true;
    if(a[i]==num)
     System.out.print("present at index="+i);
   }
if(found==false)
System.out.println("not present in array");
  }
}*/
/*import java.util.Scanner;
class First{
  public static void main(String[] args){
   Scanner scanner=new Scanner(System.in);
   int a[]=new int[10];
   //int a[]={12,22,23,32,33,67,76,444,78,78,12,5};
   for(int i=0;i<a.length;i++){
    System.out.println("Enter a number:");
    a[i]=scanner.nextInt();
   }
   int max=a[0],max2=a[0];
   for(int i=0;i<a.length;i++){
     if(a[i]>max)
      max=a[i];
   }
for(int i=0;i<a.length;i++){
     if(a[i]==max){
      a[i]=-1;
      break;
     }
   }
 for(int i=0;i<a.length;i++){
     if(a[i]>max2)
      max2=a[i];
   }
System.out.print("second largest="+max2);
}
}*/
/*import java.util.Scanner;
class First{
  public static void main(String[] args){
   int a[]={12,22,23,32,33,67,76,444,78,78,12,5};
  int count=0;
 for(int i=0;i<a.length;i++){
  count=0;
  for(int j=1;j<a[i];j++){
     if(a[i]%j==0)
      count++;
   }
   if(count<=2)
    System.out.print("prime numbers="+a[i]+" ");
  
 }
}
}*/
/*import java.util.Scanner;
class First{
  public static void main(String[] args){
  Scanner scanner=new Scanner(System.in);
   int a[]=new int[10];
   for(int i=0;i<a.length;i++){
    System.out.println("Enter number"+(i+1)+":");
    a[i]=scanner.nextInt();
   }
System.out.println("Enter number you want to delete:");
  int num=scanner.nextInt(); int index=-1;
 for(int i=0;i<a.length;i++){
     if(a[i]==num){
      index=i;
      break;
     }
 }
//int[] a2=new int[a.length-1];
//for(int j=0;j<index;j++)
//a2[j]=a[j];
 for(int i=index;i<a.length-1;i++)
  a[i]=a[i+1];
 a[a.length-1]=-1;

 System.out.println("printing new array");
 for(int i=0;i<a.length;i++)
    System.out.print(a[i]+" ");
}
}*/
import java.util.Arrays;

public class First {
    public static void main(String[] args) {
        int a[] = {12, 22, 23, 32, 33, 67, 4, 3, 76, 444, 78, 78, 12, 5};

        // Sort the array to bring duplicate elements together
        Arrays.sort(a);

        int newSize = 1;

        for (int i = 1; i < a.length; i++) {
            // Check if the current element is different from the previous one
            if (a[i] != a[i - 1]) {
                a[newSize] = a[i];
                newSize++;
            }
        }

        // Set the remaining elements to -1 to mark them as removed
        for (int i = newSize; i < a.length; i++) {
            a[i] = -1;
        }

        // Print the modified array with duplicates removed
        for (int k = 0; k < a.length; k++) {
            if (a[k] != -1) {
                System.out.println(a[k]);
            }
        }
    }
}

/*import java.util.Arrays;

public class First {
    public static void main(String[] args) {
        int a[] = {12,32, 32, 33, 33, 76, 76, 78, 78, 12, 5};
        Arrays.sort(a);

        int unique = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != a[i + 1]) {
                unique = a[i];
                break;
            }
        }
        System.out.println("unique element in array= " + unique);
    }
}*/