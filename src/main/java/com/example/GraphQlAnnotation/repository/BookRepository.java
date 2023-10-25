package com.example.GraphQlAnnotation.repository;

import com.example.GraphQlAnnotation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.id = :id")
    Book findBook(int id);
}
