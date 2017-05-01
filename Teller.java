import structure5.*;

public class Teller {

    protected boolean isIdle;
    protected PriorityQueue<Customer> customers;
    protected Customer currentClient;
    
    public Teller (PriorityQueue<Customer> customers) {
        this.customers = customers;
        isIdle = true;
    }
    
    public void serviceCustomer(){
	// Is the teller idle?
	if (isIdle && !customers.isEmpty()) {
	    currentCleint = customers.getFirst();
	}

	if (currentClient.getServiceTime() == 1) {
	    currentClient.service();
	    customers.remove();
	    isIdle = true;
	} else {
	    currentClient.service();
	    isIdle = false;
	}
    }   
    
    public boolean isAvailable() {
        return isIdle;
    }
}
