package com.example.GraphQlAnnotation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {
    private String title;
    private Integer pages;
    private String author;
}
