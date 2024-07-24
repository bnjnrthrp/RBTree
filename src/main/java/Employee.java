/**
 * This class represents an employee, to provide a generic data object for use in the BST and RBT.
 *
 * It has a static counter to serve as the employee id, their first and last name, and a boolean for
 * whether they are full time.
 */

public class Employee {
    private static int id;
    private String first;
    private String last;
    private boolean fullTime;

    public Employee(String first, String last, boolean fullTime){
        return;
    }

    private static void incrementId(){
        id++;
    }
}

