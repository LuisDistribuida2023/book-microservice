package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {
    @Inject
    private BookService bookService;

    @GET
    @Path("/{id}")
    public Book findById(@PathParam("id") Integer id){
        return bookService.findById(id);
    }
    @GET
    public List<Book> findAll () {
        return bookService.findAll();
    }

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") Integer id){
        bookService.delete(id);
        return Response.status((Response.Status.NO_CONTENT) ).build();
    }

    @POST
    public Response create(Book book){

        bookService.create(book);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT @Path("/{id}")
    public Response update (Book book, @PathParam("id") Integer id){
        bookService.update(id,book);
        return Response.status((Response.Status.OK) ).build();
    }

}
