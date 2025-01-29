package org.example;

public class Library {

    private static class Book {
        private String title;
        private String author;
        private boolean isAvailable;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public void markAsBorrowed() {this.isAvailable = false;}
        public void markAsReturned() {this.isAvailable = true;}

        @Override
        public String toString() {
            return title + " by " + author + (isAvailable ? " (available)" : " (Borrowed)");
        }
    }

    void addBooks(Book...books){

    }
    void listBooks(){

    }
    void searchBooks(String title){

    }
    void borrowBook(String title){

    }
    void returnBook(String title){

    }
    void saveToFile(String filename){

    }
    void loadFromFile(String filename){

    }

}
