package com.lux.netcracker.homework.homework.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private BigInteger id;
    private String bookName;
    private String bookAuthor;
    private String bookPubHouse;

    public Book(String bookName, String bookAuthor, String bookPubHouse) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPubHouse = bookPubHouse;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPubHouse() {
        return bookPubHouse;
    }

    public void setBookPubHouse(String bookPubHouse) {
        this.bookPubHouse = bookPubHouse;
    }
}
