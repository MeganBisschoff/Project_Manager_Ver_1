# Project Manager

A Java program that tracks various projects and project members.

## Description

This program is for a fictitious structural engineering firm, called Poised, that allows them to capture project information, edit the deadlinie, finalise a project, view an exisitng projects details, search for a project and update the details of a project contractor.

At startup, the staff member is presented with the Poised program menu. In order to use the functions of the program, the project, customer, architect and contractors details must first be inputted and captured.

The program includes the following classes:

* Poised (the parent class with the main method)
* Project
* Person

From the menu, in the main class, the staff member is able to:

* Capture the project, customer, architect and contractors details
* Edit the projects due date
* Finalise a project
* View all incomplete projects
* View all overdue projects
* Search for a project
* Edit a projects fee
* Update the contractors details
* Exit the program

Each menu option calls the corresponding class method for action. A new project (object) is captured in the Main class. A project also captures a customer, architect and contractor (object) by calling the Person class. When a project is captured or edited the details are added to the internal database, which is then written to a CSV file when the project is finalised. When a project is finalised, the completion date is added and an invoice is generated if there is an oustandinf fee on the project.

The main Poised class includes the functions:

* editDeadline()
* finaliseProject()
* incompleteProjects()
* overdueProjects()
* searchProject()
* editFee()
* editContractor()
* exitProgram()

The Project class includes the attributes, along with getters and setters for:

* number
* name
* buildingType
* physAddr
* erfNum
* totalFee
* totalPaid
* deadline
* finalise
* completion
* customer
* architect
* contractor

The Person class includes the attributes, along with getters and setters for:

* name
* telNum
* emailAddr
* physAddr

The Project and Person classes both have a final string method.

## Functionality summary

* Capture information about new projects.
* Edit the projects deadline.
* Finalise existing projects.
* See a list of projects that still need to be completed.
* See a list of projects that are past the due date.
* Find and select a project by entering either the project number or project name.
* Change the total fee of the project.
* Update the contractors contact details

## Programming principles

This program employs the programming concepts of Java OOP including classes, get and set methods, dot notation and functions. Furthermore it employs fundamental programming techniques that include external databases, lists, comparison operators, conditional logic, loops, indexing, date formatting and string handling. Lastly, it also employs the built in method compareTo().

## Dependencies

* import java.util.ArrayList;
* import java.util.Locale;
* import java.util.Scanner;
* import java.util.Date;
* import java.text.SimpleDateFormat;
* import java.text.ParseException;
* import java.io.FileWriter;
* import java.io.IOException;

## Running the program

Run the inventory.py file in any Java IDE.

## Code preview

```java
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
```

## Program preview

```
--- Project Search ---

Enter 1 to search by project name
Enter 2 to search by project number
Enter selection: 2

Enter the project number: 5205

--- Project ---
Project Number: 5205
Project Name: Glass House
Building Type: House
Physical address: 00 Lane, Cape Town
ERF Number: 1048
Total fee.: 2000000.0
Total paid: 900000.0
Deadline: Sat Jan 01 00:00:00 SAST 2022
Finalised: No
Completed date: 

--- Customer ---
Name: Megan Bisschoff
Telephone number: 0820000000
Email address: megan.bisschoff@gmail.com
Physical address: 00 Avenue, Cape Town

--- Architect ---
Name: Misses Architect
Telephone number: 0720000000
Email address: architect@gmail.com
Physical address: 00 Avenue, Johannesburg

--- Contractor ---
Name: Mister Contractor
Telephone number: 0620000000
Email address: contractor@gmail.com
Physical address: 00 Street, Durban
```

## Class diagram

![ClassDiagram](ClassDiagram.jpg)

&nbsp;
***
A project is complete when it starts working for you, rather than you working for it. \~ Scott Allen
***
&nbsp;

## Author

Megan Bisschoff

Project submitted for Software Engineering learnership Level 2 Task 07 at [HyperionDev](https://www.hyperiondev.com/)

[View](https://www.hyperiondev.com/portfolio/86596/) submission results and code review.
