package com.example.contentcalendar.repository;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.model.Status;
import com.example.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    @PostConstruct
    public void init() {
        Content c = new Content(1, "My First Blog Post", "My First Blog Post Desc", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
        contentList.add(c);

    }

    public Content save(Content content) {
        contentList.add(content);
        return content;
    }

    public Content update(Content content, Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
        contentList.add(content);
        return content;
    }

    public boolean existById(Integer id) {
        return contentList.stream()
                .filter(c -> c.id().equals(id))
                .count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
