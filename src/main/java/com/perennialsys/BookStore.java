package com.perennialsys;

import com.perennialsys.entity.Book;
import com.perennialsys.entity.History;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore {
    private static BookStore obj;
    public int hold_request_expiry;
    List<Book> listOfBooks;
    private final List<History> histories;

    private BookStore(){
        listOfBooks= new ArrayList<>();
        histories=new ArrayList<>();
    }
    public static BookStore getInstance() {
        if (obj == null) {

            obj = new BookStore();
        }
        return obj;
    }

    public int getHoldRequestExpiry() {
        return hold_request_expiry;
    }

    public BookStore setHold_request_expiry(int hold_request_expiry) {
        this.hold_request_expiry = hold_request_expiry;
        return this;
    }

    public void addHistory(History history) {
        histories.add(history);
    }

}
