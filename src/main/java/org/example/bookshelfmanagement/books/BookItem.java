package org.example.bookshelfmanagement.books;

public abstract class BookItem {
    private String title;
    private String author;
    private int year;
    private String isbn;

    public BookItem(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public abstract void displayInfo();

    public boolean validate() {
        int currentYear = java.time.Year.now().getValue();
        return (year >= 1000 && year <= currentYear) && (isbn != null && !isbn.isEmpty());
    }

    public abstract int getEstimatedReadingTime();

    public String getBasicInfo() {
        return title + " by " + author + " (" + year + ")\nISBN: " + isbn;
    }

    public String toDetailedString() {
        return getBasicInfo();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getIsbn() { return isbn; }
}
