import java.util.Random;
import structure5.*;

public class Bank extends BusinessSimulation {

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

	for (int i = 0; i < numServicePoints; ++i) {
	    output.add(new Teller(eventQueue));
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
	    // STEP 1: Handle customers & open tellers?
	    for (int i = 0; i < servicePoints.size(); ++i) {

		Teller curr = servicePoints.get(i);

		// update the time for the tellers
		curr.updateTime(time);

		// Handle existing customer, if any
		curr.serviceCustomer();

	    }

	    // STEP 2: Print out status
	    if (time % 5 == 0) {
		System.out.println(toString());
	    }

	}
	System.out.println(" ******** " + time);
    }

}
