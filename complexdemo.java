import java.util.Scanner;
 class complexdemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a complex number (e.g., 3+4i or 5-2i): ");
        String input = scanner.nextLine();

        complex c1 = new complex(input);

        System.out.println("Complex Number 1: ");
        c1.display();
	System.out.println("Enter a complex number (e.g., 3+4i or 5-2i): ");
        String input2 = scanner.nextLine();

        complex c2 = new complex(input2);

        System.out.println("Complex Number 2: ");
        c2.display();

        complex c3 = new complex(c1); 
        System.out.println("Complex Number 2 (copy of Complex Number 1): ");
        c3.display();
        System.out.println("multiplication: ");
	c1.multiply(c2);
	System.out.println("addition: ");
	c1.add(c2);
	System.out.println("subtraction: ");
	c1.subtract(c2);
System.out.println("using getter and setters");
c1.setreal(12);
System.out.println(""+c1.getreal());
    }
}