import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Job {
	
	/*
	 * Hashmap fields for the Job class
	 */
	 private Map<String, Person> people = new HashMap<>();
	 private Map<String, Department> departments = new HashMap<>();
	
	 /*
	  * Constructor with parameters
	  */
	public Job(Map<String, Person> people, Map<String, Department> departments) {
		this.people = people;
		this.departments = departments;
	}
	
	/*
	 * Empty Constructor
	 */
	public Job() {
		people = null;
		departments = null;
	}

	/*
	 * The addDepartment method checks to see if the department already exists if it doesn't it adds the department
	 */
	public void addDepartment(String name) {
        if (departments.containsKey(name)) {
            System.out.println("Department already exists.");
        } else {
            departments.put(name, new Department(name));
            System.out.println("Department " + name + " added.");
        }
    }
	
	/*
	 * The hirePerson method checks to see if the person is already hired. if not they are hired and with their seniority
	 */
	public void hirePerson(String name, int seniority) {
        if (people.containsKey(name)) {
            System.out.println("Person already exists.");
        } else {
            people.put(name, new Person(name, seniority));
            System.out.println("Hired " + name + " with seniority " + seniority + ".");
        }
    }
	
	/*
	 * JoinDepartment method checks if the person and the department exist or if they are already in a department. If not the person is added to the department
	 */
	public void joinDepartment(String personName, String departmentName) {
        Person person = people.get(personName);
        Department department = departments.get(departmentName);

        if (person == null) {
            System.out.println("Person not found.");
        } else if (department == null) {
            System.out.println("Department not found.");
        } else if (person.department != null) {
            System.out.println(personName + " is already in a department.");
        } else {
            department.Add(person);
            System.out.println(personName + " joined " + departmentName + ".");
        }
    }
	
	/*
	 * QuitDepartment method checks if the person or the department exists. If they do the person is removed from the department
	 */
	 public void quitDepartment(String personName) {
	        Person person = people.get(personName);

	        if (person == null || person.department == null) {
	            System.out.println("Person is not in any department.");
	        } else {
	            Department department = person.department;
	            department.Quit(person);
	            System.out.println(personName + " quit " + department.name + ".");
	        }
	    }
	 
	 
	 /*
	  * The changeDepartment method checks if the person or department exist. If they do the person is removed from the department they are in and they are added to another one
	  */
	 public void changeDepartment(String personName, String newDepartmentName) {
		   
		    Person p = people.get(personName);
		    Department newDepartment = departments.get(newDepartmentName);

		    if (p == null) {
		        System.out.println("Person not found.");
		    } else if (newDepartment == null) {
		        System.out.println("Department not found.");
		    } else {
		        
		        if (p.department != null) {
		            p.department.Quit(p);
		        }
		        newDepartment.Add(p);
		        System.out.println(personName + " has been moved to " + newDepartmentName + ".");
		    }
	 }
	
	 
	 /*
	  * The displayPayroll method displays the payroll of the department
	  */
	 public void displayPayroll() {
	        for (Department department : departments.values()) {
	            department.displayExecutives();
	        }
	    }
	 
	 /*
	  * DisplayPersonSalary method displays the persons salary in the department
	  */
	 public void displayPersonSalary(String personName) {
	        Person person = people.get(personName);

	        if (person == null) {
	            System.out.println("Person not found.");
	        } else if (person.department == null) {
	            System.out.println(personName + " is not in any department.");
	        } else {
	            person.calculateSalary();
	            System.out.println(personName + "'s salary: " + person.salary);
	        }
	    }
	 
	 
	 

	

}
