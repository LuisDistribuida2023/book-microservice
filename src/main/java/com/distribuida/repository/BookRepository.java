package com.distribuida.repository;

import com.distribuida.db.Book;
import com.distribuida.mappers.BookMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface BookRepository {

    @SqlQuery("SELECT * FROM books")
    @UseRowMapper(BookMapper.class)
    List<Book> getBooks();
    @SqlQuery("SELECT * FROM books WHERE id=:id")
    @UseRowMapper(BookMapper.class)
    Book getBookById(@Bind("id") Integer id);
    @SqlUpdate("INSERT INTO books(isbn,title,author,price) values (:isbn,:title,:author,:price)")
    void createBook(@Bind("isbn")String isbn,@Bind("title")String title,@Bind("author")String author,@Bind("price")Double price);
    @SqlUpdate("DELETE FROM books WHERE id=:id")
    void deleteBook(@Bind("id") Integer id);
    @SqlUpdate("UPDATE books set isbn=:isbn,title=:title,author=:author,price=:price WHERE id=:id")
    void updateBook(@Bind("id") Integer id,@Bind("isbn")String isbn,@Bind("title")String title,
                    @Bind("author")String author,@Bind("price")Double price);
}
