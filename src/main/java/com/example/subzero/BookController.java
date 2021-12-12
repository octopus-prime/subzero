package com.example.subzero;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "books")
@Tag(name = "Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public Mono<Book> save(@Validated(Creating.class) @RequestBody Mono<Book> book) {
        return bookService.save(book);
    }

    @GetMapping(path = "findByIsbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "find by isbn")
    public Mono<Book> findByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @GetMapping(path = "findAllByAuthor/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "find all by author")
    public Flux<Book> findAllByAuthor(@PathVariable String author) {
        return bookService.findAllByAuthor(author);
    }

    @GetMapping(path = "findAllByYear/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "find all by year")
    public Flux<Book> findAllByYear(@PathVariable Integer year) {
        return bookService.findAllByYear(year);
    }

    @PostMapping(path = "findAllByExample", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "find all by example")
    public Flux<Book> findAllByExample(@Validated(Finding.class) @RequestBody Mono<Book> book) {
        return bookService.findAllByExample(book);
    }
}
