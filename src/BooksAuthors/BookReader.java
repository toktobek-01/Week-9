package BooksAuthors;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class BookReader {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Book book = mapper.readValue(new File("book.json"), Book.class);

            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Year: " + book.getYearPublished());
        } catch (IOException e) {
            System.out.println("Error reading file..." + e.getMessage());
        }
    }
}
