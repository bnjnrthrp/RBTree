public class RBT<T> implements Tree<T>{

    private RBTNode root;
    private int size;

    public RBT(){

    }

    /**
     * Adds an employee to the existing tree hierarchy. Takes a pre-made employee and then creates a
     * Node with will contain the employee. Then adds the Node to the tree and puts it in its proper
     * place.
     *
     * @param data the data to add to the tree.
     */
    @Override
    public void add(T data) {

    }

    /**
     * Searches for a piece
     *
     * @param id the unique key associated with a piece of data
     * @return the data, if found. Otherwise null.
     */
    @Override
    public T find(int id) {
        return null;
    }

    /**
     * Removes an employee based off id from the tree hierarchy and returns it. If the id is not found,
     * returns null.
     *
     * @param id the id number of the data to remove
     * @return the data removed from the tree
     */
    @Override
    public T remove(int id) {
        return null;
    }
}
