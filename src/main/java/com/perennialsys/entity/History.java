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

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date issueDate;
    private LocalDateTime returnDate;
    @ManyToMany(mappedBy = "history_id")
    private List<Book> book;



    public History(Date issueDate, LocalDateTime returnDate) {
              this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public History() {
        book = new ArrayList<>();
    }


    public Date getIsuueDate() {
        return issueDate;
    }

    public void setIsuueDate(LocalDateTime issueDate) {
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

    @Id
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
