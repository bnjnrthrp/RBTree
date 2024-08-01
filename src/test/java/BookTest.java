import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;

public class BookTest {
    private Book book1;
    private Book book2;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        book2 = new Book("Clean Code", "Robert C. Martin", "9780132350884");
    }

    /**
     * reset book count after each test
     */
    @After
    public void cleanUp() {
        Book.resetIdCounter();
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Effective Java", book1.getTitle());
        assertEquals("Joshua Bloch", book1.getAuthor());
        assertEquals("9780134685991", book1.getISBN());
        assertEquals(Status.AVAILABLE, book1.getStatus());
        assertEquals(1, book1.getId());  // Assuming book1 is the first book created
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidISBN() {
        new Book("Invalid Book", "Invalid Author", "12345");
    }

    @Test
    public void testSetStatus() {
        book1.setStatus(Status.UNAVAILABLE);
        assertEquals(Status.UNAVAILABLE, book1.getStatus());
    }

    @Test
    public void testCheckout() {
        book1.checkout();
        assertEquals(Status.UNAVAILABLE, book1.getStatus());

        // Try to checkout an already checked-out book
        book1.checkout();
        assertEquals(Status.UNAVAILABLE, book1.getStatus());
    }

    @Test
    public void testCheckin() {
        book1.checkout();
        book1.checkin();
        assertEquals(Status.AVAILABLE, book1.getStatus());

        // Try to check in an already checked-in book
        book1.checkin();
        assertEquals(Status.AVAILABLE, book1.getStatus());
    }

    @Test
    public void testCompareTo() {
        assertTrue(book1.compareTo(book2) < 0);  // Assuming book1 was created before book2
    }

    @Test
    public void testToString() {
        assertEquals("Title: Effective Java\nAuthor: Joshua Bloch\nISBN: 9780134685991\nStatus: AVAILABLE\n", book1.toString());
    }
}
