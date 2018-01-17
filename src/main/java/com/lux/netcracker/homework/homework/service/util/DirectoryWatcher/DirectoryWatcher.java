package com.lux.netcracker.homework.homework.service.util.DirectoryWatcher;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class DirectoryWatcher {
    private WatchService watchService;
    private Path path;
    private WatchKey watchKey;
    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 100)
    public void init() throws IOException, InterruptedException {
        this.watchService = FileSystems.getDefault().newWatchService();
        this.path = Paths.get(new File(".").getCanonicalPath() + "\\src\\main\\resources\\static\\excelFiles\\");
        this.path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW);
        while ((this.watchKey = watchService.poll(200, TimeUnit.MILLISECONDS)) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Thread.sleep(500);
                    HttpEntity entity = new HttpEntity(event.context().toString());
                    restTemplate.exchange("http://localhost:1337/", HttpMethod.POST, entity, String.class);
                }
                System.out.println("Event kind: " + event.kind() + ". File affected: " + event.context() + ".");
            }
            watchKey.reset();
        }
    }
}
