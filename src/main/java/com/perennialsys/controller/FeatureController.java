package com.perennialsys.controller;

import com.perennialsys.entity.Book;
import com.perennialsys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is feature related endpoints it contains book feature
 * like what user can do except basic operation
 * @author
 * ankush katkar
 */
@RestController
@RequestMapping("/api/feature")
public class FeatureController {
    @Autowired
    private BookService bookService;

    @PostMapping("/issue")
    public ResponseEntity<String> issueBook(@RequestBody Book book) {
        String isSaved = bookService.issueBook(book);
        return new ResponseEntity<>(isSaved, HttpStatus.CREATED);
    }

    @PostMapping("/borrower/{borrowerId}")
    public String returnBook(@PathVariable("borrowerId") Long borrowerId) {
        bookService.returnBook(borrowerId);
        return "success";
    }

    @PostMapping("/hold/{bookName}")
    public String placeBookOnHold(@PathVariable("bookName") String bookName) {
        bookService.placeBookOnHold(bookName);
        return "success";
    }

}
