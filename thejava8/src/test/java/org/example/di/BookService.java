package org.example.di;

import org.example.reflection.di.Inject;

public class BookService {

    @Inject
    BookRepository bookRepository;

}
