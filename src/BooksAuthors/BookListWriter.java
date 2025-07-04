package BooksAuthors;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BookListWriter {
    public static void main(String[] args) {
        List<Book> booklist = new ArrayList<>();
        booklist.add(new Book("Alchemist", "Paulo Coehlo", 1988));
        booklist.add(new Book("1984", "George Orwell", 1949));
        booklist.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("books.json"), booklist);
            System.out.println("Booklist saved to book.json");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
