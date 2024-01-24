package be.heh.projetbook.adapter.out.persistence;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.out.persistence.SearchBookRepository;
import be.heh.projetBook.application.domain.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = RunningApp.class)
public class SearchBookRepositoryTest {

    @Autowired
    SearchBookRepository searchBookRepository;

    @Test
    public void shouldWork() {

        //myBook = new BookInfo("lalala","auteur","résumé","cover","101112",2);
        String titre = "the love hypothesis";
        List<BookInfo> test =  searchBookRepository.RequestBookInfos(titre);
        for (BookInfo book :test) {
            System.out.println("le titre est: "+book.getTitle()+" et l' url est: "+book.getIsbn()+ " et la des est : "+ book.getSummary()
            +"et l'image est : "+ book.getCover());
        }

    }

}
