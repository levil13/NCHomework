package com.lux.netcracker.homework.homework.service.authorService;

import com.lux.netcracker.homework.homework.model.Author;

import java.util.ArrayList;
import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);

    void delete(long id);

    Author getByName(String name);

    Author editAuthor(Author author);

    List<Author> getAll();

    Author createAuthor(String bookAuthor);

    ArrayList<Author> getAllAuthors();

}
