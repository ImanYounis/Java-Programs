package Q2Authorclass;

public class TestBook {

	public static void main(String[] args) {
		Author anAuthor = new Author("my author","ytr@gmail.com",'f');
		Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
		// Use an anonymous instance of Author
		Book anotherBook = new Book("more Java for dummy", new Author("dummy author","dummy@gmail.com",'m'), 29.95, 888);
		aBook.setPrice(24);
		System.out.println(aBook.getPrice());
		System.out.println(aBook.getAuthor());
		System.out.println(aBook);
		System.out.println(anotherBook.getAuthorName());
		System.out.println(anotherBook);

	}

}
