package com.perennialsys.service;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.Borrower;
import com.perennialsys.entity.History;
import com.perennialsys.entity.HoldRequest;
import com.perennialsys.repository.BookRepository;
import com.perennialsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BorrowerService borrowerService;
    @Autowired
    private HoldRequestService holdRequestService;
    @Autowired
    private HistoryService historyService;

    @Override
    public Book addBook(Book book) {
        long isbn = book.hashCode();
        System.out.println(isbn + "is here");
        book.setIsbn(isbn);
        book.setIsTaken("false");
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }


    @Override
    public List<Book> getAllBook() {
        List listOfBooks = bookRepository.findAll();
        return listOfBooks;
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "success";
    }

    public String issueBook(Book book) {
        Borrower borrower = new Borrower();
        String bookName = book.getName();
        Book boookResult = bookRepository.findByName(bookName);
        borrower.setBook(boookResult);
        boookResult.setIsTaken("true");
        userRepository.save(borrower);
        History history = new History();
        history.addBook(boookResult);
        history.setIsuueDate(new Date());
        boookResult.getHistory().add(history);
        bookRepository.save(boookResult);
        historyService.save(history);

        return "success";
    }


    public void returnBook(Long borrowerId) {
        Borrower returnFromBorrower = borrowerService.findById(borrowerId);
        Book returnBook = returnFromBorrower.getBook();
        returnBook.setIsTaken("false");
        HoldRequest holdRequest = new HoldRequest();
        returnBook.removeHoldRequest(holdRequest);

        holdRequestService.save(holdRequest);
        bookRepository.save(returnBook);
    }

/*

    public void addHoldRequest(Borrower borrower, Book book) {
        HoldRequest hr = new HoldRequest();
        book.holdRequests.add(hr);
    }
*/


    public Book searchByName2(String bookName) {

        Book bookResult = bookRepository.findByName(bookName);

        return bookResult;
    }

    @Override
    public Book placeBookOnHold(String bookName) {
        HoldRequest holdRequest = new HoldRequest();
        Book bookHold = bookRepository.findByName(bookName);
        Borrower borrower = new Borrower();
        Borrower name = borrower.setName("ankush");
        holdRequest.setBorrower(name);
        borrowerService.save(borrower);
        bookHold.addHoldRequest(holdRequest);

        holdRequestService.save(holdRequest);
        bookRepository.save(bookHold);
        //
        //   bookHold.setHoldRequests(holdRequest.setId());

        return bookHold;
    }

    @Override
    public List<Book> getBookDetails() {
        List bookList = bookRepository.findAll();
        return bookList;
    }

  /*  @Override
    public Optional<Object> findById(int id) {
        Optional<Book> bookToUpdate =bookRepository.findById(id);
        bookRepository.save(bookToUpdate);

        return Optional.empty();
    }*/

}
