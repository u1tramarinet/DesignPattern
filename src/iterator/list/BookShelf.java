package iterator.list;

import iterator.Aggregate;
import iterator.Book;
import iterator.Iterator;

import java.util.ArrayList;

public class BookShelf implements Aggregate {
    private ArrayList<Book> books;

    public BookShelf(int maxSize) {
        this.books = new ArrayList<>();
    }

    public Book getBookAt(int index) {
        if ((0 > index) || (books.size() <= index)) {
            return null;
        }
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
