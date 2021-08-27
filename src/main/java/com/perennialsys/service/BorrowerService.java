package com.perennialsys.service;

import com.perennialsys.entity.Borrower;

public interface BorrowerService {
    Borrower save(Borrower borrower);

    Borrower findById(Long id);
}
