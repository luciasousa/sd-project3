package clientSide.entities;
import java.rmi.*;
import interfaces.*;
import genclass.GenericIO;

/**
 *    Student thread.
 *
 *      It simulates the student life cycle.
 *      Implementation of a client-server model of type 2 (server replication).
 *      Communication is based on remote calls under Java RMI.
 */
public class Student extends Thread{
    /**
     *  Student identification.
     */
    private int studentID;

    /**
     *  Student State.
     */
    private int studentState;

    /**
     *  Reference to the table.
     */
    private final TableInterface tableInterface;

    /**
     *  Reference to the bar.
     */
    private final BarInterface barInterface;

    /**
     *   Instantiation of a student thread.
     *
     *     @param studentID student id
     *     @param studentState student state
     *     @param tableInterface reference to table Interface
     *     @param barInterface reference to the bar Interface
     */
    public Student(int studentID,int studentState, TableInterface tableInterface, BarInterface barInterface)
    {
        this.studentID = studentID;
        this.studentState = studentState;
        this.tableInterface = tableInterface;
        this.barInterface = barInterface;
    }

    /**
     *   Set student id.
     *
     *     @param id student id
     */
    public void setStudentID(int id){
        studentID = id;
    }

    /**
     *   Get student id.
     *  
     *   @return stduent id
     */
    public int getStudentID(){
        return studentID;
    }

    /**
     *   Set student state.
     *
     *     @param state student state
     */
    public void setStudentState(int state){
        studentState = state;
    }

    /**
     *   Get student state.
     *
     *   @return student state
     */
    public int getStudentState(){
        return studentState;
    }

    /**
     *   Life cycle of the student.
     *   
     *   Starts at the state going to the restaurant 
     *   Ends when the student exits the restaurant
     * 
     */
    public void run() 
    {
        //System.out.println("student walk a bit");
        walkABit();
        //System.out.println("student enter");
        int[] orderOfArrival = barInterface.enter();
        //System.out.println("student read menu");
        tableInterface.readMenu();
        if (orderOfArrival[0] != studentID){
            tableInterface.informCompanion();
            //System.out.printf("student %d inform companion left the talk\n",studentID);
        } 
        else
        {
            //System.out.printf("student %d prepare order\n", studentID);
            tableInterface.prepareTheOrder();
            while(!tableInterface.hasEverybodyChosen()) {
                //System.out.printf("student %d add up ones choice\n", studentID);
                tableInterface.addUpOnesChoice();
            }
            //System.out.println("student is going to call the waiter");
            barInterface.callWaiter();
            //System.out.printf("student %d describe order\n", studentID);
            tableInterface.describeTheOrder();
            //System.out.printf("student %d join talk\n", studentID);
            tableInterface.joinTheTalk();
        }
        
        for(int i=0; i< Constants.M; i++)
        {
            //System.out.printf("student %d start eating\n", studentID);
            tableInterface.startEating();
            //System.out.printf("student %d end eating\n", studentID);
            tableInterface.endEating();
            //wait for everyone to finish
            if(!tableInterface.hasEverybodyFinished()){
                //System.out.printf("student %d wait for everyone to finish\n", studentID);
                tableInterface.waitForEverybodyToFinish();
            }
            //System.out.printf("student %d wait for course\n", studentID);
            tableInterface.waitForCourseToBeReady();
        }

        if(orderOfArrival[Constants.N-1] != studentID){
            //System.out.printf("student %d wait for payment\n", studentID);
            tableInterface.waitForPayment();
        }
            
        
        if(orderOfArrival[Constants.N-1] == studentID) 
        {
            //System.out.printf("last student %d signal waiter\n", studentID);
            barInterface.signalTheWaiter();
            //System.out.printf("last student %d should have arrived earlier\n", studentID);
            tableInterface.shouldHaveArrivedEarlier();
            //System.out.printf("last student %d honour the bill\n", studentID);
            tableInterface.honourTheBill();
        }
        //System.out.printf("student %d exit\n", studentID);
        barInterface.exit();
    }

    /**
     *  Living normal life.
     *
     *  Internal operation.
     */
    private void walkABit() {
        try { 
            Thread.sleep ((long) (1 + 40 * Math.random ()));
        }
        catch (InterruptedException e) {}
    }
}