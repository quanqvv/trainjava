package train.Ex8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Test {

    public static void main(String[] args) {
        // Create instances of FileOutputStream and ObjectOutputStream.
        try (FileOutputStream fos = new FileOutputStream("books.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // Create a Book instance. This book object then will be stored in
            // the file.
            Book book = new Book("0-07-222565-3", "Hacking Exposed J2EE & Java",
                    "Art Taylor, Brian Buege, Randy Layman");
            // By using writeObject() method of the ObjectOutputStream we can
            // make the book object persistent on the books.dat file.
            oos.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // We have the book saved. Now it is time to read it back and display
        // its detail information.
        try (FileInputStream fis = new FileInputStream("books.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // To read the Book object use the ObjectInputStream.readObject() method.
            // This method return Object type data so we need to cast it back the its
            // origin class, the Book class.
            Book book = (Book) ois.readObject();
            System.out.println(book.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// The book object will be saved using ObjectOutputStream class and to be read
// back using ObjectInputStream class. To enable an object to be written to a
// stream we need to make the class implements the Serializable interface.
class Book implements Serializable {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

