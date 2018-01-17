package com.lux.netcracker.homework.homework.service.bookService;

import com.lux.netcracker.homework.homework.model.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    Book addBook(Book book);

    void delete(long id);

    Book getByName(String name);

    Book editBook(Book book);

    List<Book> getAll();

    Book createBook(String bookName, String authorName, String publisherName);

    ArrayList<Book> findByAuthor(String authorName);

    ArrayList<Book> findByPublisher(String publisherName);
}
