package be.heh.projetbook.adapter.in.web;

import be.heh.projetBook.RunningApp;
import be.heh.projetBook.adapter.in.web.AddComments;
import be.heh.projetBook.adapter.out.persistence.AddCommentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.doNothing;

@WebMvcTest(AddComments.class)
public class AddCommentsTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AddCommentsRepository addCommentsRepository;

    @Test
    public void testCreateBook() throws Exception {
        String comment = "Commentaire de test";
        String isbn = "1234567890";

        doNothing().when(addCommentsRepository).savecomment(comment, isbn);

        mockMvc.perform(MockMvcRequestBuilders.post("/comment/{isbn}", isbn)
                        .content(comment)
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Commentaire ajouté avec succès"));
    }
}
