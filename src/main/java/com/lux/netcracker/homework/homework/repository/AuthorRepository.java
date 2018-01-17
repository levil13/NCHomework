package com.lux.netcracker.homework.homework.repository;

import com.lux.netcracker.homework.homework.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT * FROM author a WHERE a.author_name = :name", nativeQuery = true)
    Author findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM author", nativeQuery = true)
    ArrayList<Author> getAllAuthors();
}
