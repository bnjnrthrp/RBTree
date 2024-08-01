/**
 * This class represents a book, including title, author, ISBN, and unique id
 */
public class Book implements Comparable<Book> {
    //////////////////////
    // ATTRIBUTES
    private static int bookIdCounter;   // static counter representing the number of books in the system
    private final String title;     // the title of the book
    private final String author;    // author of the book
    private final String ISBN;      // ISBN is a 13-digit identifier of the book
    private int id;                 // unique copy id of the particular book copy
    private Status status;          // the status of the book (available or unavailable)

    //////////////////////
    // CONSTRUCTORS
    /**
     * Constructor without unique id
     * 
     * @param title the title of the book
     * @param author the author of the book
     * @param ISBN the 13-digit ISBN of the book
     */
    public Book(String title, String author, String ISBN) {
        if (ISBN.length() != 13 || !ISBN.matches("\\d+")) {
            throw new IllegalArgumentException(title + " ISBN must be a 13-digit number");
        }
        
        incrementId();  // increment number of books created

        this.status = Status.AVAILABLE;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.id = bookIdCounter;
    }

    //////////////////////
    // GETTERS
    /**
     * Gets the title of the book
     * 
     * @return the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the author of the book
     * 
     * @return the author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Gets the ISBN of the book
     * 
     * @return the ISBN of the book
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * Gets the unique id of the book copy
     * 
     * @return the id of the book copy
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the status of the book
     * 
     * @return the status of the book
     */
    public Status getStatus() {
        return this.status;
    }

    //////////////////////
    // SETTERS
    /**
     * Sets the status of the book
     * 
     * @param status the new status of the book
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    //////////////////////
    // METHODS
    /**
     * Checks out the book if it is available
     */
    public void checkout() {
        if (this.status == Status.UNAVAILABLE) {
            System.out.println("Error: The book is already checked out.");
        } else {
            setStatus(Status.UNAVAILABLE);
        }
    }

    /**
     * Checks in the book if it is unavailable
     */
    public void checkin() {
        if (this.status == Status.AVAILABLE) {
            System.out.println("Error: The book is already checked in.");
        } else {
            setStatus(Status.AVAILABLE);
        }
    }

    //////////////////////
    // HELPER METHODS
    private static void incrementId() {
        bookIdCounter++;
    }

    /**
     * resets the number of books 
     */
    public static void resetIdCounter(){
        bookIdCounter = 0;
    }

    //////////////////////
    // COMPARABLE IMPLEMENTATION
    /**
     * Compares this book with the specified book for order. Returns a
     * negative integer, zero, or a positive integer as this book is less
     * than, equal to, or greater than the specified book.
     * 
     * @param o the book to be compared
     * @return a negative integer, zero, or a positive integer as this book
     *         is less than, equal to, or greater than the specified book
     */
    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.id, o.id);
    }

    //////////////////////
    // PRINT
    /**
     * Returns a string representing the book
     * 
     * @return the string representing the book
     */
    @Override
    public String toString() {
        return String.format("Title: %s\nAuthor: %s\nISBN: %s\nStatus: %s\n", 
                    getTitle(), getAuthor(), getISBN(), getStatus());
    }
}
