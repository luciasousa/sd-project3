package clientSide.entities;
import java.rmi.*;
import interfaces.*;
import genclass.GenericIO;

/**
 *    Chef thread.
 *
 *      It simulates the chef life cycle.
 *      Implementation of a client-server model of type 2 (server replication).
 *      Communication is based on remote calls under Java RMI.
 */
public class Chef extends Thread{
    /**
     *  Chef state.
     */
    private int chefState;

    /**
     *  Reference to the kitchen.
     */
    private KitchenInterface kitchenInterface;

    /**
     *  Reference to the bar.
     */
    private BarInterface barInterface;

     /**
     *   Instantiation of a Chef thread.
     *
     *     @param chefState state of the chef
     *     @param kitchenInterface reference to the kitchen Interface
     *     @param barInterface reference to the bar Interface
     */
    public Chef(int chefState, KitchenInterface kitchenInterface, BarInterface barInterface)
    {
        this.chefState = chefState;
        this.kitchenInterface = kitchenInterface;
        this.barInterface = barInterface;
    }

    /**
     *   Set chef state.
     *
     *     @param state chef state
     */
    public void setChefState(int state)
    {
        chefState = state;
    }

    /**
     *   Get chef state.
     *
     *   @return chef state
     */
    public int getChefState()
    {
        return chefState;
    }

    /**
     *   Life cycle of the chef.
     *   
     *   Starts at the state whatch the news (waiting for the note)
     *   Ends when the order is complete.
     */
    public void run() 
    {
        System.out.println("watch news");
        kitchenInterface.watchTheNews();
        System.out.println("start preparation");
        kitchenInterface.startPreparation();
        do 
        {
            if(!kitchenInterface.getFirstCourse()) kitchenInterface.startPreparation(); else kitchenInterface.setFirstCourse(false);
            System.out.println("proceed to presentation");
            kitchenInterface.proceedToPresentation();
            System.out.println("alert waiter");
            barInterface.alertTheWaiter();

            while(!kitchenInterface.haveAllPortionsBeenDelivered()) {
                System.out.println("have next portion ready");
                kitchenInterface.haveNextPortionReady();
                System.out.println("alert waiter");
                barInterface.alertTheWaiter();
            }

        } while(!kitchenInterface.hasTheOrderBeenCompleted());
        System.out.println("clean up");
        kitchenInterface.cleanUp();
    }
}
