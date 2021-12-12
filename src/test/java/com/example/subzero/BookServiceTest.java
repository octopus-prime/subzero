//package com.example.testspring;
//
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.web.server.ResponseStatusException;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.time.LocalDate;
//
//import static org.mockito.BDDMockito.given;
//import static reactor.test.StepVerifier.create;
//
//@ExtendWith(MockitoExtension.class)
//class BookServiceTest {
//
//    @InjectMocks
//    private BookService bookService;
//
//    @Mock
//    private BookRepository bookRepository;
//
//    @Test
//    void save(@Mock Book book1, @Mock Book book2) {
//        given(bookRepository.save(book1)).willReturn(Mono.just(book2));
//        create(bookService.save(Mono.just(book1))).expectNext(book2).verifyComplete();
//    }
//
//    @Nested
//    class FindByIsbnTest {
//
//        @ParameterizedTest
//        @ValueSource(strings = "978-3442153749")
//        void ok(String isbn, @Mock Book book) {
//            given(bookRepository.findByIsbn(isbn)).willReturn(Mono.just(book));
//            create(bookService.findByIsbn(isbn)).expectNext(book).verifyComplete();
//        }
//
//        @ParameterizedTest
//        @ValueSource(strings = "978-3442153749")
//        void notFound(String isbn) {
//            given(bookRepository.findByIsbn(isbn)).willReturn(Mono.empty());
//            create(bookService.findByIsbn(isbn)).expectError(ResponseStatusException.class).verify();
//        }
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = "Brian Greene")
//    void findAllByAuthor(String author, @Mock Book book1, @Mock Book book2) {
//        given(bookRepository.findAllByAuthor(author)).willReturn(Flux.just(book1, book2));
//        create(bookService.findAllByAuthor(author)).expectNext(book1, book2).verifyComplete();
//    }
//
//    @ParameterizedTest
//    @CsvSource("2021, 2021-01-01, 2021-12-31")
//    void findAllByYear(Integer year, LocalDate from, LocalDate to, @Mock Book book1, @Mock Book book2) {
//        given(bookRepository.findAllByDateBetween(from, to)).willReturn(Flux.just(book1, book2));
//        create(bookService.findAllByYear(year)).expectNext(book1, book2).verifyComplete();
//    }
//}
