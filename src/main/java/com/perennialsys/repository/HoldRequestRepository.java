package com.perennialsys.repository;

import com.perennialsys.entity.HoldRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldRequestRepository extends JpaRepository<HoldRequest,Integer> {
}
