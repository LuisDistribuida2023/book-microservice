package com.distribuida.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private Integer id;
    private String isbn;
    private String title;
    private  String author;
    private Double price;
}