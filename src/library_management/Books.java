
package library_management;

class Book {
    int bookId;
    String title;
    String author;
    boolean isBorrowed;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}