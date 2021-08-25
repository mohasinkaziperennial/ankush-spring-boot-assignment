package com.perennialsys.controller;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.History;
import com.perennialsys.entity.HoldRequest;
import com.perennialsys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {
    @Autowired
    BookService bookService;

    @PostMapping("/issue")
    public ResponseEntity<String> issueBook(@RequestBody Borrower borrower) {

        String isSaved = bookService.issueBook(borrower);
        return new ResponseEntity<>(isSaved, HttpStatus.CREATED);

    }

    @PostMapping("/borrower/{borrowerId}")
    public String returnBook(@PathVariable("borrowerId") Long borrowerId) {
        bookService.returnBook(borrowerId);
        return "success";
    }

    @PostMapping("/hold/{bookName}")
    public String placeBookOnHold(@PathVariable("bookName") String bookName) {

       Book bookHold= bookService.placeBookOnHold(bookName);


        return "success";
    }

}
