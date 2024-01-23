package be.heh.projetBook.application.domain.service;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.in.ShowFavoritesListUseCase;
import be.heh.projetBook.application.port.out.AddNewBook;
import be.heh.projetBook.application.port.out.ShowList;

import java.util.ArrayList;

public class ShowFavoritesListUseCaseImplementation implements ShowFavoritesListUseCase {
    private final ShowList showList;
    public ArrayList<BookInfo> favBooks;
    public ShowFavoritesListUseCaseImplementation(ShowList showList){
        this.showList=showList;
        this.favBooks= new ArrayList<BookInfo>();
    }
    @Override
    public ArrayList<BookInfo> ShowFavorites() {
        return favBooks;
    }
}
