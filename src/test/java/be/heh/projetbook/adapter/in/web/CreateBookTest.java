package be.heh.projetbook.adapter.in.web;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.in.web.CreateBook;
import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = RunningApp.class)
public class CreateBookTest {
    @Autowired
    private CreateBookRepository createBookRepository;
    private BookInfo bookInfo;

    @Test
    public void shouldReturnOk(){
        bookInfo = new BookInfo("mavida","eva","blabla","cover","12345__6789",9);
        CreateBook create = new CreateBook(createBookRepository);
        //when(create.createBook(bookInfo));
        ResponseEntity<String> response = create.createBook(bookInfo);
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals("Le livre : "+bookInfo.getTitle()+" a été créé avec succès",response.getBody());

    }
}
