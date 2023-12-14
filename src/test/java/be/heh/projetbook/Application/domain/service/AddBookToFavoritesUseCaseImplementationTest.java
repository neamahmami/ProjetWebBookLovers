package be.heh.projetbook.Application.domain.service;
import be.heh.projetBook.application.domain.service.AddBookToFavoritesListUseCaseImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.model.Favorites;
import be.heh.projetBook.application.port.in.AddBookToFavoritesListUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddBookToFavoritesUseCaseImplementationTest {


        private AddBookToFavoritesListUseCase addBookToFavoritesListUseCase;
        private Favorites favorites;
        private BookInfo book;

        @BeforeEach
        public void setUp() {
            favorites = Mockito.mock(Favorites.class);
            addBookToFavoritesListUseCase = new AddBookToFavoritesListUseCaseImplementation(favorites);
            book = new BookInfo("Title", "Author","sammury","//lien", "er", 4.5);
        }

        @Test
        public void addFavoriteBookTest() {
            List<BookInfo> bookList = new ArrayList<>();
            when(favorites.getFavoriteBooks()).thenReturn(bookList);
            addBookToFavoritesListUseCase.addFavoriteBook(book);
            assertEquals(1, bookList.size());
            assertEquals(book, bookList.get(0));
        }

        @Test
        public void addFavoriteBook_BookAlreadyExists_Test() {
            List<BookInfo> bookList = new ArrayList<>();
            bookList.add(book);
            when(favorites.getFavoriteBooks()).thenReturn(bookList);
            assertThrows(IllegalArgumentException.class, () -> addBookToFavoritesListUseCase.addFavoriteBook(book));
        }
    }



