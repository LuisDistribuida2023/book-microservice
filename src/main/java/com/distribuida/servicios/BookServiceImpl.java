package com.distribuida.servicios;

import com.distribuida.db.Book;
import com.distribuida.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;
import java.util.*;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    @Inject
    private DataSource dataSource;
    private Jdbi jdbi;

    @PostConstruct
    public void init(){
        jdbi=Jdbi.create(dataSource)
                .installPlugin(new SqlObjectPlugin());
    }

    public Book findById(Integer id) {
       return jdbi.withExtension(BookRepository.class,extension -> extension.getBookById(id));
    }

    @Override
    public List<Book> findAll() {
        return jdbi.withExtension(BookRepository.class,BookRepository::getBooks);

    }

    @Override
    public void delete(Integer id) {
        jdbi.useExtension(BookRepository.class,extension -> extension.deleteBook(id));
    }

    @Override
    public void create(Book book) {
        jdbi.useExtension(BookRepository.class,extension -> extension.createBook(book.getIsbn(),
                book.getTitle(),book.getAuthor(),book.getPrice()));
    }

    @Override
    public void update(Integer id, Book book) {
        jdbi.useExtension(BookRepository.class,extension ->extension.updateBook(id,
                book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()));

    }

}