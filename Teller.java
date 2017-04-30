import structure5.*;

public class Teller {

    protected boolean isIdle;
    protected PriorityQueue<Customer> customers;
    protected Customer currentClient;
    
    public Teller (PriorityQueue<Customer> customers) {
        this.customers = customers;
        isIdle = true;
    }

    public void serviceCustomer(Customer nextClient) {
        if (currentClient == null) {currentClient = nextClient;}
        nextClient.service();
    }

    public boolean isAvailable() {
        return isIdle;
    }
}
