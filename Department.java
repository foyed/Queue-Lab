import java.util.Queue;

public class Department {
    String name;
    Queue<Person> executives;

    
    /*
     * Constructor with parameters
     */
	public Department(String name) {
		this.name = name;
		executives = null;
	}

	/*
	 * Empty constructor
	 */
	public Department() {
		name = "";
		executives = null;
	}

	
	/*
	 * Add method that adds an executive into the Queue
	 */
	public void Add(Person executive) {
        executives.add(executive);
    }
	
	/*
	 * Hire method hires a person and they are put into the Queue
	 */
	public Person Hire(Person executive) {
		executives.offer(executive);
		return executive;
	}

	/*
	 * Quit method removes the executive from the Queue
	 */
    public void Quit(Person executive) {
        executives.remove(executive);
    }
    

    /*
     *  Counts how many people in the department have less seniority
     */
    public int getLowerSeniorityCount(Person executive) {
        int count = 0;
        for (Person e : executives) {
            if (e.seniority < executive.seniority) {
                count++;
            }
        }
        return count;
    }
    
    /*
     * Displays the executive and their salary
     */
    public void displayExecutives() {
        System.out.println("Department: " + name);
        for (Person executive : executives) {
            executive.calculateSalary(); 
            System.out.println("  " + executive);
        }
    }
}
