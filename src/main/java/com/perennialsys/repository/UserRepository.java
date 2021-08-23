package com.perennialsys.repository;

import com.perennialsys.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Borrower,Integer> {

}
