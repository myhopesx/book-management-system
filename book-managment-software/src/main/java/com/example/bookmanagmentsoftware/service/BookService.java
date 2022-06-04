package com.example.bookmanagmentsoftware.service;
import com.example.bookmanagmentsoftware.model.Book;
import com.example.bookmanagmentsoftware.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List getAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }
    public void addBook(Book Book)throws IllegalAccessException{
        bookRepository.save(Book);
    }
}
