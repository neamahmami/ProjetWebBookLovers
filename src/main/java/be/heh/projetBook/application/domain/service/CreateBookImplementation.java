package be.heh.projetBook.application.domain.service;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.in.CreateBookUseCase;
import be.heh.projetBook.application.port.out.AddNewBook;

public class CreateBookImplementation implements CreateBookUseCase {

    private final AddNewBook addNewBook;

    public CreateBookImplementation(AddNewBook addNewBook) {
        this.addNewBook = addNewBook;
    }

    @Override
    public void addTheBook(BookInfo book){
        addNewBook.addBook(book);
    }
}
