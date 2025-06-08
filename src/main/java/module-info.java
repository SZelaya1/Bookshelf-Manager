module org.example.bookshelfmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.bookshelfmanagement to javafx.fxml;
    exports org.example.bookshelfmanagement;
    exports org.example.bookshelfmanagement.books;
    opens org.example.bookshelfmanagement.books to javafx.fxml;
}