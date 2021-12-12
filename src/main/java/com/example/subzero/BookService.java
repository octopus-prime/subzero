package com.example.subzero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Mono<Book> save(Mono<Book> book) {
        return book.flatMap(bookRepository::save);
    }

    public Mono<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "No book with isbn " + isbn)));
    }

    public Flux<Book> findAllByAuthor(String author) {
        return bookRepository.findAllBooksByAuthor(author);
    }

    public Flux<Book> findAllByYear(Integer year) {
        return bookRepository.findAllByYear(year);
    }

    public Flux<Book> findAllByExample(Mono<Book> book) {
        return book.map(Example::of).flatMapMany(bookRepository::findAll);
    }
}
