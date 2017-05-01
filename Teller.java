import structure5.*;

public class Teller {

    protected boolean isIdle;
    protected PriorityQueue<Customer> customers;
    protected Customer currentClient;
    protected int time;
    
    /** Constructor */
    public Teller (PriorityQueue<Customer> customers) {
        this.customers = customers;
        isIdle = true;
    }

    /** */
    public void serviceCustomer() {

	// Is the teller idle? and Is it time for the next customer to arrive?
	if (isIdle && !customers.isEmpty() && time >= customers.getFirst().getEventTime()) {
	    currentClient = customers.remove();
	}
	
	if (currentClient != null) {
	    // Service the client for a single timestep
	    currentClient.service();
	    
	    // Is the client satisfied?
	    isIdle = (currentClient.getServiceTime() <= 0);
	}
    }
    
    public boolean isAvailable() {
        return isIdle;
    }

    public void updateTime(int time) {
	this.time = time;
    }

    public String toString() {
	String result;
	if (currentClient == null) {
	    result = "Serving no customers";
	} else {
	    result = "isIdle: " + isIdle + "\n" +
		"Customer arrived at " + currentClient.getEventTime() + ", serviceTime is " + currentClient.getServiceTime();
	}
	return result;
    }
    
}

