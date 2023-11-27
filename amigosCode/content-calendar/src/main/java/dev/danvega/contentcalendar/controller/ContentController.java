package dev.danvega.contentcalendar.controller;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all pieces of content in the system.
     *
     * @return List of Content objects
     */
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    /**
     * Retrieve a specific piece of content by ID.
     *
     * @param id The ID of the content to retrieve
     * @return The Content object if found
     * @throws ResponseStatusException with status NOT_FOUND if content is not found
     */
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    /**
     * Create a new piece of content.
     *
     * @param content The Content object to be created
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

    // Uncomment and implement the update method if needed
    // public void update(@RequestBody Content content, Integer id) { }

}
