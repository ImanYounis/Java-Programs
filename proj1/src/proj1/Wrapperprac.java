package proj1;

//public class Wrapperprac {
//	public void f1(int i){
//		i=20;
//	}
//	public void f2(Integer I) {
//		I=20;
//	}
//	public static void main(String[] args) {
//		int a=10;
//		Integer i=a;
//		//int b;
//		Wrapperprac w=new Wrapperprac();
//		System.out.println("initial value of 'a':" +a);
//		System.out.println("new value of 'a' with no wrapper:"+a);
//		w.f1(a);
//		w.f2(a);
//
//		System.out.println("value returned from f1:"+a);
//		System.out.println("new value of 'a' with wrapper:"+i);
//		w.f2(i);//auto boxing happening over here
//
//		System.out.println("value returned from f2:"+i);
//	}
//
//}
public class Wrapperprac {
    public void f2(Integer[] arr) {
        arr[0] += 10; 
    }
	public void f1(int i){
		i=20;
	}
    public static void main(String[] args) {
        Integer[] arr = { 10 };
        int a=arr[0];
        Wrapperprac w = new Wrapperprac();
        System.out.println("value of 'a' before calling f1:"+a);
        w.f1(a);
        System.out.println("value of 'a' after calling f1:"+a);
        System.out.println("Initial value: " + arr[0]);
        w.f2(arr);
        System.out.println("Value after f2: " + arr[0]); 
    }
}

