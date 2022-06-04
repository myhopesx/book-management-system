package com.example.bookmanagmentsoftware.service;


import com.example.bookmanagmentsoftware.exeption.InvalidIdException;
import com.example.bookmanagmentsoftware.model.Book;
import com.example.bookmanagmentsoftware.model.Loan;
import com.example.bookmanagmentsoftware.model.User;
import com.example.bookmanagmentsoftware.repository.BookRepository;
import com.example.bookmanagmentsoftware.repository.LoanRepository;
import com.example.bookmanagmentsoftware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookService bookRepository;
    private final UserService userRepository;


    public List getAllLoan() {
        return loanRepository.findAll();
    }

    public Loan getUserById(Integer id) {
        return loanRepository.findById(id).get();
    }

    public Set<Book> getLenedBook() {
        Set<Book> books=new HashSet<>();
        for (int i = 0; i < loanRepository.findAll().size(); i++) {
            for (int j = 0; j < loanRepository.findAll().get(i).getBooks().size(); j++) {
               books.add(loanRepository.findAll().get(i).getBooks().get(j));
            }
        }
        return books;
    }
    public boolean addLoan(Integer userId,Integer bookId) {
        Optional<User> currentUser= userRepository.getUserById(userId);
        Optional<Book> currentBook=bookRepository.getBookById(bookId);
        if (!currentUser.isPresent()
                ||!currentBook.isPresent()){
             throw new InvalidIdException("book id or user id is not found");
        }
        Loan currentLoan=new Loan();
        currentLoan.setUser(currentUser.get());
        currentLoan.getBooks().add(currentBook.get());
        loanRepository.save(currentLoan);
        return true;
    }
}
