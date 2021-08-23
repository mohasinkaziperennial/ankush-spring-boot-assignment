package com.perennialsys.service;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.History;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);

    String issueBook(Borrower borrower, Book book);

    void returnBook(Borrower borrower, History history);

  /*  void serviceHoldRequest(HoldRequest hr, Book b);
*/
    List<Book> searchByName(String bookName);

    void placeBookOnHold(Book book);

    List<Book> getBookDetails();
}
