/**
 * This class represents an employee, to provide a generic data object for use in the BST and RBT.
 *
 * It has a static counter to serve as the employee id, their first and last name, and a boolean for
 * whether they are full time.
 */

public class Employee {
    private static int idCounter;
    private int id;
    private String first;
    private String last;
    private boolean fullTime;

    public Employee(String first, String last, boolean fullTime){
        this.first = first;
        this.last = last;
        this.id = idCounter;
        incrementId();
        this.fullTime = true;
    }

    public int getId(){
        return this.id;
    }

    private static void incrementId(){
        idCounter++;
    }
}

