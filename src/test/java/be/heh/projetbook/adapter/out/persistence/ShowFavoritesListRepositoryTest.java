package be.heh.projetbook.adapter.out.persistence;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.out.ShowList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RunningApp.class)
public class ShowFavoritesListRepositoryTest {

    @Autowired
    private ShowList showListRepository;
    @Mock
    private JdbcTemplate jbdc;
    @Mock
    private BeanPropertyRowMapper bean;
    @Test
    public void shouldReturnNonEmptyList_WhenFavoritesExist() {
        // Mocking the expected behavior of JdbcTemplate.query
        JdbcTemplate jdbcTemplateMock = mock(JdbcTemplate.class);

        List<BookInfo> fakeFavorites = new ArrayList<>();
        fakeFavorites.add(new BookInfo("isbn1", "title1", "author1", "summary1", "cover1", 4.5));
        fakeFavorites.add(new BookInfo("isbn2", "title2", "author2", "summary2", "cover2", 3.8));

        when(jdbcTemplateMock.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(fakeFavorites);

        // Testing the ShowFavorites method
        ArrayList<BookInfo> result = showListRepository.ShowFavorites();

        // Verifying that the result is a non-empty list
        assertEquals(fakeFavorites, result);
    }

    // You can add more test cases based on your specific scenarios
}
