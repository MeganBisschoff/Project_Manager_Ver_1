// Main class to create a Person.
public class Person {

	// Attributes for Person.
	private String name;
	private String telNum;
	private String emailAddr;
	private String physAddr;
	
	// Constructor to initialise Person attributes.
	public Person ( String name, String telNum, String emailAddr, String physAddr ) {
		
		this.name = name;
		this.telNum = telNum;
		this.emailAddr = emailAddr;
		this.physAddr = physAddr;
	}
	
	// ----- Set Methods ----- //
	
	// Method to set name.
	public void setName (String newName) {
		name = newName;
	}
	// Method to set telephone number.
	public void setTelNum (String newTelNum) {
		telNum = newTelNum;
	}
	// Method to set email address.
	public void setEmailAddr (String newEmailAddr) {
		emailAddr = newEmailAddr;
	}
	// Method to set physical address.
	public void setPhysAddr (String newPhysAddr) {
		physAddr = newPhysAddr;
	}
	
	// ----- Get Methods ----- //
	
	// Method to get name.
	public String getName () {
		return name;
	}
	// Method to get telephone number.
	public String getTelNum () {
		return telNum;
	}
	// Method to get email address.
	public String getEmailAddr () {
		return emailAddr;
	}
	// Method to get physical address.
	public String getPhysAddr () {
		return physAddr;
	}
	
	// ----- String Method ----- //
	
	// Method to print out instances as string.
	public String toString() {
		String output = "Name: " + name;
		output += "\nTelephone number: " + telNum;
		output += "\nEmail address: " + emailAddr;
		output += "\nPhysical address: " + physAddr;
		return output;
	}
	
} 
