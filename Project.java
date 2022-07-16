import java.util.Date;

// Main class to create a Project.
public class Project {

	// Attributes for Project.
	private int number;
	private String name;
	private String buildingType;
	private String physAddr;
	private int erfNum;
	private float totalFee;
	private float totalPaid;
	private Date deadline;
	private String finalise;
	private String completion;
	private Person customer;
	private Person architect;
	private Person contractor;
	
	// Constructor to initialise Project attributes.
	public Project ( int number, String name, String buildingType, String physAddr, int erfNum, 
			float totalFee, float totalPaid, Date deadline, String finalise, String completion, Person customer, Person architect, Person contractor) {
		
		this.number = number;
		this.name = name;
		this.buildingType = buildingType;
		this.physAddr = physAddr;
		this.erfNum  = erfNum;
		this.totalFee = totalFee;
		this.totalPaid = totalPaid;
		this.deadline = deadline;
		this.finalise = finalise;
		this.completion = completion;
		this.customer = customer;
		this.architect = architect;
		this.contractor = contractor;
	}
	
	// ----- Set Methods ----- //
	
	// Method to set number.
	public void setNumber (int newNumber) {
		number = newNumber;
	}
	// Method to set name.
	public void setName (String newName) {
		name = newName;
	}
	// Method to set building type.
	public void setBuiildingType (String newBuildingType) {
		buildingType = newBuildingType;
	}
	// Method to set physical address.
	public void setPhysAddr (String newPhysAddr) {
		physAddr = newPhysAddr;
	}
	// Method to set ERF number.
	public void setErfNum (int newErfNum) {
		erfNum = newErfNum;
		}
	// Method to set total fee.
	public void setTotalFee (float newTotalFee) {
		totalFee = newTotalFee;
	}
	// Method to set total paid.
	public void setTotalPaid (float newTotalPaid) {
		totalPaid = newTotalPaid;
	}
	// Method to set deadline.
	public void setDeadline (Date newDeadline) {
		deadline = newDeadline;
	}
	// Method to set project finalisation.
	public void setFinalise (String newFinalise) {		
		finalise = newFinalise;	
	}
	// Method to set project completion date.
	public void setCompletion (String newCompletion) {
		completion = newCompletion;
	}
	
	// ----- Get Methods ----- //
	
	// Method to get number.
	public int getNumber () {
		return number;
	}
	// Method to get name.
	public String getName () {
		return name;
	}
	// Method to get building type.
	public String getBuiildingType () {
		return buildingType;
	}
	// Method to get physical address.
	public String getPhysAddr () {
		return physAddr;
	}
	// Method to get ERF number.
	public int getErfNum () {
		return erfNum;
		}
	// Method to get total fee.
	public float getTotalFee () {
		return totalFee;
	}
	// Method to get total paid.
	public float getTotalPaid () {
		return totalPaid;
	}
	// Method to get deadline.
	public Date getDeadline () {
		return deadline;
	}
	// Method to get project finalisation.
	public String getFinalise () {
		return finalise;
	}
	// Method to get project completion date.
	public String getCompletion () {
		return completion;
	}
	// Method to get customer.
	public Person getCustomer () {
		return customer;
	}
	// Method to get architect.
	public Person getArchitect () {
		return architect;
	}
	// Method to get contractor.
	public Person getContractor() {
		return contractor;
	}
	
	// ----- String Method ----- //
	
	// Method to print out instances as string.
	public String toString() {
		String output = "--- Project ---";
		output += "\nProject Number: " + number;
		output += "\nProject Name: " + name;
		output += "\nBuilding Type: " + buildingType;
		output += "\nPhysical address: " + physAddr;
		output += "\nERF Number: " + erfNum;
		output += "\nTotal fee.: " + totalFee;
		output += "\nTotal paid: " + totalPaid;
		output += "\nDeadline: " + deadline;
		output += "\nFinalised: " + finalise;
		output += "\nCompleted date: " + completion;
		output += "\n\n--- Customer ---\n" + customer;
		output += "\n\n--- Architect ---\n" + architect;
		output += "\n\n--- Contractor ---\n" + contractor;

		return output;
	}
	
} 
