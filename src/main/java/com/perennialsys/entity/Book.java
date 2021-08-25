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
    @OneToMany
    private List<History> history;
    @ElementCollection
    private List<String> authors;

    public Book() {
        this.authors = new ArrayList<>();
        this.holdRequests = new ArrayList<>();
    }

    public Book(long isbn, String name, String taken, List<String> authors) {
        this.isbn = isbn;
        this.name = name;
        this.isTaken = taken;
        this.authors = authors;
        this.holdRequests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;

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
    public  void removeHoldRequest(HoldRequest holdRequest){
        holdRequests.remove(holdRequest);
    }

}