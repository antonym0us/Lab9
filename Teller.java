/* SHIVAM PATEL & ANTONY KIM */

/*
 * 
 */
import structure5.*;
public class Teller {

    protected int currentTime;
    protected boolean isIdle;
    protected Queue<Customer> customerQueue;
    protected Customer currentClient;
    
    public Teller(Queue<Customer> q){
	//this.currentTime = currentTime; ?
	customerQueue = q;
	isIdle = true;
	currentClient = customerQueue.getFirst();
    }

    public void serviceCustomer(){
	if (customerQueue.hasNext()) {
	    if (currentClient.getServiceTime() != 0) {
		currentClient.service();
	    } else {
		currentClient = customerQueue.getFirst();
		serviceCustomer();
	    }
	}
    }
    
    public boolean isAvailable() {
	return isIdle;
    }
}
