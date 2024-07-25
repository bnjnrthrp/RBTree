public class BST implements Tree {
    private Node root;
    private int size;

    /**
     * No argument constructor creates an empty BST.
     */
    public BST() {
        this.root = null;
        size = 0;
    }

    /**
     * Creates a BST and makes the given employee the root.
     *
     * @param employee the first employee to be in the structure
     */
    public BST(Employee employee) {
        Node root = new Node(employee);
        this.root = root;
        this.size = 1;
    }


    /**
     * Adds an employee to the existing tree hierarchy. Takes a pre-made employee and then creates a
     * Node with will contain the employee. Then adds the Node to the tree and puts it in its proper
     * place.
     *
     * @param employee the employee to add to the tree.
     */
    @Override
    public void add(Employee employee) {
        Node newEmployee = new Node(employee);
        // Check if the current tree is empty
        if (this.root == null) {
            this.root = newEmployee;
            incrementSize();
            return;
        }
        // Traverse the tree until reaching null
        Node currNode = this.root;
        // Until we reach a return
        while (true) {
            // Traverse the tree to the left or right, depending on the key (employee id)
            if (newEmployee.id < currNode.id) {
                // If we go left and there is a left child, update the current node to the left child
                if (currNode.left != null) {
                    currNode = currNode.left;
                } else {
                    // Otherwise, update the left child to be the new employee and return
                    currNode.left = newEmployee;
                    return;
                }
            } else if (newEmployee.id > currNode.id) {
                // If we go right and there is a right child, update the current node to the right child
                if (currNode.right != null) {
                    currNode = currNode.right;
                } else {
                    // Otherwise, update the right child to be the new employee and return
                    currNode.right = newEmployee;
                    return;
                }
            } else {
                // if a match, send a message to the console and return
                System.out.println("This employee id already exists in the tree");
                return;
            }
        }
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

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }
}
