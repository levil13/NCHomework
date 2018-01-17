package com.lux.netcracker.homework.homework.service.publisherService.impl;

import com.lux.netcracker.homework.homework.model.Publisher;
import com.lux.netcracker.homework.homework.repository.PublisherRepository;
import com.lux.netcracker.homework.homework.service.publisherService.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(Publisher publisher) {
        Publisher savedPublisher = getByName(publisher.getPublisherName());
        if (savedPublisher == null) {
            savedPublisher = publisherRepository.saveAndFlush(publisher);
        }
        return savedPublisher;
    }

    @Override
    public void delete(long id) {
        publisherRepository.delete(id);
    }

    @Override
    public Publisher getByName(String name) {
        return publisherRepository.findByName(name);
    }

    @Override
    public Publisher editPublisher(Publisher publisher) {
        return publisherRepository.saveAndFlush(publisher);
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher createPublisher(String bookPublisher) {
        return new Publisher(bookPublisher);
    }

    @Override
    public ArrayList<Publisher> getAllPublishers() {
        return publisherRepository.getAllPublishers();
    }
}
