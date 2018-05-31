package com;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import generated.Book;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class LibraryRepository {
    private static final Map<String, Book> books = new HashMap<>();

    @PostConstruct
    public void initData() {

        Book book = new Book();
        book.setTitle("W pustyni i w puszczy");
        book.setAuthor("Sienkiewicz");
        book.setRent(false);
        books.put(book.getTitle(), book);

        book = new Book();
        book.setTitle("Wiedzmin");
        book.setAuthor("Sapkowski");
        book.setRent(true);
        books.put(book.getTitle(), book);

        book = new Book();
        book.setTitle("Sql");
        book.setAuthor("Arad");
        book.setRent(false);
        books.put(book.getTitle(), book);
    }

    public Book findBook(String name) {
        Assert.notNull(name, "The Book's title must not be null");
        return books.get(name);
    }

    public Book rentBook(String name){
        Assert.notNull(name, "The Book's title must not be null");
        Book bookToRent = books.get(name);
        if(bookToRent!=null){
            bookToRent.setRent(true);
            return bookToRent;
        }
        return null;
    }

    public Book rentBackBook(String name){
        Assert.notNull(name, "The Book's title must not be null");
        Book bookToRent = books.get(name);
        if(bookToRent!=null){
            bookToRent.setRent(false);
            return bookToRent;
        }
        return null;
    }
}
