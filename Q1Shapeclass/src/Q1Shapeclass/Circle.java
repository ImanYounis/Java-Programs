package Q1Shapeclass;

public class Circle extends Shape {

	double radius;
	public Circle() {
		radius=1.0;
	}
	public Circle(double radius) {
		super();
		this.radius=radius;
	}
	public Circle(double radius,String color,boolean filled) {
		super(color,filled);
		this.radius=radius;
		
	}
	public void setRadius(double radius) {
		this.radius=radius;
	}
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		return Math.PI*radius*radius;
	}
	public double getPerimeter(){
		return Math.PI*2*radius;
	}
	public String toString() {
		return "A Circle with radius= "+radius+" , which is a subclass of "+super.toString();
	}
}
