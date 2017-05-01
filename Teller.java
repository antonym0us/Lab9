import structure5.*;

public class Teller {

    protected boolean isIdle;
    protected Queue<Customer> customers;
    protected Customer currentClient;
    
    public Teller (Queue<Customer> customers) {
	this.customers = customers;
	isIdle = true;
    }
    
    public void serviceCustomer(){
	if (!customers.isEmpty()) {
	    currentClient = customers.getFirst();
	    if (currentClient.getServiceTime() == 1) {
	    	currentClient.service();
	    	customers.remove();
	    	isIdle = true;
	    } else {
	    	currentClient.service();
	    	isIdle = false;
	    }
    	}   
    }    
    
    
    public boolean isAvailable() {
    	return isIdle;
    }
}
