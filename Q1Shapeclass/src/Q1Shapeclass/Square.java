package Q1Shapeclass;

public class Square extends Rectangle {
	public String toString() {
		return "A Square with side= "+length+" ,which is a subclass of "+super.toString();
	}
	public Square(double side) {
	    super(side, side);
	}
	public void setWidth(double side) {
	    super.setWidth(side);
	    super.setLength(side);//calling both to keep square geometry
	}
	public void setLength(double side) {
	    super.setLength(side);
	    super.setWidth(side);
	}
	//no need to override getarea() and getperimeter() as formulas for the
	//2 shapes is same only the sides are equal in square
	//and when the length and width have been set to sane length then the 
	//area and perimeter calculated would be correct w.r.t square
}
