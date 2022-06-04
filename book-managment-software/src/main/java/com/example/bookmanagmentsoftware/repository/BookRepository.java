package com.example.bookmanagmentsoftware.repository;

import com.example.bookmanagmentsoftware.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book,Integer> {
}
