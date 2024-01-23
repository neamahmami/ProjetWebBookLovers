package be.heh.projetBook.application.port.out;

import be.heh.projetBook.application.domain.model.BookInfo;

import java.util.ArrayList;

public interface ShowList {
    public ArrayList<BookInfo> ShowFavorites();
}
