package cakeQuiz;

public class Cake {
	private String title;
	private int price;
	private int qty;
	private String size;
	private String flavor;
	private String cakeID;
	private String category;
	Cake(){
		
	}
	Cake(String cid,String t,int p,int q,String f,String s,String c){
		this.cakeID=cid;
		this.title=t;
		this.price=p;
		this.qty=q;
		this.flavor=f;
		this.size=s;
		this.category=c;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCakeID() {
		return cakeID;
	}
	public void setCakeID(String cakeID) {
		this.cakeID = cakeID;
	}

}
