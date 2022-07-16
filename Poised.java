/* Program for Poised structural engineering firm that's
used to record and update project details together with 
the customer, architect and contractors details */

// Import utilities.
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat; 
import java.text.ParseException;
import java.io.FileWriter;
import java.io.IOException;


// Main program for Poised
public class Poised {

	public static void main(String[] args) throws ParseException, IOException {
		
		// Create database to store and access project details.
		ArrayList <Project> projList = new ArrayList <Project> (); 
		
		// Open scanner to read user input.
		Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH) ;
		
		// Use while loop to display menu options.
		int progMenu = 0;
		while (progMenu != 9) {
		
			// Menu selection for program
			System.out.println("\n--- Poised Program ---\n" +
				"\nEnter 1 to capture the project, customer, architect and contractors details" +
				"\nEnter 2 to edit the projects due date" + 					
				"\nEnter 3 to finalise a project" + 						
				"\nEnter 4 to view all incomplete projects" +
				"\nEnter 5 to view all overdue projects" +
				"\nEnter 6 to search for a project" +
				"\nEnter 7 to edit a projects fee" + 						
				"\nEnter 8 to update the contractors details of a project" + 
				"\nEnter 9 to exit the program" +
				"\nEnter selection: ");
			progMenu = input.nextInt();
			input.nextLine();
		
			// --- Capture Customer, Architect, Contractor and Project attributes ---
			if (progMenu == 1) {
				captureDetails(projList, input);
			}
			// --- Edit project deadline --- 
			if (progMenu == 2) {
				editDeadline(projList, input);
			}
			// --- Finalise project --- 
			if (progMenu == 3) {
				finaliseProject(projList, input);
			}
			// --- View Incomplete ProjectS --- 
			if (progMenu == 4) {
				incompleteProjects(projList);
			}
			// --- View Overdue Projects --- 
			if (progMenu == 5) {
				overdueProjects(projList);
			}	
			// --- Search For Project --- 
			if (progMenu == 6) {
				searchProject(projList, input);
			}
			// --- Edit Project Fee --- 
			if (progMenu == 7) {
				editFee(projList, input);
			}
			// --- Update Contractors Details --- 
			if (progMenu == 8) {
				editContractor(projList, input);
			}
			// --- Exit Program --- 
			if (progMenu == 9) {
				exitProgram(input); 
			}
		}
	}

	// Methods to run program menu selection.
	
	private static void captureDetails(ArrayList<Project> projList, Scanner input) throws ParseException {
		// Get user inputs for CUSTOMER.
			System.out.println("Enter customers full name: ");
				String custName = input.nextLine();
			System.out.println("Enter customers telephone number: ");
				String custTelNum = input.nextLine();
			System.out.println("Enter customers email address: "); 
				String custEmailAddr = input.nextLine();
			System.out.println("Enter customers physical address: ");
				String custPhysAddr = input.nextLine();
				
			// Get user inputs for ARCHITECT.	
			System.out.println("Enter architects full name: ");
				String archiName = input.nextLine();
			System.out.println("Enter architects telephone number: ");
				String archiTelNum = input.nextLine();
			System.out.println("Enter architects email address: ");
				String archiEmailAddr = input.nextLine();
			System.out.println("Enter architects physical address: ");
				String archiPhysAddr = input.nextLine();
		
			// Get user inputs for CONTRACTOR.
			System.out.println("Enter contractors full name: ");
				String contrName = input.nextLine();
			System.out.println("Enter contractors telephone number: ");
				String contrTelNum = input.nextLine();
			System.out.println("Enter contractors email address: ");
				String contrEmailAddr = input.nextLine();
			System.out.println("Enter contractors physical address: ");
				String contrPhysAddr = input.nextLine();	
		
			// Get user inputs for PROJECT.
			System.out.println("Enter the project number: ");
				int projNumber = input.nextInt();
				input.nextLine();
				System.out.println("Enter the building type: ");
				String projBuildingType = input.nextLine();
			System.out.println("Enter the projects name: ");				
				String projName = input.nextLine() ;
					if (projName.equals("")) {
						projName = projBuildingType + " " + (custName.split(" ")[1]); }
			System.out.println("Enter projects physical address: ");
				String projPhysAddr = input.nextLine();
			System.out.println("Enter projects ERF number: ");
				int projErfNum = input.nextInt();
				input.nextLine();
			System.out.println("Enter projects total fee: R");
				float projTotalFee = input.nextFloat();
				input.nextLine();
			System.out.println("Enter projects total paid: R");
				float projTotalPaid = input.nextFloat();
				input.nextLine();
			System.out.println("Enter projects deadline as day(01), month(12), year(2020): ");
				int dd = input.nextInt();
				int MM = input.nextInt();
				int yyyy = input.nextInt();
				String ddMMyyyy = dd + "/" + MM + "/" + yyyy;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date projDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyy); 
				input.nextLine();	
			String projFinalise = "No";
			String projCompletion = "";
			
			// Pass attributes to class and create new Person and Project objects.
			Person customer = new Person (custName, custTelNum, custEmailAddr, custPhysAddr);
			Person architect = new Person (archiName, archiTelNum, archiEmailAddr, archiPhysAddr);	
			Person contractor = new Person (contrName, contrTelNum, contrEmailAddr, contrPhysAddr);	
			Project project = new Project (projNumber, projName, projBuildingType, projPhysAddr, projErfNum, projTotalFee, 
					projTotalPaid, projDeadline, projFinalise, projCompletion, customer, architect, contractor);
			
			// Print to view on console.
			System.out.println(project);
			
			// Add() Project objects to array list 'projlist'.
			projList.add(new Project (projNumber, projName, projBuildingType, projPhysAddr, projErfNum, projTotalFee, 
					projTotalPaid, projDeadline, projFinalise, projCompletion, customer, architect, contractor));
	}

	private static void editDeadline(ArrayList<Project> projList, Scanner input) throws ParseException {
		
		// User input to get projNumber of project to be edited.
		System.out.println("\n--- Edit Deadline ---\n" +
				"\nEnter the project number to edit the deadline: ");
		int editProjDate = input.nextInt();
		input.nextLine();
		
		// User inputs for new deadline date
		System.out.println("Enter the new project deadline, as day(01), month(12), year(2020): ");
		int ddNew = input.nextInt();
		int MMNew = input.nextInt();
		int yyyyNew = input.nextInt();
		String ddMMyyyyNew = ddNew + "/" + MMNew + "/" + yyyyNew;
		
		// Format string deadline to date format.
		Date newProjDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyyNew); 
		
		// Loop through projList to get project then set() new deadline.
		for (int i = 0; i < projList.size(); i++) {
			if (projList.get(i).getNumber()==(editProjDate)) { 
				projList.get(i).setDeadline(newProjDeadline);
				System.out.println("\nDeadline of project " + editProjDate + " successfully updated.\n" 
						+ projList.get(i));					
			}
		}
	}
	
	private static void finaliseProject(ArrayList<Project> projList, Scanner input) throws ParseException, IOException {
		
		// User input to get projNumber of project to be finalised.
		System.out.println("\n--- Finalise Project ---\n" +
				"\nEnter the project number to finalise: ");
		int finaliseProject = input.nextInt();
		input.nextLine();
		
		// Loop through projList to get project then update as finalised and set new completion date.
		for (int i = 0; i < projList.size(); i++) {
			if (projList.get(i).getNumber() == (finaliseProject)) { 
								
				// Set() 'finalise' status to 'yes'.
				projList.get(i).setFinalise("Yes");
				System.out.println("Project " + finaliseProject + " finalisation status updated.");
				
				// User inputs for completion date.
				System.out.println("\n--- Project completion Date ---\n" +
						"\nEnter the projects completion date as day(01), month(12), year(2020): ");
				int ddFinal = input.nextInt();
				int MMFinal = input.nextInt();
				int yyyyFinal = input.nextInt();
				String ddMMyyyyFinal = ddFinal + "/" + MMFinal + "/" + yyyyFinal;
				
				// Format string deadline to date format, then convert back to string.
				Date formatDate = new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyyFinal);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");	
				String newProjCompletion = formatter.format(formatDate);  
				input.nextLine();
				
				// Set() 'completion' to new completion date.
				projList.get(i).setCompletion(newProjCompletion);
				System.out.println("Project " + finaliseProject + " completion date updated.");
				
				// Generate invoice for project with customer details and outstanding project fee.
				float outstandingFee = projList.get(i).getTotalFee() - projList.get(i).getTotalPaid() ;
				if (outstandingFee > 0) {
					System.out.println("\n--- INVOICE ---" 
						+ "\n\n--- Customer ---\n" 
							+ projList.get(i).getCustomer()
						+ "\n\n--- Project Fee ---" 
							+ "\nTotal fee: \t" + projList.get(i).getTotalFee()
							+ "\nTotal paid: \t" + projList.get(i).getTotalPaid()
							+ "\nOutstanding balance: \tR" + outstandingFee );
				}
				
				// Write completed project details to 'completedtasks' text file.
				FileWriter writer = new FileWriter("completedtasks.txt");
				try {
					for (Project str : projList) {
						writer.write (str + System.lineSeparator());
					} writer.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				System.out.println("\nPoised project " + finaliseProject + " completed "
						+ "and succussfully added to file.");
			}		      
		}
	}

	private static void incompleteProjects(ArrayList<Project> projList) {
		
		// Loop through projList to get projects that are not finalised. 
		for (int i = 0; i < projList.size(); i++) {
			if (projList.get(i).getFinalise().equals("No")) { 
				System.out.println("\nIncomplete Poised project/s: \n" + projList.get(i));	
			}
		}
	}
	
	private static void overdueProjects(ArrayList<Project> projList) throws ParseException {
		
		// Get todays date using Date method.
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = formatter.parse(formatter.format(new Date()));
	
		// Loop through projList to compare project deadline with todays date.
		for (int i = 0; i < projList.size() ; i++) {
			
			// If deadline occurs after currentDate,
			// notify that projects are on schedule.
			if (projList.get(i).getDeadline().compareTo(currentDate) > 0) { 
				System.out.println("\nAll Poised projects are on schedule.");	
			}
			// Else if deadline occurs before currentDate,
			// display projects that are behind schedule.
			else if (projList.get(i).getDeadline().compareTo(currentDate) < 0) { 
				System.out.println("\nPoised projects past deadline:\n"
					+ projList.get(i));
			} 
		}
	}
	
	private static void searchProject(ArrayList<Project> projList, Scanner input) {
		
		// User input for project search options.
		System.out.println("\n--- Project Search ---\n" +
				"\nEnter 1 to search by project name" +
				"\nEnter 2 to search by project number" +
				"\nEnter selection: ");
		int searchOption = input.nextInt();
		input.nextLine();

		if (searchOption == 1) {
			// User input to search project by name.
			System.out.println("\nEnter the project name: ");
			String searchName = input.nextLine();
			
			// Loop through projList with getName() to view requested project.
			for (int i = 0; i < projList.size(); i++) {
				if (projList.get(i).getName().equals(searchName)) { 
					System.out.println(projList.get(i)); 
				} 
			}
		}
		if (searchOption == 2) {
			// User input to search project by number.
			System.out.println("\nEnter the project number: ");
			int searchNum = input.nextInt();
			
			// Loop through projList with getNumber() to view requested project.
			for (int i = 0; i < projList.size(); i++) {
				if (projList.get(i).getNumber()==(searchNum)) {
					System.out.println(projList.get(i)); 
				}
			}
		}
	}
	
	private static void editFee(ArrayList<Project> projList, Scanner input) {
		
		// User input to get projNumber of project fee to be change.
		System.out.println("\n--- Update Project Fee ---\n" +
				"\nEnter the project number to change the fee of: ");
		int changeProjFee = input.nextInt();
		
		// User input of new project fee.
		System.out.println("\nEnter the new project fee: ");
		int newFee = input.nextInt();
		input.nextLine();
		
		// Loop through projList to get project then set() new 'totalFee'. 
		for (int i = 0; i < projList.size(); i++) {
			if (projList.get(i).getNumber() == (changeProjFee)) { 
				projList.get(i).setTotalFee(newFee);
			}
		}
		System.out.println("\nFee successfully updated for project " + changeProjFee);
	}

	private static void editContractor(ArrayList<Project> projList, Scanner input) {
		
		// User input to get the name of the contractor to update the details of.
		System.out.println("\n--- Update Contractors Details ---\n" +
				"\nEnter the contractors name to update: ");
		String updateContractor = input.nextLine();
		
		// User input for contractors new 'TelNum', 'EmailAddr' and 'PhysAddr'.
		System.out.println("Enter contractors telephone number: ");
		String newContrTelNum = input.nextLine();
		System.out.println("Enter contractors email address: ");
		String newContrEmailAddr = input.nextLine();
		System.out.println("Enter contractors physical address: ");
		String newContrPhysAddr = input.nextLine();	
		
		// Loop through projList to get contractor then set() new contact details. 
		for (int i = 0; i < projList.size(); i++) {
			if (projList.get(i).getContractor().getName().equals(updateContractor)) { 
				projList.get(i).getContractor().setTelNum(newContrTelNum);
				projList.get(i).getContractor().setEmailAddr(newContrEmailAddr);
				projList.get(i).getContractor().setPhysAddr(newContrPhysAddr);
			}
		}
		System.out.println("\nContact details successfully updated for " + updateContractor);
	}

	private static void exitProgram(Scanner input) {
		
		System.exit(0);
		System.out.println("Poised program closed.");
		
		//Close scanner input.
		input.close() ;
	}

}
