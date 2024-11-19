import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		
		 Person p = new Person();
		 Job j = new Job();
		 Scanner sc = new Scanner(System.in);
		
		    while (true) {
		        System.out.print("What do you want to do or find?: ");
		        String command = sc.nextLine();
		        String[] parts = command.split(" ");

		        if (parts[0].equals("add")) {
		        	if (parts.length > 1) {
	                    j.addDepartment(parts[1]);
	                } else {
	                    System.out.println("You can't add this department");
	                }
		        } else if (parts[0].equals("hire")) {
		        	 if (parts.length > 1) {
		                    j.hirePerson(parts[1], p.seniority);
		                } else {
		                    System.out.println("You can't hire this person");
		                }
		        } else if (parts[0].equals("join")) {
		        	if (parts.length > 2) {
	                    j.joinDepartment(parts[1], parts[2]);
	                } else {
	                    System.out.println("This person can't join the department");
	                }
		        } else if (parts[0].equals("quit")) {
		        	if (parts.length > 1) {
	                    j.quitDepartment(parts[1]);
	                } else {
	                    System.out.println("The person you are looking for doesn't exist");
	                }
		        } else if (parts[0].equals("change")) {
		        	 if (parts.length > 2) {
		                    j.changeDepartment(parts[1], parts[2]);
		                } else {
		                    System.out.println("There arent departments to change");
		                }
		        } else if (parts[0].equals("payroll")) {
		            j.displayPayroll();
		        } else if (parts[0].equals("salary")) {
		        	if (parts.length > 1) {
	                    j.displayPersonSalary(parts[1]);
	                } else {
	                    System.out.println("This person's salary doesn't exist");
	                }
		        } else if (parts[0].equals("exit")) {
		            System.out.println("Exiting program.");
		            return;
		        } else {
		            System.out.println("Invalid input.");
		        }
		    }

	}

}
