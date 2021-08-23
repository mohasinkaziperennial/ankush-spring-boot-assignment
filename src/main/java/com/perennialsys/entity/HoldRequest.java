package com.perennialsys.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "hold_request")
public class HoldRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Date requestDate;
    private Long id;

    public HoldRequest() {
    }

    public HoldRequest(  Date reqDate) {
             requestDate = reqDate;
    }
/*
    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;

    }*/

   /* public Book getBook() {
        return book;
    }*/
/*
    public void setBook(Book book) {
        this.book = book;
    }*/

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;

    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
