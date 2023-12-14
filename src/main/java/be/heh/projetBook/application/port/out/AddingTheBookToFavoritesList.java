package be.heh.projetBook.application.port.out;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.model.Favorites;

import java.util.List;

public interface AddingTheBookToFavoritesList {
    public void addFavoriteBook(BookInfo book);
}
