package aptech.dm6.controllers;

import aptech.dm6.helpers.ApiResponse;
import aptech.dm6.models.Author;
import aptech.dm6.repositories.AuthorRepository;
import aptech.dm6.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService _authorService) {
        authorService = _authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthors() {
       try {
           List<Author> authors = authorService.findAll();
           return ResponseEntity.ok(ApiResponse
                   .success(authors,"Get authors successfully"));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(ApiResponse.errorServer(e.getMessage()));
       }
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@Valid @RequestBody Author author,
                                       BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.badRequest(bindingResult));
            }
            Author authorCreated =  authorService.save(author);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.created(authorCreated,
                            "created author successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.errorServer(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthors(@PathVariable long id) {
        try {
            Author authors = authorService.findById(id);
            return ResponseEntity.ok(ApiResponse
                    .success(authors,"Get author "+id+" successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.errorServer(e.getMessage()));
        }
    }
}
