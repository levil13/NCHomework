package com.lux.netcracker.homework.homework.service.authorService.impl;

import com.lux.netcracker.homework.homework.model.Author;
import com.lux.netcracker.homework.homework.repository.AuthorRepository;
import com.lux.netcracker.homework.homework.service.authorService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        Author savedAuthor = getByName(author.getAuthorName());
        if (savedAuthor == null) {
            savedAuthor = authorRepository.saveAndFlush(author);
        }
        return savedAuthor;
    }

    @Override
    public void delete(long id) {
        authorRepository.delete(id);
    }

    @Override
    public Author getByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Author editAuthor(Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(String bookAuthor) {
        return new Author(bookAuthor);
    }

    @Override
    public ArrayList<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }
}
