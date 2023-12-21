package be.heh.projetbook.adapter.in.web;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.in.web.CreateBook;
import be.heh.projetBook.adapter.in.web.SearchBook;
import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.adapter.out.persistence.SearchBookRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(classes = RunningApp.class)
public class SearchBookTest {

    @Autowired
    private SearchBookRepository searchBookRepository;
    private String title = "icebreaker";

    @Test
    public void shouldReturnOk(){
        SearchBook search = new SearchBook(searchBookRepository);
        //when(create.createBook(bookInfo));
        ResponseEntity<List<BookInfo>> response = search.returnBook(title);
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertFalse(response.getBody().isEmpty());

        //Assertions.assertEquals(false,response.getBody().);

    }
}
