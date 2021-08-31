package com.perennialsys.service;

import com.perennialsys.entity.Book;

import java.util.List;

/**
 * This is book service interface define methods related to book
 */
public interface BookService {
    Book addBook(Book book);

    List<Book> getAllBook();

    String deleteBook(int id);

    String issueBook(Book book);

    void returnBook(Long borrower);

    Book searchByName2(String bookName);

    Book placeBookOnHold(String bookName);

    List<Book> getBookDetails();
}
