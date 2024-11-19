

public class Customer {
	
	/*
	 * Fields for the Customer class
	 */
	private int numItems;
	private double arrivalTime;
	private double waitTime;
	
	/*
	 * Empty Constructor
	 */
	public Customer() {
		arrivalTime = 0.0;
		numItems = 0;
		waitTime = 0;
	}
	
	/*
	 * Constructor with parameters
	 */
	public Customer(double custArrivalRate, double custWaitTime, int custNumItems) {
		arrivalTime = custArrivalRate;
		waitTime = custWaitTime;
		numItems = custNumItems;
	}
	
	/*
	 * getArrivalTime returns the arrivalTime
	 */
	public double getArrivalTime() {
		return arrivalTime;
	}

	/*
	 * setArrivalTime sets the arrivalTime
	 */
	public void setArrivalTime(double custArrivalTime) {
		arrivalTime = custArrivalTime;
	}
	
	/*
	 * WaitingTime method returns the waiting time of the customer
	 */
	public double waitingTime(double timeRightNow) {
		if(timeRightNow >= arrivalTime) {
			return timeRightNow - arrivalTime;
		}else {
			return 0.0;
		}
	}
	
/*
 * getNumItems returns numItems
 */
	public int getNumItems() {
		return numItems;
	}

	/*
	 * setNumItems sets the numItems variable
	 */
	public void setNumItems(int numItems) {
		if(numItems >= 0) {
			this.numItems = numItems;
		}else {
			System.out.println("You can't have negative items");
		}
	}

	/*
	 * getWaitTime returns the waitTime
	 */
	public double getWaitTime() {
		return waitTime;
	}

	/*
	 * setWaitTime sets the waitTime
	 */
	public void setWaitTime(double waitTime) {
		this.waitTime = waitTime;
	}
	
	

}
