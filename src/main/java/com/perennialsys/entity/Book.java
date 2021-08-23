package com.perennialsys.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public long isbn;
    public String name;
    public String isTaken;
    @OneToMany
    public List<HoldRequest> holdRequests;
    @OneToMany
    private List<History> history;
    @ElementCollection
    public Set<String> authors;
    public Book() {
    }
    public Book(long isbn, String name, Set<String> authors, String taken) {
        this.isbn = isbn;
        this.name = name;
        this.authors = authors;
        this.isTaken = taken;
        this.holdRequests = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isTaken=" + isTaken +
                ", holdRequests=" + holdRequests +
                ", isbn=" + isbn +
                ", authors=" + authors +

                '}';
    }

    public List<HoldRequest> getHoldRequests() {
        return holdRequests;
    }
    public void setHoldRequests(ArrayList<HoldRequest> holdRequests) {
        this.holdRequests = holdRequests;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String isTaken(String b) {
        return isTaken;
    }

    public void setTaken(String taken) {
        isTaken = taken;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;

    }

    public void addNewBook(Book book) {
        this.isbn = book.isbn;
        this.name = book.name;
    }


    public void setIssuedStatus(boolean b) {

    }


}