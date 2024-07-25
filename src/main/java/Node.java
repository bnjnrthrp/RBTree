public class Node implements TreeNode {

    int id;
    Employee employee;
    Node left;
    Node right;

    public Node(Employee newEmployee) {
        this.id = newEmployee.getId();
        this.employee = newEmployee;
        this.left = null;
        this.right = null;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
