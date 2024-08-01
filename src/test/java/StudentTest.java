import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class StudentTest {
    Student s1;
    Student s2;
    Student s3;
    Student s4;
    Book book1;
    Book book2;

    @Before
    public void setUp() throws Exception {
        Student.resetIdCounter();  // Reset the static counter before each test
        s1 = new Student("Abby", "AlastName");
        s2 = new Student("Bobby", "BlastName");
        s3 = new Student("Charlie", "ClastName");
        s4 = new Student("Danielle", "DlastName");

        // Initialize some books
        book1 = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        book2 = new Book("Clean Code", "Robert C. Martin", "9780132350884");
    }

    @After
    public void cleanUp() {
        Student.resetIdCounter();
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Abby", s1.getFirst());
        assertEquals("AlastName", s1.getLast());
        assertEquals(1, s1.getId()); 

        assertEquals("Bobby", s2.getFirst());
        assertEquals("BlastName", s2.getLast());
        assertEquals(2, s2.getId()); 
    }

    @Test
    public void testAddBook() {
        s1.addBook(book1);
        assertEquals(1, s1.getBooks().size());
        assertEquals(book1, s1.getBooks().get(0));

        s1.addBook(book2);
        assertEquals(2, s1.getBooks().size());
        assertEquals(book2, s1.getBooks().get(1));
    }

    @Test
    public void testRemoveBook() {
        s1.addBook(book1);
        s1.addBook(book2);
        assertEquals(2, s1.getBooks().size());

        s1.removeBook(book1);
        assertEquals(1, s1.getBooks().size());
        assertEquals(book2, s1.getBooks().get(0));

        s1.removeBook(book2);
        assertEquals(0, s1.getBooks().size());
    }

    @Test
    public void testCompareTo() {
        assertTrue(s1.compareTo(s2) < 0);  // Assuming s1 was created before s2
    }

    @Test
    public void testToString() {
        s1.addBook(book1);
        s1.addBook(book2);
        assertEquals("Student ID: 1\nFirst Name: Abby\nLast Name: AlastName\nStudent Checkout List...\nEffective Java\nClean Code\n", s1.toString());
    }

    @Test
    public void testToStringNoBooks() {
        assertEquals("Student ID: 1\nFirst Name: Abby\nLast Name: AlastName\nAccount has no books checked out\n", s1.toString());
    }
}
