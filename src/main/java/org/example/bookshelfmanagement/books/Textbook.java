package org.example.bookshelfmanagement.books;

public class Textbook extends NonFictionBook {
    public Textbook(String title, String author, int year, String isbn) {
        super(title, author, year, isbn);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Textbook]");
        System.out.println(getBasicInfo());
    }

    @Override
    public boolean validate() {
        return super.validate() && getYear() >= 1950;
    }

    @Override
    public int getEstimatedReadingTime() {
        return 180;
    }

    @Override
    public String toDetailedString() {
        return "[Textbook]\n" + getBasicInfo() + "\n";
    }
}
