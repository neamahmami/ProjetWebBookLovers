package be.heh.projetbook.Adapter.out.persistence;

import be.heh.projetBook.Adapter.out.persistence.AddBookToFavoritesListRepository;
import be.heh.projetBook.RunningApp;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = RunningApp.class)
public class AddBookToFavoritesListRepositoryTest {

    private BookInfo myBook;
    @Autowired
    private AddBookToFavoritesListRepository repository;



    @Container
    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("FavoritesDB")
            .withUsername("postgres")
            .withPassword("root");

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private BeanNameUrlHandlerMapping bean;


    @Test
    public void shoulAddToDatabase() {
        myBook = new BookInfo("lalala","auteur","résumé","cover","70",2);
        repository.addFavoriteBook(myBook);

    }

    
}
