package org.example.proxy;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class BookServiceProxyTest {

    private Book book;

    private final BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            BookService bookService = new DefaultBookService();
            if (method.getName().equals("rent")) {
                System.out.println("aaa");
                Object invoke = method.invoke(bookService, args);
                System.out.println("bbb");
                return invoke;
            }
            return method.invoke(bookService, args);
            }
        });

    @Before
    public void setUp() throws Exception {
        book = new Book("상자 밖에 있는 사람");
    }

    @Test
    public void proxy_rent() {
        bookService.rent(book);
    }

    @Test
    public void returnBook_test() {
        bookService.returnBook(book);
    }

}