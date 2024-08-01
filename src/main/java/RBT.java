import java.util.LinkedList;
import java.util.Queue;

public class RBT implements Tree{

    private Node root;
    private int size;

    public RBT(){
        this.root = null;
        this.size = 0;
    }

    /**
     * Getter for the root node of this RB Tree
     * @return A node of the type
     */
    public Node getRoot(){
        return this.root;
    }

    /**
     * Adds an employee to the existing tree hierarchy. Takes a pre-made employee and then creates a
     * Node with will contain the employee. Then adds the Node to the tree and puts it in its proper
     * place.
     *
     * @param data the data to add to the tree.
     */
    @Override
    public void add(Indexable data) {
          // Start at the root and travel left or right until reaching null
        Node currNode = this.root;
        Node parent = null;

        while (currNode != null){
            parent = currNode;
            if (data.getId() == currNode.data.getId()){
                System.out.println("This data is already in the tree");
            } else if (data.getId() < currNode.data.getId()){
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }

        // Once at null, create the new node and set its parent to currNode, and determine if
        // its the left or right child of the parent.
        Node newNode = new Node(data); // New nodes are always red
        newNode.parent = parent;

        if (parent == null){
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
//        fixAfterInsert(newNode);
    }

    private void fixAfterInsert(Node node){
        Node parent = node.parent;

        // Case 1: Parent is null, because the node is the root. Early return, nothing to fix
        if (parent == null){
            return;
        }

        // Case 2: Parent node is black, nothing to fix, early return.
        if (parent.isBlack()){
            return;
        }

        // Parent is red, so we determine how to adjust
        Node grandparent = parent.parent;
        // Get the uncle
        Node uncle;
        if (grandparent.left == parent){
            uncle = grandparent.right;
        } else {
            uncle = grandparent.left;
        }

        // Case 3: Uncle is a red, so recolor the parent, grandparent, and uncle
        if (uncle != null && !uncle.isBlack()){
            parent.setColorBlack();
            grandparent.setColorRed();
            uncle.setColorBlack();

            // Since we changed the grandparent from black to red, we recursively continue the fix upwards until
            // we reach case 1 or case 2.
            fixAfterInsert(grandparent);
        }
        // Case 4: Uncle is Black or Null
        else if (parent == grandparent.left){
            // Case 4a: Node is the right child of parent, and parent is left child of grandparent.
            // Rotate to the left
            if (node == parent.right){
                rotateLeft(parent);
            }
        }
    }

    private void rotateLeft(Node node){
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        // if node.right.left is null, nothing will change, but if
        // there is a node, then update its parent to the current node.
        if (rightChild.left != null){
            rightChild.left.parent = node;
        }

        // Swap the positions of the node and child so that the child becomes the parent of node.
        rightChild.left = node;
        node.parent = rightChild;

        // reset the original parent's child so that it is now the right child
        resetParent(parent, node, rightChild);
    }

    private void rotateRight(Node node){
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        // if node.left.right is null, nothing will change, but if
        // there is a node, then update its parent to the current node.
        if (leftChild.right != null){
            leftChild.right.parent = node;
        }

        // Swap the positions of the node and child so that the child becomes the parent of node.
        leftChild.right = node;
        node.parent = leftChild;

        // reset the original parent's child so that it is now the left child
        resetParent(parent, node, leftChild);
    }

    private void resetParent(Node parent, Node oldChild, Node newChild){
        // If the parent is null, we rotated the root. Set root to the new child
        if (parent == null){
            this.root = newChild;
        } else if (parent.left == oldChild){
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }

        // Incase we are reseting for a deleted node and new child is null
        if (newChild != null){
            newChild.parent = parent;
        }
    }

    /**
     * Searches for a piece
     *
     * @param id the unique key associated with a piece of data
     * @return the data, if found. Otherwise, null.
     */
    @Override
    public Indexable find(int id) {
        // Start at the root
        Node currNode = this.root;

        // Iterate while the current node isn't null
        while (currNode != null){
            if (id == currNode.data.getId()){
                return currNode.data;
            } else if (id < currNode.data.getId()){
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        // If we get to null, it doesn't exist
        return null;
    }

    public Indexable find(Indexable data){
        return find(data.getId());
    }

    /**
     * Removes an employee based off id from the tree hierarchy and returns it. If the id is not found,
     * returns null.
     *
     * @param id the id number of the data to remove
     * @return the data removed from the tree
     */
    @Override
    public Indexable remove(int id) {
        return null;
    }

    /**
     * Does an in-order traversal to print a RB Tree
     */
    @Override
    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(Node node){
        if (node != null){
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
        if (this.root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.println(curr);

            if (curr.left != null){
                queue.add(curr.left);
            }
            if (curr.right != null){
                queue.add(curr.right);
            }
        }
    }
}
