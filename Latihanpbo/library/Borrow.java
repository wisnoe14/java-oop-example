import java.util.ArrayList;

abstract class Borrow {
    public ArrayList<Book> borrowedBooks = new ArrayList<>();

    public abstract void receiveBook(Book book);

    public abstract void giveBook(Book book);

    public Book[] getBorrowList() {
        Book[] bookArray = new Book[borrowedBooks.size()];
        int i = 0;
        for (Book book : borrowedBooks) {
            bookArray[i++] = book;
        }
        return bookArray;
    }
}
