package com.perennialsys.service;

import com.perennialsys.entity.Borrower;

public interface BorrowerService {
    public Borrower save(Borrower borrower);

    public Borrower findById(Long id);
}
