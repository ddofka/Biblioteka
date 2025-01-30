package org.example;

import org.example.Enums.Komanda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        boolean isActive = true;
        Library library = new Library();
        String initialLibrary = "biblioteka";
        library.loadFromFile(initialLibrary);

        while (isActive) {
            System.out.println("-".repeat(43));
            Komanda.printCommands();
            System.out.println("-".repeat(43));
            System.out.println("Input command:");
            switch (Komanda.ofKey(Integer.parseInt(sc.nextLine()))) {
                case ADD_BOOK -> {
                    while (true) {
                        System.out.println("--- RETURN TO MENU ENTER 'x': ");
                        System.out.println("Enter book title:");
                        String title = sc.nextLine();
                        if (title.equalsIgnoreCase("x")) {
                            break;
                        }
                        System.out.println("Enter book author:");
                        String author = sc.nextLine();
                        library.addBooks(new Library.Book(title, author));
                    }
                }
                case PRINT_LIBRARY -> library.listBooks();
                case SEARCH_BOOK -> {
                    System.out.println("Enter the book title to search:");
                    library.searchBooks(String.valueOf(sc.nextLine()));
                }
                case BORROW_BOOK -> {
                    System.out.println("Enter the complete book title to borrow:");
                    library.borrowBook(String.valueOf(sc.nextLine()));
                }
                case RETURN_BOOK -> {
                    System.out.println("Enter the complete book title to return:");
                    library.returnBook(String.valueOf(sc.nextLine()));
                }
                case SAVE_TO_JSON -> {
                    System.out.println("Enter filename to save as:");
                    try {
                        library.saveToFile(String.valueOf(sc.nextLine()));
                    } catch (InputMismatchException | FileNotFoundException e) {
                        System.out.println("ERROR: invalid filename format!");
                    }
                }
                case IMPORT_FROM_JSON -> {
                    System.out.println("Enter filename to load from:");
                    try {
                        library.loadFromFile(String.valueOf(sc.nextLine()));
                    } catch (InputMismatchException | FileNotFoundException e) {
                        System.out.println("ERROR: invalid filename format!");
                    }
                }
                case REMOVE_TITLE -> {
                    System.out.println("Enter book title to delete: ");
                    library.deleteBookByTitle(String.valueOf(sc.nextLine()));
                }
                case EXIT_PROGRAM -> {
                    library.saveToFile(initialLibrary);
                    System.out.println("Program is closing...");
                    isActive = false;
                }
                case null -> System.out.println("ERROR: unknown command");
            }
        }
        sc.close();

    }
}