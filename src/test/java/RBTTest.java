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
        s1 = new Student("Abby", "AlastName");
        s2 = new Student("Bobby", "BlastName");
        s3 = new Student("Charlie", "ClastName");
        s4 = new Student("Danielle", "DlastName");
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

    @Test
    public void remove() {
    }
}