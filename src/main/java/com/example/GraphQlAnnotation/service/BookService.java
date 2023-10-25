package com.example.GraphQlAnnotation.service;

import com.example.GraphQlAnnotation.dto.BookInput;
import com.example.GraphQlAnnotation.entity.Book;
import com.example.GraphQlAnnotation.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBook(int id){
        return bookRepository.findBook(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(BookInput bookInput) {
        Book book = convertDtoToEntity(bookInput);
        return bookRepository.save(book);
    }

    private Book convertDtoToEntity(BookInput bookInput) {
        Book book = new Book();
        book.setTitle(bookInput.getTitle());
        book.setAuthor(bookInput.getAuthor());
        book.setPages(bookInput.getPages());
        return book;
    }

    public void deleteById(int id) {
        bookRepository.deleteById((long) id);
    }
}
