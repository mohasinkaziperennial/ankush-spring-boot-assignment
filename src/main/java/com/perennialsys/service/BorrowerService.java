package com.perennialsys.service;

import com.perennialsys.entity.Borrower;

/**
 * This borrower service interface will let user track about record
 * @Author
 * ankush katkar
 */
public interface BorrowerService {
    Borrower save(Borrower borrower);

    Borrower findById(Long id);
}
