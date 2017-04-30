import java.util.Vector;
import java.util.Random;
import structure5.*;

public abstract class BusinessSimulation {

    /* sequence of customers, prioritized by randomly-generated event time */
    PriorityQueue<Customer> eventQueue;
    
    /* series of service points where customers queue and are served */
    Vector<Teller> servicePoints;

    /* current time step in the simulation */
    int time;

    /* maximum time steps to run */
    int duration;
    
    /* seed for Random() so that simulation is repeatable */
    int seed;

    /* number of customers generated */
    int numCustomers;

    /* number of service points generated */
    int numServicePoints;

    /* the latest time a customer could arrive */
    int maxEventStart;
    
    /* Used to bound the range of service times that Customers require */
    static final int MIN_SERVICE_TIME = 5; //TODO: set appropraitely
    static final int MAX_SERVICE_TIME = 20; //TODO: set appropriately
    
    /**
     * Creates a BusinessSimulation.
     * @post the step() function may be called.
     *
     * @numCustomers number of random customers that appear in the simulation
     * @numSerivicePoints number of tellers in this simulation
     * @maxEventStart latest timeStep that a Customer may appear in the simulation
     * @seed used to seed a Random() so that simulation is repeatable.
     */
    public BusinessSimulation(int numCustomers, int numServicePoints,
                              int maxEventStart, int seed, int duration) {

        //Store all variables
        this.numCustomers = numCustomers;
        this.numServicePoints = numServicePoints;
        this.maxEventStart = maxEventStart;
        this.seed = seed;
        this.duration = duration;

        // Populate customers
        eventQueue = generateCustomerSequence(numCustomers, maxEventStart, seed);

        // Populate tellers
        servicePoints = generatrServicePoints();

        // Run the simulation
        time = 0;
        runSimulation(duration);
    }

    abstract public void runSimulation(int duration);
    
    /**
     * Generates a sequence of Customer objects, stored in a PriorityQueue.
     * Customer priority is determined by arrival time
     * @arg numCustomers number of customers to simulate
     * @arg maxEventStart maximum timeStep that a customer arrives
     *      in @eventQueue
     * @arg seed use Random(seed) to make customer sequence repeatable
     * @return A PriorityQueue that represents Customer arrivals,
     *         ordered by Customer arrival time
     */
    public PriorityQueue<Customer> generateCustomerSequence
        (int numCustomers, int maxEventStart, int seed) {
                
        PriorityQueue<Customer> output = new PriorityVector<Customer>();
        Random r = new Random(seed);
        
        for (int i = 0; i < numCustomers; ++i) {
            output.add (new Customer(r.nextInt(maxEventStart),
                                     MAX_SERVICE_TIME -
                                     r.nextInt(MAX_SERVICE_TIME - MIN_SERVICE_TIME)));
        }
        
        return output;
    }

    abstract public Vector<Teller> generateServicePoints();
    
    /**
     * Advances @timeSteps time steps through the simulation.
     *
     * @post the simulation has advanced @timeSteps time steps
     * @return true if the simulation is over, false otherwise
     */
    public boolean step(int timeSteps) {
        time += timeSteps;
        return time >= duration;
    }
    
    /**
     * Advances 1 time step through the simulation.
     *
     * @post the simulation has advanced 1 time step
     * @return true if the simulation is over, false otherwise
     */
    public boolean step() {
        ++time;
        return time >= duration;
    }
    
    /**
     * @return a string representation of the simulation
     */
    public String toString() {
        // TODO: modify if needed.
        String str = "Time: " + time + "\n";
        str = str + "Event Queue: ";
        if (eventQueue != null) {
            str = str + eventQueue.toString();
        }
        str = str + "\n";
        
        if (servicePoints != null)  {
            for (Queue<Customer> sp : servicePoints) {
                str = str + "Service Point: " + sp.toString() + "\n";
            }
        }
        
        return str;
    }
}
