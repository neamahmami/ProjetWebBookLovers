package be.heh.projetBook.adapter.in.web;

import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.adapter.out.persistence.ShowFavoritesListRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowFavoritesList {

    @Autowired
    private ShowFavoritesListRepository showFavoritesListRepository;


    @Autowired
    public ShowFavoritesList(ShowFavoritesListRepository showFavoritesListRepository) {
        this.showFavoritesListRepository = showFavoritesListRepository;
    }

    @GetMapping("/favorites")
    public ResponseEntity<ArrayList<BookInfo>> getFavorites() {
        ArrayList<BookInfo> favorites = showFavoritesListRepository.ShowFavorites();
        if (favorites.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(favorites);
    }
}