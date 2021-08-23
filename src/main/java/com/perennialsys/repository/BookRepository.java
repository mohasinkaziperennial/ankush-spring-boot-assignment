package com.perennialsys.repository;

import com.perennialsys.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
       @Query(value = "SELECT * FROM books WHERE name = ?1", nativeQuery = true)
       Book findByName(String bookName);
}
