package be.heh.projetBook.application.port.out;

import be.heh.projetBook.application.domain.model.BookInfo;

public interface AddNewBook {
    public void addBook(BookInfo book);
}
