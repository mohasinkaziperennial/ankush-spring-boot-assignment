package com.perennialsys.repository;

import com.perennialsys.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface will track record about book history
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
