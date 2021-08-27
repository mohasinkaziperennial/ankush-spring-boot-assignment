package com.perennialsys.service;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public List<Book> getAllBook();

    public String deleteBook(int id);

    String issueBook(Book book);

    void returnBook(Long borrower);

    /*  void serviceHoldRequest(HoldRequest hr, Book b);
     */
    // List<Book> searchByName(String bookName);
    Book searchByName2(String bookName);

    Book placeBookOnHold(String bookName);

    List<Book> getBookDetails();

    /* Optional<Object> findById(int id);*/
}
