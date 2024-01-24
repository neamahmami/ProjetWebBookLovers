package be.heh.projetBook.adapter.in.web;

import be.heh.projetBook.adapter.out.persistence.AddCommentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddComments {

    AddCommentsRepository addCommentsRepository;

    public AddComments(AddCommentsRepository addCommentsRepository) {
        this.addCommentsRepository = addCommentsRepository;
    }

    @PostMapping("/comment/{isbn}")
        public ResponseEntity<String> createBook(@RequestBody String comment, @PathVariable String isbn) {
            try {
                addCommentsRepository.savecomment(comment,isbn);
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
