import java.util.LinkedList;
import java.util.Queue;

public class Checkout {
	
	/*
	 * The fields for the Checkout class
	 */
	private int maxItems;
    private Queue<Customer> customers;
    private int numOfCustomers;
    private double totalWaitTime;
    private int totalProcessedItems;
    private int maxLineSize;
    private double totalFreeTime;
    private double hours;

    /*
     * Empty constructor
     */
    public Checkout() {
        this.maxItems = 0;
        this.customers = new LinkedList<>(); 
        this.numOfCustomers = 0;
        this.totalWaitTime = 0;
        this.totalProcessedItems = 0;
        this.maxLineSize = 0;
        this.totalFreeTime = 0;
        this.hours = 0;
    }

    /*
     * Constructor with parameters
     */
    public Checkout(int maxItems, Queue<Customer> customers, int numOfCustomers, double totalWaitTime,
                    int totalProcessedItems, int maxLineSize, double totalFreeTime, double hours) {
        this.maxItems = maxItems;
        this.customers = new LinkedList<>(); 
        this.numOfCustomers = numOfCustomers;
        this.totalWaitTime = totalWaitTime;
        this.totalProcessedItems = totalProcessedItems;
        this.maxLineSize = maxLineSize;
        this.totalFreeTime = totalFreeTime;
        this.hours = hours;
    }

    /*
     * getMaxItems returns maxItems
     */
	public int getMaxItems() {
		return maxItems;
	}
	
	/*
	 * steMaxItems sets maxItems
	 */
	public void setMaxItems(int items) {
		maxItems = items;
	}

	/*
	 * getTotalWaitTime returns totalWaitTime
	 */
	public double getTotalWaitTime() {
		return totalWaitTime;
	}

	/*
	 * getMaxLineSize returns maxLineSize
	 */
	public int getMaxLineSize() {
		return maxLineSize;
	}

	/*
	 * setMaxLineSize sets the MaxLineSize variable
	 */
	public void setMaxLineSize(int maxLineSize) {
		this.maxLineSize = maxLineSize;
	}

	/*
	 * getTotalFreeTime returns the total free time
	 */
	public double getTotalFreeTime() {
		return totalFreeTime;
	}

	/*
	 * getTotalProcessedItems returns the total Processed Items
	 */
	public int getTotalProcessedItems() {
		return totalProcessedItems;
	}
	
	/*
	 * getHours returns the hours
	 */
	public double getHours() {
		return hours;
	}
	
	/*
	 * The isEmpty method checks to see if something is empty
	 */
	public boolean isEmpty() {
		return customers.isEmpty();
	}
	
	/*
	 * addCustomer method adds the customer into the queue
	 */
	public void addCustomer(Customer customer) {
		customers.add(customer);
		numOfCustomers++;
		if (customers.size() > maxLineSize) {
		    maxLineSize = customers.size();
		}
	}
	
	/*
	 * removeCustomer removes the customer from the queue
	 */
	public void removeCustomer() {
		if(customers == null) {
			System.out.println("There is no one in line.");
		}
		customers.poll();
		numOfCustomers--;
	}
	
	/*
	 * customerAtCounter method processes the customers info then removes them from the line/queue
	 */
	 public void customerAtCounter(double currentTime) {
	        if (!customers.isEmpty()) {
	            Customer customer = customers.poll();
	            numOfCustomers--;
	            int items = customer.getNumItems();
	            totalProcessedItems += items;
	            totalWaitTime += currentTime - customer.getArrivalTime();
	        } else {
	            totalFreeTime++;
	        }
	    }
	
	 /*
	  * lookAtFrontOfTheLine shows the front of the line/queue
	  */
	public void lookAtFrontOfTheLine() {
		if(customers == null) {
			System.out.println("There is no one in the line.");
		}else {
			System.out.println(customers.peek());
		}
	}
	
	/*
	 * numOIfCustomers returns the numOfCustomers variable
	 */
	public int numOfCustomers() {
		return numOfCustomers;
	}
	
	/*
	 * maxSimTime processes the maximum sim time
	 */
	public void maxSimTime(double simTime) {
		double timeNow = 0;
		while (timeNow < simTime) {
			timeNow++;
		}
	}
	
	/*
	 * averageWaitTime method returns the average wait time of the customer
	 */
	public double averageWaitTime() {
		if(numOfCustomers > 0) {
			return totalWaitTime / numOfCustomers;
		}else {
			return 0.0;
		}
		
	}
	
	/*
	 * numOfCustPerHour returns the number of customers per hour
	 */
	public int numOfCustPerHour() {
		int hours = 60;
		if(numOfCustomers > 0) {
			return numOfCustomers / hours;
		}else {
			return 0;
		}
	}
	
	/*
	 * nnumOfItemsPerHour returns the number of items processed per hour
	 */
	public int numOfItemsPerHour() {
		int hours = 60;
		if(totalProcessedItems > 0) {
			return totalProcessedItems / hours;
		}else {
			return 0;
		}
	}
	
	/*
	 * getFreeTime gives the free time of the customer
	 */
	public void getFreeTime(double simTime) {
		if(customers.isEmpty()) {
			totalFreeTime += simTime;
		}
	}

	/*
	 * The Display methods displays all of the information given
	 */
	public void Display(Queue<Checkout> checkouts) {
	   for (Checkout checkout : checkouts) {
		   System.out.println("Checkout Type: " + checkout.getClass().getSimpleName());
	       System.out.println("Average Wait Time: " + checkout.averageWaitTime() + " seconds");
	       System.out.println("Max Line Size: " + checkout.getMaxLineSize());
	       System.out.println("Total Items Processed: " + checkout.getTotalProcessedItems());
	       System.out.println("Total Free Time: " + checkout.getTotalFreeTime() + " seconds");
	     }
	 }
	

	
	
	
	
}
 