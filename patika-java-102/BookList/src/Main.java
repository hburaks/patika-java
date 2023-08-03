import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book 1", 120, "Author 1", "2020-01-01"));
        bookList.add(new Book("Book 2", 200, "Author 2", "2019-05-15"));
        bookList.add(new Book("Book 3", 80, "Author 3", "2022-03-10"));


        Map<String, String> titleAuthorMap = bookList.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getAuthor));

        System.out.println("Title - Author");
        for(String title : titleAuthorMap.keySet()){
            System.out.println(title + " - " + titleAuthorMap.get(title));
        }

        List<Book> filteredBooks = bookList.stream()
                .filter(book -> book.getPageCount() > 100)
                .collect(Collectors.toList());

        System.out.println("\nBooks with more than 100 pages:");
        filteredBooks.forEach(book -> System.out.println(book.getTitle()));
    }
}