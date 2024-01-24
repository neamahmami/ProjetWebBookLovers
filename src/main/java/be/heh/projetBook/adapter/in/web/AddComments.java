package be.heh.projetBook.adapter.in.web;

import be.heh.projetBook.adapter.out.persistence.AddCommentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@CrossOrigin
@RestController
public class AddComments {

    AddCommentsRepository addCommentsRepository;

    public AddComments(AddCommentsRepository addCommentsRepository) {
        this.addCommentsRepository = addCommentsRepository;
    }

    @PostMapping("/comment/{bookIsbn}")
    public ResponseEntity<String> AddYourComment(@RequestBody String comment, @PathVariable String bookIsbn) {
        try {
            addCommentsRepository.savecomment(comment,bookIsbn);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Commentaire ajouté avec succès");
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du commentaire ");
        }
    }
}
