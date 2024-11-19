
public class Person {
	/*
	 * Fields for the Person class
	 */
	String name;
    int seniority;
    int salary;
    Department department;

    /*
     * Constructor with Parameters
     */
    public Person(String name, int seniority) {
        this.name = name;
        this.seniority = seniority;
        this.salary = 0;
        this.department = null;
    }

    /*
     * Empty Constructor
     */
    public Person() {
		name = "";
		seniority = 0;
		salary = 0;
		department = null;
	}

    
    /*
     * Calculates the salary and if the department exists and they get $5000 for having a lower seniority
     */
	public void calculateSalary() {
        if (department != null) {
            this.salary = 40000 + (5000 * department.getLowerSeniorityCount(this));
        }
    }
	
}
