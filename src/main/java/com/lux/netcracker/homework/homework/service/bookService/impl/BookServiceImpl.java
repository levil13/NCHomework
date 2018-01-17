package com.lux.netcracker.homework.homework.service.bookService.impl;

import com.lux.netcracker.homework.homework.model.Book;
import com.lux.netcracker.homework.homework.repository.BookRepository;
import com.lux.netcracker.homework.homework.service.bookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        Book savedBook = getByName(book.getBookName());
        if (savedBook == null) {
            savedBook = bookRepository.saveAndFlush(book);
        }
        return savedBook;
    }

    @Override
    public void delete(long id) {
        bookRepository.delete(id);
    }

    @Override
    public Book getByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Book editBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(String bookName, String authorName, String publisherName) {
        return new Book(bookName, authorName, publisherName);
    }

    @Override
    public ArrayList<Book> findByAuthor(String authorName) {
        return bookRepository.findByAuthor(authorName);
    }

    @Override
    public ArrayList<Book> findByPublisher(String publisherName) {
        return bookRepository.findByPublisher(publisherName);
    }
}
