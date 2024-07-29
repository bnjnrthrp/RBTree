public class Node implements TreeNode {

    int id;
    Student student;
    Node left;
    Node right;

    public Node(Student newStudent) {
        this.id = newStudent.getId();
        this.student = newStudent;
        this.left = null;
        this.right = null;
    }

    public Student getEmployee() {
        return this.student;
    }
}
