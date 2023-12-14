package be.heh.projetBook.adapter.in.web;

import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateBook {
    CreateBookRepository bookRepository = new CreateBookRepository(new JdbcTemplate());

    public CreateBook(CreateBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book")
    public ResponseEntity<String> createBook(@RequestBody BookInfo book) {
        try {
            bookRepository.addBook(book);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Le livre : "+book.getTitle()+" a été créé avec succès");
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création du livre : " + e.getMessage());
        }
    }
}
