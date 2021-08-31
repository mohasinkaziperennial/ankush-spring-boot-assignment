package com.perennialsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * This is  Borrower user of application
 *
 * @Author ankush katkar
 */
@Entity
@Table(name = "borrower")
public class Borrower {
    @ManyToMany
    List<History> borrowedBooks;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int contactNo;
    @OneToOne
    private Book book;

    public Borrower() {
        borrowedBooks = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public Borrower setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Borrower setName(String name) {
        this.name = name;
        return this;
    }

    public int getContactNo() {
        return contactNo;
    }

    public Borrower setContactNo(int contactNo) {
        this.contactNo = contactNo;
        return this;
    }


    public List<History> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Borrower setBorrowedBooks(List<History> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
        return this;
    }


    public Book getBook() {
        return book;
    }

    public Borrower setBook(Book book) {
        this.book = book;
        return this;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public void addBorrowedBook(History history) {
        borrowedBooks.add(history);
    }

    public void removeBorrowedBook(History history) {
        borrowedBooks.remove(history);
    }
}
