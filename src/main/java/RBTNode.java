public class RBTNode extends Node implements TreeNode{
    /**
     * The RBTNode inherits the following attributes from Node:
     *     private int id;
     *     private Employee employee;
     *     private TreeNode left;
     *     private TreeNode right;
     *
     * Methods:
     *      public void add(Employee employee)
     *      public void add(TreeNode node)
     *      public void remove(int id)
     *      public void search(int id)
     *
     * The main difference is the RBTNode adds another attribute: color. This will help
     * with maintaining the balance
     */
    private TreeNode parent;
    private boolean isBlack;

    /**
     * Constructor for a RBT Node. Sets the color attribute as required when inserting a node
     * into the tree
     * @param student
     */
    public RBTNode(Student student){
        super(student);
    }

}
