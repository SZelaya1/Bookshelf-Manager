package org.example.bookshelfmanagement.books;

public abstract class NonFictionBook extends BookItem {
    public NonFictionBook(String title, String author, int year, String isbn) {
        super(title, author, year, isbn);
    }
}
