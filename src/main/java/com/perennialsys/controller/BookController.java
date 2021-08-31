package com.perennialsys.controller;

import com.perennialsys.entity.Book;
import com.perennialsys.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is Book related endpoints
 *
 * @author ankush katkar
 */
@RestController
@RequestMapping("/api/book")
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    BookService bookService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long addBook(@RequestBody Book book) {
        book.setIsTaken("false");
        return bookService.addBook(book).getIsbn();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }

   /* @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {

        bookService.findById(id).orElseThrow(BookNotFoundException::new);
        return bookService.save(book);
    }*/


    @GetMapping("/search/{bookName}")
    public Book searchForBook(@PathVariable("bookName") String bookName) {
        LOGGER.info("Entering >> searchForBook()");
        bookService.searchByName2(bookName);

        return bookService.searchByName2(bookName);
    }

}
