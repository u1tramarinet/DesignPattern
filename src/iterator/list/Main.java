package iterator.list;

import iterator.Book;
import iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("book1"));
        bookShelf.appendBook(new Book("book2"));
        bookShelf.appendBook(new Book("book3"));
        bookShelf.appendBook(new Book("book4"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book)iterator.next();
            System.out.println(book.getName());
        }
    }
}
