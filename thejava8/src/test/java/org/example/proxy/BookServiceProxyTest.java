package org.example.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceProxyTest {

    private final BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    public void proxy_test() {
        Book book = new Book("상자 밖에 있는 사람");
        bookService.rent(book);
    }

}