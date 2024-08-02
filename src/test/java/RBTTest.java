import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.After;

public class RBTTest {
    RBT rbt;
    Student s1;
    Student s2;
    Student s3;
    Student s4;
    Student s5;

    @Before
    public void setUp() throws Exception {
        rbt = new RBT();
        s1 = new Student("Abby", "AlastName");
        s2 = new Student("Bobby", "BlastName");
        s3 = new Student("Charlie", "ClastName");
        s4 = new Student("Danielle", "DlastName");
        s5 = new Student("Evan", "ElastName");
    }

    @After
    public void cleanUp() {
        Student.resetIdCounter();
    }

    @Test
    public void getRoot() {
        rbt.add(s1);
        assertEquals(s1.getId(), rbt.getRoot().data.getId());
        assertTrue(rbt.getRoot().isBlack());
        rbt.printBFS();
        rbt.printInOrder();
    }

    @Test
    public void add() {
        rbt.add(s2);
        rbt.add(s1);
        rbt.add(s3);

        rbt.printBFS();
        // rbt.printInOrder();

        assertEquals(s2.getId(), rbt.getRoot().data.getId());
        assertEquals(s1.getId(), rbt.getRoot().left.data.getId());
        assertEquals(s3.getId(), rbt.getRoot().right.data.getId());
    }

    @Test
    public void find() {
        rbt.add(s1);
        rbt.add(s2);
        rbt.add(s3);

        assertEquals(s1, rbt.find(s1.getId()));
        assertEquals(s2, rbt.find(s2.getId()));
        assertEquals(s3, rbt.find(s3.getId()));
        assertNull(rbt.find(s4.getId()));
    }


    /**
     * s1(B)                            s2(B)
     *   \               rotation     /       \
     *     s2(R)            --->    s1(R)     s3(R)
     *        \
     *         s3(R)
     *
     *
     */
    @Test
    public void rotateLeft(){
        // Forces a rotation by adding to the right each time. End up with s2 as root, s1 and left child
        // (red) and s3 as right child(red)
        rbt.add(s1);
        rbt.add(s2);
        rbt.add(s3);

        assertEquals(s2, rbt.getRoot().data);
        assertTrue(rbt.getNode(s2).isBlack());
        assertEquals(s1, rbt.getRoot().left.data);
        assertFalse(rbt.getNode(s1).isBlack());
        assertEquals(s3, rbt.getRoot().right.data);
        assertFalse(rbt.getNode(s1).isBlack());
    }

    /**
     *          s3(B)                   s2(B)
     *         /         rotation     /       \
     *     s2(R)            --->    s1(R)     s3(R)
     *    /
     * s1(R)
     *
     *
     */
    @Test
    public void rotateRight(){
        // Forces a rotation by adding to the right each time. End up with s2 as root, s1 and left child
        // (red) and s3 as right child(red)
        rbt.add(s3);
        rbt.add(s2);
        rbt.add(s1);

        assertEquals(s2, rbt.getRoot().data);
        assertTrue(rbt.getNode(s2).isBlack());
        assertEquals(s1, rbt.getRoot().left.data);
        assertFalse(rbt.getNode(s1).isBlack());
        assertEquals(s3, rbt.getRoot().right.data);
        assertFalse(rbt.getNode(s1).isBlack());
    }

    @Test
    public void testRemoveLeafNode() {
        rbt.add(s1);
        rbt.add(s2);
        rbt.add(s3);

        // remove leaf node s3
        rbt.remove(s3.getId());

        assertNull(rbt.find(s3.getId()));
        assertNotNull(rbt.find(s1.getId()));
        assertNotNull(rbt.find(s2.getId()));
    }

    @Test
    public void testRemoveNodeWithOneChild() {
        rbt.add(s1);
        rbt.add(s2);
        rbt.add(s3);
        rbt.add(s4); // s3 has one child

        // remove node s2 with one child
        rbt.remove(s2.getId());

        assertNull(rbt.find(s2.getId()));
        assertNotNull(rbt.find(s1.getId()));
        assertNotNull(rbt.find(s3.getId()));
        assertNotNull(rbt.find(s4.getId()));
    }

    @Test
    public void testRemoveNodeWithTwoChildren() {
        rbt.add(s1);
        rbt.add(s2);
        rbt.add(s3);
        rbt.add(s4);
        rbt.add(s5); // s2 has two children

        // remove node s2 with two children
        rbt.remove(s2.getId());

        assertNull(rbt.find(s2.getId()));
        assertNotNull(rbt.find(s1.getId()));
        assertNotNull(rbt.find(s3.getId()));
        assertNotNull(rbt.find(s4.getId()));
        assertNotNull(rbt.find(s5.getId()));
    }
}