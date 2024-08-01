import java.util.ArrayList;                 // import the ArrayList class

/**
 * This class represents a student, to provide a generic data object for use in the BST and RBT.
 *
 * It has a static counter to serve as the student id, their first and last name
 */

public class Student implements Comparable<Student>, Indexable {
    //////////////////////
    // ATTRIBUTES
    private static int studentIdCounter;           // static counter representing the number of students in the system
    private int id;                         // unique id for student
    private String first;                   // first name of the student
    private String last;                    // last name of the student
    private ArrayList<Book> books;          // current list of books they have checked out

    //////////////////////
    // CONSTRUCTOR
    /**
     * Constructor for Student
     * 
     * @param first the first name of the student
     * @param last the last name of the student
     */
    public Student(String first, String last){
        incrementId();                      // increment number of students created
        this.first = first;
        this.last = last;
        this.id = studentIdCounter;
        this.books = new ArrayList<Book>(); // creates an empty list of books they've checked out
    }

    //////////////////////
    // GETTERS
    /**
     * Gets the unique id of the student
     * 
     * @return the id of the student
     */
    public int getId(){
        return this.id;
    }

    /**
     * Gets the first name of the student
     * 
     * @return the first name of the student
     */
    public String getFirst(){
        return this.first;
    }

    /**
     * Gets the last name of the student
     * 
     * @return the last name of the student
     */
    public String getLast(){
        return this.last;
    }

    /**
     * Gets the list of books checked out by the student
     * 
     * @return the list of books
     */
    public ArrayList<Book> getBooks() {
        return this.books;
    }

   
    //////////////////////
    // METHODS
    /**
     * Adds a book to the student's checked out list
     * 
     * @param book the book to add
     */
    public void addBook(Book book){
        books.add(book);
    }

    /**
     * Removes a book from the student's checked out list
     * 
     * @param book the book to remove
     */
    public void removeBook(Book book){
        books.remove(book);
    }

    //////////////////////
    // HELPER METHODS
    private static void incrementId(){
        studentIdCounter++;
    }

    /**
     * resets the number of students 
     */
    public static void resetIdCounter(){
        studentIdCounter = 0;
    }

    /**
     * Compares this student with the specified student for order. Returns a
     * negative integer, zero, or a positive integer as this student is less
     * than, equal to, or greater than the specified student.
     * 
     * @param o the student to be compared
     * @return a negative integer, zero, or a positive integer as this student
     *         is less than, equal to, or greater than the specified student
     */
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }

    //////////////////////
    // PRINT
    /**
     * Returns a string representing the student
     * 
     * @return the string representing the student
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                          // set up a string builder

        
        sb.append(String.format("Student ID: %d\nFirst Name: %s\nLast Name: %s\n",  
                                  getId(), getFirst(), getLast()));                     // add student info to string

        if (books.size() == 0) {                                                        // if no books are checked out
            sb.append("Account has no books checked out\n");
        }

        else {                                                                          // if student has books checked out
            sb.append("Student Checkout List...\n");                                    // intitial checkout list header
            for (Book book: getBooks()) {                                                   // go through list of books
                sb.append(book.getTitle());                                                 // get the title of book and append
                sb.append("\n");                                                        // add newline
            }
        }

        return sb.toString();                                                           // return string builder
    }
}

