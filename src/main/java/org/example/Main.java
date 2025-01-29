package org.example;

import org.example.Enums.Komanda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isActive = true;
        Library library = new Library();

        while (isActive){
            // - here should be library update from file.
            System.out.println("-".repeat(43));
            Komanda.printCommands();
            System.out.println("-".repeat(43));
            System.out.println("Input command:");
            switch (Komanda.ofKey(Integer.parseInt(sc.nextLine()))){
                case null -> System.out.println("ERROR: unknown command");
                case ADD_BOOK -> {
                }
                case SEARCH_BOOK -> {
                }
                case BORROW_BOOK -> {
                }
                case RETURN_BOOK -> {
                }
                case SAVE_TO_JSON -> {
                }
                case IMPORT_FROM_JSON -> {
                }
                case EXIT_PROGRAM -> {
                    // - here should be library update to file. (same file)
                    System.out.println("Program is closing...");
                    isActive = false;
                }
            }
        }
        sc.close();

    }
}