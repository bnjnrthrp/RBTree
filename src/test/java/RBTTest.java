import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

public class RBTTest {
    RBT rbt;
    Student s1;
    Student s2;
    Student s3;
    Student s4;
    @Before
    public void setUp() throws Exception {
        rbt = new RBT();
        s1 = new Student("Abby", "AlastName", true);
        s2 = new Student("Bobby", "BlastName", true);
        s3 = new Student("Charlie", "ClastName", true);
        s4 = new Student("Danielle", "DlastName", true);
    }

    @Test
    public void getRoot() {
        rbt.add(s1);
        assertEquals(0, rbt.getRoot().data.getId());
        assertEquals(true, rbt.getRoot().isBlack());
        rbt.printBFS();
        rbt.printInOrder();
    }

    @Test
    public void add() {
        rbt.add(s2);
        rbt.add(s1);
        rbt.add(s3);

        rbt.printBFS();
//        rbt.printInOrder();

        assertEquals(1, rbt.getRoot().data.getId());
        assertEquals(0, rbt.getRoot().left.data.getId());
        assertEquals(2, rbt.getRoot().right.data.getId());

    }

    @Test
    public void find() {
    }

    @Test
    public void remove() {
    }
}