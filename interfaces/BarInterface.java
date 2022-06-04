package interfaces;
import java.rmi.*;
import commInfra.*;

/**
 *   Operational interface of a remote object of type Bar.
 *
 *     It provides the functionality to access the Bar.
 */
public interface BarInterface extends Remote {

    /**
     *    Operation look around
     *
     *    Called by the waiter to look around
     *    waits until has requests
     *    @return the request read from the queue
     * 
     */
    public Request lookAround() throws RemoteException;

    /**
     *    Operation enter
     *
     *    Called by the student to enter in the restaurant
     *    puts a request for the waiter 
     *    signals waiter 
     *    while students are waiting to take a seat at the table
     *    @return array of the students IDs in order of arrival
     * 
     */
    public int[] enter(int studentID) throws RemoteException;

    /**
     *    Operation return to bar
     *
     *    Called by the waiter to return to the bar
     * 
     */
    public void returnToBar() throws RemoteException;

    /**
     *    Operation call waiter
     *
     *    Called by the student to describe the order
     *    puts a request for the waiter
     *    signals waiter waiting in lookaround
     *    while students are waiting in the table for waiter to get the pad
     * 
     */
    public void callWaiter(int studentID, int studentState) throws RemoteException;

    /**
     *    Operation alert the waiter
     *
     *    Called by the chef for waiter collect the portions
     *    puts a request for the waiter
     *    signals waiter waiting in lookaround
     *    while chef is waiting in the kitchen for the collection
     * 
     */
    public void alertTheWaiter() throws RemoteException;

    /**
     *    Operation collect portion
     *
     *    Called by the waiter to collect portion
     *    and informing chef in the kitchen that portion was collected
     * 
     */
    public void collectPortion() throws RemoteException;
    

    /**
     *    Operation signal the waiter
     *
     *    Called by the last student to signal the waiter after everybody eaten and is time to pay
     *    puts a request for the waiter
     *    signals waiter waiting in lookaround
     *    
     */
    public void signalTheWaiter(int studentID) throws RemoteException;

    /**
     *    Operation prepare the bill
     *
     *    Called by the waiter to prepare the bill
     * 
     */
    public void prepareTheBill() throws RemoteException;
    /**
     *    Operation exit
     *
     *    Called by the student to exit the restaurant
     *    puts a request for the waiter
     *    signals waiter waiting in lookaround
     *    waits for waiter to say goodbye 
     * 
     */
    public void exit(int studentID) throws RemoteException;

    /**
     *    Operation say goodbye
     *
     *    Called by the waiter to say goodbye to the student
     *    signals student that waiter said goodbye
     * 
     *    @param studentID student id
     *    @return number of students in restuarant
     *    
     */
    public int sayGoodbye(int studentID) throws RemoteException;

    /**
     *  Operation end of work.
     *
     *   New operation.
     *
    */
    public void endOperation () throws RemoteException;

    /**
     *   Operation server shutdown.
     *
     *   New operation.
     */
    public void shutdown () throws RemoteException;
}
