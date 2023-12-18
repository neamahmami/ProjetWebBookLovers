package be.heh.projetBook.Adapter.web;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.model.Favorites;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ShowListFavorites {
    private final Favorites favList;
    public ShowListFavorites(Favorites favList){
        this.favList = favList ;
    }
    @PostMapping("/favorites")
    public ResponseEntity<List<BookInfo>>  myList(){
        List<BookInfo> booksList = favList.getFavoriteBooks();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(booksList);

    }
}