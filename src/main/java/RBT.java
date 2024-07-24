public class RBT implements Tree<Employee>{

    private TreeNode<Employee> root;
    private int size;

    /**
     * Adds an employee to the existing tree hierarchy. Takes a pre-made employee and then creates a
     * Node with will contain the employee. Then adds the Node to the tree and puts it in its proper
     * place.
     *
     * @param employee the employee to add to the tree.
     */
    @Override
    public void add(Employee employee) {

    }

    /**
     * Searches for an employee by their id number. Returns null if id not found
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
     * returns null.
     *
     * @param id the id number of the employee to remove
     * @return the employee removed from the tree
     */
    @Override
    public Employee remove(int id) {
        return null;
    }
}
