package org.example.Enums;

public enum Komanda {
    ADD_BOOK(1,"[1] - add book('s) to the library"),
    PRINT_LIBRARY(2,"[2] - print library books"),
    SEARCH_BOOK(3,"[3] - search for the book"),
    BORROW_BOOK(4,"[4] - borrow the book"),
    RETURN_BOOK(5,"[5] - return the book"),
    SAVE_TO_JSON(6,"[6] - save library to file"),
    IMPORT_FROM_JSON(7,"[7] - import book library from [.JSON] file"),
    REMOVE_TITLE(8,"[8] - remove book by title"),
    EXIT_PROGRAM(9,"[9] - exit program");

    private int key;
    private String description;

    Komanda(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public static void printCommands(){
        for (Komanda c: Komanda.values()){
            System.out.printf("| %-45s|%n",c.getDescription());
        }
    }

    public static Komanda ofKey(int key){
        for (Komanda c: Komanda.values()){
            if (c.getKey() == key){
                return c;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
