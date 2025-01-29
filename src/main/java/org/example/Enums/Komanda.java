package org.example.Enums;

public enum Komanda {
    ADD_BOOK(1,"[1] - add book to the library"),
    SEARCH_BOOK(2,"[2] - search for the book"),
    BORROW_BOOK(3,"[3] - borrow the book"),
    RETURN_BOOK(4,"[4] - return the book"),
    SAVE_TO_JSON(5,"[5] - save library to file"),
    IMPORT_FROM_JSON(7,"[7] - import library status JSON file"),
    EXIT_PROGRAM(9,"[9] - exit program");

    private int key;
    private String description;

    Komanda(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public static void printCommands(){
        for (Komanda c: Komanda.values()){
            System.out.printf("| %-40s|%n",c.getDescription());
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
