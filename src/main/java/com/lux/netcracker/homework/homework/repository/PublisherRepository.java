package com.lux.netcracker.homework.homework.repository;

import com.lux.netcracker.homework.homework.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    @Query(value = "select * from publisher p where p.publisher_name = :name", nativeQuery = true)
    Publisher findByName(@Param("name") String name);

    @Query(value = "select * from publisher", nativeQuery = true)
    ArrayList<Publisher> getAllPublishers();
}
