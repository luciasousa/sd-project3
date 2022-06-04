package interfaces;
import java.rmi.*;

/**
 *   Operational interface of a remote object of type Kitchen.
 *
 *     It provides the functionality to access the Kitchen.
 */
public interface KitchenInterface extends Remote {
        /**
     *    Operation set first course
     *
     *    Called by the chef to set first course
     *    @param b boolean value setting the first course
     *    
     */
    public void setFirstCourse(boolean b) throws RemoteException;

    /**
     *    Operation get first course
     *
     *    Called by the chef to get first course
     *    @return boolean value for the first course
     *    
     */
    public boolean getFirstCourse() throws RemoteException;

    /**
     *    Operation watch the news
     *
     *    Called by the chef to watch the news
     *    waits until note is available
     *    
     */
    public void watchTheNews() throws RemoteException;
    
    /**
     *    Operation hand note to the chef
     *
     *    Called by the waiter to hand note to the chef
     *    signals chef that note is available
     *    waiter waits until chef starts preparation
     *    
     */
    public void handTheNoteToChef() throws RemoteException;

    /**
     *    Operation chef wait for collection
     *
     *    Called by the waiter for chef to wait for collection of the portion
     *    
     */
    public void chefWaitForCollection(int chefState) throws RemoteException;

    /**
     *    Operation portion has been collected
     *
     *    Called by the waiter to inform that portion was collected
     *    signals chef that portion was collected
     *    
     */
    public void portionHasBeenCollected(int waiterState) throws RemoteException;

    /**
     *    Operation start preparation
     *
     *    Called by the chef to start preparation
     *    signals waiter that preperation was started
     *    
     */    
    public void startPreparation() throws RemoteException;

    /**
     *    Operation proceedToPresentation
     *
     *    Called by the chef to proceed to presentation
     *    
     */
    public void proceedToPresentation() throws RemoteException;

    /**
     *    Operation have all portions been delivered
     *
     *    Called by the chef to check if all portions were delivered
     *    
     *    @return true if the portions have been fully delivered otherwise false
     */
    public boolean haveAllPortionsBeenDelivered() throws RemoteException;

    /**
     *    Operation has the order been completed
     *
     *    Called by the chef to check if the order was completed
     *    
     *    @return true if the order has been fully completed otherwise false
     */
    public boolean hasTheOrderBeenCompleted() throws RemoteException;

    /**
     *    Operation have next portion ready
     *
     *    Called by the chef to have next portion ready
     *    
     */
    public void haveNextPortionReady() throws RemoteException;

    /**
     *    Operation continue preparation
     *
     *    Called by the chef to continue preparation
     *    
     */
    public void continuePreparation() throws RemoteException;

    /**
     *    Operation clean up
     *
     *    Called by the chef to clean up
     *    
     */
    public void cleanUp() throws RemoteException;

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
