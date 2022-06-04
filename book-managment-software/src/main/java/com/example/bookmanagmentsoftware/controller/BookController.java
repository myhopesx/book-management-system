package com.example.bookmanagmentsoftware.controller;

import com.example.bookmanagmentsoftware.model.Book;
import com.example.bookmanagmentsoftware.service.BookService;
import com.example.bookmanagmentsoftware.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public ResponseEntity getBook(){
        return ResponseEntity.status(200).body(bookService.getAllBook());
    }
    @PostMapping
    public ResponseEntity postBook(@RequestBody @Valid Book book) throws IllegalAccessException {
        bookService.addBook(book);
        logger.info("new book added");
        return ResponseEntity.status(200).body("Book Added!!");
    }
}
