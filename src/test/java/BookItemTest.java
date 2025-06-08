import org.example.bookshelfmanagement.books.BookItem;
import org.example.bookshelfmanagement.books.FictionBook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookItemTest {

    @Test
    public void testBasicInfo() {
        BookItem book = new FictionBook("Test Title", "Test Author", 2020, "1234567890");
        String expected = "Test Title by Test Author (2020) - ISBN: 1234567890";
        assertEquals(expected, book.getBasicInfo());
    }

    @Test
    public void testToFileString() {
        BookItem book = new FictionBook("Book", "Author", 2022, "9999999999");
        assertEquals("FictionBook;Book;Author;2022;9999999999", book.toFileString());
    }

    @Test
    public void testValidateValid() {
        BookItem book = new FictionBook("Book", "Author", 2022, "9999999999");
        assertTrue(book.validate());
    }

    @Test
    public void testValidateInvalidISBN() {
        BookItem book = new FictionBook("Book", "Author", 2022, "123");
        assertFalse(book.validate());
    }
}
