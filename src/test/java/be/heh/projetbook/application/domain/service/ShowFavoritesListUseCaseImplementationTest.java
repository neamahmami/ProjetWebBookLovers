package be.heh.projetbook.Application.domain.service;


import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.service.ShowFavoritesListUseCaseImplementation;
import be.heh.projetBook.application.port.out.AddNewBook;
import be.heh.projetBook.application.port.out.ShowList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ShowFavoritesListUseCaseImplementationTest {

    private ShowFavoritesListUseCaseImplementation useCase;
    ShowList showListMock = mock(ShowList.class);

    @Test
    void showFavorites_ShouldReturnCorrectList_WhenFavoritesExist() {
        useCase = new ShowFavoritesListUseCaseImplementation(showListMock);
        // Cas où il y a des favoris
        ArrayList<BookInfo> fakeFavorites = new ArrayList<>();
        fakeFavorites.add(new BookInfo("test1", "neama","summary","url","123b",2.2));
        fakeFavorites.add(new BookInfo("test1", "neama","summary","url","123b",2.2));
        useCase.favBooks = fakeFavorites;

        // Appeler la méthode ShowFavorites
        ArrayList<BookInfo> result = useCase.ShowFavorites();

        // Vérifier que la liste renvoyée correspond à la liste factice de favoris
        assertEquals(fakeFavorites, result);
    } }

