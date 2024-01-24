package be.heh.projetbook.adapter.in.web;

import be.heh.projetBook.adapter.in.web.ShowFavoritesList;
import be.heh.projetBook.adapter.out.persistence.ShowFavoritesListRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ShowFavoritesListTest {
    @Mock
    ShowFavoritesListRepository showFavoritesListRepository = Mockito.mock(ShowFavoritesListRepository.class);
    private ShowFavoritesList showFavoritesList = new ShowFavoritesList(showFavoritesListRepository);
    @Test
    void getFavorites_ShouldReturnOk_WhenFavoritesNotEmpty() {
        // Arrange
        ArrayList<BookInfo> fakeFavorites = new ArrayList<>();
        fakeFavorites.add(new BookInfo("web", "neama", "summary", "url", "ISBN123", 1.1));


        Mockito.when(showFavoritesListRepository.ShowFavorites()).thenReturn(fakeFavorites);



        ResponseEntity<ArrayList<BookInfo>> response = showFavoritesList.getFavorites();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(fakeFavorites, response.getBody());
    }
}

