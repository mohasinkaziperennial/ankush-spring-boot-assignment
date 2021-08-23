package com.perennialsys.controller;

import com.perennialsys.UserExcelExporter;
import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.History;
import com.perennialsys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public long addBook(@RequestBody Book book) {
        book.setTaken("false");
        return bookService.addBook(book).getIsbn();
    }
    @PostMapping("/issue-book")
    public ResponseEntity<String> issueBook(@RequestBody  Book book, Borrower borrower) {

        String isSaved = bookService.issueBook(borrower, book);
        return new ResponseEntity<>(isSaved, HttpStatus.CREATED);

    }
    @PostMapping("/return-book")
    public String returnBook(Borrower borrower, History history) {
        bookService.returnBook(borrower, history);
        return "success";
    }

    @GetMapping("/hold")
    public String placeBookOnHold(Book book) {
        bookService.placeBookOnHold(book);
        return "success";
    }

    @GetMapping("/search")
    public String searchForBook(String bookName) {
       Book bookrec= (Book) bookService.searchByName(bookName);
       System.out.println("bookrecordishere"+bookrec);
        return "success";
    }
}
