import structure5.*;

/**
 *  SHIVAM PATEL & ANTONY KIM // WEDNESDAY PM
 *
 *  Bank.java
 *
 *  Defines the queue behavior for bank-style customer service
 *
 **/
public class Bank extends BusinessSimulation {

    /* The bank's main customer queue */
    //protected PriorityQueue<Customer> mainQueue = new PriorityVector<Customer>();
    
    /**
     * The constructor for the bank simulation calls the super-
     * constructor
     */
    public Bank (int numCustomers, int numServicePoints,
                 int maxEventStart, int seed, int duration) {
        super(numCustomers, numServicePoints,
              maxEventStart, seed, duration); 
    }

    /**
     * Generates a series of service points, stored as a vector of
     * teller objects that each have a designated queue of customers
     * to draw from
     * @arg numServicePoints number of tellers to add to the vector
     */
    public Vector<Teller> generateServicePoints(int numServicePoints) {
	Vector<Teller> output = new Vector<Teller>();
	
	// Add tellers who draw customers from the main event queue
        for (int i = 0; i < numServicePoints; ++i) {
            output.add(new Teller(eventQueue));
	    System.out.println("hi" + Boolean.toString(mainQueue == null));
        }
        return output;
    }

    /**
     * Runs the simulation for a given amount of timeSteps
     * @arg duration the number of timeSteps to run the simulation
     */
    public void runSimulation(int duration) {
        this.duration = duration;

        while(!step()) {
	    
	    // STEP 1: Add any arriving customers to the main queue
	    if ((eventQueue.getFirst() != null) && (eventQueue.getFirst().getEventTime() <= time)) {
		mainQueue.add(eventQueue.remove());
	    }

	    // STEP 2: Have the tellers handle their customers or get new ones
	    for (int i = 0; i < servicePoints.size(); ++i) {

		Teller curr = servicePoints.get(i);

		// update the time
		curr.updateTime(time);
		
		// Handle existing customer, if any
		curr.serviceCustomer();
	    }
	    
	    // STEP 3: Print out status every 5 steps
	    if (time % 5 == 0) {
		System.out.println(toString());
	    }
	    
	}
	System.out.println(" ******* " + time);
    }
    
}

