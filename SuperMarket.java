import structure5.*;

public class SuperMarket extends BusinessSimulation {

    /**
     * The constructor for the supermarket simulation calls the super-
     * constructor
     */
    public SuperMarket (int numCustomers, int numServicePoints,
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

	for (int tellerNum = 0; tellerNum < numServicePoints; ++tellerNum) {

	    // Construct the teller's unique queue
	    PriorityQueue<Customer> line = new PriorityVector<Customer>();

	    // Construct the teller
	    output.add(new Teller(line));
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
	    Teller curr;
	    // initally assume the shortest queue is the first one (if they're all equal)
	    PriorityQueue<Customer> shortestLine = servicePoints.get(0).getCustomers();
	    
	    if (eventQueue.getFirst() != null && time == eventQueue.getFirst().getEventTime()) {
		// STEP 1: search for the shortestLine
		for (int i = 0; i < servicePoints.size(); ++i) {
		    curr = servicePoints.get(i);
		    // since a teller servicing a customer technically counts as having no queue,
		    // also check if the teller is available
		    if (curr.getCustomers().size() < shortestLine.size() || curr.isAvailable()) {
			shortestLine = curr.getCustomers();
		    }
		}
		// STEP 2: add a customer to the shortest line if they arrive
		shortestLine.add(eventQueue.remove());
	    }
	    
	    // STEP 3: serve the customers
	    for (int i = 0; i < servicePoints.size(); ++i) {
		curr = servicePoints.get(i);
		// update the time for the tellers
		curr.updateTime(time);
		
		// Handle existing customer, if any
		curr.serviceCustomer();
		
	    }
	    
	    // STEP 4: Print out status
	    if (time % 5 == 0) {
		System.out.println(toString());
	    }

	}
	System.out.println(" ******* " + time);
    }

}
	

