package com.perennialsys.service;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.History;
import com.perennialsys.entity.HoldRequest;
import com.perennialsys.repository.BookRepository;
import com.perennialsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
@Autowired
private UserRepository borrowerRepository;

    @Override
    public Book addBook(Book book) {
        long isbn= book.hashCode();
        System.out.println(isbn+"is here");
        book.setIsbn(isbn);
        book.setTaken("false");
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public String issueBook(Borrower borrower, Book book) {
        String name=borrower.getName();
        borrower.setName(name);
        String bookName = book.getName();
        Book boookResult = bookRepository.findByName(bookName);
        boookResult.setTaken("true");
       // borrower.setOnHoldBooks((ArrayList<HoldRequest>) boookResult.getHoldRequests());
        bookRepository.save(book);
        borrowerRepository.save(borrower);

        return "success";
    }


    public void returnBook(Borrower borrower,History history) {
      Book book = new Book();
        book.setTaken("false");
        history.setReturnedDate(new Date());
        borrower.removeBorrowedBook(history);
    }


    public void addHoldRequest(Borrower borrower, Book book) {
        HoldRequest hr = new HoldRequest(new Date());
        book.holdRequests.add(hr);
    }

    public void removeHoldRequest(Book b) {
        if (!b.holdRequests.isEmpty()) {
            b.holdRequests.remove(0);
        }
    }


    public List<Book> searchByName(String bookName) {

        Book bookResult = bookRepository.findByName(bookName);

        return (List<Book>) bookResult;
    }

    @Override
    public void placeBookOnHold(Book book) {

    }

    @Override
    public List<Book> getBookDetails() {
    List bookList= bookRepository.findAll();
        return bookList;
    }

}
