package com.perennialsys.repository;

import com.perennialsys.entity.HoldRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface will perform operation related to  hold request on book
 */
@Repository
public interface HoldRequestRepository extends JpaRepository<HoldRequest, Integer> {
}
