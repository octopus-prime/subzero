//package com.example.testspring;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import static org.mockito.BDDMockito.given;
//import static reactor.test.StepVerifier.create;
//
//@ExtendWith(MockitoExtension.class)
//class BookControllerTest {
//
//    @InjectMocks
//    private BookController bookController;
//
//    @Mock
//    private BookService bookService;
//
//    @Test
//    void save(@Mock Mono<Book> book1, @Mock Book book2) {
//        given(bookService.save(book1)).willReturn(Mono.just(book2));
//        create(bookController.save(book1)).expectNext(book2).verifyComplete();
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = "978-3442153749")
//    void findByIsbn(String isbn, @Mock Book book) {
//        given(bookService.findByIsbn(isbn)).willReturn(Mono.just(book));
//        create(bookController.findByIsbn(isbn)).expectNext(book).verifyComplete();
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = "Brian Greene")
//    void findAllByAuthor(String author, @Mock Book book1, @Mock Book book2) {
//        given(bookService.findAllByAuthor(author)).willReturn(Flux.just(book1, book2));
//        create(bookController.findAllByAuthor(author)).expectNext(book1, book2).verifyComplete();
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = 2021)
//    void findAllByYear(Integer year, @Mock Book book1, @Mock Book book2) {
//        given(bookService.findAllByYear(year)).willReturn(Flux.just(book1, book2));
//        create(bookController.findAllByYear(year)).expectNext(book1, book2).verifyComplete();
//    }
//}
