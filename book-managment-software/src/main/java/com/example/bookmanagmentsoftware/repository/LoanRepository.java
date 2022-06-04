package com.example.bookmanagmentsoftware.repository;

import com.example.bookmanagmentsoftware.model.Book;
import com.example.bookmanagmentsoftware.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

}
