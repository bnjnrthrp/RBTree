public class Node implements TreeNode {

    int id;
    Indexable data;
    Node parent;
    Node left;
    Node right;
    boolean isBlack;

    /**
     * Constructor for the node, takes in the data object and initializes it as a black node with no children.
     * @param data the data to store in the node
     */
    public Node(Indexable data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.setColorRed();
    }

    /**
     * Creates a new node holding the data and then adds it to the tree. Recursively proceeds down
     * the left or right side depending on the data id comparison until it reaches a null child.
     * Then, the created node becomes the new leaf.
     *
     * @param data the data to add to the tree.
     */
    @Override
    public void add(Indexable data) {
        Node newNode = new Node(data);
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
    public void add(Node node) {

    }

    public Indexable find(int id){
        return null;
    }

    public Indexable remove(int id){
        return null;
    }

    public boolean isBlack(){
        return this.isBlack;
    }

    public void setColorBlack(){
        this.isBlack = true;
    }

    public void setColorRed(){
        this.isBlack = false;
    }
}
