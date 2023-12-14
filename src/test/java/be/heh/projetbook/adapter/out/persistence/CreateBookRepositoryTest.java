package be.heh.projetbook.adapter.out.persistence;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = RunningApp.class)
public class CreateBookRepositoryTest {

    private BookInfo myBook;
    @Autowired
    CreateBookRepository repository;

    @Test
    public void shoulAddToDatabase() {
        myBook = new BookInfo("lalala","auteur","résumé","cover","101112");
        repository.addBook(myBook);

    }
}
