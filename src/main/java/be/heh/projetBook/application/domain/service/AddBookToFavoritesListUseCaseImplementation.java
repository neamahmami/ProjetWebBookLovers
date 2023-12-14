package be.heh.projetBook.application.domain.service;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.model.Favorites;
import be.heh.projetBook.application.port.in.AddBookToFavoritesListUseCase;

import java.util.List;

public class AddBookToFavoritesListUseCaseImplementation implements AddBookToFavoritesListUseCase {
    private Favorites favoriteBooks;

    public AddBookToFavoritesListUseCaseImplementation(Favorites favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public void addFavoriteBook(BookInfo book) {
        List<BookInfo> bookList = favoriteBooks.getFavoriteBooks();

        if (bookList.contains(book)) {
            throw new IllegalArgumentException("Le livre existe déjà dans la liste des favoris.");
        } else {
            bookList.add(book);
            System.out.println("Le livre a été ajouté à la liste des favoris.");
        }
    }
}
