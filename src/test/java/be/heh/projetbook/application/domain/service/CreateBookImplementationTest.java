package be.heh.projetbook.Application.domain.service;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.service.CreateBookImplementation;
import be.heh.projetBook.application.port.out.AddNewBook;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateBookImplementationTest {
public BookInfo book;

@Test
public void shouldAddBook(){
    AddNewBook addNewBook = mock(AddNewBook.class);
    CreateBookImplementation createBook = new CreateBookImplementation(addNewBook);
    createBook.addTheBook(book);
    verify(addNewBook).addBook(book);
}

}
