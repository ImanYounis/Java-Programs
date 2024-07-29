package parkinglotSystem;

public class parkingLot {

	private int pNo;
	private int status;
	private String fNo;
	private String ptype;
	
	public parkingLot() {
		setpNo(1);
		setStatus('f');
		setfNo("A1");
		setPtype("car");
	}
	public parkingLot(int pNo, String fNo, String type) {
		this.setfNo(fNo);
		this.setPtype(type);
		this.setpNo(pNo);
		this.setStatus(0);
		
	}
	public String toString() {
		return "Parking Slot No: "+pNo+" on floor "+fNo+" for vehicle type="+ptype;
	}
	
//-----------------setters and getters--------------------------------------
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

}
