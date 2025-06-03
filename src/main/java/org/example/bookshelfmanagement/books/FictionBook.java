package org.example.bookshelfmanagement.books;

public class FictionBook extends BookItem {

    public FictionBook(String title, String author, int year, String isbn) {
        super(title, author, year, isbn);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Fiction Book]");
        System.out.println(getBasicInfo());
    }

    @Override
    public boolean validate() {
        return super.validate();
    }

    @Override
    public int getEstimatedReadingTime() {
        return 60;
    }

    @Override
    public String toDetailedString() {
        return "[Fiction Book]\n" + getBasicInfo() + "\nA thrilling and immersive story.";
    }
}
