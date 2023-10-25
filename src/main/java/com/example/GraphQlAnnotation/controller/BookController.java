package com.example.GraphQlAnnotation.controller;

import com.example.GraphQlAnnotation.dto.BookInput;
import com.example.GraphQlAnnotation.entity.Book;
import com.example.GraphQlAnnotation.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book findBook(@Argument int id) {
        return bookService.findBook(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        return bookService.addBook(bookInput);
    }

    @MutationMapping
    public void deleteBook(@Argument int id){
         bookService.deleteById(id);
    }
}
