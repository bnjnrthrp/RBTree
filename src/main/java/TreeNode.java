/**
 * This interface explains the requirements for a generic tree node, which will hold the data
 * and pointers for the BST and RBT.
 *
 * This node holds employees but can be adjusted easily to become generic.
 *
 * @author Benji Northrop
 * @author Ocean Gershberg
 * @author Ritika Kumar
 * @author Gabbie Williams
 */

// I don't think this interface is going to be required since we will do both trees iteratively.

public interface TreeNode {
//    /**
//     * Creates a new node holding the employee and then adds it to the tree. Recursively proceeds down
//     * the left or right side depending on the employee id comparison until it reaches a null child.
//     * Then, the created node becomes the new leaf.
//     *
//     * @param employee the employee to add to the tree.
//     */
//    void add(Employee employee);
//
//    /**
//     * Takes a given node containing an employee and inserts it into the tree structure.
//     * Uses the employee id as the key to compare nodes and determine if we travel left or right
//     * down the tree. Will insert the node at the first null location found. If a duplicate is found,
//     * log the duplicate id in the console and return early.
//     *
//     * @param node the node containing an employee to add
//     */
//    void add(TreeNode node);
//
//    /**
//     * Searches for an employee by their id number. Returns null if id not found. Recursively searches
//     * each node, then depending on the comparison between the id and the node's id, continues to the left
//     * or right child. If it reaches null without finding, then the id is not in the tree.
//     *
//     * @param id the employee id number
//     * @return the Employee if found. Null if not found.
//     */
//    Employee find(int id);
//
//    /**
//     * Removes an employee based off id from the tree hierarchy and returns it. If the id is not found,
//     * returns null. Recursively searches each node, then depending on the comparison between the id
//     * and the node's id, continues to the left or right child. If it reaches null without finding,
//     * then the id is not in the tree.
//     *
//     * @param id the id number of the employee to remove
//     * @return the employee removed from the tree
//     */
//    Employee remove(int id);
}

