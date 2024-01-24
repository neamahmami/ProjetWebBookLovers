package be.heh.projetbook.adapter.out.persistence;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.out.persistence.ShowFavoritesListRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = RunningApp.class)
public class ShowFavoritesListRepositoryTest {

    // You can add more test cases based on your specific scenarios

    @Mock
    private ShowFavoritesListRepository showFavoritesListRepository;
    private ArrayList<BookInfo> favorites;

    @Test
    public void shouldReturnFavoritesList() {
        favorites = new ArrayList<>();
        favorites.add(new BookInfo("title1", "author1", "sammry", "url","123q",2.2));
        favorites.add(new BookInfo("title2", "author2", "sammary", "url","234q",2.2));
        when(showFavoritesListRepository.ShowFavorites()).thenReturn( favorites);

        List<BookInfo> result = showFavoritesListRepository.ShowFavorites();

        assertEquals(favorites, result);
        verify(showFavoritesListRepository, times(1)).ShowFavorites();
    } }