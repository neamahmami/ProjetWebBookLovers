package be.heh.projetBook.application.port.in;

import be.heh.projetBook.application.domain.model.BookInfo;

import java.util.ArrayList;

public interface ShowFavoritesListUseCase {
    public ArrayList<BookInfo> ShowFavorites();
}
