package com.perennialsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is Histroy entity class will track record about history
 *
 * @Author ankush katkar
 */
@Entity
@Table(name = "history")
public class History {

    @ManyToMany(mappedBy = "history")
    private final List<Book> book;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;

    public History() {
        book = new ArrayList<>();
    }

    public History(Long id, LocalDateTime issueDate, LocalDateTime returnDate, List<Book> book) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public LocalDateTime getIsuueDate() {
        return issueDate;
    }

    public void setIsuueDate(Date issueDate) {
        issueDate = issueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        returnDate = returnDate;
    }

    public void setReturnedDate(Date date) {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*

        public void addHoldRequest(Borrower borrower, Book book) {
            HoldRequest hr = new HoldRequest();
            book.holdRequests.add(hr);
        }
    */
    public void addBook(Book books) {

        book.add(books);
    }
}
