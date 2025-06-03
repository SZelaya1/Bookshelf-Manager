package org.example.bookshelfmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.bookshelfmanagement.books.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartController {
    private List<BookItem> books = new ArrayList<>();
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField yearField;
    @FXML private TextField isbnField;
    @FXML private TextField searchTitleField;
    @FXML private TextField searchAuthorField;
    @FXML private TextField searchGenreField;
    @FXML private TextField yearFromField;
    @FXML private TextField yearToField;
    @FXML private TextArea outputArea;
    @FXML public ChoiceBox<String> genreChoiceBox;

    public StartController() {
        // Initial
        books.add(new FictionBook("Dune", "Frank Herbert", 1965, "9780441013593"));
        books.add(new Cookbook("Best Indian Food Ideas", "Gordon Ramsey", 2011, "9781451648539"));
        books.add(new FictionBook("1984", "George Orwell", 1949, "9780451524935"));
    }

    @FXML
    public void initialize() {
        genreChoiceBox.getItems().addAll("Fiction", "Novel", "Cookbook", "Textbook");
        genreChoiceBox.setValue("Fiction"); // Optional: set default
    }

    @FXML
    public void displayAllBooks() {
        outputArea.clear();
        for (BookItem book : books) {
            outputArea.appendText(book.toDetailedString() +
                    "\nEstimated reading time: " + book.getEstimatedReadingTime() + " minutes\n\n");
        }
    }

    @FXML
    public void sortBooks() {
        books.sort(Comparator.comparing(b -> b.getTitle().toLowerCase()));

        outputArea.clear();
        outputArea.appendText("Books sorted alphabetically by title:\n\n");
        for (BookItem book : books) {
            outputArea.appendText(book.toDetailedString() +
                    "\nEstimated reading time: " + book.getEstimatedReadingTime() + " minutes\n\n");
        }
    }


    @FXML
    public void searchTitle() {
        String title = searchTitleField.getText();
        outputArea.clear();
        books.stream()
                .filter(book -> book.getBasicInfo().toLowerCase().contains(title.toLowerCase()))
                .forEach(book -> outputArea.appendText(book.getBasicInfo() + "\n"));
    }

    @FXML
    public void searchAuthorGenre() {
        String author = searchAuthorField.getText();
        String genre = searchGenreField.getText();
        outputArea.clear();
        books.stream()
                .filter(book -> book.getBasicInfo().toLowerCase().contains(author.toLowerCase())
                        && book.getClass().getSimpleName().toLowerCase().contains(genre.toLowerCase()))
                .forEach(book -> outputArea.appendText(book.getBasicInfo() + "\n"));
    }

    @FXML
    public void searchYearRange() {
        int from, to;
        try {
            from = Integer.parseInt(yearFromField.getText());
            to = Integer.parseInt(yearToField.getText());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid year range.");
            return;
        }

        outputArea.clear();
        books.stream()
                .filter(book -> book.getYear() >= from && book.getYear() <= to)
                .forEach(book -> outputArea.appendText(book.toDetailedString() + "\n\n"));
    }

    @FXML
    public void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();
        String genre = genreChoiceBox.getValue();
        int year;

        try {
            year = Integer.parseInt(yearField.getText());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid year.");
            return;
        }

        BookItem newBook;
        switch (genre) {
            case "Novel" -> newBook = new Novel(title, author, year, isbn);
            case "Cookbook" -> newBook = new Cookbook(title, author, year, isbn);
            case "Textbook" -> newBook = new Textbook(title, author, year, isbn);
            default -> newBook = new FictionBook(title, author, year, isbn);
        }

        if (!newBook.validate()) {
            outputArea.setText("Book data validation failed for " + genre + ".");
            return;
        }

        books.add(newBook);
        outputArea.setText("Book added:\n" + newBook.toDetailedString() +
                "\nEstimated reading time: " + newBook.getEstimatedReadingTime() + " minutes.");
        clearFields();
    }

    @FXML
    public void removeBook() {
        String isbnToRemove = isbnField.getText();
        BookItem found = null;

        for (BookItem book : books) {
            if (book.getBasicInfo().contains(isbnToRemove)) {
                found = book;
                break;
            }
        }

        if (found != null) {
            books.remove(found);
            outputArea.setText("Book removed:\n" + found.toDetailedString());
        } else {
            System.out.println("No book found with ISBN: " + isbnToRemove);
        }
        clearFields();
    }

    private void clearFields() {
        titleField.clear();
        authorField.clear();
        yearField.clear();
        isbnField.clear();
    }
}