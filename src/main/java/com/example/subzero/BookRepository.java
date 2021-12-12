package com.example.subzero;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface BookRepository extends R2dbcRepository<Book, UUID> {

    Mono<Book> findByIsbn(String isbn);

    Flux<Book> findAllBooksByAuthor(String author);

    @Query("SELECT book.id, book.isbn, book.title, book.author, book.date FROM book WHERE YEAR(book.date) = :year")
    Flux<Book> findAllByYear(Integer year);
}
