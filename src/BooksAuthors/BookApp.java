package BooksAuthors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BookApp {
    private static final String FILE_NAME = "books.json";
    private static final Scanner scanner = new Scanner(System.in);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n📘 Book Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Show all books");
            System.out.println("3. Save to JSON");
            System.out.println("4. Load from JSON");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    books.add(addBook());
                    break;
                case 2:
                    showBooks(books);
                    break;
                case 3:
                    saveBooks(books);
                    break;
                case 4:
                    books = loadBooks();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static Book addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year published: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        return new Book(title, author, year);
    }

    private static void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("📭 No books yet.");
        } else {
            System.out.println("\n📚 Book List:");
            for (Book b : books) {
                System.out.println("- " + b.getTitle() + " by " + b.getAuthor() + " (" + b.getYearPublished() + ")");
            }
        }
    }

    private static void saveBooks(List<Book> books) {
        try {
            mapper.writeValue(new File(FILE_NAME), books);
            System.out.println("✅ Books saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Save error: " + e.getMessage());
        }
    }

    private static List<Book> loadBooks() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("⚠️ No saved file found.");
                return new ArrayList<>();
            }

            List<Book> books = mapper.readValue(file, new TypeReference<List<Book>>() {});
            System.out.println("✅ Loaded " + books.size() + " books.");
            return books;

        } catch (IOException e) {
            System.out.println("❌ Load error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
