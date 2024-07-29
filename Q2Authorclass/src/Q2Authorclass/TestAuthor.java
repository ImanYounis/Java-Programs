package Q2Authorclass;

public class TestAuthor {

	public static void main(String[] args) {
		Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
		System.out.println(anAuthor);  
		anAuthor.setEmail("paul@nowhere.com");
		System.out.println(anAuthor);
		Author a=new Author("me","me@gmail.com",'f');
		a.setEmail("mine@gmail.com");
		System.out.println(a.getEmail());
		System.out.println(a.getGender());
		System.out.println(a.getName());

	}

}
