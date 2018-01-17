package com.lux.netcracker.homework.homework.controller;

import com.lux.netcracker.homework.homework.model.Author;
import com.lux.netcracker.homework.homework.model.Book;
import com.lux.netcracker.homework.homework.model.Publisher;
import com.lux.netcracker.homework.homework.service.authorService.AuthorService;
import com.lux.netcracker.homework.homework.service.bookService.BookService;
import com.lux.netcracker.homework.homework.service.publisherService.PublisherService;
import com.lux.netcracker.homework.homework.service.util.DirectoryWatcher.DirectoryWatcher;
import com.lux.netcracker.homework.homework.service.util.XLSParser.XLSParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class MainController {

    @Autowired
    XLSParser xlsParser;

    @Autowired
    PublisherService publisherService;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    DirectoryWatcher directoryWatcher;

    @PostMapping("/")
    public String test(@RequestBody String file) throws IOException, InterruptedException {
        xlsParser.readFromExcel(new File(".").getCanonicalPath() + "\\src\\main\\resources\\static\\excelFiles\\" + file);
        for (int i = 0; i < xlsParser.getPublishers().size(); i++) {
            Publisher savedPublisher = publisherService.addPublisher(xlsParser.getPublishers().get(i));
            Author savedAuthor = authorService.addAuthor(xlsParser.getAuthors().get(i));
            bookService.addBook(bookService.createBook(xlsParser.getBooks().get(i), savedAuthor.getAuthorName(), savedPublisher.getPublisherName()));
        }
        return "Nice";
    }

    @GetMapping("/authors")
    public ArrayList<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{authorName}")
    public ArrayList<Book> getAllAuthorsBooks(@PathVariable String authorName) {
        return bookService.findByAuthor(authorName);
    }

    @GetMapping("/publishers")
    public ArrayList<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/publishers/{publisherName}")
    public ArrayList<Book> getAllPublishersBooks(@PathVariable String publisherName) {
        return bookService.findByPublisher(publisherName);
    }

    @GetMapping("/books")
    public ArrayList<Book> getAllBooks(){
        return (ArrayList<Book>) bookService.getAll();
    }
}
