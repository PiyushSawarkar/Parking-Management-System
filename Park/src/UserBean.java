import java.io.Serializable;

public class UserBean implements Serializable {
	
	
	
	private String FirstName;
	private String LastName;
	private String VehicleNumberV;
	private String VehicleTypeV;
	
	private String eMail;
	private String MobileNumber;
	private String EntryTime;
	//String ExitTime;
	private String EntryDate;
	//String ExitDate;
	private String EntryTimeMSV;
	//String ExitTimeMSV;
	//String RandomNumber ;
	private int slot;
	
	
	
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getVehicleNumberV() {
		return VehicleNumberV;
	}
	public void setVehicleNumberV(String vehicleNumberV) {
		VehicleNumberV = vehicleNumberV;
	}
	public String getVehicleTypeV() {
		return VehicleTypeV;
	}
	public void setVehicleTypeV(String vehicleTypeV) {
		VehicleTypeV = vehicleTypeV;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getEntryTime() {
		return EntryTime;
	}
	public void setEntryTime(String entryTime) {
		EntryTime = entryTime;
	}
	
	public String getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(String entryDate) {
		EntryDate = entryDate;
	}

	public String getEntryTimeMSV() {
		return EntryTimeMSV;
	}
	public void setEntryTimeMSV(String entryTimeMSV) {
		EntryTimeMSV = entryTimeMSV;
	}
	
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	



}
