public class Node implements TreeNode{

    private int id;
    private Employee employee;
    private TreeNode left;
    private TreeNode right;

    public Node(Employee newEmployee){

    }

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
     * Takes a given node containing an employee and inserts it into the tree structure.
     * Uses the employee id as the key to compare nodes and determine if we travel left or right
     * down the tree. Will insert the node at the first null location found. If a duplicate is found,
     * log the duplicate id in the console and return early.
     *
     * @param node the node containing an employee to add
     */
    @Override
    public void add(TreeNode node) {
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
