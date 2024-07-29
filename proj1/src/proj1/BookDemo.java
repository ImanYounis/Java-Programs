package proj1;

public class BookDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1=new Book("ABC","XYZ");
		System.out.println(b1);
		Book b2=new Book();
		System.out.println(b2);
		Book b3=new Book("name","author");
		System.out.println(b3);
		Book b4=new Book(b2);
		System.out.println(b4);
		Book b5=b3;
		System.out.println(b5);
		b5.setAuthor("lmn");
		System.out.println(b5);
		System.out.println(b3);

	}

}
