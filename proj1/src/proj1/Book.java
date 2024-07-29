package proj1;

public class Book {
	private String author;
	private String title;
	private int id;
	private static int iden=0;
	public Book(){
		author=title="unknown";
		id=0;
	}
	public Book(String title) {
		this.title=title;
		iden++;
	}
	public Book(Book b) {
		this.title=b.title;
		this.author=b.author;
		this.id=b.id;
	}
	public Book(String title,String author) {
		this.author=author;
		this.title=title;
		id=iden;
		iden++;
	}
	public void setAuthor(String a) {
		this.author=a;
	}
	public String toString() {
		return "Book no:"+id+"entitled-"+title+"written by"+author;
	}
}
