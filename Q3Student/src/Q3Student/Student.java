package Q3Student;
public class Student {

    private String regNo;
    private String name;
    private String address;
    private String dept;

    public Student(String regNo, String name, String address, String dept) {
        this.regNo = regNo;
        this.name = name;
        this.address = address;
        this.dept = dept;
    }
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public String getRegNo() {
		return regNo;
	}
    public String toString() {
        return "Reg No: " + regNo + "\nName: " + name + "\nAddress: " + address + "\nDept: " + dept;
    }
}
