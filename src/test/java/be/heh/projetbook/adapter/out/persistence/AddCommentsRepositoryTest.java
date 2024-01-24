package be.heh.projetbook.adapter.out.persistence;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.out.persistence.AddCommentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RunningApp.class)
public class AddCommentsRepositoryTest {
    @Autowired
    AddCommentsRepository addCommentsRepository;

    @Test
    public void AddedToDatabase(){
        addCommentsRepository.savecomment("ce livre est très bien","12345");
    }
}
