package org.example.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultBookServiceTest {

    private final BookService bookService = new DefaultBookService();

    @Test
    public void rent_test() {
        Book book = new Book("자바 성능 튜닝 이야기");
        bookService.rent(book);
    }

}