package com.perennialsys.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * This is hold request class will track record about hold request on book
 *
 * @Author ankush katkar
 */
@Entity
@Table(name = "hold_request")
public class HoldRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Date requestDate;
    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    public HoldRequest() {

    }

    public HoldRequest(Date requestDate, Long id, Borrower borrower) {
        this.requestDate = requestDate;
        this.id = id;
        this.borrower = borrower;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public HoldRequest setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    public Long getId() {
        return id;
    }

    public HoldRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public HoldRequest setBorrower(Borrower borrower) {
        this.borrower = borrower;
        return this;
    }

    @Override
    public String toString() {
        return "HoldRequest{" +
                "requestDate=" + requestDate +
                ", id=" + id +
                ", borrower=" + borrower +
                '}';
    }
}
