import java.util.LinkedList;
import java.util.Queue;

public class RBT implements Tree {
    //////////////////////
    // ATTRIBUTES
    private Node root;
    private int size;

    //////////////////////
    // CONSTRUCTORS
    public RBT() {
        this.root = null;
        this.size = 0;
    }

    //////////////////////
    // GETTERS
    /**
     * Getter for the root node of this RB Tree
     *
     * @return A node of the type
     */
    public Node getRoot() {
        return this.root;
    }

    //////////////////////
    // METHODS
    /**
     * Adds an object to the existing tree hierarchy. Takes a pre-made object and then creates a
     * Node with will contain the object. Then adds the Node to the tree and puts it in its proper
     * place.
     *
     * @param data the data to add to the tree.
     */
    @Override
    public void add(Indexable data) {
        // Start at the root and travel left or right until reaching null
        Node currNode = this.root;
        Node parent = null;

        while (currNode != null) {
            parent = currNode;
            if (data.getId() == currNode.data.getId()) {
                System.out.println("This data is already in the tree");
            } else if (data.getId() < currNode.data.getId()) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }

        // Once at null, create the new node and set its parent to currNode, and determine if
        // its the left or right child of the parent.
        Node newNode = new Node(data); // New nodes are always red
        newNode.parent = parent;

        if (parent == null) {
            this.root = newNode;
            newNode.setColorBlack(); // Root is always black
        } else if (newNode.data.getId() < parent.data.getId()) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        // Set the parent of the now-inserted node.
        newNode.parent = parent;

        // Rebalance the tree after inserting a node
        fixAfterInsert(newNode);
    }

