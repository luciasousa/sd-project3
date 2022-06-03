package serverSide.objects;
import interfaces.KitchenInterface;

/**
 *    Kitchen
 *
 *    It is responsible for the the synchronization of the Chef and Waiter
 *    is implemented as an implicit monitor.
 *    There is one internal synchronization points: 
 *    a single blocking point for the Chef, where he waits for the Waiter to signal
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on Java RMI.
 */
public class Kitchen implements KitchenInterface{
    
}
