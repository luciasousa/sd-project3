package clientSide.entities;
import java.rmi.*;

import commInfra.Request;
import interfaces.*;
import genclass.GenericIO;

/**
 *    Waiter thread.
 *
 *      It simulates the waiter life cycle.
 *      Implementation of a client-server model of type 2 (server replication).
 *      Communication is based on remote calls under Java RMI.
 */
public class Waiter extends Thread{
    /**
     *  Waiter State.
     */
    private int waiterState;

    /**
     *  Reference to the bar.
     */
    private BarInterface barInterface;

    /**
     *  Reference to the kitchen.
     */
    private KitchenInterface kitchenInterface;

    /**
     *  Reference to the table.
     */
    private TableInterface tableInterface;

    /**
     *   Instantiation of a Waiter thread.
     *
     *     @param waiterState waiter state
     *     @param barInterface reference to the bar Interface
     *     @param kitchenInterface reference to the kitchen Interface
     *     @param tableInterface reference to the table Interface
     */
    public Waiter(int waiterState, BarInterface barInterface, KitchenInterface kitchenInterface, TableInterface tableInterface)
    {
        this.waiterState = waiterState;
        this.barInterface = barInterface;
        this.kitchenInterface = kitchenInterface;
        this.tableInterface = tableInterface;
    }

    /**
     *   Set waiter state.
     *
     *     @param state waiter state
     */
    public void setWaiterState(int state)
    {
        this.waiterState = state;
    }

    /**
     *   Get waiter state.
     *
     *     @return waiter state
     */
    public int getWaiterState()
    {
        return this.waiterState;
    }

    /**
     *   Life cycle of the waiter.
     *   
     *   Starts at the state appraising situation (waiting for the arrival of the students)
     *   Ends when all the N students exit the restuarant
     */
    public void run() 
    {
        ////System.out.println("waiter thread");
        while(true)
        {
            Request r = barInterface.lookAround();
            switch(r.getRequestType()) 
            {
                case 'c': //client arriving
                    //System.out.println("client arriving - 'c'");
                    //System.out.printf("salute client %d\n",r.getRequestID());
                    tableInterface.saluteTheClient(r);
                    //System.out.println("return to bar");
                    barInterface.returnToBar();
                    break;
                
                case 'o': //order ready to be collected
                    //System.out.println("order ready to be collected - 'o'");
                    //System.out.println("get the pad");
                    tableInterface.getThePad();
                    //System.out.println("hand note to chef");
                    kitchenInterface.handTheNoteToChef();
                    //System.out.println("return to bar");
                    barInterface.returnToBar();
                    break;
                
                case 'p': //portion ready to be collected
                    //System.out.println("portion ready to be collected - 'p'");
                    if(!tableInterface.haveAllClientsBeenServed())
                    {
                        //System.out.println("collect portion");
                        barInterface.collectPortion();
                        //System.out.println("deliver portion");
                        tableInterface.deliverPortion();
                        //System.out.println("return to bar");
                        barInterface.returnToBar();
                    }
                    break;

                case 'b': //bill presentation
                    //System.out.println("bill presentation - 'b'");
                    //System.out.println("prepare bill");
                    barInterface.prepareTheBill();
                    //System.out.println("present bill");
                    tableInterface.presentTheBill();
                    //System.out.println("return to bar");
                    barInterface.returnToBar();
                    break;
                    
                case 'g': //say goodbye to students
                    //System.out.println("say goodbye to students - 'g'");
                    int numberOfStudentsInRestaurant = barInterface.sayGoodbye(r);
                    if(numberOfStudentsInRestaurant == 0) return;
            }
        }
    }
}
