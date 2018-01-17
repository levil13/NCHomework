package com.lux.netcracker.homework.homework.service.publisherService;

import com.lux.netcracker.homework.homework.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public interface PublisherService {
    Publisher addPublisher(Publisher publisher);

    void delete(long id);

    Publisher getByName(String name);

    Publisher editPublisher(Publisher publisher);

    List<Publisher> getAll();

    Publisher createPublisher(String bookPublisher);

    ArrayList<Publisher> getAllPublishers();
}
