package com.perennialsys.repository;

import com.perennialsys.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * this interface will let user updated the borrower related operation
 */
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
