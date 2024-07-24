public class Node implements TreeNode<Employee>{

    private int id;
    private Employee employee;
    private TreeNode<Employee> left;
    private TreeNode<Employee> right;


    /**
     * Creates a new node holding the employee and then adds it to the tree. Recursively proceeds down
     * the left or right side depending on the employee id comparison until it reaches a null child.
     * Then, the created node becomes the new leaf.
     *
     * @param employee the employee to add to the tree.
     */
    @Override
    public void add(Employee employee) {

    }

    /**
     * Searches for an employee by their id number. Returns null if id not found. Recursively searches
     * each node, then depending on the comparison between the id and the node's id, continues to the left
     * or right child. If it reaches null without finding, then the id is not in the tree.
     *
     * @param id the employee id number
     * @return the Employee if found. Null if not found.
     */
    @Override
    public Employee find(int id) {
        return null;
    }

    /**
     * Removes an employee based off id from the tree hierarchy and returns it. If the id is not found,
     * returns null. Recursively searches each node, then depending on the comparison between the id
     * and the node's id, continues to the left or right child. If it reaches null without finding,
     * then the id is not in the tree.
     *
     * @param id the id number of the employee to remove
     * @return the employee removed from the tree
     */
    @Override
    public Employee remove(int id) {
        return null;
    }
}
