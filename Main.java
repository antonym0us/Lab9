public class Main {

    public static final int NUM_CUSTOMERS = 5;
    public static final int NUM_SERVICE_POINTS = 1;
    public static final int MAX_EVENT_START = 80;
    public static final int SEED = 3;
    public static final int DURATION = 100;
    
    public static void main (String[] args) {
	BusinessSimulation sm = new SuperMarket(NUM_CUSTOMERS, NUM_SERVICE_POINTS,
					   MAX_EVENT_START, SEED, DURATION);
        
    }
}
