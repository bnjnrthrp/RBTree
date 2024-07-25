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
        Node currNode = this.root;
        // Traverse the tree, go left if id is less than the node, go right if greater than the current node
        // Return if matched
        while (currNode != null) {
            if (id == currNode.id) {
                return currNode.employee;
            } else if (id < currNode.id) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        return null;
    }

    /**
     * Removes an employee based off id from the tree hierarchy and returns it. If the id is not found,
     * returns null.
     *
     * @param id the id number of the employee to remove
     * @return the employee removed from the tree, null if not found
     */
    @Override
    public Employee remove(int id) {
        // Track the parent and current node
        Node parent = null;
        Node currNode = this.root;

        // Traverse the tree to the left or right, depending on the id, until we get a match
        while (currNode != null && currNode.id != id) {
            parent = currNode;
            if (id < currNode.id) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        // If not found, return null
        if (currNode == null) {
            return null;
        }

        // Determine how many children the matched node has and rearrange the subtree from that node due to that.
        // There are 3 cases: no children, 1 child, or 2 children

        // Case 1: No children
        if (currNode.left == null && currNode.right == null) {
            // If it was the root node and no children, make the root null and return
            if (currNode == this.root) {
                this.root = null;
            }
            // Otherwise, change the parent's left or right child to null, depending on the id
            else if (id < parent.id) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            decrementSize();
            return currNode.employee;
        }

        // Case 2: 1 Child
        if (currNode.left == null || currNode.right == null) {
            // Set child to the non-null child of currNode
            Node child = currNode.left != null ? currNode.left : currNode.right;

            // If removing the root, then make the root the remaining child
            if (currNode == this.root) {
                this.root = child;
            } else if (id < parent.id) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            decrementSize();
            return currNode.employee;
        }

        // Case 3: 2 children
        Node inOrderSuccessor = currNode.right;
        Node inOrderSuccessorParent = currNode;
        while (inOrderSuccessor != null){
            // Go as far down the left side of the right subtree
            inOrderSuccessorParent = inOrderSuccessor;
            inOrderSuccessor = inOrderSuccessor.left;
        }

        // Copy the data from the successor to the current node
        Employee deleted = currNode.employee;
        currNode.employee = inOrderSuccessor.employee;

        // Delete the successor node
        // Case 1: successor is the right child
        if (inOrderSuccessor == currNode.right){
            // Make the successor's right child the new right child
            currNode.right = inOrderSuccessor.right;
        }

        // Case 2: Successor is some left child all the way down
        // This could have either another node on the right side, which becomes the parent's new left child
        // Or it is null, and that parent's left child is now null
        else {
            inOrderSuccessorParent.left = inOrderSuccessor.right;
        }

        decrementSize();
        return deleted; // Return the deleted employee
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }
}
