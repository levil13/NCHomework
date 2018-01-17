package com.lux.netcracker.homework.homework.repository;

import com.lux.netcracker.homework.homework.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book b where b.book_name = :name", nativeQuery = true)
    Book findByName(@Param("name") String name);

    @Query(value = "select * from book b where b.author_name = :name", nativeQuery = true)
    ArrayList<Book> findByAuthor(@Param("name") String authorName);

    @Query(value = "select * from book b where b.publisher_name = :name", nativeQuery = true)
    ArrayList<Book> findByPublisher(@Param("name") String publisherName);
}
