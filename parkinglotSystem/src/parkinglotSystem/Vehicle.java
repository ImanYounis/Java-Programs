package parkinglotSystem;

public class Vehicle {
	private String RegNo;
	private String OwnerName;
	private String vtype;
	private String model;
	private String color;
	private String edate;
	private String etime;
	parkingLot p;
	
	Vehicle(){
		
	}
	Vehicle(String r, String o, String type,String model,String color,String edate,String etime){
		this.RegNo=r;
		this.OwnerName=o;
		this.vtype=type;
		this.model=model;
		this.color=color;
		this.edate=edate;
		this.etime=etime;
	}
	
	
//-----------------setters and getters--------------------------------------	
	public String getRegNo() {
		return RegNo;
	}
	public void setRegNo(String regNo) {
		RegNo = regNo;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEntryDate() {
		return edate;
	}
	public void setEntryDate(String entryDate) {
		this.edate = entryDate;
	}
	public String getEntryTime() {
		return etime;
	}
	public void setEntryTime(String entryTime) {
		this.etime = entryTime;
	}

}
