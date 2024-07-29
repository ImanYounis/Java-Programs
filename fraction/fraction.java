import java.util.Scanner;
class fraction
{
int num;
int denom;
fraction(){}
/*fraction(){
num=1;
denom=1;
}*/
int getdenom(){
return denom;
}
void setdenom(int d){
denom=d;
}
int getnum(){
return num;
}
void setnum(int n){
num=n;
}
//copy constructor
fraction(fraction f1){
this.num=f1.num;
this.denom=f1.denom;
}
fraction(String str){
String[] frac=str.split("/");
this.num=Integer.parseInt(frac[0]);
this.denom=Integer.parseInt(frac[1]);
}
fraction(int num,int denom){
this.num=num;
this.denom=denom;
}
void reducedfraction(){
int min=0;
if(num<denom)min=num;
else min=denom;
  for (int i=min;i>=2;i--){
   if(num%i==0&&denom%i==0){
 // System.out.println()
    num=num/i;
    denom=denom/i;
   }
  }
}

fraction add(fraction f1){
  fraction res=new fraction();
  res.denom=denom*f1.denom;
  res.num=num*f1.denom+f1.num*denom;
   res.reducedfraction();
 System.out.println(res.num+"/"+res.denom);
  return res;
}

fraction mul(fraction f1){
 fraction res=new fraction();
 res.num=f1.num*num;
 res.denom=f1.denom*denom;
   res.reducedfraction();
 return res;
}
fraction divide(fraction f1){
 fraction res=new fraction();
 int temp;
 temp=f1.num;
 f1.num=f1.denom;
 f1.denom=temp;
 res=mul(f1);
 res.reducedfraction();
 return res;
}
fraction subtract(fraction f1){
 fraction res=new fraction();
  res.denom=denom*f1.denom;
  res.num=num*f1.denom-f1.num*denom;
  res.reducedfraction();
  return res;
}
void showfrac(){
 System.out.println("numerator="+num);
 System.out.println("denominator="+denom);
}
}
