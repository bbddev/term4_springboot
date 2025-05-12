package aptech.dm6.services;

import aptech.dm6.models.Author;
import aptech.dm6.models.Book;
import aptech.dm6.repositories.AuthorRepository;
import aptech.dm6.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository _bookRepository) {
        bookRepository = _bookRepository;
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}