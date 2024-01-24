package be.heh.projetBook.adapter.in.web;


import be.heh.projetBook.application.port.out.CommentsRequester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SearchComments {
    CommentsRequester commentsRequester;

    public SearchComments(CommentsRequester commentsRequester) {
        this.commentsRequester = commentsRequester;
    }

    @GetMapping("/book/{bookIsbn}/comments")
    public ResponseEntity<List<String>> returnComments(@PathVariable String bookIsbn){
        try {
            List<String> CommentList = commentsRequester.routeComments(bookIsbn);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(CommentList);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
