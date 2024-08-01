/**
 * This class represents an employee, to provide a generic data object for use in the BST and RBT.
 *
 * It has a static counter to serve as the employee id, their first and last name, and a boolean for
 * whether they are full time.
 */

public class Student extends Indexable implements Comparable<Student> {
    private static int idCounter;
//    private int id;
    private String first;
    private String last;
    private RBT books;

    public Student(String first, String last, boolean fullTime){
        this.first = first;
        this.last = last;
        this.id = idCounter;
        incrementId();
        this.books = new RBT();
    }

    private static void incrementId(){
        idCounter++;
    }

    public void addBook(Book book){
        books.add(book);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}

