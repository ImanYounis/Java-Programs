package Q2Authorclass;

public class Book {
	private Author author;
	private String name;
	private int qtyInStock;
	private double price;
	public Book(String name,Author author,double price){
		this.name=name;
		this.author=author;
		this.price=price;
	}
	public Book(String name,Author author,double price,int qtyInStock){
		this.name=name;
		this.author=author;
		this.price=price;
		this.qtyInStock=qtyInStock;
	}
	public Author getAuthor() {
		return author;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQtyInStock() {
		return qtyInStock;
	}
	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock=qtyInStock;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public String toString() {
		return name+" by "+author.toString();
	}
	public String getAuthorName() {
		return author.getName();
	}
	public String getAuthorEmail() {
		return author.getEmail();
	}
	public char getAuthorGender() {
		return author.getGender();
	}
}
