import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        int numNormalCounters = 3;
        double simulationTime = 3600;
        double arrivalRate = 0.5;
        int maxItems = 20;

        Queue<Checkout> checkouts = new LinkedList<>();
        checkouts.add(new SupCheckout(5)); 
        checkouts.add(new ExpCheckout(10)); 

        for (int i = 0; i < numNormalCounters; i++) {
            checkouts.add(new NormalCheckout(15)); 
        }

        Random random = new Random();
        double currentTime = 0.0;

        while (currentTime < simulationTime) {
            if (random.nextDouble() < arrivalRate) {
                int items = random.nextInt(maxItems) + 1;
                Customer newCustomer = new Customer(currentTime, 0, items);
                customerGoesToLines(newCustomer, checkouts); 
            }
            for (Checkout checkout : checkouts) {
                checkout.customerAtCounter(currentTime);
            }

            currentTime++;
        }
        for (Checkout checkout : checkouts) {
            checkout.Display(checkouts);
        }
    }

   /*
    * Puts the customer in their correct line
    */
    private static void customerGoesToLines(Customer customer, Queue<Checkout> checkouts) {
      
        int numItems = customer.getNumItems();
        Checkout bestCheckout = null;

        for (Checkout checkout : checkouts) {
            if ((checkout instanceof SupCheckout && numItems <= checkout.getMaxItems()) ||
                (checkout instanceof ExpCheckout && numItems <= checkout.getMaxItems()) ||
                (checkout instanceof NormalCheckout)) {
                
                if (bestCheckout == null || checkout.numOfCustomers() < bestCheckout.numOfCustomers()) {
                    bestCheckout = checkout;
                }
            }
        }

        if (bestCheckout != null) {
            bestCheckout.addCustomer(customer);
        }
    }
}


