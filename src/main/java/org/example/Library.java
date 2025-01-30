package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> bookList = new ArrayList<>();

    static class Book {
        private String title;
        private String author;
        private boolean isAvailable = true;

        public Book() {
        }

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public void markAsBorrowed() {
            this.isAvailable = false;
        }

        public void markAsReturned() {
            this.isAvailable = true;
        }

        @Override
        public String toString() {
            return title + " by " + author + (isAvailable ? " (available)" : " (Borrowed)");
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }
    }

    void addBooks(Book... books) {
        for (Book book : books) {
            bookList.add(book);
            System.out.println("Book '" + book.getTitle() + "' was added.");
        }
    }

    void listBooks() {
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    void searchBooks(String title) {
        List<Book> booksFound = new ArrayList<>();
        for (Book book : bookList) {
            String titleLoweredCase = book.getTitle().toLowerCase();
            if (titleLoweredCase.contains(title.toLowerCase())) {
                booksFound.add(book);
            }
        }
        if (booksFound.isEmpty()) {
            System.out.println("There is no book by the title: " + "[" + title + "]");
        } else {
            System.out.println("Books found by given title: " + "[" + title + "]");
            System.out.println("-".repeat(15));
            booksFound.forEach(System.out::println);
        }
    }

    void deleteBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book + " - deleted.");
                bookList.remove(book);
                return;
            }
        }
        System.out.println("There is no book by the title: " + "[" + title + "]");
    }

    void borrowBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.markAsBorrowed();
                System.out.println(book);
                return;
            }
        }
        System.out.println("There is no book by this title: " + "[" + title + "]");
    }

    void returnBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.markAsReturned();
                System.out.println(book);
                return;
            }
        }
        System.out.println("There is no book by this title: " + "[" + title + "]");
    }

    void saveToFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder("src/main/java/org/example/");
        sb.append(filename);
        sb.append(".json");
        String parseFileName = sb.toString();
        File file = new File(parseFileName);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(file, bookList);
        System.out.println("Writing to file was successful!");
    }

    void loadFromFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder("src/main/java/org/example/");
        sb.append(filename);
        sb.append(".json");
        String parseFileName = sb.toString();
        File file = new File(parseFileName);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Book> fromJson = mapper.readValue(file, new TypeReference<List<Book>>() {
        });
        bookList.clear();
        bookList.addAll(fromJson);
        System.out.println("Loading from file was successful!");
    }

}
