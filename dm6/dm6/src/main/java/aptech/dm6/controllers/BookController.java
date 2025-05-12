package aptech.dm6.controllers;

import aptech.dm6.helpers.ApiResponse;
import aptech.dm6.models.Author;
import aptech.dm6.models.Book;
import aptech.dm6.services.AuthorService;
import aptech.dm6.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService _bookService, AuthorService _authorService) {
        bookService = _bookService;
        authorService = _authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
       try {
           List<Book> books = bookService.findAll();
           return ResponseEntity.ok(ApiResponse
                   .success(books,"Get books successfully"));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(ApiResponse.errorServer(e.getMessage()));
       }
    }

    @PostMapping
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book,
                                       BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.badRequest(bindingResult));
            }
            Author existingAuthor = authorService.findById(book.getAuthor().getId());
            if(existingAuthor == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.notfound(
                                "author not found"));
            }

            Book bookCreated =  bookService.save(book);
            bookCreated.setAuthor(existingAuthor);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.created(bookCreated,
                            "created author successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.errorServer(e.getMessage()));
        }
    }
}
