package com.perennialsys.repository;

import com.perennialsys.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This will let user perform basic operation for borrower
 *
 * @author ankush katkar
 */
@Repository
public interface UserRepository extends JpaRepository<Borrower, Integer> {

}
