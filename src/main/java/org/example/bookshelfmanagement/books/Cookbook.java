package org.example.bookshelfmanagement.books;

public class Cookbook extends NonFictionBook {
    private int recipeCount = 120;
    private String cuisineType = "International Fusion";

    public Cookbook(String title, String author, int year, String isbn) {
        super(title, author, year, isbn);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Cookbook]");
        System.out.println(getBasicInfo());
    }

    @Override
    public boolean validate() {
        return super.validate() && getYear() >= 1900;
    }

    @Override
    public int getEstimatedReadingTime() {
        return 120;
    }

    @Override
    public String toDetailedString() {
        return "[Cookbook]\n" + getBasicInfo() + "\nRecipes: " + recipeCount + "\nCuisine: " + cuisineType;
    }
}
