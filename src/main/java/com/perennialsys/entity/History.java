package com.perennialsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date issueDate;
    private LocalDateTime returnDate;


    public History(  Date issueDate, LocalDateTime returnDate) {

        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public History() {

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
}
