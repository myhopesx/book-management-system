package com.example.bookmanagmentsoftware.controller;
import com.example.bookmanagmentsoftware.model.Loan;
import com.example.bookmanagmentsoftware.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public ResponseEntity getLoan(){

        return ResponseEntity.status(200).body(loanService.getAllLoan());
    }
    @GetMapping("/lendedbooks")
    public ResponseEntity getLendedBooks(){

        return ResponseEntity.status(200).body(loanService.getLenedBook());
    }
    @PostMapping("/{userid}/{bookid}")
    public ResponseEntity postLoan(@PathVariable Integer userid,@PathVariable Integer bookid) throws IllegalAccessException {
        loanService.addLoan(userid,bookid);
        logger.info("new book lended");
        return ResponseEntity.status(200).body("Loan Added!!");
    }
}
