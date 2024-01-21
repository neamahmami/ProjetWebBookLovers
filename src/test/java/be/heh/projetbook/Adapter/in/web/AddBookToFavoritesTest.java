package be.heh.projetbook.Adapter.in.web;

import be.heh.projetBook.Adapter.in.web.AddBookToFavorites;
import be.heh.projetBook.Adapter.out.persistence.AddBookToFavoritesListRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddBookToFavoritesTest {

    @Mock
    private AddBookToFavoritesListRepository mockRepository;

    @InjectMocks
    private AddBookToFavorites addBook;

    @Test
    public void shouldReturnOk() {
        // Arrange
        BookInfo testBook = new BookInfo("devWeb", "neama", "nothing", "urlCover", "abc123", 5.0);

        // Mocking behavior
        doNothing().when(mockRepository).addFavoriteBook(testBook);

        // Act
        ResponseEntity<String> response = addBook.addBookToFavorites(testBook);

        // Assert
        verify(mockRepository, times(1)).addFavoriteBook(testBook);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Le livre a été ajouté à la liste de favoris avec succès.", response.getBody());
    }
}
