package org.example.proxy;

public class BookServiceProxy implements BookService{

    private final BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("hi");
        bookService.rent(book);
        System.out.println("bye");
    }

    @Override
    public void returnBook(Book book) {

    }

}
