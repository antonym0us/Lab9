import structure5.*;

public class SuperMarket extends BusinessSimulation {
    
    public SuperMarket(int numCustomers, int numServicePoints,
		       int maxEventStart, int seed) {
	super(numCustomers, numServicePoints, maxEventStart, seed);
    }

    public void run(int duration) {
	this.duration = duration;
	
	while(!step()) {
	    // STEP 1: Handle customers & open tellers?
	    for (int i = 0; i < servicePoints.size(); ++i) {

		Teller curr = servicePoints.get(i);
		
		// Handle existing customer, if any
		curr.serviceCustomer();

		// Is the teller idle?
		if (curr.isAvailable()) {
		    // Get next customer
		} else {
		    // Add to the teller's idle time
		}
	    }
	    
	    // STEP 2: Print out status
	    if (time % 5 == 0) {
		toString();
	    }
	    
	}
    }
    
}
