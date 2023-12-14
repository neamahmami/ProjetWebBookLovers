package be.heh.projetBook.application.domain.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Favorites {
    private List<BookInfo> favoriteBooks;

    public Favorites() {
        this.favoriteBooks = new ArrayList<>();
    }
    public List<BookInfo> getFavoriteBooks() {
        return favoriteBooks;
    }
}
