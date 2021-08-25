package com.perennialsys.service;

import com.perennialsys.entity.Borrower;
import com.perennialsys.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Override
    public Borrower save(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @Override
    public Borrower findById(Long id) {
        return borrowerRepository.findById(id).orElse(null);
    }
}
