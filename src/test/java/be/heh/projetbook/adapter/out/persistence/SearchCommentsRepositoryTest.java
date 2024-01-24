package be.heh.projetbook.adapter.out.persistence;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.out.persistence.SearchCommentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = RunningApp.class)
@ActiveProfiles("dev")
public class SearchCommentsRepositoryTest {

    @Autowired
    SearchCommentsRepository searchCommentsRepository;

    @Test
    public void shouldWork() {
        String isbn = "12345";
        List<String> test = searchCommentsRepository.routeComments(isbn);
        for (String comment : test) {
            System.out.println("le commentaire est : " + comment);
        }
    }
}
