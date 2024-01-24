package be.heh.projetbook.application.domain.service;

import be.heh.projetBook.application.domain.service.SearchBookImplementation;
import be.heh.projetBook.application.domain.service.SearchCommentsImplementation;
import be.heh.projetBook.application.port.out.CommentsRequester;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SearchCommentsImplementationTest {

    String isbn ;

    @Test
    public void shouldReturnComments(){
        CommentsRequester commentsRequester = mock(CommentsRequester.class);
        SearchCommentsImplementation searchCommentsImplementation = new SearchCommentsImplementation(commentsRequester);
        searchCommentsImplementation.fetchComments(isbn);
        verify(commentsRequester).routeComments(isbn);
    }

}
