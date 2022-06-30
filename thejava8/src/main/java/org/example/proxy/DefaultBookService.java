package org.example.proxy;

public class DefaultBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("title:" + book.title());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return");
    }
}
