package org.example.proxy;

public class Book {
    private String title;
    private String contents;

    public Book(String title) {
        this(title, "");
    }

    public Book(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String title() {
        return title;
    }

    public String contents() {
        return contents;
    }

}
