package BooksAuthors;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class BookWriter {
    public static void main(String[] args) {
        Book book =new Book("The Alchemist", "Paulo Coehlo", 1988);

        ObjectMapper mapper = new ObjectMapper();

        try{
            mapper.writeValue(new File("book.json"), book);
            System.out.println("Book saved to book.json");
        } catch (IOException e) {
            System.out.println("Error..." + e.getMessage());
        }
    }
}
