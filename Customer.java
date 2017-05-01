import structure5.*;

/**
 * SHIVAM PATEL & ANTONY KIM // WEDNESDAY PM
 *
 * Customer.java
 *
 * A class to represent all time-related customer data
 *
 **/

public class Customer implements Comparable<Customer> {

    /* The time step at which the customer arrives */
    protected int eventTime;

    /* The duration needed to service the customer */
    protected int serviceTime;
    
    /** Constructor */
    public Customer(int eventTime, int serviceTime) {
        this.eventTime = eventTime;
        this.serviceTime = serviceTime;
    }
    
    /** Compares Customers by arrival time */
    public int compareTo(Customer other) {
        return this.eventTime - other.eventTime;
    }

    /** Returns the service time of the customer */
    public int getServiceTime() {
	return serviceTime;
    }

    public void service() {
	--serviceTime;
    }

    public int getEventTime() {
	return this.eventTime;
    }
    
    /** Produces a string representation of the customer */
    public String toString() {
        return "Customer Arrived At: " + this.eventTime +
            "\nService Time: " + this.serviceTime;
    }
}
