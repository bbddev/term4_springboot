package aptech.dm6.services;

import aptech.dm6.models.Author;
import aptech.dm6.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository repository;
    public AuthorService(AuthorRepository _repository) {
        repository = _repository;
    }
    public List<Author> findAll() {
        return repository.findAll();
    }
    public Author findById(long id) {
        return repository.findById(id).get();
    }
    public Author save(Author author) {
        return repository.save(author);
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
