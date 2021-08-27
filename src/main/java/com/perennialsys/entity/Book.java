package com.perennialsys.entity;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    public long isbn;
    public String name;
    public String isTaken;
    @OneToMany
    public List<HoldRequest> holdRequests;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_history",
            joinColumns = @JoinColumn(name = "history_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<History> history;
    @ElementCollection
    private List<String> authors;

    public Book(int id, long isbn, String name, String isTaken, List<HoldRequest> holdRequests, List<History> history, List<String> authors) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.isTaken = isTaken;
        this.holdRequests = holdRequests;
        this.history = history;
        this.authors = authors;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public long getIsbn() {
        return isbn;
    }

    public Book setIsbn(long isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getIsTaken() {
        return isTaken;
    }

    public Book setIsTaken(String isTaken) {
        this.isTaken = isTaken;
        return this;
    }

    public List<HoldRequest> getHoldRequests() {
        return holdRequests;
    }

    public Book setHoldRequests(List<HoldRequest> holdRequests) {
        this.holdRequests = holdRequests;
        return this;
    }

    public List<History> getHistory() {
        return history;
    }

    public Book setHistory(List<History> history) {
        this.history = history;
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public void addNewBook(Book book) {
        this.isbn = book.isbn;
        this.name = book.name;
    }


    public void setIssuedStatus(boolean b) {

    }

    public void addHoldRequest(HoldRequest holdRequest) {
        holdRequests.add(holdRequest);
    }

    public void removeHoldRequest(HoldRequest holdRequest) {
        holdRequests.remove(holdRequest);
    }

}