    private void fixAfterInsert(Node node) {
        Node parent = node.parent;

        // Case 1: Parent is null, because the node is the root. Early return, nothing to fix
        if (parent == null) {
            return;
        }

        // Case 2: Parent node is black, nothing to fix, early return.
        if (parent.isBlack()) {
            return;
        }

        // Parent is red, so we determine how to adjust
        Node grandparent = parent.parent;
        // Get the uncle
        Node uncle;
        if (grandparent.left == parent) {
            uncle = grandparent.right;
        } else {
            uncle = grandparent.left;
        }

        // Case 3: Uncle is a red, so recolor the parent, grandparent, and uncle
        if (uncle != null && !uncle.isBlack()) {
            parent.setColorBlack();
            grandparent.setColorRed();
            uncle.setColorBlack();

            // Since we changed the grandparent from black to red, we recursively continue the fix upwards until
            // we reach case 1 or case 2.
            fixAfterInsert(grandparent);
        }
        // Case 4: Uncle is Black or Null
        else if (parent == grandparent.left) {
            // Case 4a: Node is the right child of parent, and parent is left child of grandparent.
            // Rotate to the left
            if (node == parent.right) {
                rotateLeft(parent);
                parent = node;
            }

            // Case 5a: Node is the left child of parent, parent left child of grandparent
            rotateRight(grandparent);

            parent.setColorBlack();
            grandparent.setColorRed();
        } else {
            // Case 4b: Opposite of 4a - node is the left child of parent, parent is right child of grandparent
            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }
            rotateLeft(grandparent);
            // Reset colors
            parent.setColorBlack();
            grandparent.setColorRed();
        }
    }

    //////////////////////
    // ROTATE
    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        // if node.right.left is null, nothing will change, but if
        // there is a node, then update its parent to the current node.
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        // Swap the positions of the node and child so that the child becomes the parent of node.
        rightChild.left = node;
        node.parent = rightChild;

        // reset the original parent's child so that it is now the right child
        resetParent(parent, node, rightChild);
    }

    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        // if node.left.right is null, nothing will change, but if
        // there is a node, then update its parent to the current node.
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        // Swap the positions of the node and child so that the child becomes the parent of node.
        leftChild.right = node;
        node.parent = leftChild;

        // reset the original parent's child so that it is now the left child
        resetParent(parent, node, leftChild);
    }

    //////////////////////
    // FIND
    /**
     * Searches data
     *
     * @param id the unique key associated with a piece of data
     * @return the data, if found. Otherwise, null.
     */
    @Override
    public Indexable find(int id) {
        // Start at the root
        Node currNode = this.root;

        // Iterate while the current node isn't null
        while (currNode != null) {
            if (id == currNode.data.getId()) {
                return currNode.data;
            } else if (id < currNode.data.getId()) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        // If we get to null, it doesn't exist
        return null;
    }

    public Indexable find(Indexable data) {
        return find(data.getId());
    }

    //////////////////////
    // GET
    /**
     * Returns the node that contains the data provided
     * 
     * @param data the data to search for
     * @return the node that contains the data
     */
    public Node getNode(Indexable data){
        // Pulls the id from the data and searches for the node
        return getNode(data.getId());
    }

    /**
     * Returns the node that contains the data provided
     * 
     * @param id the id to search for
     * @return the node that contains the data
     */
    public Node getNode(int id){
        Node currNode = this.root;

        while (currNode != null){
            if (id == currNode.data.getId()){
                return currNode;
            } else if (id < currNode.data.getId()){
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        return null;
    }

    //////////////////////
    // REMOVE
    /**
     * Removes a node by its id from the tree
     *
     * @param id the id of data to be removed
     * @return data removed from the tree
     */
    @Override
    public Indexable remove(int id) {
        Node node = getNode(id);            // find the node to remove
        if (node == null) {                 // node doesn't exist
            return null;                    // return null
        }

        Node toRemove = node;               // variable for node to be removed
        Node child, parent;                 // variable for child and parent
        boolean color;                      // variable bool for color

        // Determine the node to actually remove, node or successors
        if (node.left == null || node.right == null) {  
            toRemove = node;                    // node has at most one child
        } 
        else {                                  // node has two children
            toRemove = successor(node);         // find the successor
        }

        // the child node to replace the removed node
        child = (toRemove.left != null) ? toRemove.left : toRemove.right;

        parent = toRemove.parent;            // get parent of node to be removed
        color = toRemove.isBlack;            // store color of node to be removed

        // the parent
        if (child != null) {                // if child isn't null
            child.parent = parent;          // set parent of child to parent
        }

        if (parent == null) {               // if removing the root node 
            this.root = child;                  // update the root reference
        } else if (toRemove == parent.left) {   
            parent.left = child;                // replace the left child reference
        } else {
            parent.right = child;               // replace the right child reference
        }

        if (toRemove != node) {             // if we're not removing the node itself
            node.data = toRemove.data;          // copy the data from the successor to the node
        }
        
        if (color) {                        // if the removed node was black
            fixAfterRemove(child, parent);      // fix the tree
        }

        size--;                             // decrease tree size
        return node.data;
    }

    /**
     * Fixes the tree after a removal
     *
     * @param node node replacing the removed node
     * @param parent parent of the node
     */
    private void fixAfterRemove(Node node, Node parent) {
        while (node != this.root && (node == null || node.isBlack)) {
            if (node == parent.left) {
                Node sibling = parent.right;        // set sibling to parent right

                // CASE 1: Sibling is red
                if (!sibling.isBlack) {
                    sibling.setColorBlack();        // sibling color to black
                    parent.setColorRed();           // parent color to red
                    rotateLeft(parent);             // rotate left around parent
                    sibling = parent.right;         // update sibling
                }

                // CASE 2: Sibling is black with two black children
                if ((sibling.left == null || sibling.left.isBlack) && 
                    (sibling.right == null || sibling.right.isBlack)) {
                    sibling.setColorRed();         // sibling color to red
                    node = parent;                  // node is now the parent
                    parent = node.parent;           // update parent
                } 

                else {
                    // CASE 3: Sibling is black with a red left child and black right child
                    if (sibling.right == null || sibling.right.isBlack) {
                        sibling.left.setColorBlack();   // set left of sibling to black
                        sibling.setColorRed();          // set sibling to red
                        rotateRight(sibling);           // rotate right around sibling
                        sibling = parent.right;         // update sibling
                    }

                    // CASE 4: Sibling is black with a red right child
                    sibling.isBlack = parent.isBlack;   // set sibling to parent color
                    parent.setColorBlack();             // set parent to black
                    if (sibling.right != null) {        // if sibling right exists
                        sibling.right.setColorBlack();      // set sibling right color to black
                    }

                    rotateLeft(parent);                 // rotate left around the parent
                    node = this.root;                   // update node to root
                    break;                              // end loop
                }
            } 
            else {
                Node sibling = parent.left;             // sibling set to parent left

                // CASE 1: Sibling is red
                if (!sibling.isBlack) {                 
                    sibling.setColorBlack();            // set sibling color to black
                    parent.setColorRed();               // set parent color to red
                    rotateRight(parent);                // rotate right around the parent
                    sibling = parent.left;              // update sibling
                }

                // CASE 2: Sibling is black with two black children
                if ((sibling.left == null || sibling.left.isBlack) && 
                    (sibling.right == null || sibling.right.isBlack)) {
                    sibling.setColorRed();              // set sibling color to red
                    node = parent;                      // update node
                    parent = node.parent;               // update parent
                } 
                else {
                    // CASE 3: Sibling is black with a red right child and black left child
                    if (sibling.left == null || sibling.left.isBlack) {
                        sibling.right.setColorBlack();  // set right child of sibling to black
                        sibling.setColorRed();          // set sibling color to red
                        rotateLeft(sibling);            // rotate left around sibling
                        sibling = parent.left;          // update sibling
                    }

                    // CASE 4: Sibling is black with a red left child
                    sibling.isBlack = parent.isBlack;   // set sibling color to parent color
                    parent.setColorBlack();             // set parent color to black
                    if (sibling.left != null) {         // if sibling left exists
                        sibling.left.setColorBlack();       // set sibling left color to black
                    }

                    rotateRight(parent);                // rotate right around parent
                    node = this.root;                   // update node to root
                    break;                              // end loop
                }
            }
        }

        if (node != null) {                             // if node is not null
            node.setColorBlack();                           // set color to black
        }
    }

    //////////////////////
    // HELPER METHODS
    private void resetParent(Node parent, Node oldChild, Node newChild) {
        // If the parent is null, we rotated the root. Set root to the new child
        if (parent == null) {
            this.root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }

        // Incase we are reseting for a deleted node and new child is null
        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    /**
     * Finds the in-order successor of the given node (node with the smallest key)
     *
     * @param node the node for which to find the successor
     * @return the successor node
     */
    private Node successor(Node node) {
        if (node.right != null) {                       // if the right node exists
            return findMinimum(node.right);             // find the minimum
        }

        Node parent = node.parent;                      // set parent as the parent of the node
        while (parent != null && node == parent.right) {    // traverse through tree until a node is found that's left of its parent
            node = parent;                                      // move up in the tree
            parent = parent.parent;                             // move up in the tree
        }

        return parent;                                  // return the parent
    }

    /**
     * Finds the minimum node in the subtree rooted at a given node
     *
     * @param node root of the subtree
     * @return minimum node in the subtree
     */
    private Node findMinimum(Node node) {
        while (node.left != null) {         // while left node is not null
            node = node.left;               // move to left node
        }
        return node;                        // return node
    }

    //////////////////////
    // PRINT
    /**
     * Does an in-order traversal to print a RB Tree
     */
    @Override
    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            // Example output: id: 14 [B]
            System.out.print(node);
            printInOrder(node.right);
        }
    }

    /**
     * Prints the tree using a breadth first traversal
     */
    @Override
    public void printBFS() {
        if (this.root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr);

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
