package be.heh.projetbook.application.domain.service;

import be.heh.projetBook.adapter.out.persistence.SearchBookRepository;
import be.heh.projetBook.application.domain.service.CreateBookImplementation;
import be.heh.projetBook.application.domain.service.SearchBookImplementation;
import be.heh.projetBook.application.port.out.AddNewBook;
import be.heh.projetBook.application.port.out.ApiRequester;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SearchBookImplementationTest {

public String title;

    @Test
    public void shouldReturnBooks(){
        ApiRequester apiRequester = mock(ApiRequester.class);
        SearchBookImplementation searchBook = new SearchBookImplementation(apiRequester);
        searchBook.GetBooksInformations(title);
        verify(apiRequester).RequestBookInfos(title);
    }
}
