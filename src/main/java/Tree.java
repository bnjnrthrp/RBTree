/**
 * This interface explains the requirements for a generic tree, which will provide the base for both the
 * Binary Search Tree (BST) and the Red-Black Tree (RBT)
 * <p>
 * The tree uses a generic type to allow for flexible use.
 *
 * @author Benji Northrop
 * @author Ocean Gershberg
 * @author Ritika Kumar
 * @author Gabbie Williams
 */

public interface Tree {

    /**
     * Adds an employee to the existing tree hierarchy. Takes a pre-made employee and then creates a
     * Node with will contain the employee. Then adds the Node to the tree and puts it in its proper
     * place.
     *
     * @param data the employee to add to the tree.
     */
    void add(Indexable data);

    /**
     * Searches for an employee by their id number. Returns null if id not found
     * @param id the employee id number
     * @return the Employee if found. Null if not found.
     */
    Indexable find(int id);

    /**
     * Removes an employee based off id from the tree hierarchy and returns it. If the id is not found,
     * returns null.
     *
     * @param id the id number of the employee to remove
     * @return the employee removed from the tree
     */
    Indexable remove(int id);

    /**
     * Does an in-order traversal to print a RB Tree
     */
    void printInOrder();

    /**
     * Prints the tree using a breadth first traversal
     */
    void printBFS();
}
