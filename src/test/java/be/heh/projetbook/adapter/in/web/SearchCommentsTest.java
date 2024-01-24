package be.heh.projetbook.adapter.in.web;

import be.heh.projetBook.adapter.in.web.SearchComments;
import be.heh.projetBook.adapter.out.persistence.SearchCommentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(SearchComments.class)
public class SearchCommentsTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SearchCommentsRepository searchCommentsRepository;

    @Test
    public void testSearchComments() throws Exception{
        String isbn = "12345";

        List<String> mockCommentList = Arrays.asList("Comment 1", "Comment 2");
        when(searchCommentsRepository.routeComments(isbn)).thenReturn(mockCommentList);

        mockMvc.perform(MockMvcRequestBuilders.get("/book/{bookIsbn}/comments", isbn)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("Comment 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("Comment 2"));
    }
}
