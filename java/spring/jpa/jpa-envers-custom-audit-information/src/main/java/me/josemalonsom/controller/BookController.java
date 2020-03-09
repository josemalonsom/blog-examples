package me.josemalonsom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.josemalonsom.entity.Book;
import me.josemalonsom.model.BookRevision;
import me.josemalonsom.repository.BookAuditRepository;
import me.josemalonsom.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookAuditRepository auditRepository;

    @GetMapping
    public List<Book> getBooks() {

        return repository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {

        return repository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {

        book.setId(id);

        return repository.save(book);
    }

    @DeleteMapping
    public void deleteBook(Long id) {

        repository.deleteById(id);
    }

    @GetMapping("/revisions/{id}")
    public List<BookRevision> getRevisions(@PathVariable("id") Long id) {

        return auditRepository.getRevisions(id);
    }
}
