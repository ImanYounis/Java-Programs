package Q1Shapeclass;
public class TestShape {
	public static void main(String[] args) {
		Shape s=new Shape();
		Shape s1=new Shape("orange",false);
		//testing toString()
		System.out.println(s);
		System.out.println(s1);
		//testing getter and setter
		System.out.println(s.getColor());
		System.out.println(s1.isFilled());
		s.setFilled(false);
		System.out.println(s);
		s1.setColor("maroon");
		System.out.println(s1);
		//testing subclasses
		Rectangle r1=new Rectangle();
		r1.setColor("yellow");
		r1.setLength(20);
		System.out.println(r1.getArea());
		Circle c1=new Circle(25);
		c1.setFilled(false);
		System.out.println(c1);
		System.out.println(c1.getColor());
		System.out.println(c1.getPerimeter());
		Square sq1=new Square(30);
		sq1.setLength(40);
		sq1.setColor("pink");
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getPerimeter());
	}
}
