package be.heh.projetbook.Adapter.out.persistence;

import be.heh.projetBook.Adapter.out.persistence.AddBookToFavoritesListRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Testcontainers
public class AddBookToFavoritesListRepositoryTest {

    @Container
    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("FavoritesDB")
            .withUsername("postgres")
            .withPassword("root");

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private BeanNameUrlHandlerMapping bean;

    @InjectMocks
    private AddBookToFavoritesListRepository addBookToFavoritesListRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        addBookToFavoritesListRepository = new AddBookToFavoritesListRepository(jdbcTemplate, bean);
    }

    @Test
    public void testAddFavoriteBook() {
        BookInfo book = new BookInfo("Testttt", "neaaama", "Test Auuthor", "uurl Cover", "1ee", 65.0);

        // Mock behavior of isBookInDatabase to return false
        /*when(addBookToFavoritesListRepository.isBookInDatabase(anyDouble())).thenReturn(false);*/

        // Mock behavior of jdbc.update to do nothing
        doThrow(new RuntimeException()).when(jdbcTemplate).update(any(), any(), any(), any(), any(), any(), any());

        // Call the method you want to test
        addBookToFavoritesListRepository.addFavoriteBook(book);

        // Verify that the jdbc.update method was called with the expected parameters
        verify(jdbcTemplate, times(1)).update(anyString(), any(), anyDouble(), any(), any(), any(), any());
    }

    // You can write more test cases for other methods as needed
}
