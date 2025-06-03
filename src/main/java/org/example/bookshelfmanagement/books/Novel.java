package org.example.bookshelfmanagement.books;

public class Novel extends FictionBook {

    public Novel(String title, String author, int year, String isbn) {
        super(title, author, year, isbn);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Novel]");
        System.out.println(getBasicInfo());
    }

    @Override
    public boolean validate() {
        return super.validate() && getYear() >= 1800;
    }

    @Override
    public int getEstimatedReadingTime() {
        return 90;
    }

    @Override
    public String toDetailedString() {
        return "[Novel]\n" + getBasicInfo() + "\nA deep and emotional long story.";
    }
}
